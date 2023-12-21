Feature: Place the order for products

@PlaceOrder
Scenario Outline: Search experience for product search in both home and offer page

Given User is on greenCart landing page
When user searched with shortname <Name> and extracted actual name of product
And Added "3" items of the selected product to cart
Then User proceeds to checkout and validate the <Name> items in checkout page
And Verify user has the ability to enter promo code and place the order

Examples:
|Name|
|Tomato|
|Carrot|