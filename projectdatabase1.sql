use airlinemanagmentsystem;

describe login;

create table login(username	varchar(20),	
password	varchar(20)	);

insert into login values("admin","12345");

drop table login;		

select * from passanger;
create  table passanger(username varchar(20) Not Null,
name varchar(20) Not Null,
 age int(2) Not Null,
 birthdate varchar(10) Not Null,
 address varchar(20) Not Null,
 phone  int(10) Not Null check(length(phone)=10),
 nationality varchar(20) Not Null,
 passportno varchar(20) Not Null,
 gender varchar(7) Not Null,
 emailid varchar(25) Not Null);
 drop table passanger;
 describe passanger;
 
 
 
 describe Tickit;
 
 
 create table Tickit(Tickitid int(20) Not Null,	
       Source	varchar(20)	NOT Null,		
       Destination	varchar(20)	NOT Null,		
       Class	varchar(20)	NOT Null,		
       Price	decimal(7,2)Not Null,		
      Flight_code	varchar(7)Not Null,	
      Flight_Name	varchar(20)	NOt Null,	
      Journeydate	varchar(10)	Not Null,		
       Journeytime	varchar(6)	NOt Null,		
        Username	varchar(20)	NOt Null,		
         Name	varchar(20)	NOt Null );	
         
         drop  table Tickit;
         select * from Tickit;
         describe AddFlight;
         
 create table  AddFlight(FlightCode	varchar(20)	NOt Null primary key,	
Flight_Name	varchar(20)	Not Null,		
Source	varchar(20)	NOt Null,		
Destination	varchar(20)	NOt Null,		
Capacity	varchar(20)	NOt Null,		
Class	varchar(20)	NOt Null,		
Price	decimal(7,2)NOt Null);		
 
 drop table AddFlight;
 describe payment;
 
 create table payment(amount	decimal(7,2)Not Null,		
method	varchar(20)	NOt Null,		
Id	varchar(20)	NOt Null,		
user	varchar(20)	NOt Null,		
Name	varchar(20)	NOt Null);

		
