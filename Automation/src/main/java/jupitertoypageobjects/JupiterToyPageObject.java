package jupitertoypageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JupiterToyPageObject {
	public WebDriver driver;
	// locators to find the element in the web page
	By startShoppingButton = By.xpath("//a[contains(text(), 'Start Shopping »')]");
	By toyName = By.tagName("h4");

	By buyButton = By.xpath("//a[@ng-click='add(item)']");
	By itemsAddedCartValue = By.xpath("//span[@class='cart-count ng-binding']");

	By cartTab = By.xpath("//a[@href='#/cart']");
	By deleteItemFromCart = By.xpath("//i[@class='icon-remove icon-white']");
	By cancelItemFromDeletion = By.xpath("//a[@ng-click='cancel()']");
	By removeItemFromCart = By.xpath("//a[@ng-click='removeItem(item)']");

	By cartCheckOutButton = By.xpath("//a[@href='#/checkout']");
	By checkoutSubmitButton = By.xpath("//button[@id='checkout-submit-btn']");
	By validErrorMessage = By.xpath("//div[@class='alert alert-error ng-scope']");

	By userForename = By.xpath("//input[@id='forename']");
	By userSurname = By.xpath("//input[@id='surname']");
	By userEmail = By.xpath("//input[@id='email']");
	By userTelephone = By.xpath("//input[@id='telephone']");
	By checkoutAddress = By.xpath("//textarea[@id='address']");
	By checkoutDropDown = By.xpath("//select[@id='cardType']");
	By checkoutCardNumber = By.xpath("//input[@id='card']");

	By userLoginTab = By.xpath("//a[contains(text(), 'Login')]");
	By loginUserHeader = By.xpath("//h1[contains (text(), 'Login')]");
	By loginModalUserName = By.xpath("//input[@id='loginUserName']");
	By loginModalPassword = By.xpath("//input[@id='loginPassword']");
	By loginModalSubmitButton = By.xpath("//button[@type='submit' and contains(text(), 'Login')]");
	By loginModalError = By.xpath("//strong[contains(text(), 'Your login details are incorrect')]");
	By loginModalCancel = By.xpath("//button[@type='button' and contains(text(), 'Cancel')]");

	By emptyCartButton = By.xpath("//a[contains(text(),'Empty Cart')]");
	By emptyCartModelEmpty = By.xpath("//a[@ng-click='empty()']");
	By emptyCartModelCancel = By.xpath("//a[@ng-click='cancel()']");

	By contactTab = By.xpath("//a[@href='#/contact']");
	By contactMessage = By.xpath("//textarea[@id='message']");
	By contactSubmitButton = By.xpath("//a[contains(text(), 'Submit')]");
	By confirmedContactBackButton = By.xpath("//a[@ng-click='goBack()']");
	By contactPageRequiredErrorMessage = By.xpath("//span[@class='help-inline ng-scope']");

	By popUpHeader = By.tagName("h1");
	By jupiterHomeLogo = By.xpath("//a[@href='#']");
	By successMessageText = By.xpath("//div[@class='alert alert-success']");
	By confirmedShoppingAgain = By.xpath("//a[@href='#/shop' and contains(text(),'Shopping Again »')]");

	// create constructor to pass driver object to another test case
	public JupiterToyPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement jupiterHomeLogo() {
		return this.driver.findElement(jupiterHomeLogo);
	}

	public WebElement startShoppingButton() {
		return this.driver.findElement(startShoppingButton);
	}

	public List<WebElement> toyName() {
		return this.driver.findElements(toyName);
	}

	public List<WebElement> buyButton() {
		return this.driver.findElements(buyButton);
	}

	public WebElement itemsAddedCartValue() {
		return this.driver.findElement(itemsAddedCartValue);
	}

	public WebElement cartTab() {
		return this.driver.findElement(cartTab);
	}

	public WebElement deleteItemFromCart() {
		return this.driver.findElement(deleteItemFromCart);
	}

	public WebElement cancelItemFromDeletion() {
		return this.driver.findElement(cancelItemFromDeletion);
	}

	public WebElement removeItemFromCart() {
		return this.driver.findElement(removeItemFromCart);
	}

	public WebElement popUpHeader() {
		return this.driver.findElement(popUpHeader);
	}

	public WebElement emptyCartButton() {
		return this.driver.findElement(emptyCartButton);
	}

	public WebElement emptyCartModelEmpty() {
		return this.driver.findElement(emptyCartModelEmpty);
	}

	public WebElement emptyCartModelCancel() {
		return this.driver.findElement(emptyCartModelCancel);
	}

	public WebElement cartCheckOutButton() {
		return this.driver.findElement(cartCheckOutButton);
	}

	public WebElement userForename() {
		return this.driver.findElement(userForename);
	}

	public WebElement userSurname() {
		return this.driver.findElement(userSurname);
	}

	public WebElement userEmail() {
		return this.driver.findElement(userEmail);
	}

	public WebElement userTelephone() {
		return this.driver.findElement(userTelephone);
	}

	public WebElement checkoutAddress() {
		return this.driver.findElement(checkoutAddress);
	}

	public WebElement checkoutCardNumber() {
		return this.driver.findElement(checkoutCardNumber);
	}

	public WebElement validErrorMessage() {
		return this.driver.findElement(validErrorMessage);
	}

	public WebElement checkoutSubmitButton() {
		return this.driver.findElement(checkoutSubmitButton);
	}

	public WebElement successMessageText() {
		return this.driver.findElement(successMessageText);
	}

	public WebElement contactMessage() {
		return this.driver.findElement(contactMessage);
	}

	public WebElement contactTab() {
		return this.driver.findElement(contactTab);
	}

	public WebElement contactSubmitButton() {
		return this.driver.findElement(contactSubmitButton);
	}

	public List<WebElement> contactPageRequiredErrorMessage() {
		return this.driver.findElements(contactPageRequiredErrorMessage);
	}

	public WebElement confirmedContactBackButton() {
		return this.driver.findElement(confirmedContactBackButton);
	}

	public WebElement confirmedShoppingAgain() {
		return this.driver.findElement(confirmedShoppingAgain);
	}

	public WebElement userLoginTab() {
		return this.driver.findElement(userLoginTab);
	}

	public WebElement loginUserHeader() {
		return this.driver.findElement(loginUserHeader);
	}

	public WebElement loginModalUserName() {
		return this.driver.findElement(loginModalUserName);
	}

	public WebElement loginModalPassword() {
		return this.driver.findElement(loginModalPassword);
	}

	public WebElement loginModalSubmitButton() {
		return this.driver.findElement(loginModalSubmitButton);
	}

	public WebElement checkoutDropDown() {
		return this.driver.findElement(checkoutDropDown);
	}

	public WebElement loginModalError() {
		return this.driver.findElement(loginModalError);
	}

	public WebElement loginModalCancel() {
		return this.driver.findElement(loginModalCancel);
	}
}
