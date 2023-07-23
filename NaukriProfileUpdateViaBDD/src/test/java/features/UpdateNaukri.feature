Feature: Update Naukri Profile on multiple Websites

  Background:
  	@naukriIndiaUpdate
  Scenario: Update my Naukri profile
  Given I have all system setup and logged in to Naukri(India) website
  And have my profile section open
  When I check for about section and validate whether updated with or without dot
  Then I add dot if not available or remove if already available
  And check whether my profile is updated or not
 
 
  