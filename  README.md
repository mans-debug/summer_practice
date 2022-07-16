### Для запуска тестов:
- mvn clean test
- прописать путь к папке для логов в классе AbstractSelenium test на 29-ой строчке
### Для получения отчетов:
- mvn allure::serve (запускать только после 'mvn clean test')
### Для генерации javadoc:
- mvn javadoc:test-javadoc
- javadoc будет находится в /target/site/testapidocs/index.html
### Зависимости
Зависимость Selenium WD manager
Плагин allure-maven
### Логи всего приложения
Находятся в корневой папке с названием main.log
По умолчанию показывает только ошибки уровня ERROR
Для изменения уровня логгирования с ERROR на INFO, следует изменить первую срочку файла log4j.properties на
log4j.rootLogger=ERROR, STDOUT, file
