import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='input_search']")
    private WebElement searchInput;

    @FindBy(xpath = "//span[@class='sidebar-item']")
    private WebElement productCatalogButton;

    @FindBy(xpath = "//ul[contains(@class,'sidebar-list')]//a[contains(@href, 'apple-store')]")
    private WebElement appleStoreButton;

    @FindBy(xpath = "//li[@class='has-dropdown']/a")
    private WebElement listOfLanguages;

    @FindBy(xpath = "//li[@class='has-dropdown']/ul[contains(@class, menu-dropdown__lang)]/li/a")
    private WebElement uaItem;

    @FindBy(xpath = "//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'cart_count')]")
    private WebElement amountOfProductsInCart;

    @FindBy(xpath = "//button[@class='button-reset search-btn']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@class='sidebar-item']")
    private WebElement catalog;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchByKeyword(final String keyword) {
        searchInput.sendKeys(keyword);
        searchButton.click();
    }

    public void clickOnProductCatalogButton() {
        productCatalogButton.click();
    }

    public void clickOnListOfLanguages() {
        listOfLanguages.click();
    }

    public void clickOnUAItem() {
        uaItem.click();
    }

    public void clickOnAppleStoreButton() {
        appleStoreButton.click();
    }

    public String getTextOfAmountProductsInCart() {
        return amountOfProductsInCart.getAttribute("innerText");
    }

    public String getTextOfCatalog() {
        return catalog.getAttribute("innerText");
    }
}