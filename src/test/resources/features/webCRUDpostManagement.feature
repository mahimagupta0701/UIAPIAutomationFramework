Feature: Post Management in React Admin Demo

  Scenario Outline: Create post with all required fields
    Given user opens the application
    When I login with username "test@example.com" and password "admin"
    Given I enter reference details from example section: "<reference>", "<image>"
    And I provide additional inputs: height "<height>", width "<width>", price "<price>", stock "<stock>", sales "<sales>", category "<category>", reference "<reference>"
    And I enter description "Water"
    When I submit the post
    Then I should see "<reference>" in the list
    Then I delete the poster

    Examples:
      | reference          | image      | height | width | price | stock | sales | category |
      | Test Automation    | water.jpg  | 10     | 20    | 500   | 50    | 12    | Water    |

