Feature: verify registration functionality

Scenario: verify user registration successfully

Given registration page should be open
When enter first name
And enter last name
And enter email
And select gender
And enter mobile number
Then registration form should be filled successfully