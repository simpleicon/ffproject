package com.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server extends Thread{
	
	ServerSocket serverSocket;
	int port = 9999;
	
	boolean flag = true;
	
	ArrayList<DataOutputStream> list;
	
	String client;
	
	public Server() throws IOException {
		list = new ArrayList<>();
		serverSocket = new ServerSocket(port);
	}
	
	
	public void run() {
		while(flag) {
			System.out.println("Ready Server ...");
			Socket socket;
			try {
				socket = serverSocket.accept();
				client = socket.getInetAddress().getHostAddress();
				System.out.println(client);
				new Receiver(socket, client).start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//메시지보냄
	public void sendMsg(String msg) {
		// BroadCast Msg
		Sender sender = new Sender();
		sender.setMsg(msg);
		sender.start();
	}
	
	//클라이언트로 부터 메시지를 받을수 있음
	class Receiver extends Thread{

		InputStream is;
		DataInputStream dis;
		String client;
		
		// For Sender..
		OutputStream os;
		DataOutputStream dos;
		
		public Receiver(Socket socket,String client) throws IOException {
			this.client = client;
			is = socket.getInputStream();
			dis = new DataInputStream(is);
			
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
			list.add(dos);
			System.out.println("Connected Cnt:"	+list.size());
		}
		
		@Override
		public void run() {
			while(dis != null) {
				try {
					String msg = dis.readUTF();
					System.out.println(client+":"+msg);
					sendMsg(msg);
				} catch (IOException e) {
					//e.printStackTrace();
					break;
				}
			} // end while
			
			try {
				list.remove(dos);
				System.out.println("Connected Cnt:"+list.size());

				Thread.sleep(100);
				if(dis != null) {
					dis.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	class Sender extends Thread{
		
		String msg;
		public void setMsg(String msg) {
			this.msg = msg;
		}
		
		@Override
		public void run() {
			if(list.size() == 0) {
				return;
			}
			for(DataOutputStream out:list) {
				if(out != null) {
					try {
						out.writeUTF(msg);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	

	
	
	
}
