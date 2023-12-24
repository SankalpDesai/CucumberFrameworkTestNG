Feature: Offers page dropdown and discounted items scenarios

@OfferPageScenarios
Scenario Outline: Check offers page page size dropdown

Given User is on greenCart landing page
When user click on top deals link
Then user should able to see 5,10,20 options in page size dropdown
And user click on <pageSizeCount> in dropdown and able to see options in result

Examples:
|pageSizeCount|
|5|
|10|
|20|