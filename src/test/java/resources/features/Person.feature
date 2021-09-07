Feature: Person
  Scenario: Validate Acting Timeline
    Given the user selects a movie with actors
    And the user selects an actor from the top billed cast
    When the user checks the actor's acting timeline
    Then the title of the movie should be in the timeline