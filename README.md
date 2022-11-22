# README #

Please refer to this document regarding any doubts
### What is this repository for? ###

* Tests are built upon the Selenium WebDriver automation framework, written in Java and executed using the TestNG unit framework.
* Version 1.0
* Please make sure to add the latest stable version dependency of the selenium webdriver library
  * To use selenium, you can either add as a JAR file in your library through Project Structure > Modules > Dependencies > Add Jar or directories
  * Or add the dependency through Maven or Gradle
* [WebDriver Documentation](https://www.selenium.dev/documentation/webdriver/)
* [MVN repository for Selenium](https://mvnrepository.com/artifact/org.seleniumhq.selenium/)
* [MVN repository for TestNG](https://mvnrepository.com/artifact/org.testng/testng/)
* [MVN repository for JUnit](https://mvnrepository.com/artifact/junit/junit/)
* [ChromeDriver](https://chromedriver.chromium.org/)
* [GeckoDriver](https://github.com/mozilla/geckodriver/releases)
  * Assets > and download the respective driver for your OS

### How do I get set up? ###

* You must have a proper IDE to be able to run Java projects (Intellij, Eclipse or Visual Studio Code)
* For this code, we are using azul-15.0.7, refer to java --version to make sure your java is compatible
* Configuration
* For dependencies:
  * add the latest dependency for selenium (please refer to the links above)
  * add the latest dependency for TestNG (please refer to the links above)
* Download the latest ChromeDriver and GeckoDriver release (please refer to the links above)
  * After downloading it, make sure to add it to the resources file on src/resources file on your repository
* How to run tests
  * You may run TestSteps on tests package or run each scenario separately
  * You may change test priority to run all scenarios in a certain order
* Screenshots will be stored in C:\Screenshots\
* You may run with either browsers uncommenting some lines of system property

### Who do I talk to? ###

* Repo owner [GITHUB](https://github.com/daniellyluzardo)

### Other Scenarios to automate ###
* Some scenarios can be added for later use:
  * Concatenate valid email address (example@example.com)
  * Try to input Names containing numbers and special characters
  * Test mandatory fields in Feedback forms
  * Check if the successful message after sending is showing the correct Name value
  * Run with both browsers without having to uncomment
