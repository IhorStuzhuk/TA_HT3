import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IphonePage extends BasePage{
    @FindBy(xpath = "//a[@class='prod-cart__buy']")
    private List<WebElement> addToCartButton;

    public IphonePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartButton() {
        addToCartButton.get(0).click();
    }
}
