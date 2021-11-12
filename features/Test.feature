#Author: Santosh Singh
Feature: Construct 365 Field App Crew TimeSheet Summary Feature


@test
Scenario: As a user, I should see the summary and details tabs in hours screen
    
    Then I should see summary and details tabs
    
    @test
    Scenario: Verify the summary headers
    
    When I click on summary tab
    Then I should  see the headers of summary tab
    
    @test
    Scenario: Verify the summary headers
    
    When I click on details tab
    Then I should  see the headers of details tab
    
    @test
    Scenario Outline: As a user, I should be able to search for the worker in add crew hours
   
   When I click on search worker bar in add crew hours
   And I enter the search text in worker search bar "<searchText>"
   And I select a worker "<workername>"
   And I click on add worker button
    Then I should see selected worker in the list "<workername>"
    
    Examples:
    
    |workername|searchText|
    |Crew119Automation|Crew119Automation|
    
    @test
   Scenario: Verify the title of the screen
   
   
   Then I should see add crew hours as title of the screen
   
   @test
    Scenario: Verify the header titles for the search workers
    
    Then I should see the header titles as Worker Name and Personnel Number
    
    @test
    Scenario: Verify the Search Workers text
   
   Then I should see the search workers text
   
   @test
   Scenario: As a User, I should return to summary screen after clicking cancel button in search project
    
    
    When I click on cancel button
    Then I should see add crew hours screen