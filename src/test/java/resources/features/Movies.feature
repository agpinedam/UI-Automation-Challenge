Feature: Movies
  Scenario: Successful Search
    Given the user wants to search for a movie
    When the user enters the title "Fight Club"
    Then the user should see the movie "Fight Club" as the first result

  Scenario: Verify Movie Genre Filter
    Given the user wants to see the top-rated movies
    And the user wants to filter for "Action" movies
    When the user applies the "Action" filter
    And the user selects "The Dark Knight" movie
    Then the user should see the genre of the movie includes "Action"

  Scenario: Sort by Dates on Ascending Order
    Given the user wants to sort top-rated movies by their date
    When the user sorts by date on ascending order
    Then the user should see the dates of the first 4 movies in ascending order
