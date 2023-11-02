FROM postgres:14.9
ENV POSTGRES_USERNAME=postgres
ENV POSTGRES_PASSWORD=postgres
ENV ON_ERROR_STOP=0

COPY ./init/qw_create_database_dump.sql /docker-entrypoint-initdb.d/1.sql
COPY ./init/qw_fierst_data_dump.sql /docker-entrypoint-initdb.d/2.sql
COPY ./init/qw_roles_dump.sql /docker-entrypoint-initdb.d/3.sql

COPY ./qw_dump.sql ./rebut.sh /bd/
WORKDIR /bd

RUN chmod 777 -R /bd && chmod 777 -R /docker-entrypoint-initdb.d