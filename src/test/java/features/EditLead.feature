Feature: Edit Lead

Background:
#Given A Chrome Browser is launched
#And Load the leaftaps URL 'http://leaftaps.com/opentaps/control/main'
#And Maximize the broswer
Given Enter the UserName 'DemoSalesManager'
And Enter the Password 'crmsfa'
And Click on Login Button
And Click on CRM/SFA link

Scenario: Edit Lead Positive Flow

Given Create Lead link is available
And Enter the CompanyName as 'TestCompanyName'
And Enter the FirstName as 'Balaji'
And Enter the LastName as 'S'
And Create Lead button is clicked
Then Lead should be created successfully
And Edit button is available and Clicked
And Update the Company name as 'UpdatedName'
When click submit button
Then Verify the edit lead details 'UpdatedName'

