chcp 1251
set PGPASSWORD=petrov200217
psql -w -U postgres -d qw -f "qw_dump.sql" 2>&1
set PGPASSWORD=no