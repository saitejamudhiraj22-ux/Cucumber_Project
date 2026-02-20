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