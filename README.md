# UI-Automation-Challenge
SUT:
https://www.themoviedb.org/

Scenarios:

o Scenario: Successful Login
Given the user wants to login
When the user enters the credentials
Then the user should be able to login

o Scenario: Failed Login
Given the user wants to log in
When the user submits invalid credentials
Then the user should see a red error message
And the user should see two more error messages

o Scenario: Successful Search
Given the user wants to search for a movie
When the user enters the title ‘Fight Club’
Then the user should see the movie as the first result

o Scenario: Verify Movie Genre Filter
Given the user wants to see the top-rated movies
And the user wants to filter for ‘action’ movies
When the user applies the ‘action’ filter
And the user selects any movie
Then the user should see the genre of the movie includes ‘action’

o Scenario: Validate Acting Timeline
Given the user selects a movie with actors
And the user selects an actor from the top billed cast
When the user checks the actor’s acting timeline
Then the title of the movie should be in the timeline

o Scenario: Sort by Dates on Ascending Order
Given the user wants to sort top-rated movies by their date
When the user sorts by date on ascending order
Then the user should see the dates of the first 4 movies in ascending order

Examination Criteria
The challenge consists in automating the scenarios provided, applying the concepts learned during the UI-Selenium training.
Sharing code with your peers is completely forbidden and will have an entire point deduction in the evaluation of your challenge.
You are allowed to use any test runner, reporting tool and login tool of your choice. 

If you want to investigate, you are allowed to use the BDD tool Cucumber as well, however, keep in mind that this is not mandatory 
for the challenge.
The criteria for the evaluation consist in the following items.

Mandatory:
• Best locator strategies
• Page object model (page object design pattern)
• Meaningful loggers
• Execution of the entire suite using Maven
• Test reporting implementation

Forbidden:
• Thread.sleep()
• Positional locators
• Code duplication
• Hard-coded values

Dependencies used:
Cucumber
Testng
Selenium
Hamcrest
Logback

Project structure:

pages: pages of the Webpage
resources : contains the driver, the features, hooks and step definitions
utils : have clases that help the steps
