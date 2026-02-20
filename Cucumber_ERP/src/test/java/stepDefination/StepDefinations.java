package stepDefination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinations {
WebDriver driver;
String Expected ="";
String Actual ="";
@Given("i lanunch url {string} in a browser")
public void LaunchUrl(String url) {
   driver = new ChromeDriver();
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   driver.get(url);
}

@When("i enter user as {string} in username")
public void EnterUsername(String user) {
	driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys(user);
}

@When("i enter pass as {string} in password")
public void Enterpassword(String pass) {
	driver.findElement(By.name("password")).clear();
	driver.findElement(By.name("password")).sendKeys(pass);
}

@When("i click login button")
public void ClickloginButton() throws Throwable {
	driver.findElement(By.name("btnsubmit")).click();
	Thread.sleep(1000);
	
}

@Then("i verify dashboard text in home page")
public void VerifyDashboard() {
    if(driver.findElement(By.xpath("(//li[contains(.,'Dashboard')])[3]")).isDisplayed())
    {
    	Reporter.log("Dashboard Displayed in Home Page",true);
    }
}

@When("i close browser")
public void closeApp() throws Throwable {
	Thread.sleep(1000);
    driver.quit();
}

@When("i navigate to add supplier page")
public void NavigateToAddSupplier() throws Throwable {
    driver.findElement(By.xpath("(//a[contains(text(),'Suppliers')])[2]")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(//span[@data-caption='Add'])[1]")).click();
    Thread.sleep(1000);
}

@When("i capture supplier number")
public void CaptureSupplierNumber() {
    Expected = driver.findElement(By.name("x_Supplier_Number")).getAttribute("value");
}

@When("i enter as{string} in sname")
public void EnterSupplierName(String sname) {
	driver.findElement(By.name("x_Supplier_Name")).sendKeys(sname);
    
}

@When("i enter as{string} in address")
public void EnterAddress(String address) {
	driver.findElement(By.name("x_Address")).sendKeys(address);
}

@When("i enter as {string} in city")
public void EnterCity(String city) {
	driver.findElement(By.name("x_City")).sendKeys(city);
}

@When("i enter as {string} in country")
public void EnterCountry(String country) {
	driver.findElement(By.name("x_Country")).sendKeys(country);
}

@When("i enter as {string} in Contact Person")
public void EnterContact_Person(String cperson) {
	driver.findElement(By.name("x_Contact_Person")).sendKeys(cperson);
}

@When("i enter as {string} in pnumber")
public void EnterPhonenumber(String pnumber) {
	driver.findElement(By.name("x_Phone_Number")).sendKeys(pnumber);
}

@When("i enter as {string} in email")
public void EnterEmail(String Email) {
	driver.findElement(By.name("x__Email")).sendKeys(Email);
}

@When("i enter as {string} in mnumber")
public void EnterMobilenumber(String mnumber) {
	driver.findElement(By.name("x_Mobile_Number")).sendKeys(mnumber);
}

@When("i enter as {string} in notes")
public void EnterNotes(String notes) {
	driver.findElement(By.name("x_Notes")).sendKeys(notes);
}

@When("i click add button")
public void ClickAdd_button() throws Throwable {
   driver.findElement(By.id("btnAction")).sendKeys(Keys.ENTER);
   Thread.sleep(2000);
}

@When("i click ok to confirm window")
public void ClickConfirm_OkButton() throws Throwable {
    driver.findElement(By.xpath("//button[normalize-space()='OK!']")).click();
    Thread.sleep(3000);
}

@When("i click alert ok button")
public void ClickAlert_Ok_Button() throws Throwable {
	 driver.findElement(By.xpath("(//button[contains(text(),'OK')])[6]")).click();
	    Thread.sleep(2000);
}

@When("i search for Supplier number")
public void SearchSupplier_Number() throws Throwable {
    if(!driver.findElement(By.name("psearch")).isDisplayed())
    	//click search panel if not displayed
    	driver.findElement(By.xpath("//button[@data-caption='Search Panel']")).click();
    driver.findElement(By.name("psearch")).clear();
    driver.findElement(By.name("psearch")).sendKeys(Expected);
    driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
    Thread.sleep(2000);
}

@Then("i validate supplier number in table")
public void i_validate_supplier_number_in_table() throws Throwable {
    //Capture supplier number from table
	Actual = driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[6]/div/span/span")).getText();
	Reporter.log(Expected+"-----------"+Actual,true);
	Thread.sleep(2000);
	Assert.assertEquals(Actual, Expected,"Supplier Number Not Found In Table");
	
}
@When("i navigate to add customer page")
public void NavigatetoAddCustomer() throws Throwable {
	driver.findElement(By.xpath("(//a[contains(text(),'Customers')])[2]")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("(//span[@data-caption='Add'])[1]")).click();
    Thread.sleep(1000);
}
@When("i enter as{string} in cname")
public void EnterCname(String cname) {
    driver.findElement(By.name("x_Customer_Name")).sendKeys(cname);
}


@When("i capture customer number")
public void CaptureCustomerNumber() {
    Expected = driver.findElement(By.name("x_Customer_Number")).getAttribute("value");
}

@When("i search for customer number")
public void SearchCustomerNumber() throws Throwable {
	if(!driver.findElement(By.name("psearch")).isDisplayed())
    	//click search panel if not displayed
    	driver.findElement(By.xpath("//button[@data-caption='Search Panel']")).click();
    driver.findElement(By.name("psearch")).clear();
    driver.findElement(By.name("psearch")).sendKeys(Expected);
    driver.findElement(By.xpath("//button[@id='btnsubmit']")).click();
    Thread.sleep(2000); 
}

@Then("i validate customer number in table")
public void ValidateCustomerNumber() throws Throwable {
	//Capture customer number from table
		Actual = driver.findElement(By.xpath("//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")).getText();
		Reporter.log(Expected+"-----------"+Actual,true);
		Thread.sleep(2000);
		Assert.assertEquals(Actual, Expected,"Customer Number Not Found In Table");
    
}



}

