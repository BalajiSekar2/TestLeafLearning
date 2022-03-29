Feature: Duplicate Lead

Background: 
#Given A Chrome Browser is launched
#And Load the leaftaps URL 'http://leaftaps.com/opentaps/control/main'
#And Maximize the broswer
Given Enter the UserName 'DemoSalesManager'
And Enter the Password 'crmsfa'
And Click on Login Button
And Click on CRM/SFA link

Scenario: Duplicate Lead Positive flow

Given Click Find Leads link
And Enter the Email as 'test@gmail.com'
And Click on Find Leads button
When Click on the First Search result
Then Click on Duplicate Lead button and Verify
