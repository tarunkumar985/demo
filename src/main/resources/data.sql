INSERT INTO employees (name, department, age, email, salary, created_at, updated_at) VALUES
('Alice Johnson','Technology', 28, 'alice.johnson@example.com', 55000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Bob Smith', 'Mechanical',35, 'bob.smith@example.com', 72000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Cathy Brown','Technology', 30, 'cathy.brown@example.com', 64000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('David Lee','Mechanical', 42, 'david.lee@example.com', 85000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Eva Green','Technology', 25, 'eva.green@example.com', 48000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Frank Miller', 'Mechanical',50, 'frank.miller@example.com', 92000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Grace Kim', 'Mechanical',27, 'grace.kim@example.com', 51000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Henry Adams', 'Technology',33, 'henry.adams@example.com', 70000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Isla Moore','Mechanical', 29, 'isla.moore@example.com', 61000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Jack Wilson','Technology', 40, 'jack.wilson@example.com', 88000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Kelly Martinez','Mechanical', 32, 'kelly.martinez@example.com', 67000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Leo Thomas','Technology', 38, 'leo.thomas@example.com', 76000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Mia Clark','Civil', 24, 'mia.clark@example.com', 47000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Noah Lewis','Technology', 26, 'noah.lewis@example.com', 52000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Olivia Walker','Civil', 31, 'olivia.walker@example.com', 66000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Paul Allen','Civil', 36, 'paul.allen@example.com', 74000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Quinn Young','Technology', 41, 'quinn.young@example.com', 81000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Ruby Hall','Civil', 23, 'ruby.hall@example.com', 46000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Sam Scott','Technology', 39, 'sam.scott@example.com', 79000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Tina Evans','Civil', 34, 'tina.evans@example.com', 69000.00, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);


INSERT INTO users (username, password) VALUES ('alice', '$2a$12$Ok/OOEOmb0mo11UILZWHAeEpLG0DPdDjZ97eMdVTidbPZq6lF0E6u');--password123
INSERT INTO users (username, password) VALUES ('bob', '$2a$12$Ok/OOEOmb0mo11UILZWHAeEpLG0DPdDjZ97eMdVTidbPZq6lF0E6u');
INSERT INTO users (username, password) VALUES ('charlie', 'charlie123');
INSERT INTO users (username, password) VALUES ('diana', 'mypassword');


INSERT INTO role (name) VALUES ('ROLE_USER');
INSERT INTO role (name) VALUES ('ROLE_ADMIN');


INSERT INTO user_roles (user_id, role_name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO user_roles (user_id, role_name) VALUES (2, 'ROLE_USER');
