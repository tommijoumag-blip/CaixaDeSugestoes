-- Conta didática local: admin / Admin@123456. Apenas o hash BCrypt é persistido.
-- Uma base com administrador cadastrado é preservada.
INSERT INTO administrators (username, password_hash, active)
SELECT 'admin', '$2a$12$V1POzMK.w8.31MWqErlWWOqtDKTj2.5rSz9/5tIcFtxtmC.tmHKdG', TRUE
WHERE NOT EXISTS (SELECT 1 FROM administrators);