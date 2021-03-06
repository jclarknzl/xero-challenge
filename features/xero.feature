
Feature: Xero technical challenge feature
    As a Xero User,
    In order to manage my business successfully,
    I want to be able to add an “ANZ (NZ)” bank account inside any Xero Organisation.

    @xero
    Scenario: A scenario
        Given I am on the Xero login page
        And I log in to my account
        When I select to add a bank account to my organisation
        And I choose an "ANZ (NZ)" bank account
        Then the bank account should be added