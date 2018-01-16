Feature: Ask my name
  As a developer
  In order to know my name
  I want to be able to ask

  Scenario: Hit endpoint /whatsyourname
    Given a running application
    When accessing the endpoint /whatsyourname
    Then should return Alex

  @MockedApi
  Scenario: Hit endpoint /whatsyourmiddlename
    Given a running application
    When accessing the endpoint /whatsyourmiddlename
    Then should return Rocha

  Scenario: Hit endpoint /whatsyourage
    Given a running application
    When accessing the endpoint /whatsyourage
    Then should return 18

  Scenario: Hit endpoint /whatsyourjob
    Given a running application
    When accessing the endpoint /whatsyourjob
    Then should return Still seeking one

