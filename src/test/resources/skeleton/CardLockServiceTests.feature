Feature: Card Lock Service Tests 

Background: Server is up and running 
Given Rest service is deployed on "http://demo4963299.mockable.io/"

Scenario: Verify if user is able to successfully lock the card on providing all correct information 
When I requested card lock service with "Header_card_locking_success"
Then I should get status code as "200"

Scenario: Verify if card is already locked  
When I requested card lock service with "Header_card_locking_already_locked"
Then I should get status code as "403"

