Проект по безопасности для института - sql инъекции: Web приложение с методами обращения к бд по образу торговой площадки, позволяющие сделать sql инъекцию

Папка qw содержит дамп файлы:
1) единожды в исполнении
qw_create_database_dump - создание бд qw
qw_fierst_data_dump - заполнение данными
qw_roles_dump - создание ролей и пользователей
2) в логике переодического использования
qw_dump и rebut скрипты - возвращают бд к изначальному виду

Папка security-project содержит back-end проект (java 11):
Переменные среды в папке applications.
Pom описнаие:
<groupId>ru.ygtu.student</groupId>
<artifactId>security-project</artifactId>
<version>0.0.1-SNAPSHOT</version>


Запуск: в корневой директории с docker-compose.yml (должен быть установлен docker и docker-compose в дистрибутив unix системы) 1) запустить docker-compose build, 2) после сборки docker-compose up