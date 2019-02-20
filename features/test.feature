Feature: Test feature
	Smoke test to ensure cucumber is working.

	Scenario: Code smoke test
	    Given I have 4 pieces of toast
	    When I eat 2 pieces of toast
	    Then I should have 2 pieces of toast

    Scenario: Browser smoke test
    	Given I open a browser
    	When I navigate to google
    	And I search for New Zealand
    	Then I should see search results
