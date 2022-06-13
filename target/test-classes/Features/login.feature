Feature: this is the login feature for orange HRM

Scenario Outline: this is the login scenario
Given user is on login page
When the user enters the valid "<username>" and "<password>"
And clicks on the login button
Then the user should be navigated to home page

Examples:
|username|password|
|AAA|123|
|Admin|Admin123|

