Feature: To verify account creation of Checkings and Savings Type 

Background: 
	When user enters the URL in browser 
	And  user logins to application using credentials 
	Then user should be able to see the title 
	
	
Scenario Outline: To create CHECKINGS account 
	When user clicks on Open new Account link 
	Then user should be able to see 'Open New Account' title 
	And Checkings should be by default selected 
	And user clicks on OpenNewAccount button 
	Then new checkings Account Number should be created 
	Then in Account details section "<AccountType>" , "<Balance>", "<Available>" should be present for checkings account 
	
	Examples: 
		| AccountType | Balance | Available |
		| CHECKING    | $100.00 | $100.00   |
		
Scenario Outline: To create SAVINGS account 
	When user clicks on Open new Account link 
	Then user should be able to see 'Open New Account' title 
	And selects savings from the dropdown list 
	And user clicks on OpenNewAccount button 
	Then new savings Account Number should be created 
	Then in Account details section "<Account Type>" , "<Balance>", "<Available>" should be present for savings account 
	
	Examples: 
		| AccountType | Balance | Available |
		| SAVING      | $100.00 | $100.00   |
		
		
Scenario Outline: To transfer amount from checkings to savings 
	When user clicks on BillPay link 
	Then 'Bill Payment Service' header should be displayed 
	And user fills "<Payee Name>" , "<Address>", "<City>", "<State>", "<Zip Code>", "<Phone>"
	And user clicks on Send Payment Button 
	Then user should get BillPaymentComplete message 
	And user clicks on Account Overview 
	And user selects debited account number 
	Then entry should be created for debited amount 
	And user clicks on Account Overview 
	And user selects credited account number 
	Then entry should be created for credited amount 
	
	Examples: 
		|Payee Name|Address|City|State|Zip Code|Phone|
		|abc       |abc    |abc |abc  |abc     |abc  |