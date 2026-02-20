@tag
Feature: 
As Admin user i wwant to loog ERp and verify Supplier and customer
@LoginTest
Scenario:
as admin user i want to login to Stcokaccounting project
Given i lanunch url "http://webapp.qedgetech.com/" in a browser
When i enter user as "admin" in username
And i enter pass as "master" in password
And i click login button
Then i verify dashboard text in home page
When i close browser
@suppliers
Scenario Outline:
as admin user i want to create multiple suppliers
Given i lanunch url "http://webapp.qedgetech.com/" in a browser
When i enter user as "admin" in username
And i enter pass as "master" in password
And i click login button
When i navigate to add supplier page
When i capture supplier number
When i enter as"<supplierName>" in sname
And i enter as"<Address>" in address
And i enter as "<City>" in city
And i enter as "<Country>" in country
And i enter as "<ContactPerson>" in Contact Person
And i enter as "<phonenumber>" in pnumber
And i enter as "<Email>" in email
And i enter as "<mobilenumber>" in mnumber
And i enter as "<Notes>" in notes
And i click add button
And i click ok to confirm window
And i click alert ok button
And i search for Supplier number
Then i validate supplier number in table
When i close browser
 
Examples:
|supplierName|Address|City|Country|ContactPerson|phonenumber|Email|mobilenumber|Notes|
|First supplier1|Sangareddy11|Hyderabad|India|Qedgetect11|5454563642|Test11@gmail.com|9875543221|iam first supplier1|
|Second supplier2|Sangareddy22|Hyderabad|India|Qedgetect11|5454563632|Test22@gmail.com|9886543221|iam Second supplier2|












