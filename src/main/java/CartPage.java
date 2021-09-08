import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy (xpath = "//div[@class='total-h']/span[@class = 'prise']")
    private WebElement price;

    @FindBy (xpath = "//div[@class='item-total']/span[@class = 'prise']")
    private WebElement totalAmount;

    @FindBy(id = "js_cart")
    private WebElement addToCartPopup;

    @FindBy(xpath = "//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//div[@class = 'item']//i[contains(@class, 'icon-close')]")
    private WebElement iconClose;

    @FindBy(xpath = "//span[(contains(@class, 'js_plus'))]")
    private WebElement increaseButton;

    @FindBy(xpath = "//input[(contains(@class, 'js-change'))]")
    private WebElement amountOfProducts;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public void clickOnIconCloseButton() {
        iconClose.click();
    }

    public WebElement getAddToCartPopup() {
        return addToCartPopup;
    }

    public int getTextOfTotalAmountOfProductsInCart() {
        return Integer.parseInt(totalAmount.getAttribute("innerText").replace(" грн", ""));
    }

    public int getPriceOfProductInCart() {
        return Integer.parseInt(price.getAttribute("innerText").replace(" грн", ""));
    }

    public void increaseCountOfProductInCart() {
       increaseButton.click();
    }

    public int getTextOfAmountOfProductsInCart() {
        return Integer.parseInt(amountOfProducts.getAttribute("value"));
    }
}
