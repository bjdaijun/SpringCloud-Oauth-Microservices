DROP TABLE account if EXISTS ;
DROP TABLE role if EXISTS ;
DROP TABLE account_role if EXISTS ;
DROP TABLE client_details if EXISTS ;

--
create table account (
  ACCOUNT_ID INT,
  ACCOUNT_USERNAME VARCHAR (255) not null,
  PASSWORD VARCHAR(255) not null,
  EMAIL VARCHAR(255) not null,
  ENABLED bool default true);

--
create table role (
  ROLE_ID VARCHAR(255) not null,
  ROLE_NAME VARCHAR(255) not null,);

--
create table account_role (
  ACCOUNT_ID VARCHAR(255) not null,
  ROLE_ID VARCHAR(255) not null,);

--
create table client_details(
  CLIENT_ID VARCHAR (255) not null unique ,
  CLIENT_SECRET VARCHAR (255) not null   ,
  RESOURCE_IDS VARCHAR (255) null ,
  SCOPES VARCHAR (255) null ,
  GRANT_TYPES VARCHAR (255) null ,
  AUTHORITIES VARCHAR (255) null
);