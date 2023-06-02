# Test automation project for [webinar.ru](https://webinar.ru/)
<img title="Webinar" src="images/webinar_top.jpg"></div>

##  <a name="contents">:page_facing_up: Сontents</a>
- [Description](#paperclip-description)
- [Tools and technologies](#hammer_and_wrench-tools-and-technologies)
- [Test cases](#white_check_mark-test-cases)
- [How to run](#arrow_forward-how-to-run)
- [Test results report in Allure Report](#-test-results-report-in-allure-report)
- [Allure TestOps integration](#-allure-testops-integration)
- [Jira integration](#-jira-integration)
- [BrowserStack App Automate](#-browserstack-app-automate)
- [Telegram notifications](#-telegram-notifications)
- [Sample test run in Selenoid](#-sample-test-run-in-selenoid)

## :paperclip: Description
The project implements web and mobile (android) tests for website and app. \
It has the following features:
- [x] **Page Object** design pattern
- [x] Using **Java Faker** for generating test data
- [x] Parametrized tests
- [x] Different configs using **Owner** for test running 
- [x] Parametrized build
- [x] **Allure TestOps** and **Jira** integration
- [x] Lambda style **Steps**
- [x] Autotests as test documentation

## :hammer_and_wrench: Tools and technologies
<p  align="center"><a href="https://www.jetbrains.com/idea/"><img src="https://github.com/gloomyana/gloomyana/blob/main/icons/intellij_idea.svg" title="IntelliJ IDEA" alt="IntelliJ IDEA" width="50" height="50"/></a>
<a href="https://www.java.com"><img src="https://github.com/gloomyana/gloomyana/blob/main/icons/java.svg" title="Java" alt="Java" width="50" height="50"/></a>
<a href="https://selenide.org"><img src="https://github.com/gloomyana/gloomyana/blob/main/icons/selenide.svg" title="Selenide" alt="Selenide" width="50" height="50"/></a>
<a href="https://junit.org/junit5"><img src="https://github.com/gloomyana/gloomyana/blob/main/icons/junit5.svg" title="JUnit5" alt="JUnit5" width="50" height="50"/></a>
<a href="https://gradle.org"><img src="https://github.com/gloomyana/gloomyana/blob/main/icons/gradle.svg" title="Gradle" alt="Gradle" width="50" height="50"/></a>
<a href="https://www.jenkins.io"><img src="https://github.com/gloomyana/gloomyana/blob/main/icons/jenkins.svg" title="Jenkins" alt="Jenkins" width="50" height="50"/></a>
<a href="https://qameta.io/allure-report"><img src="https://github.com/gloomyana/gloomyana/blob/main/icons/allure_report.svg" title="Allure Report" alt="Allure Report" width="50" height="50"/></a>
<a href="https://qameta.io"><img src="https://github.com/gloomyana/gloomyana/blob/main/icons/allure_testops.svg" title="Allure Testops" alt="REST Assured" width="50" height="50"/></a>
<a href="https://web.telegram.org/"><img src="https://github.com/gloomyana/gloomyana/blob/main/icons/telegram.svg" title="Telegram" alt="Telegram" width="50" height="50"/></a> 
<a href="https://www.atlassian.com/software/jira"><img src="https://github.com/gloomyana/gloomyana/blob/main/icons/jira.svg" title="Jira" alt="Jira" width="50" height="50"/></a> 
<a href="https://aerokube.com/selenoid/latest/"><img src="https://github.com/gloomyana/gloomyana/blob/main/icons/selenoid.svg" title="Selenoid" alt="Selenoid" width="50" height="50"/></a>
<a href="https://www.browserstack.com/automate"><img src="https://github.com/gloomyana/gloomyana/blob/main/icons/browserstack.svg" title="Browserstack" alt="Browserstack" width="50" height="50"/></a></p>

## :white_check_mark: Test cases
**UI tests:**
- [x] Successful opening of **Blog** page
- [x] Click **Try** button opens **Sign Up** page
- [x] **Blog page** menu items are enabled, visible and clickable *(parametrized)*
- [x] Click on logo reopens main page
- [x] Click on participant button opens registration sidebar
- [x] Check promo title of main page
- [x] Successful opening of **Tariffs** page
- [x] Webinar tariff type contains expected tariff options *(parametrized)*

**Mobile app tests:**
- [x] Check **Forgot** password button functionality
- [x] Successful user login
- [x] Successful user logout
- [x] Successful user data update

[back to Contents ⬆](#contents)

## :arrow_forward: How to run
### Gradle build
To run tests locally the following gradle command is used:
```bash
$ gradle clean test -Denv=<env>
```
`test` tasks with tags:
- web
- mobile
 
`env`, `envMobile`  - defines an environment for running these tests:
- local
- remote
- mobile_local
- mobile_remote

Additional parameters:
- `-Dbrowser=` `DbrowserVersion=` `DbrowserSize=` - set parameters for the browser
- `-DremoteUrl=` - set url for remote webdriver

Valid combinations:
```mermaid
graph LR
A[test type] --> B[web]
A --> C[mobile]
B --> D[remote]
B --> E[local]
C --> F[mobile-local]
C --> G[mobile-remote]
```
### Running tests in [Jenkins](https://jenkins.autotests.cloud/job/gloomyana_webinar_tests/)
To run tests in Jenkins the following command is used:
```bash
clean
${TASK}
"-Dbrowser=${BROWSER}"
"-DbrowserVersion=${BROWSER_VERSION}"
"-DbrowserSize=${BROWSER_SIZE}"
"-DremoteUrl=${REMOTE_URL}"
"-Denv=${ENV}"
"-DenvMobile=${MOBILE_ENV}"
```
Main page of the build:

<img src="images/jenkins-job.jpg" alt="Jenkins job main page">

The build of the project is parameterized, so before starting it, you need to choose parameters:

<img src="images/jenkins-build-page.jpg" alt="Jenkins build page">

To run web/mobile tests only:
<img src="images/jenkins-build-parameters.jpg" alt="run web/mobile tests parameters" width="900">

After the build is done the test results are available in `Allure Report` and `Allure TestOps` 

<img src="images/jenkins-build.jpg" alt="Jenkins build page"> 

[back to Contents ⬆](#contents)

## <img width="3%" title="Allure Report" src="https://github.com/gloomyana/gloomyana/blob/main/icons/allure_report.svg"> Test results report in [Allure Report](https://jenkins.autotests.cloud/job/gloomyana_webinar_tests/allure)
### Overview page

Overview page of Allure report contains the following parts:
>- **ALLURE REPORT** displays date and time of the test, overall number of launched tests and chart showing the percentage and number of successful, fallen and broken tests
>- **SUITES** displays groups of tests that share a common context such as a specific test environment or a particular test category
>- **FEATURES** displays groups of tests according to Epic, Feature tags
>- **TREND** displays trend of running tests for all runs
>- **CATEGORIES** displays distribution of unsuccessful tests by defect types
>- **EXECUTORS** displays information on test executors that were used to run the tests

<img src="images/allure-result-main.jpg" alt="Allure Report Overview page">

### Graphs page
Graphs allow to see different statistics collected from the test data: statuses breakdown or severity and duration diagrams.

<img src="images/allure-result-graphs.jpg" alt="Allure Report graphs">

### Suites page
On the **SUITES** tab a standard structural representation of the executed tests, grouped by suites and classes can be found.
Each test case have information such as `severity`, `description`, `duration`, `test data` and execution `steps`.

<img src="images/allure-result-test-example.jpg" alt="Allure Report suites">

Also additional test artifacts are available:
>- Last Screenshot
>- Page Source
>- Browser console logs
>- Video

<img src="images/allure-result-attachments.jpg" alt="Allure Report attachments">

[back to Contents ⬆](#contents)

## <img width="3%" title="Allure TestOps" src="https://github.com/gloomyana/gloomyana/blob/main/icons/allure_testops.svg"> [Allure TestOps](https://allure.autotests.cloud/project/2582/dashboards) integration

### Dashboards
<img src="images/allure-testops-dashboard.jpg" alt="Allure TestOps dashboards">

### Test cases
<img src="images/allure-testops-test-cases.jpg" alt="Allure TestOps test cases">

<img src="images/allure-testops-test-cases-2.jpg" alt="Allure TestOps test cases">

[back to Contents ⬆](#contents)

## <img width="3%" title="Jira" src="https://github.com/gloomyana/gloomyana/blob/main/icons/jira.svg"> Jira integration
<img src="images/jira-integration.jpg" alt="Jira task">

[back to Contents ⬆](#contents)

## <img width="3%" title="Browserstack" src="https://github.com/gloomyana/gloomyana/blob/main/icons/browserstack.svg"> BrowserStack App Automate

BrowserStack Dashboard with an example of a mobile test result:

<p align="center"><img src="images/browserstack-app-profiling-full.jpg" alt="Browserstack app capabilities">
 </p>

[back to Contents ⬆](#contents)

## <img width="3%" title="Telegram" src="https://github.com/gloomyana/gloomyana/blob/main/icons/telegram.svg"> Telegram notifications

**Telegram bot** sends a report to a specified telegram chat by results of each project build.

<p align="center"><img src="images/telegram-notifications.jpg" alt="Telegram notifications">
</p>

[back to Contents ⬆](#contents)

## <img width="3%" title="Selenoid" src="https://github.com/gloomyana/gloomyana/blob/main/icons/selenoid.svg"> Sample test run in Selenoid

<p align="center"><img src="images/web-test-video.gif" alt="web test video">
</p>

<p align="center"><img src="images/mobile-test-video.gif" alt="mobile test video">
</p>

[back to Contents ⬆](#contents)
