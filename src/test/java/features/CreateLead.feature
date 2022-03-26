Feature: Create Lead

Background:
Given A Chrome Browser is launched
And Load the leaftaps URL 'http://leaftaps.com/opentaps/control/main'
And Maximize the broswer
And Enter the UserName 'DemoSalesManager'
And Enter the Password 'crmsfa'
And Click on Login Button
And Click on CRM/SFA link

Scenario: Create Lead Postive flow
Given Create Lead link is available
And Enter the CompanyName as 'TestCompanyName'
And Enter the FirstName as 'Balaji'
And Enter the LastName as 'S'
When Create Lead button is clicked
Then Lead should be created successfully