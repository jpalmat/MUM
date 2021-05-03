SET SQL_SAFE_UPDATES = 0;
delete from MonthlyStatment;
delete from Transaction;
delete from DailyTransaction;
delete from Account;
delete from Client;

INSERT INTO Client (clientNo,email,firstName,lastName) VALUES ('1001', 'ehabfoua.ibm@gmail.com','Ehab','Abdelhamid');
INSERT INTO Client (clientNo,email,firstName,lastName) VALUES ('1002','hoba.fci@gmail.com','Ehab','Tarek');
INSERT INTO Client  (clientNo,email,firstName,lastName) VALUES ('1003','messam@gmail.com','Mohamed','Essam');
INSERT INTO Client (clientNo,email,firstName,lastName)  VALUES('1004','sara@gmail.com','Sara','Fahmy');
INSERT INTO Client  (clientNo,email,firstName,lastName) VALUES('1005','bethel99@gmail.com','Melania','Kailey');
INSERT INTO Client  (clientNo,email,firstName,lastName) VALUES('1006','jada07@gmail.com','Mela','Hadgu');
INSERT INTO Client  (clientNo,email,firstName,lastName) VALUES('1007','jaron99@gmail.com','Carole','Estevan');
INSERT INTO Client  (clientNo,email,firstName,lastName) VALUES('1008','krista51@gmail.com','Melat','Pouros');
INSERT INTO Client (clientNo,email,firstName,lastName)  VALUES('1009','wmorar@gmail.com','Leon','Myrna');
INSERT INTO Client  (clientNo,email,firstName,lastName) VALUES('1010','prosacco.ocie@gmail.com','Jed','Bertha');

INSERT INTO Account (accountNo,balance,currency,type,clientId) VALUES('9001' ,10000,'USD','saving',1);
INSERT INTO Account (accountNo,balance,currency,type,clientId) VALUES('9002' ,10000,'USD','saving',2);
INSERT INTO Account (accountNo,balance,currency,type,clientId) VALUES('9003' ,10000,'USD','checking',3);
INSERT INTO Account (accountNo,balance,currency,type,clientId) VALUES('9004' ,10000,'USD','saving',4);
INSERT INTO Account (accountNo,balance,currency,type,clientId) VALUES('9005' ,10000,'USD','checking',5);
INSERT INTO Account (accountNo,balance,currency,type,clientId) VALUES('9006' ,10000,'USD','checking',6);
INSERT INTO Account (accountNo,balance,currency,type,clientId) VALUES('9007' ,10000,'USD','checking',7);
INSERT INTO Account (accountNo,balance,currency,type,clientId) VALUES('9008' ,10000,'USD','saving',8);
INSERT INTO Account (accountNo,balance,currency,type,clientId) VALUES('9009' ,10000,'USD','checking',9);
INSERT INTO Account (accountNo,balance,currency,type,clientId) VALUES('9010' ,10000,'USD','saving',10);

INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-1001-001' , 50.30 , 'created' , 'amazon' , '2018-01-01', 1 , 1);
INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-1001-002' , 10.20 , 'created' , 'ebay' , '2018-01-01 05:13:08', 1 , 1);
INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-1001-003' , 30.15 , 'created' , 'BestBuy' , '2018-01-01 05:13:08', 1 , 1);
INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-1001-004' , 7.10 , 'created' , 'Walmart' , '2018-01-01 05:13:08', 1 , 1);
INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-1001-005' , 3.00 , 'created' , 'MAC' , '2018-01-01 05:13:08', 1 , 1);

INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-2002-001' , 50.30 , 'created' , 'amazon' , '2018-01-01', 2 , 2);
INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-2002-002' , 10.20 , 'created' , 'ebay' , '2018-01-01 05:13:08', 2 , 2);
INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-2002-003' , 30.15 , 'created' , 'BestBuy' , '2018-01-01 05:13:08', 2 , 2);
INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-2002-004' , 7.10 , 'created' , 'Walmart' , '2018-01-01 05:13:08', 2 , 2);
INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-2002-005' , 3.00 , 'created' , 'MAC' , '2018-01-01 05:13:08', 2 , 2);

INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-3003-001' , 50.30 , 'created' , 'amazon' , '2018-01-01', 3 , 3);
INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-3003-002' , 10.20 , 'created' , 'ebay' , '2018-01-01 05:13:08', 3 , 3);
INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-3001-003' , 30.15 , 'created' , 'BestBuy' , '2018-01-01 05:13:08', 3 , 3);
INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-3003-004' , 7.10 , 'created' , 'Walmart' , '2018-01-01 05:13:08', 3 , 3);
INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-3003-005' , 3.00 , 'created' , 'MAC' , '2018-01-01 05:13:08', 3 , 3);

INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-4004-001' , 50.30 , 'created' , 'amazon' , '2018-01-01', 4 , 4);
INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-4004-002' , 10.20 , 'created' , 'ebay' , '2018-01-01 05:13:08', 4 , 4);
INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-4004-003' , 30.15 , 'created' , 'BestBuy' , '2018-01-01 05:13:08', 4 , 4);
INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-4004-004' , 7.10 , 'created' , 'Walmart' , '2018-01-01 05:13:08', 4 , 4);
INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-4004-005' , 3.00 , 'created' , 'MAC' , '2018-01-01 05:13:08', 4 , 4);

INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-5005-001' , 50.30 , 'created' , 'amazon' , '2018-01-01', 5 , 5);
INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-5005-002' , 10.20 , 'created' , 'ebay' , '2018-01-01 05:13:08', 5 , 5);
INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-5005-003' , 30.15 , 'created' , 'BestBuy' , '2018-01-01 05:13:08', 5 , 5);
INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-5005-004' , 7.10 , 'created' , 'Walmart' , '2018-01-01 05:13:08', 5 , 5);
INSERT INTO DailyTransaction (tranId,amount,status,description,tranTime,accountId,clientId) VALUES( '20181217-5005-005' , 3.00 , 'created' , 'MAC' , '2018-01-01 05:13:08', 5 , 5);