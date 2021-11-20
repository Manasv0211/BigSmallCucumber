Feature: Clicking on giftcard

  Scenario: Checking for giftcard validation
    Given user clicks on giftcard
    And user validates for giftcard
    Then user adds quantity
    When user adds gift to cart and clicks on goto checkout
    And user goes back to cart and validates whether it entered into cart or not