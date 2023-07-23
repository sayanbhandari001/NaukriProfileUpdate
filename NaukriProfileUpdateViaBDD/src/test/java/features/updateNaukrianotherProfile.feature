
Feature: Update Naukri another Profile on multiple Websites

@naukriIndiaUpdate
Scenario: Update my Naukri profile using another login
    Given I have all logged in setup and logged in to Naukri website
    And have my profile section open with 2nd login
    When I check for about section and validate whether updated
    Then I add dots if not available or remove if already available
    And check whether my profile is updated
