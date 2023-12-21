Feature: Search and place the order for products

@OfferPage
Scenario Outline: Search experience for product search in both home and offer page

Given User is on greenCart landing page
When user searched with shortname <Name> and extracted actual name of product
Then user searched for <Name> same shortname in offers page
And validate product name in offer page matched with landing page

Examples:
|Name|
|Tom|