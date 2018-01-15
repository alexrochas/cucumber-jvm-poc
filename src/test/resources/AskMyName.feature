Feature: Ask my name
  As a developer
  In order to know my name
  I want to be able to ask

  Scenario: Hit endpoint /whatsyourname
    Given a running application
    When accessing the endpoint http://localhost:8080/whatsyourname
    Then should return Alex

  @MockedApi
  Scenario: Hit endpoint /whatsyourmiddlename
    Given a running application
    When accessing the endpoint http://localhost:8081/whatsyourmiddlename
    Then should return Rocha

  Scenario: Hit endpoint /whatsyourmiddlename
    Given a running application
    When accessing the endpoint http://canned:8082/whatsyourage
    Then should return 18

  Scenario: Hit endpoint /whatsyourjob
    Given a running application
    When accessing the endpoint http://external:8084/whatsyourjob
    Then should return Still seeking one

