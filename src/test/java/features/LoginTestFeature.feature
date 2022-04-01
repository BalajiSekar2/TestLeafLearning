Feature: Create Lead

#Background:
#Given A Chrome Browser is launched
#And Load the leaftaps URL 'http://leaftaps.com/opentaps/control/main'
#And Maximize the broswer

@functional
Scenario Outline: LeafTaps Login Mutiple data

Given Enter the UserName <username>
And Enter the Password <password>
When Click on Login Button
Then Home screen should be displayed successfully

Examples:
|username|password|
|'DemoSalesManager'|'crmsfa'|

@smoke @regression
Scenario: LeafTaps Login Positive flow
Given Enter the UserName 'DemoSalesManager'
And Enter the Password 'crmsfa'
When Click on Login Button
Then Home screen should be displayed successfully

@Sanity
Scenario: LeafTaps Login Negative flow
Given Enter the UserName 'DemoSalesManager'
And Enter the Password 'crmsfa1'
When Click on Login Button
But Error message should be displayed


