This project is a framework for UI testing of web sites.<br />

Technology stack: Java, TestNG, Selenium Webdriver, Maven, Jackson, Lombok, Log4j

The framework is based on the following rules:<br />

•	All the classes are put to corresponding packages to maintain a coherent structure <br />
•	Test and configure data are put to json files for fast and convenient changing<br />
• Before- and after- blocks contain common code for every test<br />
• After- block contains quitting of web driver, so it is performed even in case of test failing<br />
• Repeting parts of code are put to methods to reduce amount of code and improve editing<br />
• All the Asserts contain a message explaining possible error in case of failing<br />
