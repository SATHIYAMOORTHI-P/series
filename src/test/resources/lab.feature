
@tag
Feature: To check the product foliow details

  @tag1
  Scenario: product follow for shampoo
    Given User enters into the home page
    When User addtobag the product
    Then User enters into the checkout page
   
@tag2
Scenario: product follow for wash
Given User enter into the home page
When User select the product
Then User enters into payment page

@tag3
Scenario: To check the login functionality
Given User enter into the login page 
When User enter the details
Then User enters into the account page