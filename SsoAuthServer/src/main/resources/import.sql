-- accounts in system
insert into account(account_id, account_username , password, email) values(1,'test', 'spring', 'eamil@gmail.com');
insert into account(account_id, account_username , password, email) values(2,'peter', 'spring', 'eamil1@gmail.com');

-- available roles
insert into role(role_id, role_name) values (1,'ROLE_USER');
insert into role(role_id, role_name) values (2,'ROLE_ADMIN');
insert into role(role_id, role_name) values (3,'ROLE_GUEST');

-- accounts with roles
insert into account_role(account_id, role_id) values (1,1);
insert into account_role(account_id, role_id) values (1,2);
insert into account_role(account_id, role_id) values (2,1);
--
--
--
-- -- oauth client details
insert into client_details(   client_id, client_secret,  resource_ids,   scopes,   grant_types,                                  authorities)
                    values(   'acme' ,  'acmesecret',    null,           'openid,read',   'authorization_code,refresh_token,password',  null );