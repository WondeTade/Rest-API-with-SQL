INSERT INTO users (username, password, enabled)
                    values ('user', 'user_password', 1);
 INSERT INTO users (username, password, enabled)
                    values ('admin', 'admin_password', 1);
 INSERT INTO users (username, password, enabled)
                    values ('wonde', 'wonde_password', 1);

INSERT INTO authorities (username, authority)
                    values ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority)
                    values ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority)
                    values ('wonde', 'ROLE_ADMIN');



