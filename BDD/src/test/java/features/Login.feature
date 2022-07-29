
Feature: Login feature
#Author: Md Shadab Asim
#Created Date: 26-07-22
#Modified: 30-07-2022

 Background:
Given launch the "<browser>"
And Enter url "http://localhost:8888"



@smoke
Scenario Outline: Login to Vtiger using Valid data
Then login page should be displayed and title should contain "vtiger"
When Enter valid username "<username>" and password "<pwd>"
And  Click on loginbutton
Then Homepage should be displayed with Contact icon


Examples:

|username | pwd   |browser|
| admin   | admin |chrome |

@smoke
Scenario Outline: Login to Vtiger using Valid data
Then login page should be displayed and title should contain "vtiger"
When Enter valid username "<username>" and password "<pwd>"
And  Click on loginbutton
Then Homepage should be displayed with Organization icon
And Close the browser


Examples:

|username | pwd   |browser|
| admin   | admin |chrome |
