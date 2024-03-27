# About The Project and Framework
This is the Test Automation project for the Web Factory; It makes use of the [SHAFT_Engine](https://github.com/ShaftHQ/SHAFT_ENGINE) Framework (Unified Test Automation Engine).

## High Level Design
- We are implementing the Page Object Model (POM) design pattern with Fluent Design
- **Page/Object classes:** (found in src/main/java path) to store the page locators and the actions made on them
- **Test classes:** (found in src/test/java path) to have the test suite, test cases, setup and tear-down methods.  
Test classes are making use of the Page/Object classes to serve as test cases steps.
- **Test Data files:** (found in src/test/resources path) to store the test data used in the test cases.
- **Cookie switchers files:** (found in src/test/resources path) to store the cookie switchers files we need to switch branches for testing purposes.
- **Properties files:** (found in src/main/resources path) to store the project and framework global configurations.

## Conventions
- [Git Management Process](https://github.vodafone.com/VFDE-Digital/wf-test-automation/wiki/Git-Management-Process)
- [Project & Code Conventions](https://github.vodafone.com/VFDE-Digital/wf-test-automation/wiki/Project-&-Code-Conventions)
