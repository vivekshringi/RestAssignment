Feature: Getting Card Service details

Background: Server is up and running 
Given Rest service is deployed on "http://demo4963299.mockable.io/"

Scenario: Verify if user is able to get card details successfully on providing correct information 
When I requested card details with "Header_active_card_user"
Then I should get response as "get_card_details_active" and status code as "200"

Scenario: Verify if user is able to get card details successfully if card is locked but with encrypted pan no in response
When I requested card details with "Header_locked_card_user"
Then I should get response as "get_card_details_status_locked" and status code as "200"

Scenario: Verify if user is not authenticated
When I requested card details with "Header_with_wrong_authentication"
Then I should get response as "user_with_unauthorised" and status code as "401"