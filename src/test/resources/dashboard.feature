Feature: Create Certificate
  Create certificates and download them after creation

  Scenario: Login as a authenticated user
    Given User Login to Dashboard 
    When User clicks on ‘create certificate'
    And User enters the Product and Customer information
    And User completes the payment
    Then Certificate is available for download
    
    
  