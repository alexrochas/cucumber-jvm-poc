Feature: Ask my name
  As a developer
  In order to know my name
  I want to be able to ask

  Scenario: Hit endpoint /whatsyourname
    Given a running application
    When accessing the endpoint http://localhost:8080/whatsyourname
    Then should return Alex

  Scenario: Hit endpoint /whatsyourmiddlename
    Given a running application
    When accessing the endpoint http://localhost:8081/whatsyourmiddlename
    Then should return Rocha
