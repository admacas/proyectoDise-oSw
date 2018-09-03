PGDMP         7                v            LineaBlanca    9.5.14    10.4 2    t           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            u           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            v           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            w           1262    16393    LineaBlanca    DATABASE     �   CREATE DATABASE "LineaBlanca" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Ecuador.1252' LC_CTYPE = 'Spanish_Ecuador.1252';
    DROP DATABASE "LineaBlanca";
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            x           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    6            y           0    0    SCHEMA public    ACL     �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    6                        3079    12355    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            z           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1255    16403 !   obtenerusuario(character varying)    FUNCTION     �   CREATE FUNCTION public.obtenerusuario(nombre character varying) RETURNS SETOF record
    LANGUAGE plpgsql
    AS $$
	begin
		select * from usuarios where usuarios.username=nombre and usuarios.estado=1;
	end;
$$;
 ?   DROP FUNCTION public.obtenerusuario(nombre character varying);
       public       postgres    false    6    1            �            1259    16437    clientes    TABLE     !  CREATE TABLE public.clientes (
    cedula character varying(15) NOT NULL,
    nombre character varying(50) NOT NULL,
    apellido character varying(50) NOT NULL,
    telefono character varying(25) NOT NULL,
    email character varying(25) NOT NULL,
    direccion character varying(150)
);
    DROP TABLE public.clientes;
       public         postgres    false    6            �            1259    16416 	   empleados    TABLE     �  CREATE TABLE public.empleados (
    cedula character varying(20) NOT NULL,
    nombre character varying(20) NOT NULL,
    apellido character varying(20) NOT NULL,
    email character varying(25) NOT NULL,
    telefono character varying(15) NOT NULL,
    edad integer NOT NULL,
    direccion character varying(150) NOT NULL,
    idlocal integer,
    iduser integer NOT NULL,
    estado boolean DEFAULT false,
    CONSTRAINT empleados_edad_check CHECK ((edad > 17))
);
    DROP TABLE public.empleados;
       public         postgres    false    6            �            1259    16406    locales    TABLE       CREATE TABLE public.locales (
    idlocal integer NOT NULL,
    nombre character varying(50) NOT NULL,
    telefono character varying(50) NOT NULL,
    email character varying(50) NOT NULL,
    red character varying(50) NOT NULL,
    direccion character varying(100)
);
    DROP TABLE public.locales;
       public         postgres    false    6            �            1259    16404    locales_idlocal_seq    SEQUENCE     |   CREATE SEQUENCE public.locales_idlocal_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.locales_idlocal_seq;
       public       postgres    false    184    6            {           0    0    locales_idlocal_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.locales_idlocal_seq OWNED BY public.locales.idlocal;
            public       postgres    false    183            �            1259    24585 	   productos    TABLE     0  CREATE TABLE public.productos (
    codigo character varying(25) NOT NULL,
    marca character varying(25) NOT NULL,
    modelo character varying(25) NOT NULL,
    color character varying(20) NOT NULL,
    descripcion character varying(150) NOT NULL,
    cantidad integer,
    precio double precision
);
    DROP TABLE public.productos;
       public         postgres    false    6            �            1259    24623    reportes    TABLE     �   CREATE TABLE public.reportes (
    idreporte integer NOT NULL,
    idfactura character varying(15),
    idproducto character varying(20),
    cantidad integer
);
    DROP TABLE public.reportes;
       public         postgres    false    6            �            1259    24621    reportes_idreporte_seq    SEQUENCE        CREATE SEQUENCE public.reportes_idreporte_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.reportes_idreporte_seq;
       public       postgres    false    190    6            |           0    0    reportes_idreporte_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.reportes_idreporte_seq OWNED BY public.reportes.idreporte;
            public       postgres    false    189            �            1259    16396    usuarios    TABLE     �   CREATE TABLE public.usuarios (
    iduser integer NOT NULL,
    username character varying(25) NOT NULL,
    passwords character varying(25) NOT NULL,
    rol character varying(50) NOT NULL,
    estado integer DEFAULT 1
);
    DROP TABLE public.usuarios;
       public         postgres    false    6            �            1259    16394    usuarios_iduser_seq    SEQUENCE     |   CREATE SEQUENCE public.usuarios_iduser_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.usuarios_iduser_seq;
       public       postgres    false    182    6            }           0    0    usuarios_iduser_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.usuarios_iduser_seq OWNED BY public.usuarios.iduser;
            public       postgres    false    181            �            1259    24590    ventas    TABLE     �   CREATE TABLE public.ventas (
    factura character varying(15) NOT NULL,
    valor double precision NOT NULL,
    fechas date NOT NULL,
    idempleado character varying(15),
    idcliente character varying(15)
);
    DROP TABLE public.ventas;
       public         postgres    false    6            �           2604    16409    locales idlocal    DEFAULT     r   ALTER TABLE ONLY public.locales ALTER COLUMN idlocal SET DEFAULT nextval('public.locales_idlocal_seq'::regclass);
 >   ALTER TABLE public.locales ALTER COLUMN idlocal DROP DEFAULT;
       public       postgres    false    184    183    184            �           2604    24626    reportes idreporte    DEFAULT     x   ALTER TABLE ONLY public.reportes ALTER COLUMN idreporte SET DEFAULT nextval('public.reportes_idreporte_seq'::regclass);
 A   ALTER TABLE public.reportes ALTER COLUMN idreporte DROP DEFAULT;
       public       postgres    false    190    189    190            �           2604    16399    usuarios iduser    DEFAULT     r   ALTER TABLE ONLY public.usuarios ALTER COLUMN iduser SET DEFAULT nextval('public.usuarios_iduser_seq'::regclass);
 >   ALTER TABLE public.usuarios ALTER COLUMN iduser DROP DEFAULT;
       public       postgres    false    182    181    182            m          0    16437    clientes 
   TABLE DATA               X   COPY public.clientes (cedula, nombre, apellido, telefono, email, direccion) FROM stdin;
    public       postgres    false    186   �:       l          0    16416 	   empleados 
   TABLE DATA               x   COPY public.empleados (cedula, nombre, apellido, email, telefono, edad, direccion, idlocal, iduser, estado) FROM stdin;
    public       postgres    false    185   k;       k          0    16406    locales 
   TABLE DATA               S   COPY public.locales (idlocal, nombre, telefono, email, red, direccion) FROM stdin;
    public       postgres    false    184   �<       n          0    24585 	   productos 
   TABLE DATA               `   COPY public.productos (codigo, marca, modelo, color, descripcion, cantidad, precio) FROM stdin;
    public       postgres    false    187   -=       q          0    24623    reportes 
   TABLE DATA               N   COPY public.reportes (idreporte, idfactura, idproducto, cantidad) FROM stdin;
    public       postgres    false    190   ?       i          0    16396    usuarios 
   TABLE DATA               L   COPY public.usuarios (iduser, username, passwords, rol, estado) FROM stdin;
    public       postgres    false    182   �?       o          0    24590    ventas 
   TABLE DATA               O   COPY public.ventas (factura, valor, fechas, idempleado, idcliente) FROM stdin;
    public       postgres    false    188   A@       ~           0    0    locales_idlocal_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.locales_idlocal_seq', 2, true);
            public       postgres    false    183                       0    0    reportes_idreporte_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.reportes_idreporte_seq', 28, true);
            public       postgres    false    189            �           0    0    usuarios_iduser_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.usuarios_iduser_seq', 12, true);
            public       postgres    false    181            �           2606    16441    clientes clientes_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (cedula);
 @   ALTER TABLE ONLY public.clientes DROP CONSTRAINT clientes_pkey;
       public         postgres    false    186            �           2606    16421    empleados empleados_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.empleados
    ADD CONSTRAINT empleados_pkey PRIMARY KEY (cedula);
 B   ALTER TABLE ONLY public.empleados DROP CONSTRAINT empleados_pkey;
       public         postgres    false    185            �           2606    16413    locales locales_nombre_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.locales
    ADD CONSTRAINT locales_nombre_key UNIQUE (nombre);
 D   ALTER TABLE ONLY public.locales DROP CONSTRAINT locales_nombre_key;
       public         postgres    false    184            �           2606    16411    locales locales_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.locales
    ADD CONSTRAINT locales_pkey PRIMARY KEY (idlocal);
 >   ALTER TABLE ONLY public.locales DROP CONSTRAINT locales_pkey;
       public         postgres    false    184            �           2606    16415    locales locales_telefono_key 
   CONSTRAINT     [   ALTER TABLE ONLY public.locales
    ADD CONSTRAINT locales_telefono_key UNIQUE (telefono);
 F   ALTER TABLE ONLY public.locales DROP CONSTRAINT locales_telefono_key;
       public         postgres    false    184            �           2606    24589    productos productos_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_pkey PRIMARY KEY (codigo);
 B   ALTER TABLE ONLY public.productos DROP CONSTRAINT productos_pkey;
       public         postgres    false    187            �           2606    16402    usuarios usuarios_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (iduser);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public         postgres    false    182            �           2606    24594    ventas ventas_factura_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.ventas
    ADD CONSTRAINT ventas_factura_key UNIQUE (factura);
 C   ALTER TABLE ONLY public.ventas DROP CONSTRAINT ventas_factura_key;
       public         postgres    false    188            �           2606    16422     empleados empleados_idlocal_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.empleados
    ADD CONSTRAINT empleados_idlocal_fkey FOREIGN KEY (idlocal) REFERENCES public.locales(idlocal);
 J   ALTER TABLE ONLY public.empleados DROP CONSTRAINT empleados_idlocal_fkey;
       public       postgres    false    2021    185    184            �           2606    16427    empleados empleados_iduser_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.empleados
    ADD CONSTRAINT empleados_iduser_fkey FOREIGN KEY (iduser) REFERENCES public.usuarios(iduser);
 I   ALTER TABLE ONLY public.empleados DROP CONSTRAINT empleados_iduser_fkey;
       public       postgres    false    185    182    2017            �           2606    24627     reportes reportes_idfactura_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.reportes
    ADD CONSTRAINT reportes_idfactura_fkey FOREIGN KEY (idfactura) REFERENCES public.ventas(factura);
 J   ALTER TABLE ONLY public.reportes DROP CONSTRAINT reportes_idfactura_fkey;
       public       postgres    false    190    188    2031            �           2606    24632 !   reportes reportes_idproducto_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.reportes
    ADD CONSTRAINT reportes_idproducto_fkey FOREIGN KEY (idproducto) REFERENCES public.productos(codigo);
 K   ALTER TABLE ONLY public.reportes DROP CONSTRAINT reportes_idproducto_fkey;
       public       postgres    false    190    2029    187            �           2606    24600    ventas ventas_idcliente_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ventas
    ADD CONSTRAINT ventas_idcliente_fkey FOREIGN KEY (idcliente) REFERENCES public.clientes(cedula);
 F   ALTER TABLE ONLY public.ventas DROP CONSTRAINT ventas_idcliente_fkey;
       public       postgres    false    186    2027    188            �           2606    24595    ventas ventas_idempleado_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.ventas
    ADD CONSTRAINT ventas_idempleado_fkey FOREIGN KEY (idempleado) REFERENCES public.empleados(cedula);
 G   ALTER TABLE ONLY public.ventas DROP CONSTRAINT ventas_idempleado_fkey;
       public       postgres    false    185    188    2025            m   �   x�]пN�0����y��v�/R%*!!�0�\]S��\{I�=I:��;|����c���\J�J�#�.xc]����~���b.�H�)il���$dwSZo��C�7�3�j��O]��w��xI�r|X�<a��D�X��2�Vic}���-��X��4��
eݺZi}>ϩ�c�����x�����3LL�)5���B���{X	      l   B  x�e��J�0��O��O0�4I��Ʉ����W�9��ڙ&������E�7�_��K�*�k!WΞ�[L�g�4|݅q�ޭ�0@e�f�Q�Wp��/�����G�=���2�2#��c��m���8�/��6��R �`;aB���%��P5���	>�8���!3��ac�	S���R��)<�D�����*`�����ٔA�@�I�F�l(��!l0�CC��aZyr/���<�2���Ի����ȸ����؆!W쎤j)����}�]Vߺi�A��IG�I��7�)��a��T�N����>�҇8Z���ݪ(�o�ߗ�      k   `   x�3�.M.-*N�Q.-�4012�0�41����KM
9d��&f��%��rC��5q!�����B0364� �j@^>� ��=... �=,/      n   �  x����n�@ ���)V�7�7�i��SR�iE���S3b��.o�#N<�_�Y�@�8pAp��;3ߌ��Wh�ה����X��R��jw�Di�i��-T>`+A����޽��he��2_]<)��0t0h^��TAip�w/|p^d��r�؃@=��b�;ME�g����z�]��������$�.
b�ن�Ș�\O.�Ƌ���.��}��g4�o�.W�]ޑ&t�b
��#�y��ڇ�ȓ�I,����f���a��7�@.)�uMm����{J�.�Akh@sS_�d�ǎ�q���GTuD=_��:�BG�"?b�en_�'N�}w��L\C���z��W��o������S��h��#U��</n|���s2��.�/�������Ӵ�p�i�9�P�2�K�w�Y.���W?��1�g�*����(�a����-��l~����~�$�7���      q   �   x�]��
�0��u�0%�$��ō���Ep��oc�Q'ۏ2?*��N�2�����0K#�E�����V�.�Ou��B�G���2|����4��u��5%�ٖA��De��@e ����Ku@2�����}/\      i   �   x�U���0D���TuU�]"b%�ȡK��!R]Ζ��w��}F�:�m;��^Y!M˔7�Ad,^sdY������E�q���Uɵ7��l\\���dT����i�\�bwH}������+ơf�?��RKJ�M�XN��b��'H=      o   �   x���A� E�x�N�(
w���1f:��hqg�B���|=THv�`b�^YԜ�k
�^�4����w�����+�x��<l��C�v��F��O��{�2[ԑ�B_Ӆw�L�.�A��]f�%DM����EJR$$�I�"Q�HR$Z8��T��)�|��x�     