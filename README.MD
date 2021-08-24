# Test task:

1. Зайти на сайт https://www.aviasales.by/.
2. Ввести данные рейса:
	Откуда: Москва
	Куда: Санкт-Петербург
	Дата туда: завтра (относительно текущей даты)
	Дата обратно: послезавтра (относительно текущей даты)
	Пассажиры: 1 взрослый, 1 ребенок.
3. Нажать "Найти".
4. На странице с результатами поиска для каждого результата (блок с рейсами туда и обратно) проверить:
	- города вылета и прилета для обоих рейсов соответствуют введенным на главной странице;
	- даты вылета каждого из рейсов соответствуют введенной на главной странице.
5. Проверить, что все результаты отсортированы по возрастанию цены (цена в кнопке "Купить").


## Languages and Frameworks

This project using the following languages and frameworks:

* [Java 8](https://openjdk.java.net/projects/jdk/8/) as the programming language
* [TestNG](https://testng.org/doc/) as the UnitTest framework to support the test creation
* [Selenium WebDriver](https://www.selenium.dev/) as the web browser automation framework using the Java binding
* [Log4J2](https://logging.apache.org/log4j/2.x/) as the logging management strategy
* [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) as the Selenium binaries management
* [Owner](http://owner.aeonbits.org/) to minimize the code to handle the properties file


## Test architecture

* [Page Objects pattern](#page-objects-pattern)
* [BaseTest](#basetest)
* [TestListener](#testlistener)
* [Logging](#logging)
* [Configuration files](#configuration-files)