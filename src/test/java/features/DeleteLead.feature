Feature: Delete Lead

Background: 
#Given A Chrome Browser is launched
#And Load the leaftaps URL 'http://leaftaps.com/opentaps/control/main'
#And Maximize the broswer
Given Enter the UserName 'DemoSalesManager'
And Enter the Password 'crmsfa'
And Click on Login Button
And Click on CRM/SFA link

Scenario: Delete Lead Positive flow

Given Click Find Leads link
And Enter the PhoneNumber as '98'
And Click on Find Leads button
And Click on the First Search result
Then Click on Delete Lead button and Verify



