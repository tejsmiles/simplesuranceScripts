Feature: Create Certificate
  Create certificates and download them after creation

  Scenario: Create and Download Certificate
    Given User Login to Dashboard 
    When User clicks on ‘create certificate'
    And User enters the Product and Customer information
    And User completes the payment
    Then Certificate is available for download
    
    
   Scenario: Search using Zertifikatsnummer
    Given User Login to Dashboard 
    When User clicks on ‘search functionality'
    And User enters the Zertifikatsnummer
    And User clicks search
    Then Certificate with Zertifikatsnummer is displayed
    
   Scenario: Search using Customer email
    Given User Login to Dashboard 
    When User clicks on ‘search functionality'
    And User enters the customer email 
    And User clicks search
    Then Certificate with Zertifikatsnummer is displayed
    
   Scenario: View certificates from list
    Given User Login to Dashboard 
    When User clicks on ‘search functionality'
    And User clicks on first certificate from the list
    Then Certificate is displayed
    
    
   Scenario: Create subagents
    Given User Login to Dashboard 
    When User clicks on ‘create subagents'
    And User enters subagent details
    Then Subagent created is displayed in the list
    
   Scenario: View subagents
    Given User Login to Dashboard 
    When User clicks on ‘create subagents'
    Then Subagent list is displayed
    
  