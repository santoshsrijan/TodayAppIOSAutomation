Feature: Today App Home Feature

  #scenario 1
    @home
    Scenario: User should be able to see the minute menu is highlighted
    
    When I am in app splash screen in today app
    And I click on minute menu
    And I verify the minute menu is selected
    
    
    #scenario 1
    @home
    Scenario: User should be able to see the search results with valid data
    
    When I am in app splash screen in today app
     And I click on search button
    And I enter the "singapore" search text
    Then I should see the "singapore" search results 
    
    
    #scenario 1
    @invalidsearch
    Scenario: User should see the error message with invalid search data
    
    When I am in app splash screen in today app
    And I click on search button
     And I enter the "xyz" search text
    Then I should see the "xyz" error message
    
    
    
    
    
    #scenario 2
    @home
    Scenario: User should be able to see the lates news menu is highlighted
    
    And I click on Latest news menu
    And I verify the latest news menu is selected
    
    #scenario 3
    @home
    Scenario: User should be able to see the Menu button is highlighted
    
 
    And I click on Menu button
    And I verify the menu button is selected
    
     #scenario 4
    @home
    Scenario: User should be able to see the home button is highlighted
    
 
    And I click on home button
    And I verify the home button is selected
        
        
    
    
     
  
    
    
    
   
    
   
   
  
    
    
    
    
    
    
    
    

 