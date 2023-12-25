Feature: Test the Register, Login & Logout functionality of Para Bank

  @testRegister @TestParaBank
  Scenario Outline: Test Para Bank Register feature
    Given Open the Para Bank Website
    When Open the Register page and fill the form with "<FirstName>", "<LastName>", "<Address>", "<City>", "<State>", "<ZipCode>", "<PhoneNo>", "<SSN>", "<UserName>", "<Password>", "<ConfirmPass>"
    And Press the Register button
    Then Registered page will be visible with "<UserName>"
    
    Examples:
    
    | FirstName   | LastName    | Address 									 | City  | State   | ZipCode | PhoneNo | SSN 			 | UserName 		| Password  | ConfirmPass |
    | sycho       | Tester      | 111, st road, steveson bay | Miami | Florida | 40685 	 | 8969852 | 230493492 | sychoTester7 | Test@1234 | Test@1234 	|
    | sycho       | Tester      | 111, st road, steveson bay | Miami | Florida | 40685 	 | 8969852 | 230493492 | sychoTester8 | Test@1234 | Test@1234 	|

  @testLogin @TestParaBank
  Scenario Outline: Test Para Bank login feature
    Given Open the Para Bank Website
    When Login to Para Bank website with "<UserName>" & "<Password>"
    And Press the Login button
    Then Bank Dashboard page will be visible
    
    Examples:
    
    | UserName     | Password  |
    | sychoTester2 | Test@1234 |
    | sychoTester2 | Test@1224 |

  @testLogout @TestParaBank
  Scenario: Test Para Bank logout feature
    Given Logged in to Para Bank Website
    When Select Logout option
    Then Redirected to Para Bank Website home page
