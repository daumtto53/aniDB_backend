USE anidb_batch_test;
CREATE TABLE IF NOT EXISTS anidb_role (
    role_id INT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(32),
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP DEFAULT now() ON UPDATE now()
);
INSERT IGNORE INTO anidb_role (role_name)
    VALUES  ('ROLE_ADMIN'),
            ('ROLE_MANAGER'),
            ('ROLE_USER')