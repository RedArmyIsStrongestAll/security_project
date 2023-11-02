--
-- PostgreSQL database dump
--

-- Dumped from database version 14.3
-- Dumped by pg_dump version 14.3

\c qw


--
-- Roles and Users
--

--REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA public FROM user_role;
--REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA public FROM seller_role;
--REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA public FROM admin_role;
--DROP ROLE IF EXISTS admin_role;
--DROP ROLE IF EXISTS seller_role;
--DROP ROLE IF EXISTS user_role;
CREATE ROLE admin_role;
CREATE ROLE seller_role;
CREATE ROLE user_role;

GRANT ALL ON ALL TABLES IN SCHEMA public TO admin_role;
GRANT ALL ON TABLE products TO seller_role;
GRANT INSERT ON TABLE user_product_r TO seller_role;
GRANT SELECT ON TABLE products TO user_role;

--DROP USER IF EXISTS admin_u;
--DROP USER IF EXISTS seller_u;
--DROP USER IF EXISTS user_u;
CREATE USER admin_u WITH PASSWORD 'admin_p';
ALTER USER admin_u SET ROLE admin_role;
grant admin_role to admin_u;
CREATE USER seller_u WITH PASSWORD 'seller_p';
ALTER USER seller_u SET ROLE seller_role;
grant seller_role to seller_u; 
CREATE USER user_u WITH PASSWORD 'user_p';
ALTER USER user_u SET ROLE user_role;
grant user_role to user_u; 


--
-- PostgreSQL database dump complete
--