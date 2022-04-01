Feature: Create Contact

Background: 
#Given A Chrome Browser is launched
#And Load the leaftaps URL 'http://leaftaps.com/opentaps/control/main'
#And Maximize the broswer
Given Enter the UserName 'DemoSalesManager'
And Enter the Password 'crmsfa'
And Click on Login Button
And Click on CRM/SFA link

@smoke @sanity
Scenario: Create Contact Positive flow

Given Click Create contact link
And Enter the First Name as 'Balaji' and LastName as 'S'
And Enter the Department as 'Software' and Description as 'Test Desc' and Email as 'Test@email.com'
And Select the State as 'New York'
Given Click on Submit button
Then Click on Edit Contact button and Update the details as 'Test Update'





