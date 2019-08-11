My configuration details : MacOS, Chrome web driver, Eclipse with java, selenium and junit

I have used chrome browser. Generally we test on all the browsers (Web and Mobile) that more than an accepted number of users are using along with various combinations of Operating Systems. Major chunk of tests are executed on headless browser for faster execution of test suites. All these things are configurable and would need one time set up.

Setup:
Install JDK
Download eclipse from https://www.eclipse.org/downloads/
Download Chrome driver compatible with your OS from http://chromedriver.chromium.org/downloads
Place the chromedriver executable in lib folder (I have already places the executable for mac)

It is a maven based project, so all jar files will be automatically added.

I have used Page Object Model for setting up the Tests.
