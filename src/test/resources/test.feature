@Test
  Feature: MailRu_test

    @Test_001
    Scenario Outline: Send-receive email
    Given I am om mail.ru start page
    When I login to mail using "<login>" and "<password>"
    When I press 'Write letter' button
    When I write letter to "<login>" with "<subject>" and text "<textMessage>"
    Then I press 'Send letter'
    Then I receive new letter
      Examples:
        | login | password | subject | textMessage|
        |seleniumlearning|SeleniumLearning!23|Test subject|sample message|
