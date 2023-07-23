Feature: Update Naukri Profile on multiple Websites

  Background:
 @naukriIndiaUpdate
  Scenario: Update my Naukri profile
  Given I have all system setup and logged in to Naukri(India) website
  And have my profile section open
  When I check for about section and validate whether updated with or without dot
  Then I add dot if not available or remove if already available
  And check whether my profile is updated or not
  
@naukriIndiaUpdate
Scenario: Update my Naukri profile using another login
    Given I have all logged in setup and logged in to Naukri website
    And have my profile section open with 2nd login
    When I check for about section and validate whether updated
    Then I add dots if not available or remove if already available
    And check whether my profile is updated