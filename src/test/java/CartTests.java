import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTests extends BaseTest {
    private static final String EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART = "0";
    private static final int COUNT_OF_THE_SAME_PRODUCT = 2;

    @Test(priority = 1)
    public void checkAutoIncrementFieldInCartAfterClickingPlus() {
        addToCart();
        getCartPage().increaseCountOfProductInCart();
        getCartPage().waitForPageLoadComplete(30);
        assertEquals(getCartPage().getTextOfAmountOfProductsInCart(), COUNT_OF_THE_SAME_PRODUCT);
    }

    @Test(priority = 2)
    public void checkCalculationOfTheOrderAmountAfterIncreasingTheQuantityOfGood() {
        addToCart();
        getCartPage().increaseCountOfProductInCart();
        getDriver().navigate().refresh();
        assertEquals(getCartPage().getTextOfTotalAmountOfProductsInCart(),
                getCartPage().getPriceOfProductInCart() * COUNT_OF_THE_SAME_PRODUCT);

    }

    @Test(priority = 3)
    public void checkDeleteFromCart() {
        addToCart();
        getCartPage().clickOnIconCloseButton();
        getCartPage().clickOnContinueShoppingButton();
        getIphonePage().waitInvisibilityOfElement(30, getCartPage().getAddToCartPopup());
        assertEquals(getHomePage().getTextOfAmountProductsInCart(), EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART);

    }

    public void addToCart() {
        getHomePage().clickOnProductCatalogButton();
        getHomePage().clickOnAppleStoreButton();
        getAppleStorePage().clickOnIphoneButton();
        getIphonePage().waitForPageLoadComplete(30);
        getIphonePage().clickOnAddToCartButton();
        getIphonePage().waitVisibilityOfElement(30, getCartPage().getAddToCartPopup());
    }
}
