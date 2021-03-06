DROP TABLE ERROR_LOG CASCADE CONSTRAINTS;
DROP TABLE TB_ERROR CASCADE CONSTRAINTS;
DROP TABLE TB_WORK_HISTORY CASCADE CONSTRAINTS;
DROP TABLE TB_WORK_PLAN CASCADE CONSTRAINTS;
DROP TABLE TB_ADMIN CASCADE CONSTRAINTS;
DROP TABLE TB_CAR CASCADE CONSTRAINTS;

CREATE TABLE TB_CAR(
		CAR_ID                        		NUMBER(10)		 NOT NULL,
		CAR_NAME                      		VARCHAR2(30)		 NOT NULL,
		CUR_LOCATION_X                		VARCHAR2(20)		 NOT NULL,
		CUR_LOCATION_Y                		VARCHAR2(20)		 NOT NULL,
		CUR_LOAD                      		VARCHAR2(30)		 NOT NULL
);


CREATE TABLE TB_ADMIN(
		A_ID                          		VARCHAR2(10)		 NOT NULL,
		A_PW                          		VARCHAR2(10)		 NOT NULL,
		A_NAME                        		VARCHAR2(10)		 NOT NULL,
		ACCESS_LEVEL                  		NUMBER(10)		 NOT NULL
);


CREATE TABLE TB_WORK_PLAN(
		PLAN_NUM                      		NUMBER(15)		 NOT NULL,
		CAR_ID                        		NUMBER(10)		 NOT NULL,
		A_ID                          		VARCHAR2(10)		 NOT NULL,
		P_LOCATION_X                  		VARCHAR2(20)		 NULL ,
		P_LOCATION_Y                  		VARCHAR2(20)		 NULL ,
		P_LOAD                        		VARCHAR2(30)		 NULL ,
		PLANNED_TIME                  		VARCHAR2(50)		 NOT NULL
);


CREATE TABLE TB_WORK_HISTORY(
		HISTORY_NUM                   		NUMBER(15)		 NOT NULL,
		CAR_ID                        		NUMBER(10)		 NOT NULL,
		PLAN_NUM                      		NUMBER(15)		 NOT NULL,
		WORK_STATUS                   		VARCHAR2(20)		 NOT NULL,
		START_TIME                    		VARCHAR2(50)		 NOT NULL,
		END_TIME                      		VARCHAR2(50)		 NULL 
);


CREATE TABLE TB_ERROR(
		ERROR_CODE                    		NUMBER(10)		 NOT NULL,
		ERROR_MSG                     		VARCHAR2(50)		 NOT NULL
);


CREATE TABLE ERROR_LOG(
		ERR_NUM                       		NUMBER(10)		 NOT NULL,
		HISTORY_NUM                   		NUMBER(15)		 NOT NULL,
		ERROR_CODE                    		NUMBER(10)		 NOT NULL,
		OCCUR_TIME                    		VARCHAR2(50)		 NOT NULL
);



ALTER TABLE TB_CAR ADD CONSTRAINT IDX_TB_CAR_PK PRIMARY KEY (CAR_ID);

ALTER TABLE TB_ADMIN ADD CONSTRAINT IDX_TB_ADMIN_PK PRIMARY KEY (A_ID);

ALTER TABLE TB_WORK_PLAN ADD CONSTRAINT IDX_TB_WORK_PLAN_PK PRIMARY KEY (PLAN_NUM);
ALTER TABLE TB_WORK_PLAN ADD CONSTRAINT IDX_TB_WORK_PLAN_FK0 FOREIGN KEY (CAR_ID) REFERENCES TB_CAR (CAR_ID);
ALTER TABLE TB_WORK_PLAN ADD CONSTRAINT IDX_TB_WORK_PLAN_FK1 FOREIGN KEY (A_ID) REFERENCES TB_ADMIN (A_ID);

ALTER TABLE TB_WORK_HISTORY ADD CONSTRAINT IDX_TB_WORK_HISTORY_PK PRIMARY KEY (HISTORY_NUM);
ALTER TABLE TB_WORK_HISTORY ADD CONSTRAINT IDX_TB_WORK_HISTORY_FK0 FOREIGN KEY (PLAN_NUM) REFERENCES TB_WORK_PLAN (PLAN_NUM);

ALTER TABLE TB_ERROR ADD CONSTRAINT IDX_TB_ERROR_PK PRIMARY KEY (ERROR_CODE);

ALTER TABLE ERROR_LOG ADD CONSTRAINT IDX_ERROR_LOG_PK PRIMARY KEY (ERR_NUM, HISTORY_NUM);
ALTER TABLE ERROR_LOG ADD CONSTRAINT IDX_ERROR_LOG_FK0 FOREIGN KEY (ERROR_CODE) REFERENCES TB_ERROR (ERROR_CODE);
ALTER TABLE ERROR_LOG ADD CONSTRAINT IDX_ERROR_LOG_FK1 FOREIGN KEY (HISTORY_NUM) REFERENCES TB_WORK_HISTORY (HISTORY_NUM);


########
Location 컬럼 : x y  
LOAD 컬럼 : 적재 중, 미적재

TB_CAR INSERT SQL

INSERT INTO TB_CAR (CAR_ID, CAR_NAME, CUR_LOCATION_X, CUR_LOCATION_Y, CUR_LOAD)
		VALUES (101, '1번 차량', '0', '0', '미적재');
INSERT INTO TB_CAR (CAR_ID, CAR_NAME, CUR_LOCATION_X, CUR_LOCATION_Y, CUR_LOAD)
		VALUES (201, '2번 차량', '0', '0', '미적재');

		
		
########
TB_ADMIN INSERT SQL

INSERT INTO TB_ADMIN (A_ID, A_PW, A_NAME, ACCESS_LEVEL) VALUES ('id01', '1234', 'kim', 0);

		
########

TB_WORK_PLAN INSERT SQL

##이동만
INSERT INTO TB_WORK_PLAN (PLAN_NUM, CAR_ID, A_ID, P_LOCATION_X, P_LOCATION_Y, PLANNED_TIME) 
		VALUES (1, 101, 'id01', '1', '1', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'));

##LOAD 업무까지		
INSERT INTO TB_WORK_PLAN (PLAN_NUM, CAR_ID, A_ID, P_LOCATION_X, P_LOCATION_Y, P_LOAD, PLANNED_TIME) 
		VALUES (2, 201, 'id01', '2', '1', '적재', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'));

		
#######
TB_WORK_HISTORY INSERT SQL

INSERT INTO TB_WORK_HISTORY (HISTORY_NUM, CAR_ID, PLAN_NUM, WORK_STATUS, START_TIME) 
		VALUES (1, 101, 1, '작업 중', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'));
		
INSERT INTO TB_WORK_HISTORY (HISTORY_NUM, CAR_ID, PLAN_NUM, WORK_STATUS, START_TIME) 
		VALUES (2, 201, 2, '작업 중', TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'));
		
#######		
TB_WORK_HISTORY UPDATE SQL

UPDATE TB_WORK_HISTORY SET WORK_STATUS = '작업 완료' ,END_TIME =  TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE HISTORY_NUM = 1;
UPDATE TB_WORK_HISTORY SET WORK_STATUS = '오류 발생' ,END_TIME =  TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') WHERE HISTORY_NUM = 2;


#######
ERROR_CODE
10 > 적재물에 관련된
10+1
11

20 >

INSERT INTO TB_ERROR (ERROR_CODE, ERROR_MSG) 
		VALUES (11, '적재할 물건이 없습니다.');


#######
ERROR_LOG INSERT SQL

INSERT INTO ERROR_LOG (ERR_NUM, HISTORY_NUM, ERROR_CODE, OCCUR_TIME) 
		VALUES (1, 2, 11, TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS'));







