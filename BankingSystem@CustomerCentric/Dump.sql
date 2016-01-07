CREATE DATABASE  IF NOT EXISTS `bankingsystem` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bankingsystem`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: bankingsystem
-- ------------------------------------------------------
-- Server version	5.6.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `AccountNumber` int(11) NOT NULL AUTO_INCREMENT,
  `AccountType` char(5) NOT NULL,
  `DateCreated` date NOT NULL,
  `AvailableBalance` double NOT NULL,
  `RoutingNumber` int(11) NOT NULL,
  PRIMARY KEY (`AccountNumber`),
  KEY `FK_AccountType_idx` (`AccountType`),
  CONSTRAINT `FK_AccountType` FOREIGN KEY (`AccountType`) REFERENCES `account_type` (`AccountType`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=657451235 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (135790642,'AT001','2014-01-01',700,98760),(246815791,'AT002','2014-01-01',890,90765),(345310012,'AT001','2014-01-01',110,14567),(567439871,'AT001','2014-09-09',245,98345),(657451234,'AT001','2014-01-01',2000,34521);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_customer`
--

DROP TABLE IF EXISTS `account_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_customer` (
  `AccountNumber` int(11) NOT NULL,
  `CustomerId` int(11) NOT NULL,
  PRIMARY KEY (`AccountNumber`,`CustomerId`),
  KEY `FK_customerId6_idx` (`CustomerId`),
  CONSTRAINT `FK_accountId1` FOREIGN KEY (`AccountNumber`) REFERENCES `account` (`AccountNumber`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_customerId6` FOREIGN KEY (`CustomerId`) REFERENCES `customer` (`CustomerId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_customer`
--

LOCK TABLES `account_customer` WRITE;
/*!40000 ALTER TABLE `account_customer` DISABLE KEYS */;
INSERT INTO `account_customer` VALUES (135790642,1),(246815791,1),(345310012,2),(657451234,3),(567439871,4);
/*!40000 ALTER TABLE `account_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_transaction`
--

DROP TABLE IF EXISTS `account_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_transaction` (
  `TransactionId` int(11) NOT NULL AUTO_INCREMENT,
  `TransactionType` char(4) NOT NULL,
  `AccountId` int(11) NOT NULL,
  `TransactionDate` datetime NOT NULL,
  `SentToOrReceivedFrom` varchar(45) NOT NULL,
  `CreditOrDebit` char(1) NOT NULL,
  `Status` varchar(45) NOT NULL,
  `TransactionAmount` decimal(10,0) NOT NULL,
  `employeeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`TransactionId`),
  KEY `FK_accountId_idx` (`AccountId`),
  KEY `FK_transactionType_idx` (`TransactionType`),
  KEY `fk_employeeId_idx` (`employeeId`),
  CONSTRAINT `FK21_AccountId` FOREIGN KEY (`AccountId`) REFERENCES `account` (`AccountNumber`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK21_TransactionType` FOREIGN KEY (`TransactionType`) REFERENCES `transactiontype` (`TransactionType`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk21_employeeId` FOREIGN KEY (`employeeId`) REFERENCES `employee` (`EmployeeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_transaction`
--

LOCK TABLES `account_transaction` WRITE;
/*!40000 ALTER TABLE `account_transaction` DISABLE KEYS */;
INSERT INTO `account_transaction` VALUES (1,'TT01',246815791,'2014-01-01 00:00:00','908023483','D','Completed',100,NULL),(2,'TT03',135790642,'2014-02-02 00:00:00','329482302','C','Completed',25,NULL),(3,'TT04',345310012,'2014-03-03 00:00:00','234234898','C','Completed',100,NULL),(4,'TT05',567439871,'2014-01-01 00:00:00','043423575','D','Completed',100,NULL);
/*!40000 ALTER TABLE `account_transaction` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger log_transaction
after
insert on account_transaction
for each row
begin
insert into log(TransactionId, TransactionDate, TransactionAmount)
values(NEW.TransactionId, sysdate(), NEW.TransactionAmount);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `account_type`
--

DROP TABLE IF EXISTS `account_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_type` (
  `AccountType` char(5) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `MinOpeningDeposit` float NOT NULL,
  `Apr` float NOT NULL,
  PRIMARY KEY (`AccountType`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_type`
--

LOCK TABLES `account_type` WRITE;
/*!40000 ALTER TABLE `account_type` DISABLE KEYS */;
INSERT INTO `account_type` VALUES ('AT001','Saving',100,2),('AT002','Checking',0,0);
/*!40000 ALTER TABLE `account_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `AddressID` int(11) NOT NULL AUTO_INCREMENT,
  `Street` varchar(45) DEFAULT NULL,
  `City` varchar(45) DEFAULT NULL,
  `State` varchar(45) DEFAULT NULL,
  `Country` varchar(45) DEFAULT NULL,
  `ZipCode` varchar(45) DEFAULT NULL,
  `AddressType` varchar(45) DEFAULT NULL,
  `Preference` bit(1) DEFAULT NULL,
  PRIMARY KEY (`AddressID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'244 Kennedy Dr','Malden','MA ','US','02149','Billing',''),(2,'500 OakLand','Lowell','MA','US ','21933','Billing ','\0'),(3,'444 huntington ave','Boston','MA ','US','22197','Payment','\0'),(4,'256 1310 Mission Stree','SanFransico','CA','US','21456','Billing ',''),(5,'690 Fifth Street','SanFrancisco','CA','US','21456','Billing',''),(6,'1223 Vine Street','Philadelphia','PA','US','60513','Billing',''),(7,'W. Craig Rd.','Los Vegas','CA','US','45623','Billing','');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alert`
--

DROP TABLE IF EXISTS `alert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alert` (
  `AlertId` int(11) NOT NULL AUTO_INCREMENT,
  `AlertType` char(4) NOT NULL,
  `SentDate` datetime NOT NULL,
  `Reason` varchar(45) NOT NULL,
  `AccountNumber` int(11) NOT NULL,
  PRIMARY KEY (`AlertId`),
  KEY `Fk_AlertType_idx` (`AlertType`),
  KEY `FK_AccountNumber_idx` (`AccountNumber`),
  CONSTRAINT `FK1_AlertType` FOREIGN KEY (`AlertType`) REFERENCES `alert_type` (`AlertType`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_AccountNumber` FOREIGN KEY (`AccountNumber`) REFERENCES `account` (`AccountNumber`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alert`
--

LOCK TABLES `alert` WRITE;
/*!40000 ALTER TABLE `alert` DISABLE KEYS */;
INSERT INTO `alert` VALUES (1,'AL01','2014-01-01 00:00:00','Balance Updated',246815791),(2,'AL02','2014-01-01 00:00:00','Balance Updated',246815791),(3,'AL01','2014-02-02 00:00:00','Balance Updated',135790642),(4,'AL02','2014-02-02 00:00:00','Balance Updated',135790642),(5,'AL01','2014-03-03 00:00:00','Balance Updated',345310012),(6,'AL02','2014-03-03 00:00:00','Balance Updated',345310012),(7,'AL01','2014-01-01 00:00:00','Balance Updated',567439871),(8,'AL02','2014-01-01 00:00:00','Balance Updated',567439871);
/*!40000 ALTER TABLE `alert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alert_type`
--

DROP TABLE IF EXISTS `alert_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alert_type` (
  `AlertType` char(4) NOT NULL,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`AlertType`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alert_type`
--

LOCK TABLES `alert_type` WRITE;
/*!40000 ALTER TABLE `alert_type` DISABLE KEYS */;
INSERT INTO `alert_type` VALUES ('AL01','Email Alert'),('AL02','SMS Alert');
/*!40000 ALTER TABLE `alert_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `branch`
--

DROP TABLE IF EXISTS `branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `branch` (
  `BranchId` int(11) NOT NULL AUTO_INCREMENT,
  `BranchName` varchar(45) NOT NULL,
  `Location` varchar(45) NOT NULL,
  PRIMARY KEY (`BranchId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `branch`
--

LOCK TABLES `branch` WRITE;
/*!40000 ALTER TABLE `branch` DISABLE KEYS */;
INSERT INTO `branch` VALUES (1,'NorthEastern','MA');
/*!40000 ALTER TABLE `branch` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `card`
--

DROP TABLE IF EXISTS `card`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `card` (
  `CardNumber` bigint(20) NOT NULL,
  `CardType` char(5) NOT NULL,
  `StartDate` date NOT NULL,
  `ExpiryDate` date NOT NULL,
  `Rewards` varchar(45) NOT NULL,
  `CreditBalance` double NOT NULL,
  `CustomerId` int(11) NOT NULL,
  `AccountNumber` int(11) NOT NULL,
  PRIMARY KEY (`CardNumber`),
  KEY `FK_CardType_idx` (`CardType`),
  KEY `FK16_CustomerID_idx` (`CustomerId`),
  KEY `FK10_AccoutNumber_idx` (`AccountNumber`),
  CONSTRAINT `FK10_AccoutNumber` FOREIGN KEY (`AccountNumber`) REFERENCES `account_customer` (`AccountNumber`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK16_CustomerID` FOREIGN KEY (`CustomerId`) REFERENCES `account_customer` (`CustomerId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_CardType` FOREIGN KEY (`CardType`) REFERENCES `card_type` (`CardType`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

LOCK TABLES `card` WRITE;
/*!40000 ALTER TABLE `card` DISABLE KEYS */;
INSERT INTO `card` VALUES (123090979125,'CT004','2009-10-11','2015-10-01','1',0,1,135790642),(134556780909,'CT003','2009-10-11','2015-10-01','1',0,3,657451234),(567456675435,'CT001','2009-10-11','2015-10-01','1',500,4,567439871),(666456789426,'CT002','2009-10-11','2015-10-01','1',0,2,345310012);
/*!40000 ALTER TABLE `card` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `card_type`
--

DROP TABLE IF EXISTS `card_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `card_type` (
  `CardType` char(5) NOT NULL,
  `Description` varchar(45) NOT NULL,
  `TotalCreditLine` double NOT NULL,
  `CashCreditLine` double NOT NULL,
  PRIMARY KEY (`CardType`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card_type`
--

LOCK TABLES `card_type` WRITE;
/*!40000 ALTER TABLE `card_type` DISABLE KEYS */;
INSERT INTO `card_type` VALUES ('CT001','Visa Credit Card',2000,1000),('CT002','Titanium Credit Card',4000,2000),('CT003','Master Debit Card',0,0),('CT004','Visa Debit Card',0,0);
/*!40000 ALTER TABLE `card_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credentials`
--

DROP TABLE IF EXISTS `credentials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credentials` (
  `UserName` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  PRIMARY KEY (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credentials`
--

LOCK TABLES `credentials` WRITE;
/*!40000 ALTER TABLE `credentials` DISABLE KEYS */;
INSERT INTO `credentials` VALUES ('DeepthiM','*BE3FEFCC9812B512AE9'),('JoeCarew','*FF63C13E0FE7889A6C6'),('LahariM','*8BF7750FCCCADD3C6EC'),('Rebecca','*ACFF48594A65F3FA8CE');
/*!40000 ALTER TABLE `credentials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `CustomerId` int(11) NOT NULL,
  `CustomerType` char(3) NOT NULL,
  `Salary` varchar(45) NOT NULL,
  `Company` varchar(45) NOT NULL,
  PRIMARY KEY (`CustomerId`),
  KEY `customerTypeId_idx` (`CustomerType`),
  CONSTRAINT `FK_CustomerId` FOREIGN KEY (`CustomerId`) REFERENCES `person` (`PersonID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_CustomerType` FOREIGN KEY (`CustomerType`) REFERENCES `customertype` (`CustomerType`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'CT1','90000','Microsoft'),(2,'CT1','79000','Google'),(3,'CT1','67000','Yahoo'),(4,'CT1','65000','Adobe');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER password_history
AFTER
update ON customer
FOR EACH ROW
BEGIN
INSERT into passwordhistory(`Password`, CreationDate, ExpiryDate)
VALUES(OLD.password, sysdate(), ADDDATE(sysdate(), INTERVAL 2  MONTH));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary table structure for view `customer_account_information`
--

DROP TABLE IF EXISTS `customer_account_information`;
/*!50001 DROP VIEW IF EXISTS `customer_account_information`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `customer_account_information` (
  `CustomerId` tinyint NOT NULL,
  `AccountNumber` tinyint NOT NULL,
  `AccountType` tinyint NOT NULL,
  `AvailableBalance` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `customer_basic_info`
--

DROP TABLE IF EXISTS `customer_basic_info`;
/*!50001 DROP VIEW IF EXISTS `customer_basic_info`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `customer_basic_info` (
  `FirstName` tinyint NOT NULL,
  `LastName` tinyint NOT NULL,
  `SSN` tinyint NOT NULL,
  `EmailId` tinyint NOT NULL,
  `MobileNumber` tinyint NOT NULL,
  `Street` tinyint NOT NULL,
  `City` tinyint NOT NULL,
  `State` tinyint NOT NULL,
  `ZipCode` tinyint NOT NULL,
  `AddressType` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `customer_card_info`
--

DROP TABLE IF EXISTS `customer_card_info`;
/*!50001 DROP VIEW IF EXISTS `customer_card_info`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `customer_card_info` (
  `customerId` tinyint NOT NULL,
  `CardNumber` tinyint NOT NULL,
  `Description` tinyint NOT NULL,
  `startDate` tinyint NOT NULL,
  `ExpiryDate` tinyint NOT NULL,
  `CreditBalance` tinyint NOT NULL,
  `AccountNumber` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `customer_credentials`
--

DROP TABLE IF EXISTS `customer_credentials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_credentials` (
  `UserName` varchar(45) NOT NULL,
  `CustomerId` int(11) NOT NULL,
  PRIMARY KEY (`UserName`,`CustomerId`),
  KEY `FK_CustomerId_idx` (`CustomerId`),
  CONSTRAINT `FK_CustomerId19` FOREIGN KEY (`CustomerId`) REFERENCES `customer` (`CustomerId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_UserName` FOREIGN KEY (`UserName`) REFERENCES `credentials` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_credentials`
--

LOCK TABLES `customer_credentials` WRITE;
/*!40000 ALTER TABLE `customer_credentials` DISABLE KEYS */;
INSERT INTO `customer_credentials` VALUES ('DeepthiM',1),('JoeCarew',2),('LahariM',3),('Rebecca',4);
/*!40000 ALTER TABLE `customer_credentials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `customer_loan_information`
--

DROP TABLE IF EXISTS `customer_loan_information`;
/*!50001 DROP VIEW IF EXISTS `customer_loan_information`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `customer_loan_information` (
  `CustomerId` tinyint NOT NULL,
  `LoanId` tinyint NOT NULL,
  `Description` tinyint NOT NULL,
  `LoanAmount` tinyint NOT NULL,
  `StartDate` tinyint NOT NULL,
  `emi` tinyint NOT NULL,
  `Apr` tinyint NOT NULL,
  `RemainingBal` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `customer_question_answer`
--

DROP TABLE IF EXISTS `customer_question_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_question_answer` (
  `QuestionID` int(11) NOT NULL,
  `CustomerID` int(11) NOT NULL,
  `Answer` varchar(100) NOT NULL,
  PRIMARY KEY (`QuestionID`,`CustomerID`),
  KEY `FK_customerId_idx` (`CustomerID`),
  CONSTRAINT `FK_customerId16` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`CustomerId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_questionID1` FOREIGN KEY (`CustomerID`) REFERENCES `secretquestions` (`QuestionID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_question_answer`
--

LOCK TABLES `customer_question_answer` WRITE;
/*!40000 ALTER TABLE `customer_question_answer` DISABLE KEYS */;
INSERT INTO `customer_question_answer` VALUES (1,1,'DAV Public School'),(1,2,'Delhi Public School'),(1,3,'Malden High School'),(2,1,'Thota'),(2,2,'Pothireddy'),(2,3,'Ford'),(2,4,'Laytham'),(3,1,'Manam'),(3,3,'Lincoln'),(4,1,'Tonny'),(4,3,'Tomy'),(4,4,'Lucy'),(5,2,'Hyderabad'),(5,4,'Boston'),(6,2,'Hyderabad'),(6,4,'Boston');
/*!40000 ALTER TABLE `customer_question_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_rewards`
--

DROP TABLE IF EXISTS `customer_rewards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_rewards` (
  `CustomerId` int(11) NOT NULL,
  `RewardId` int(11) NOT NULL,
  PRIMARY KEY (`CustomerId`,`RewardId`),
  KEY `FK_RewardID_idx` (`RewardId`),
  CONSTRAINT `FK_CustomerID20` FOREIGN KEY (`CustomerId`) REFERENCES `customer` (`CustomerId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_RewardID` FOREIGN KEY (`RewardId`) REFERENCES `reward` (`RewardId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_rewards`
--

LOCK TABLES `customer_rewards` WRITE;
/*!40000 ALTER TABLE `customer_rewards` DISABLE KEYS */;
INSERT INTO `customer_rewards` VALUES (1,1),(2,2),(3,3),(4,4);
/*!40000 ALTER TABLE `customer_rewards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `customer_service_request`
--

DROP TABLE IF EXISTS `customer_service_request`;
/*!50001 DROP VIEW IF EXISTS `customer_service_request`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `customer_service_request` (
  `CustomerId` tinyint NOT NULL,
  `ServiceId` tinyint NOT NULL,
  `serviceDescription` tinyint NOT NULL,
  `RequestedDate` tinyint NOT NULL,
  `Status` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `customertype`
--

DROP TABLE IF EXISTS `customertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customertype` (
  `CustomerType` char(3) NOT NULL,
  `Category` varchar(45) NOT NULL,
  `Description` varchar(45) NOT NULL,
  PRIMARY KEY (`CustomerType`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customertype`
--

LOCK TABLES `customertype` WRITE;
/*!40000 ALTER TABLE `customertype` DISABLE KEYS */;
INSERT INTO `customertype` VALUES ('CT1','Individual ','Individual Customer'),('CT2','Enterprise','Enterprise Customer');
/*!40000 ALTER TABLE `customertype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `DepartmentId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Location` varchar(45) NOT NULL,
  PRIMARY KEY (`DepartmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'FinanceDept','MA'),(2,'Sales Dept','MA'),(3,'Service Dept','MA');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `EmployeeId` int(11) NOT NULL,
  `BranchId` int(11) NOT NULL,
  `DepartmentId` int(11) NOT NULL,
  `JobCode` char(4) NOT NULL,
  `ManagerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`EmployeeId`),
  KEY `FK_BranchId_idx` (`BranchId`),
  KEY `FK_ManagerId_idx` (`ManagerId`),
  KEY `Fk_DepartmentId_idx` (`DepartmentId`),
  KEY `Fk_JobCode_idx` (`JobCode`),
  CONSTRAINT `FK_BranchId` FOREIGN KEY (`BranchId`) REFERENCES `branch` (`BranchId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_EmployeeID` FOREIGN KEY (`EmployeeId`) REFERENCES `person` (`PersonID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_Jobcode` FOREIGN KEY (`JobCode`) REFERENCES `job` (`JobCode`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ManagerId` FOREIGN KEY (`ManagerId`) REFERENCES `employee` (`EmployeeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_DepartmentId` FOREIGN KEY (`DepartmentId`) REFERENCES `department` (`DepartmentId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (5,1,1,'JC01',5),(6,1,1,'JC02',5),(7,1,3,'JC03',5),(8,1,1,'JC04',5),(9,1,1,'JC05',5),(10,1,2,'JC06',5),(11,1,1,'JC07',5);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job` (
  `JobCode` char(4) NOT NULL,
  `Designation` varchar(45) NOT NULL,
  `Responsibility` varchar(45) NOT NULL,
  PRIMARY KEY (`JobCode`),
  UNIQUE KEY `JobId_UNIQUE` (`JobCode`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES ('JC01','Manager','Responsbile for everything'),('JC02','Account Manager','Approves the loans'),('JC03','Service Manager','Solves the requests'),('JC04','Front desk Officer','Welcomes the customer'),('JC05','Banking Assistant','Creates the customer'),('JC06','Sales Assistant','Markets about products'),('JC07','Teller','Responsble for maual transactions');
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan`
--

DROP TABLE IF EXISTS `loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loan` (
  `LoanId` int(11) NOT NULL,
  `LoanType` char(5) NOT NULL,
  `LoanAmount` double NOT NULL,
  `StartDate` date NOT NULL,
  `EMI` float NOT NULL,
  `Apr` float NOT NULL,
  `Term` int(11) NOT NULL,
  `RemainingBal` double NOT NULL,
  PRIMARY KEY (`LoanId`),
  KEY `FK2_LoanType_idx` (`LoanType`),
  CONSTRAINT `FK2_LoanType` FOREIGN KEY (`LoanType`) REFERENCES `loantype` (`LoanType`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan`
--

LOCK TABLES `loan` WRITE;
/*!40000 ALTER TABLE `loan` DISABLE KEYS */;
INSERT INTO `loan` VALUES (44545,'LT004',35000,'2012-06-01',500,4,48,31000),(45331,'LT002',65000,'2011-03-04',600,6,200,64000),(56741,'LT001',10000,'2012-01-01',500,5,100,9000),(56745,'LT003',50000,'2010-07-01',700,7,48,40000);
/*!40000 ALTER TABLE `loan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan_customer`
--

DROP TABLE IF EXISTS `loan_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loan_customer` (
  `loanId` int(11) NOT NULL,
  `customerId` int(11) NOT NULL,
  PRIMARY KEY (`loanId`,`customerId`),
  KEY `FK7_customerId_idx` (`customerId`),
  CONSTRAINT `FK4_LoanId` FOREIGN KEY (`loanId`) REFERENCES `loan` (`LoanId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK9_CustomerId` FOREIGN KEY (`customerId`) REFERENCES `customer` (`CustomerId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan_customer`
--

LOCK TABLES `loan_customer` WRITE;
/*!40000 ALTER TABLE `loan_customer` DISABLE KEYS */;
INSERT INTO `loan_customer` VALUES (44545,1),(45331,2),(56741,3),(56745,4);
/*!40000 ALTER TABLE `loan_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan_transaction`
--

DROP TABLE IF EXISTS `loan_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loan_transaction` (
  `LoanTransactionId` int(11) NOT NULL,
  `LoanId` int(11) NOT NULL,
  `TransactionDate` datetime NOT NULL,
  `TransactionAmount` double NOT NULL,
  PRIMARY KEY (`LoanTransactionId`),
  KEY `Fk_LoanId_idx` (`LoanId`),
  CONSTRAINT `Fk_LoanId` FOREIGN KEY (`LoanId`) REFERENCES `loan` (`LoanId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan_transaction`
--

LOCK TABLES `loan_transaction` WRITE;
/*!40000 ALTER TABLE `loan_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `loan_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loantype`
--

DROP TABLE IF EXISTS `loantype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loantype` (
  `LoanType` char(5) NOT NULL,
  `Description` varchar(45) NOT NULL,
  `MinApr` float NOT NULL,
  `MaxApr` float NOT NULL,
  `MinTerm` int(11) NOT NULL,
  `MaxTerm` int(11) NOT NULL,
  PRIMARY KEY (`LoanType`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loantype`
--

LOCK TABLES `loantype` WRITE;
/*!40000 ALTER TABLE `loantype` DISABLE KEYS */;
INSERT INTO `loantype` VALUES ('LT001','Personal Loan',5,17,1,48),('LT002','HomeEquity Loan',2,14,2,200),('LT003','Vehicle Loan',4,10,3,100),('LT004','Education Loan',2,9,4,48);
/*!40000 ALTER TABLE `loantype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `logId` int(11) unsigned NOT NULL,
  `TransactionId` int(11) NOT NULL,
  `TransactionDate` datetime NOT NULL,
  `TransactionAmount` decimal(10,0) NOT NULL,
  PRIMARY KEY (`logId`),
  KEY `FK_TransactionId_idx` (`TransactionId`),
  CONSTRAINT `FK5_TransactionID` FOREIGN KEY (`TransactionId`) REFERENCES `account_transaction` (`TransactionId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (0,1,'2014-12-02 21:56:07',100);
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_history`
--

DROP TABLE IF EXISTS `login_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login_history` (
  `LoginHistoryId` int(11) NOT NULL AUTO_INCREMENT,
  `LoginTime` datetime NOT NULL,
  `Logout` datetime NOT NULL,
  `UserName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`LoginHistoryId`),
  KEY `FK_UserName2_idx` (`UserName`),
  CONSTRAINT `FK_UserName2` FOREIGN KEY (`UserName`) REFERENCES `credentials` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_history`
--

LOCK TABLES `login_history` WRITE;
/*!40000 ALTER TABLE `login_history` DISABLE KEYS */;
INSERT INTO `login_history` VALUES (1,'2014-01-01 10:11:10','2014-01-01 10:15:10','DeepthiM'),(2,'2014-04-25 22:11:10','2014-04-25 22:12:10','JoeCarew'),(3,'2014-09-01 10:11:10','2014-01-01 10:15:10','LahariM'),(4,'2014-10-01 10:11:10','2014-01-01 10:15:10','Rebecca'),(5,'2014-01-01 10:11:10','2014-01-01 10:15:10','DeepthiM');
/*!40000 ALTER TABLE `login_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `over_draft_protection`
--

DROP TABLE IF EXISTS `over_draft_protection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `over_draft_protection` (
  `OverDraftProtectionId` int(11) NOT NULL AUTO_INCREMENT,
  `AccountId` int(11) NOT NULL,
  `isEnabled` bit(1) NOT NULL,
  `MinBalance` float NOT NULL,
  PRIMARY KEY (`OverDraftProtectionId`),
  KEY `Fk4_AccountId_idx` (`AccountId`),
  CONSTRAINT `FK4_AccountId` FOREIGN KEY (`AccountId`) REFERENCES `account` (`AccountNumber`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `over_draft_protection`
--

LOCK TABLES `over_draft_protection` WRITE;
/*!40000 ALTER TABLE `over_draft_protection` DISABLE KEYS */;
INSERT INTO `over_draft_protection` VALUES (1,135790642,'',100),(2,246815791,'',100),(3,345310012,'',100),(4,567439871,'',100),(5,657451234,'',100);
/*!40000 ALTER TABLE `over_draft_protection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passwordhistory`
--

DROP TABLE IF EXISTS `passwordhistory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passwordhistory` (
  `PasswordHistoryId` int(11) NOT NULL AUTO_INCREMENT,
  `Password` varchar(45) NOT NULL,
  `CreationDate` varchar(45) NOT NULL,
  `ExpiryDate` varchar(45) NOT NULL,
  `UserName` varchar(20) NOT NULL,
  PRIMARY KEY (`PasswordHistoryId`),
  KEY `FK14_customerID_idx` (`UserName`),
  CONSTRAINT `FK_UserName1` FOREIGN KEY (`UserName`) REFERENCES `credentials` (`UserName`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passwordhistory`
--

LOCK TABLES `passwordhistory` WRITE;
/*!40000 ALTER TABLE `passwordhistory` DISABLE KEYS */;
INSERT INTO `passwordhistory` VALUES (1,'*FF63C13E0FE7889A6C6','2014-01-01','2012-02-01','DeepthiM'),(2,'*BE3FEFCC9812B512AE9','2014-02-01','2014-04-01','DeepthiM'),(3,'*FF63C13E0FE7889A6C6','2014-01-01','2012-02-01','JoeCarew'),(4,'*8BF7750FCCCADD3C6EC','2014-01-01','2012-02-01','LahariM'),(5,'*ACFF48594A65F3FA8CE','2014-01-01','2012-02-01','Rebecca');
/*!40000 ALTER TABLE `passwordhistory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `PersonID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `SSN` varchar(45) DEFAULT NULL,
  `EmailId` varchar(45) DEFAULT NULL,
  `PhoneNumber` varchar(45) DEFAULT NULL,
  `MobileNumber` varchar(45) DEFAULT NULL,
  `PersonType` char(1) DEFAULT NULL,
  PRIMARY KEY (`PersonID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Deepthi','Manam','123451234','manam.deepthi@gmail.com','6174164609','6174164609','C'),(2,'Joe','Carew','001117000','Joe.C@gmail.com','6179097315','6179097315','C'),(3,'Lahari ','Singareddy','123450001','lahari.manam@gmail.com','9097315617','9097315617','C'),(4,'Rebeccai','Biggs','987654321','rini@gmail.com','6175541515','6175541515','C'),(5,'Tom ','Sears','678309833','tom@gmail.com','7864957444','7864957444','E'),(6,'John ','peterson','167554564','john@gmail.com','4454335454','4454335454','E'),(7,'Kim ','Timbal','56765756756','kim@gmail.com','3445455553','3445455553','E'),(8,'Michael','Burrow','56756756','michael@gmail.com','565557777','565557777','E'),(9,'Lincoln','R','2335567875','lincoln@gmail.com','775654444','775654444','E'),(10,'Richard','Simons','34534788','richard@gmail.com','4599675577','4599675577','E'),(11,'Ratna','Sirasani','234234454','dev@gmail.com','5465465465','5465465465','E');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_address`
--

DROP TABLE IF EXISTS `person_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person_address` (
  `AddressId` int(11) NOT NULL,
  `PersonId` int(11) NOT NULL,
  PRIMARY KEY (`AddressId`,`PersonId`),
  KEY `FK_PersonId_idx` (`PersonId`),
  CONSTRAINT `FK5_AddressId` FOREIGN KEY (`AddressId`) REFERENCES `address` (`AddressID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK5_PersonId` FOREIGN KEY (`PersonId`) REFERENCES `person` (`PersonID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_address`
--

LOCK TABLES `person_address` WRITE;
/*!40000 ALTER TABLE `person_address` DISABLE KEYS */;
INSERT INTO `person_address` VALUES (1,1),(3,1),(2,2),(4,3),(5,4);
/*!40000 ALTER TABLE `person_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reward`
--

DROP TABLE IF EXISTS `reward`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reward` (
  `RewardId` int(11) NOT NULL AUTO_INCREMENT,
  `Description` varchar(45) NOT NULL,
  `RewardPoints` float NOT NULL,
  PRIMARY KEY (`RewardId`),
  KEY `FK6_CustomerId_idx` (`Description`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reward`
--

LOCK TABLES `reward` WRITE;
/*!40000 ALTER TABLE `reward` DISABLE KEYS */;
INSERT INTO `reward` VALUES (1,'Reward 10 Points',10),(2,'Reward 20 Points',20),(3,'Reward 40 points',40),(4,'Reward 50 points',50),(5,'Reward 60 points',60);
/*!40000 ALTER TABLE `reward` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secretquestions`
--

DROP TABLE IF EXISTS `secretquestions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secretquestions` (
  `QuestionID` int(11) NOT NULL AUTO_INCREMENT,
  `QuestionDescription` varchar(200) NOT NULL,
  PRIMARY KEY (`QuestionID`),
  UNIQUE KEY `QuestionID_UNIQUE` (`QuestionID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secretquestions`
--

LOCK TABLES `secretquestions` WRITE;
/*!40000 ALTER TABLE `secretquestions` DISABLE KEYS */;
INSERT INTO `secretquestions` VALUES (1,'What is the name of your first school?'),(2,'what is the your mothers maiden name?'),(3,'what is your fathers maiden name?'),(4,'what is your first pet name?'),(5,'Where did you meet your first love?'),(6,'What is the first city of your job?');
/*!40000 ALTER TABLE `secretquestions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service` (
  `ServiceId` int(11) NOT NULL AUTO_INCREMENT,
  `ServiceType` char(5) NOT NULL,
  `CustomerId` int(11) NOT NULL,
  `RequestedDate` date NOT NULL,
  `Status` varchar(45) NOT NULL,
  `EmployeeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`ServiceId`),
  KEY `ServiceaType_idx` (`ServiceType`),
  KEY `CustomerId_idx` (`CustomerId`),
  KEY `FK_employeeID_idx` (`EmployeeId`),
  CONSTRAINT `FK22_CustomerID` FOREIGN KEY (`CustomerId`) REFERENCES `customer` (`CustomerId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK22_ServiceType` FOREIGN KEY (`ServiceType`) REFERENCES `servicetype` (`ServiceType`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK22_employeeID` FOREIGN KEY (`EmployeeId`) REFERENCES `employee` (`EmployeeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'ST001',1,'2011-01-02','Completed',7),(2,'ST002',2,'2010-07-06','Completed',7),(3,'ST001',4,'2009-11-02','Completed',7),(4,'ST004',2,'2011-01-15','Completed',7);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicetype`
--

DROP TABLE IF EXISTS `servicetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicetype` (
  `ServiceType` char(5) NOT NULL,
  `ServiceDescription` varchar(45) NOT NULL,
  PRIMARY KEY (`ServiceType`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicetype`
--

LOCK TABLES `servicetype` WRITE;
/*!40000 ALTER TABLE `servicetype` DISABLE KEYS */;
INSERT INTO `servicetype` VALUES ('ST001','Dispute Transaction'),('ST002','Request for cheques'),('ST003','Request for deposit slips'),('ST004','Cancel payment of cheque');
/*!40000 ALTER TABLE `servicetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactiontype`
--

DROP TABLE IF EXISTS `transactiontype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transactiontype` (
  `TransactionType` char(4) NOT NULL,
  `Description` varchar(45) NOT NULL,
  `ChargeAssociated` varchar(45) NOT NULL,
  PRIMARY KEY (`TransactionType`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactiontype`
--

LOCK TABLES `transactiontype` WRITE;
/*!40000 ALTER TABLE `transactiontype` DISABLE KEYS */;
INSERT INTO `transactiontype` VALUES ('TT01','Online','0'),('TT02','Wire','25'),('TT03','Credit Card','0'),('TT04','Debit Card','0'),('TT05','ATM with drawal','0'),('TT06','Manual','0');
/*!40000 ALTER TABLE `transactiontype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bankingsystem'
--
/*!50003 DROP FUNCTION IF EXISTS `CustomerLevel` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `CustomerLevel`(accountBal double) RETURNS varchar(10) CHARSET latin1
    DETERMINISTIC
BEGIN
    DECLARE lvl varchar(10);
 
    IF accountBal > 50000 THEN
 SET lvl = 'PLATINUM';
    ELSEIF (accountBal <= 50000 AND accountBal >= 10000) THEN
        SET lvl = 'GOLD';
    ELSEIF accountBal < 10000 THEN
        SET lvl = 'SILVER';
    END IF;
 
 RETURN (lvl);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `AccountSummary` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `AccountSummary`(accountNumber INT)
Begin
select  acctTrs.transactionDate as `Date Of Transaction`,
 acctTrs.SentToOrReceivedFrom `Sent To Or Received From`,
acctTrs.TransactionAmount `Transaction Amount`,
acctTrs.CreditOrDebit  `Credit Or Debit`,
tt.Description `Transaction Type`,
acctTrs.Status `Status`
 from 
account_transaction acctTrs inner join transactiontype tt
 on tt.TransactionType = acctTrs.TransactionType
 where AccountId = accountNumber;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Transfer_Amount` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Transfer_Amount`(accountNo1 INT, accountNo2 INT, transferAmount DOUBLE)
BEGIN
START TRANSACTION;
update account set AvailableBalance = AvailableBalance - transferAmount where AccountNumber = accountNo1;
update account set AvailableBalance = AvailableBalance + transferAmount where AccountNumber = accountNo2;
COMMIT;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `customer_account_information`
--

/*!50001 DROP TABLE IF EXISTS `customer_account_information`*/;
/*!50001 DROP VIEW IF EXISTS `customer_account_information`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `customer_account_information` AS select `c`.`CustomerId` AS `CustomerId`,`a`.`AccountNumber` AS `AccountNumber`,`at`.`Name` AS `AccountType`,`a`.`AvailableBalance` AS `AvailableBalance` from (((`customer` `c` join `account_customer` `ac` on((`ac`.`CustomerId` = `c`.`CustomerId`))) join `account` `a` on((`a`.`AccountNumber` = `ac`.`AccountNumber`))) join `account_type` `at` on((`a`.`AccountType` = `at`.`AccountType`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `customer_basic_info`
--

/*!50001 DROP TABLE IF EXISTS `customer_basic_info`*/;
/*!50001 DROP VIEW IF EXISTS `customer_basic_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `customer_basic_info` AS select `p`.`FirstName` AS `FirstName`,`p`.`LastName` AS `LastName`,`p`.`SSN` AS `SSN`,`p`.`EmailId` AS `EmailId`,`p`.`MobileNumber` AS `MobileNumber`,`a`.`Street` AS `Street`,`a`.`City` AS `City`,`a`.`State` AS `State`,`a`.`ZipCode` AS `ZipCode`,`a`.`AddressType` AS `AddressType` from ((`person` `p` join `person_address` `pa` on((`p`.`PersonID` = `pa`.`PersonId`))) join `address` `a` on((`a`.`AddressID` = `pa`.`AddressId`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `customer_card_info`
--

/*!50001 DROP TABLE IF EXISTS `customer_card_info`*/;
/*!50001 DROP VIEW IF EXISTS `customer_card_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `customer_card_info` AS select `c`.`CustomerId` AS `customerId`,`card`.`CardNumber` AS `CardNumber`,`ct`.`Description` AS `Description`,`card`.`StartDate` AS `startDate`,`card`.`ExpiryDate` AS `ExpiryDate`,`card`.`CreditBalance` AS `CreditBalance`,`card`.`AccountNumber` AS `AccountNumber` from ((`customer` `c` join `card` on((`c`.`CustomerId` = `card`.`CustomerId`))) join `card_type` `ct` on((`ct`.`CardType` = `card`.`CardType`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `customer_loan_information`
--

/*!50001 DROP TABLE IF EXISTS `customer_loan_information`*/;
/*!50001 DROP VIEW IF EXISTS `customer_loan_information`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `customer_loan_information` AS select `c`.`CustomerId` AS `CustomerId`,`l`.`LoanId` AS `LoanId`,`lt`.`Description` AS `Description`,`l`.`LoanAmount` AS `LoanAmount`,`l`.`StartDate` AS `StartDate`,`l`.`EMI` AS `emi`,`l`.`Apr` AS `Apr`,`l`.`RemainingBal` AS `RemainingBal` from (((`customer` `c` join `loan_customer` `lc` on((`lc`.`customerId` = `c`.`CustomerId`))) join `loan` `l` on((`l`.`LoanId` = `lc`.`loanId`))) join `loantype` `lt` on((`l`.`LoanType` = `lt`.`LoanType`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `customer_service_request`
--

/*!50001 DROP TABLE IF EXISTS `customer_service_request`*/;
/*!50001 DROP VIEW IF EXISTS `customer_service_request`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `customer_service_request` AS select `c`.`CustomerId` AS `CustomerId`,`s`.`ServiceId` AS `ServiceId`,`st`.`ServiceDescription` AS `serviceDescription`,`s`.`RequestedDate` AS `RequestedDate`,`s`.`Status` AS `Status` from ((`customer` `c` join `service` `s` on((`s`.`CustomerId` = `c`.`CustomerId`))) join `servicetype` `st` on((`st`.`ServiceType` = `s`.`ServiceType`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-09 13:43:47
