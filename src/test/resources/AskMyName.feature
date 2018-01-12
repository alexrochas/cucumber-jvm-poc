Feature: Ask my name
  As a developer
  In order to know my name
  I want to be able to ask

  Scenario: Hit endpoint /whatsyourname
    Given a running application
    When accessing the endpoint /whatsyourname
    Then should return Alex
