Feature: PHPTravels Complete Automation

Background:
Given user launches PHPTravels application

@Regression 
Scenario Outline: Validate complete booking workflow

When user enters phptravels username <username>
And user enters phptravels password <password>
And user clicks login button
Then user should login successfully

When user searches hotel <city>
And user selects checkin date <checkin>
And user selects checkout date <checkout>
And user selects travellers <travellers>
And user clicks hotel search button

Then hotel search result should display

When user selects first hotel
And user validates hotel prices
And user books hotel

Then booking should complete successfully

When user logout from phptravels application
Then browser should close successfully

Examples:
| username              | password | city   | checkin    | checkout   | travellers |
| user@phptravels.com   | demouser | Delhi  | 10-06-2026 | 15-06-2026 | 2 |
| user@phptravels.com   | demouser | Mumbai | 20-06-2026 | 25-06-2026 | 3 |