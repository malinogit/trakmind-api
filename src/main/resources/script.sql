INSERT INTO role (id, name) VALUES (1, 'ANONYMOUS');
INSERT INTO role (id, name) VALUES (2, 'BASIC_USER');
INSERT INTO role (id, name) VALUES (3, 'GLOBAL_ADMIN');

INSERT INTO privilege (id, name) VALUES (1, 'KIRA');

INSERT INTO roles_privileges (role_id, privilege_id) VALUES (
  (SELECT r.id
   FROM role r
   WHERE r.name = 'BASIC_USER'),
  (SELECT p.id
   FROM privilege p
   WHERE p.name = 'KIRA')),
  (
    (SELECT r.id
     FROM role r
     WHERE r.name = 'GLOBAL_ADMIN'),
    (SELECT p.id
     FROM privilege p
     WHERE p.name = 'KIRA'));
COMMIT;