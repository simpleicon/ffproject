package com.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frame.Biz;
import com.frame.Biz2;
import com.vo.Car;
import com.vo.CarStatus;
import com.vo.WorkHistory;
import com.vo.WorkPlan;

@Controller
public class ScannerController {
	//simulation을 위한 컨트롤러
	//padController와 기능은 비슷하나 pad로의 전송을 하지 않는다.
	
	@Resource(name="whbiz")
	Biz2 whbiz;
	@Resource(name="wpbiz")
	Biz wpbiz;
	@Resource(name="cbiz")
	Biz cbiz;
	@Resource(name="csbiz")
	Biz csbiz;
	
	@ResponseBody
	@RequestMapping("/simulation")
	public void simulation() {
		try {
			File file = new File("C:\\simulation.txt");
			Scanner scan = new Scanner(file);
			while (scan.hasNextLine()) {
				/*ex) 201100010*/String data = scan.nextLine();
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				String a_id = null;
				String car_id = data.substring(0, 3);
				String value =data.substring(3);
				Car car = new Car();
				String cur_load = null;
				String cur_locx = null;
				String cur_locy = null;
				a_id = "id01";
				int cmd = Integer.parseInt(value.substring(0,2));
				int can_value = Integer.parseInt(value.substring(2));
				
				try {
					car = (Car) cbiz.get(car_id);
					cur_load = car.getCur_load();
					cur_locx = car.getCur_location_x();
					cur_locy = car.getCur_location_y();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				//load 관련 신호
				if(cmd == 30) {
					String p_load = null;
					
					if(can_value == 10) {
						if(cur_load.equals("미적재")) {
							p_load = "적재";
						}
					}else if(can_value == 11) {
						if(cur_load.equals("적재중")) {
							p_load = "하차";
						}
					}
					
					if(p_load!=null) {
						WorkPlan wp = new WorkPlan(Integer.parseInt(car_id), a_id, cur_locx, cur_locy, p_load);
						try {
							wpbiz.register(wp);
//							server.sendMsg(value);
							System.out.println("plan insert");
							String load = null;
							String workStatus = null;
							try {
								car = (Car) cbiz.get(car_id);
								if(can_value==10) {
									load = "적재중";
									workStatus ="작업완료.";
								}else if(can_value==11) {
									load = "미적재";
									workStatus = "작업완료.";
								}
								WorkHistory wh = new WorkHistory(Integer.parseInt(car_id), workStatus);
								
								car.setCur_load(load);
								cbiz.modify(car);
								whbiz.register(wh);
								
//								ArrayList<WorkHistory> list = null;
//								WorkHistory updateWh = new WorkHistory();
//								list = whbiz.get();
//								updateWh = list.get(list.size()-1);
//								Thread.sleep(2000);
//								workStatus = "작업완료";
//								System.out.println("load hisnum :"+updateWh.getHistory_num());
//								updateWh.setWork_status(workStatus);
								whbiz.modify(wh);
							} catch (Exception e) {
								System.out.println("load update failed");
								e.printStackTrace();
							}
							
						} catch (Exception e) {
							System.out.println("worplan insert 오류");
							e.printStackTrace();
						}
					}
				//이동 관련 신호
				}else if(cmd == 40) {
					double locx = Double.parseDouble(cur_locx);
					double locy = Double.parseDouble(cur_locy);
					String p_locx = cur_locx;
					String p_locy = cur_locy;
					if(can_value == 10) {
						locx += 0.0001;
						p_locx = String.valueOf(locx);
					}else if(can_value==11) {
						locx -= 0.0001;
						p_locx = String.valueOf(locx);
					}else if(can_value==12) {
						locy += 0.0001;
						p_locy = String.valueOf(locy);
					}else if(can_value==13) {
						locy += 0.0001;
						p_locy = String.valueOf(locy);
					}
					WorkPlan wp = new WorkPlan(Integer.parseInt(car_id), a_id, p_locx, p_locy, "-");
					try {
						wpbiz.register(wp);
//						server.sendMsg(value);
						System.out.println(car_id+"  "+ value);
						
						
						car = (Car)cbiz.get(car_id);
						String workStatus = null;
						
						car.setCur_location_x(p_locx);
						car.setCur_location_y(p_locy);
						workStatus = "작업완료.";
						cbiz.modify(car);
						WorkHistory wh = new WorkHistory(Integer.parseInt(car_id), workStatus);
						whbiz.register(wh);
						
						////
//						ArrayList<WorkHistory> list = null;
//						WorkHistory updateWh = new WorkHistory();
//						list = whbiz.get();
//						updateWh = list.get(list.size()-1);
//						
//						workStatus = "작업완료";
//						System.out.println("move hisnum :"+updateWh.getHistory_num());
//						updateWh.setWork_status(workStatus);
						whbiz.modify(wh);
					} catch (Exception e) {
						System.out.println("moving wp insert error");
						e.printStackTrace();
					}
				//전원, 배터리 신호
				}else if(cmd==10){
					CarStatus status = new CarStatus();
					try {
						status = (CarStatus) csbiz.get(car_id);
						String ignition = null;
						if(can_value == 10) {
							ignition = "ON";
						}else if(can_value==11) {
							ignition = "OFF";
						}
						status.setIgnition(ignition);
						csbiz.modify(status);
					} catch (Exception e) {
						System.out.println("status update error");
						e.printStackTrace();
					}
					System.out.println(car_id+"  "+ value);
//					server.sendMsg(value);
				}else if(cmd==20) {
					CarStatus status = new CarStatus();
					try {
						status = (CarStatus) csbiz.get(car_id);
						int charge = Integer.parseInt(value.substring(5));
						String setcharge = null;
						if(charge == 1) {
							setcharge = "ON";
							if(!car.getCur_location_x().equals("37.368305") && !car.getCur_location_y().equals("127.323782")) {
								car.setCur_location_x("37.368305");
								car.setCur_location_y("127.323782");
								cbiz.modify(car);
							}
						}else {
							setcharge = "OFF";
						}
						status.setCharge(setcharge);
						int battery = Integer.parseInt(value.substring(2,5));
						status.setBattery(battery);
						csbiz.modify(status);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println(car_id+"  "+ value);
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/reset")
	public void reset() {
		Car car = new Car();
		CarStatus status = new CarStatus();
		String load = "미적재";
		String charge = "OFF";
		String ignition = "OFF";
		try {
			//101
			car = (Car) cbiz.get("101");
			car.setCur_load(load);
			car.setCur_location_x("37.369549");
			car.setCur_location_y("127.324461");
			cbiz.modify(car);
			status = (CarStatus)csbiz.get("101");
			status.setBattery(75);
			status.setCharge(charge);
			status.setIgnition(ignition);
			csbiz.modify(status);
			//201
			car = (Car) cbiz.get("201");
			car.setCur_load(load);
			car.setCur_location_x("37.368561");
			car.setCur_location_y("127.324704");
			cbiz.modify(car);
			status = (CarStatus)csbiz.get("201");
			status.setBattery(75);
			status.setCharge(charge);
			status.setIgnition(ignition);
			csbiz.modify(status);
			
			
			//301
			car = (Car) cbiz.get("301");
			car.setCur_load(load);
			car.setCur_location_x("37.368858");
			car.setCur_location_y("127.324134");
			cbiz.modify(car);
			status = (CarStatus)csbiz.get("301");
			status.setBattery(75);
			status.setCharge(charge);
			status.setIgnition(ignition);
			csbiz.modify(status);
			
			//401
			car = (Car) cbiz.get("401");
			car.setCur_load(load);
			car.setCur_location_x("37.369135");
			car.setCur_location_y("127.325019");
			cbiz.modify(car);
			status = (CarStatus)csbiz.get("401");
			status.setBattery(75);
			status.setCharge(charge);
			status.setIgnition(ignition);
			csbiz.modify(status);
			
			
			//history, plan delete
			whbiz.remove("1");
			wpbiz.remove("1");
			System.out.println("reset");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
