Feature: Validating place API

  Scenario Outline: Verify that place is successfully added using AddPlace API
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" using "Post" https request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

    Examples:
      | name                     | language   | address            |
      | Muzej Nikole Tesle       | Serbian-SR | Krunska 51         |
      | Studentski Dom Karaburma | Serbian-SR | Mije Kovacevica 7b |