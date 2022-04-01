Feature: Create Lead

Background:
#Given A Chrome Browser is launched
#And Load the leaftaps URL 'http://leaftaps.com/opentaps/control/main'
#And Maximize the broswer
Given Enter the UserName 'DemoSalesManager'
And Enter the Password 'crmsfa'
And Click on Login Button
And Click on CRM/SFA link

@functional @regresssion
Scenario Outline: Create Lead Postive flow
Given Create Lead link is available
And Enter the CompanyName as <CompanyName>
And Enter the FirstName as <FirstName>
And Enter the LastName as <LastName>
When Create Lead button is clicked
Then Lead should be created successfully

Examples:
|CompanyName|FirstName|LastName| 
|'TestCompanyName1' | 'Balaji' | 'S' |
|'TestCompanyName2' | 'Bharath' | 'L' |