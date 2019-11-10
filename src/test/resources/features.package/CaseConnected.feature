Feature: Case Search and Checklist

  Background:
    Given I logged in the CMS

    Scenario: Searching case on Case Search
      When I create case
      And I search for created case in Case Search page
      Then the case is found

      Scenario Outline: Complete Checklist
        When I create specific case
        And I add party with type "<partyType>" and role "<partyRole>"
        And I add case event
        And I add case caption and case title
        Then checklist is absent on Case View page

        Examples:
        | partyType | partyRole |
        | Party     | Claimant  |
        | Participant | Third Party |