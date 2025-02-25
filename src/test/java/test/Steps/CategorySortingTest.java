package test.Steps;

import Infrastructure.DriverSetup;
import Utils.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.ProductPage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class CategorySortingTest {
    private DriverSetup driverSetup;
    private WebDriver driver;
    @Given("User navigates to Sugar-reduced products page {string}")
    public void userNavigatesToSugarReducedProductsPage(String url) {
        driverSetup=new DriverSetup();
        driverSetup.setupDriver("chrome");
        driver=driverSetup.getDriver();
        driver.get(url);
    }

    @When("User click on filter button")
    public void userClickOnFilterButton() {
        ProductPage productPage=new ProductPage(driver);
        productPage.clickOnFilterButton();
    }

    @And("User open sorting dropdown and choose from cheap to expensive")
    public void userOpenSortingDropdownAndChooseFromCheapToExpensive() {
        ProductPage productPage=new ProductPage(driver);
        productPage.clickSortButton();
    }

    @Then("Products have been sorted")
    public void productsHaveBeenSorted() {
        ProductPage productPage=new ProductPage(driver);
        assertTrue(productPage.isSorted());
    }
}