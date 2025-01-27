Write a simple automation suite to automate testing for HerokuApp sample website:
  
  https://the-internet.herokuapp.com/
  
  I have used Page Object Model design pattern for automation suite. I picked POM to store WebElements as it is very easy to manage, allows reusability of code and eliminates duplication of code. 

  I have used Page Factory concept. Here I have followed the same principle of keeping repository objects or page classes separate from test classes. Here we use @FindBy to find elements and initElements process to initialize WebElements.



[] To Get this project running, I installed the following:

    java jdk latest version (openjdk version "23.0.1" in my case)
    
    maven
    
    Downloaded chromedriver.
    
    IntelliJ IDE (community edition)


[] Project layout:

    'src/main/java/herokUApp/pages/base/HerokuAppTestBase.java' is the Base class that initiates logger, driver, sets capabilities, and does the teardown.
  
    'src/main/java/herokUApp/pages' package holds all classes related to the application / URL pages
  
    'src/main/java/herokUApp/config' package holds all configuration files.
  
    'src/main/java/herokUApp/util' package holds all utilities classes and implements extent reports.

    'src/test/java/herokUApp/testcases' package holds the TestNG tests to interact with Chrome browser.

The output logs are available in logs directory.

'test-downloads' directory is where all the file downloads/uploads happen.

'test-output/Extent Report' is where the extent reports are generated.


[] To execute the test:

    From IntelliJ IDE, you can execute a single class or a single test case from Right-click on classes/Tests from 'testcases' package and select 'Run <test name>'.
  
    To generate extent reports, right click on testng.xml and select Run testng.xml.

    To execute tests from command line. Change the directory in the batch file, to local directory where project is installed, and execute "run.bat" file.
  
