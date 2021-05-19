package jupitertoytestsuite;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jupitertoypageobjects.JupiterToyPageObject;
import resources.InitiateDriver;

public class ValidateJupiterToyFlowTest extends InitiateDriver {
	String modalHeaderText, captureValidErrorMessage = null;
	public WebDriver driver;
	public JupiterToyPageObject jupiterpageobject;

	@BeforeClass
	public void init() throws IOException {
		driver = initiateDriver();
		jupiterpageobject = new JupiterToyPageObject(driver);
	}

	// Get the size of available toys and print all the names
	@Test(priority = 1)
	public void getAllToyNames() throws InterruptedException {
		// Print all toy names and get the size
		jupiterpageobject.startShoppingButton().click();
		int getToyNameSize = jupiterpageobject.toyName().size();
		System.out.println("Total number of toys displayed : " + getToyNameSize);
		if (getToyNameSize > 0) {
			for (int count = 0; count < getToyNameSize; count++) {
				String getToyName = jupiterpageobject.toyName().get(count).getText();
				// get all toys name
				System.out.println("Names are : " + getToyName);
			}
		} else {
			System.out.println("No toys available");
		}
		System.out.println("Testcase-1 passed since number of items and their names are displayed");
	}

	// Add all available items to cart
	@Test(priority = 2)
	public void addAllItemsToCart() throws InterruptedException {
		int getBuyButtonCount = jupiterpageobject.buyButton().size();
		for (int buyCount = 0; buyCount < getBuyButtonCount; buyCount++) {
			jupiterpageobject.buyButton().get(buyCount).click();
			String getIncrementedCartValue = jupiterpageobject.itemsAddedCartValue().getText();
			if (getIncrementedCartValue.equalsIgnoreCase("8")) {
				System.out.println("Testcase-2 passed since all items are added to the cart");
			}
		}
	}

	// Remove item from cart by validating pop-up using cancel and delete button
	@Test(priority = 3)
	public void removeItemFromCart() throws InterruptedException {
		jupiterpageobject.cartTab().click();
		jupiterpageobject.deleteItemFromCart().click();
		modalHeaderText = jupiterpageobject.popUpHeader().getText();
		Assert.assertEquals(modalHeaderText, "Remove Item");
		jupiterpageobject.cancelItemFromDeletion().click();
		jupiterpageobject.deleteItemFromCart().click();
		jupiterpageobject.removeItemFromCart().click();
		System.out.println("Testcase-3 passed since item was successfully removed");
	}

	// empty cart by removing all the available items
	@Test(priority = 4)
	public void emptyCart() throws InterruptedException {
		jupiterpageobject.emptyCartButton().click();
		modalHeaderText = jupiterpageobject.popUpHeader().getText();
		Assert.assertEquals(modalHeaderText, "Empty Cart");
		jupiterpageobject.emptyCartModelCancel().click();
		jupiterpageobject.emptyCartButton().click();
		jupiterpageobject.emptyCartModelEmpty().click();
		System.out.println("Testcase-4 passed since all available items were removed from the cart");
	}

	// check out items by validating the check out form fields
	@Test(priority = 5)
	public void validateEmptyFieldCheckout() throws InterruptedException {
		jupiterpageobject.startShoppingButton().click();
		addAllItemsToCart();
		jupiterpageobject.cartTab().click();
		jupiterpageobject.cartCheckOutButton().click();
		jupiterpageobject.checkoutSubmitButton().click();
		captureEmptyFieldMessage();
		captureValidErrorMessage = jupiterpageobject.validErrorMessage().getText();
		Assert.assertEquals(captureValidErrorMessage,
				"Almost there - but we can't send your items unless you complete the form correctly.");
		System.out.println("Checkout Error message matching");
		System.out.println("Testcase-5 passed since valid message is captured in Checkout page");
	}

	// check out items by validating the check out form fields
	@Test(priority = 6)
	public void cartCheckOut() throws InterruptedException {
		jupiterpageobject.userForename().sendKeys(firstName);
		jupiterpageobject.userSurname().sendKeys(lastName);
		jupiterpageobject.userEmail().sendKeys(email);
		jupiterpageobject.userTelephone().sendKeys(telephone);
		jupiterpageobject.checkoutAddress().sendKeys(address);
		Select cardDropdown = new Select(jupiterpageobject.checkoutDropDown());
		cardDropdown.selectByValue("Visa");
		jupiterpageobject.checkoutCardNumber().sendKeys(cardNumber);
		jupiterpageobject.checkoutSubmitButton().click();
		System.out.println("Testcase-6 passed since all items are added to the cart");
	}

	// Validate success message post check out
	@Test(priority = 7)
	public void confirmedShoppingAgain() {
		String successMessage = jupiterpageobject.successMessageText().getText();
		if (successMessage != null) {
			System.out.println("Success checkout message is : " + successMessage);
			jupiterpageobject.confirmedShoppingAgain().click();
			System.out.println("Testcase-7 passed since successfully completed check out flow");
		}
	}

	// Validate submit contact
	@Test(priority = 8)
	public void contactUs() {
		jupiterpageobject.contactTab().click();
		jupiterpageobject.userForename().sendKeys(firstName);
		jupiterpageobject.userSurname().sendKeys(lastName);
		jupiterpageobject.userEmail().sendKeys(email);
		jupiterpageobject.userTelephone().sendKeys(telephone);
		jupiterpageobject.contactMessage().sendKeys("Hello this is Sambid. I want to know about... Thanks");
		jupiterpageobject.contactSubmitButton().click();
		jupiterpageobject.confirmedContactBackButton().click();
		System.out.println("Testcase-8 passed since contact details are submitted");
	}

	// validate login form using invalid details
	@Test(priority = 9)
	public void userLoginTab() throws InterruptedException {
		jupiterpageobject.jupiterHomeLogo().click();
		jupiterpageobject.userLoginTab().click();
		modalHeaderText = jupiterpageobject.loginUserHeader().getText();
		Assert.assertEquals(modalHeaderText, "Login");
		jupiterpageobject.loginModalUserName().sendKeys(userName);
		jupiterpageobject.loginModalPassword().sendKeys(password);
		jupiterpageobject.loginModalSubmitButton().click();
		modalHeaderText = jupiterpageobject.loginModalError().getText();
		Assert.assertEquals(modalHeaderText, "Your login details are incorrect");
		System.out.println(modalHeaderText);
		jupiterpageobject.loginModalCancel().click();
		System.out.println("Testcase-9 passed since validated login form using invalid details");
	}

	// validate valid error message displayed when required fields are left empty in
	// contact page
	@Test(priority = 10)
	public void validateEmptyFieldContact() throws InterruptedException {
		jupiterpageobject.contactTab().click();
		jupiterpageobject.contactSubmitButton().click();
		captureEmptyFieldMessage();
		captureValidErrorMessage = jupiterpageobject.validErrorMessage().getText();
		Assert.assertEquals(captureValidErrorMessage,
				"We welcome your feedback - but we won't get it unless you complete the form correctly.");
		System.out.println("Testcase-10 passed since valid message is captured in Contact page");
		jupiterpageobject.jupiterHomeLogo().click();
	}

	public void captureEmptyFieldMessage() {
		int errorMessageCount = jupiterpageobject.contactPageRequiredErrorMessage().size();
		for (int errorCount = 0; errorCount < errorMessageCount; errorCount++) {
			System.out.println("Valid error messages are: "
					+ jupiterpageobject.contactPageRequiredErrorMessage().get(errorCount).getText());
		}
	}

	@AfterClass
	public void driverClose() {
		driver.close();
	}
}
