import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LocalizationTests extends BaseTest {
    private static final String CATALOG_AFTER_TRANSLATING_INTO_UKRAINIAN = "Каталог товарів";

    @Test
    public void checkChangeLanguageIntoUA() {
        getHomePage().clickOnListOfLanguages();
        getHomePage().clickOnUAItem();
        assertEquals(getHomePage().getTextOfCatalog(), CATALOG_AFTER_TRANSLATING_INTO_UKRAINIAN);
    }
}
