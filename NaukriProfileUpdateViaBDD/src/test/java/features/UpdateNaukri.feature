Feature: Update Naukri Profile on multiple Websites
  
Background: 
@naukriIndiaUpdateold
Scenario: Update user Naukri profile
  Given I have all system setup and logged in to Naukri(India) website
  And have my profile section open
  When I check for about section and validate whether updated with or without dot
  Then I add dot if not available or remove if already available
  And check whether my profile is updated or not
  
@naukriIndiaUpdateold
Scenario: Update user Naukri profile using another login
  Given I have all logged in setup and logged in to Naukri website
  And have my profile section open with 2nd login
  When I check for about section and validate whether updated
  Then I add dots if not available or remove if already available
  And check whether my profile is updated

@naukriUpdateInternational
Scenario: Update user GulfNaukri profile
  Given I have all logged in setup and logged in to GulfNaukri website
  And have my profile section open with GulfNaukri login
  When I check for Profile Page
  Then I update data as per my requirement
  And validate whether my profile is updated

@naukriIndiaUpdate
Scenario Outline: Update user Naukri profile using allIndian login
Given I have logged in setup and logged in to Naukri website
  And have my profile section open with <username> login and <password>
  When I check for profile section and validate whether updated
  Then I update bio with new data
  And check whether my profile is updated as of today
  
  Examples:
  
  		|	username	|	password	|
      | "sayanbhandari007@gmail.com" | "" |
     	| "bhandarisayan@gmail.com" | "" |
      | "sayanbhandari001@gmail.com" | "" |

