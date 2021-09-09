Feature: Movies
  Scenario: Successful Search
    Given the user wants to search for a movie
    When the user enters the title Fight Club
    Then the user should see the movie as the first result

  Scenario: Verify Movie Genre Filter
    Given the user wants to see the top-rated movies
    And the user wants to filter for action movies
    When the user applies the action filter
    And the user selects any movie
    Then the user should see the genre of the movie includes action

  Scenario: Sort by Dates on Ascending Order
    Given the user wants to sort top-rated movies by their date
    When the user sorts by date on ascending order
    Then the user should see the dates of the first 4 movies in ascending order

  Scenario: Add Movie in a List
    Given : I have created a list before
    And : have the corresponding list id
    And : I have a valid api key
    And : I have a valid session ID
    When : I send the query and the request
    Then : I get a confirmation
    And : I get a message
