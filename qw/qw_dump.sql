--
-- PostgreSQL database dump
--

-- Dumped from database version 14.3
-- Dumped by pg_dump version 14.3

--
-- Clear data
--

delete from user_product_r where 1=1;
delete from users where 1=1;
delete from roles where 1=1;
delete from products where 1=1;

--
-- Set conf
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: products; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.products (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    description text,
    price numeric(10,2) NOT NULL,
    code_product integer NOT NULL,
    deleted_at timestamp without time zone
);


ALTER TABLE public.products OWNER TO postgres;

--
-- Name: products_code_product_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.products_code_product_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.products_code_product_seq OWNER TO postgres;

--
-- Name: products_code_product_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.products_code_product_seq OWNED BY public.products.code_product;


--
-- Name: products_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.products_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.products_id_seq OWNER TO postgres;

--
-- Name: products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;


--
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
    id integer NOT NULL,
    name character varying(50) NOT NULL
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- Name: roles_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.roles_id_seq OWNER TO postgres;

--
-- Name: roles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;


--
-- Name: user_product_r; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_product_r (
    id integer NOT NULL,
    user_id integer NOT NULL,
    product_id integer NOT NULL,
    deleted_at timestamp without time zone
);


ALTER TABLE public.user_product_r OWNER TO postgres;

--
-- Name: user_product_r_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_product_r_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_product_r_id_seq OWNER TO postgres;

--
-- Name: user_product_r_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_product_r_id_seq OWNED BY public.user_product_r.id;


--
-- Name: user_product_r_product_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_product_r_product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_product_r_product_id_seq OWNER TO postgres;

--
-- Name: user_product_r_product_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_product_r_product_id_seq OWNED BY public.user_product_r.product_id;


--
-- Name: user_product_r_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_product_r_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_product_r_user_id_seq OWNER TO postgres;

--
-- Name: user_product_r_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_product_r_user_id_seq OWNED BY public.user_product_r.user_id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    last_name character varying(50),
    password character varying(150) NOT NULL,
    deleted_at timestamp without time zone,
    password_noencoder character varying(150),
    login character varying(150),
    role_id integer NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: users_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.users_role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_role_id_seq OWNER TO postgres;

--
-- Name: users_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.users_role_id_seq OWNED BY public.users.role_id;


--
-- Name: products id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);


--
-- Name: products code_product; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products ALTER COLUMN code_product SET DEFAULT nextval('public.products_code_product_seq'::regclass);


--
-- Name: roles id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);


--
-- Name: user_product_r id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_product_r ALTER COLUMN id SET DEFAULT nextval('public.user_product_r_id_seq'::regclass);


--
-- Name: user_product_r user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_product_r ALTER COLUMN user_id SET DEFAULT nextval('public.user_product_r_user_id_seq'::regclass);


--
-- Name: user_product_r product_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_product_r ALTER COLUMN product_id SET DEFAULT nextval('public.user_product_r_product_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Name: users role_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users ALTER COLUMN role_id SET DEFAULT nextval('public.users_role_id_seq'::regclass);


--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.products (id, name, description, price, code_product, deleted_at) FROM stdin;
1	Смартфон Samsung Galaxy S21	\N	373.51	1	\N
2	Ноутбук HP Envy x360	\N	723.56	2	\N
3	Телевизор LG OLED CX	\N	696.98	3	\N
4	Наушники Sony WH-1000XM4	\N	915.11	4	\N
5	Кофемашина DeLonghi Magnifica	\N	726.84	5	\N
6	Холодильник Bosch KGN39XL30R	\N	553.72	6	\N
7	Пылесос Dyson V11 Absolute	\N	210.40	7	\N
8	Камера Canon EOS 5D Mark IV	\N	854.20	8	\N
9	Графический планшет Wacom Intuos Pro	\N	786.18	9	\N
10	Смарт-часы Apple Watch Series 7	\N	678.56	10	\N
\.


--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles (id, name) FROM stdin;
1	USER
2	SELLER
3	ADMIN
\.


--
-- Data for Name: user_product_r; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_product_r (id, user_id, product_id, deleted_at) FROM stdin;
1	2	10	\N
2	4	1	\N
3	2	2	\N
4	4	3	\N
5	2	4	\N
6	4	5	\N
7	2	6	\N
8	4	7	\N
9	2	8	\N
10	6	9	\N
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, name, last_name, password, deleted_at, password_noencoder, login, role_id) FROM stdin;
1	Иван	Иванов	$2a$10$OYjyB0h2ZbXTfuCdqyHIVOn1wpoCdpULI6R3KM6KQRliClRAFUIim	\N	zxc	zxc	1
2	Петр	Петров	$2a$10$fPaI8wqXY8lIn1nrWhTWtOzcNsiER5lIW2XMNBC4cWj6afjsupDx6	\N	qwe	qwe	2
3	Анна	Сидорова	$2a$10$P9o2.rE.ERefuBHPBIDdweXonzu9YmSoMMxrgkK8eJ1m3uJglC5I6	\N	pas	pas	1
4	Елена	Павлова	$2a$10$KU8/MUKooRUG4E.7h/oiAuA9DvrVKu9D/PUDoPoDBcYi1S89hiBc6	\N	asd	asd	2
5	Михаил	Смирнов	$2a$10$f9HVon5/Oi3in4MpDz5hke7u2//kzV87UcfLegivT6pXynrWNOz9C	\N	bmw	bmw	1
6	Ильюха	Петров	$2a$10$hnm0JvVCueGMNzDp7iPgKeyhmdwem/CAhkM9sv8DNdRbde/TBvXW2	\N	admin	admin	3
7	Ильюха	Петров	$2a$10$PhRd2QpysEiYqfimU3om2eFYtI2D1oYZdhBYN5fZj0qFMLiTLRQ6e	\N	petr2002	ov17	3
\.


--
-- Name: products_code_product_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.products_code_product_seq', 1, false);


--
-- Name: products_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.products_id_seq', 10, true);


--
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.roles_id_seq', 3, true);


--
-- Name: user_product_r_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_product_r_id_seq', 10, true);


--
-- Name: user_product_r_product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_product_r_product_id_seq', 1, false);


--
-- Name: user_product_r_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_product_r_user_id_seq', 1, false);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_id_seq', 7, true);


--
-- Name: users_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.users_role_id_seq', 1, false);


--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- Name: roles roles_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);


--
-- Name: user_product_r user_product_r_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_product_r
    ADD CONSTRAINT user_product_r_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: user_product_r user_product_r_product_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_product_r
    ADD CONSTRAINT user_product_r_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.products(id);


--
-- Name: user_product_r user_product_r_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_product_r
    ADD CONSTRAINT user_product_r_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- Name: users users_role_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_role_id_fkey FOREIGN KEY (role_id) REFERENCES public.roles(id);


--
-- Name: TABLE products; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.products TO admin_role;
GRANT ALL ON TABLE public.products TO seller_role;
GRANT SELECT ON TABLE public.products TO user_role;


--
-- Name: TABLE roles; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.roles TO admin_role;


--
-- Name: TABLE user_product_r; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.user_product_r TO admin_role;
GRANT INSERT ON TABLE public.user_product_r TO seller_role;


--
-- Name: TABLE users; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.users TO admin_role;


--
-- PostgreSQL database dump complete
--

