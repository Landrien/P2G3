package pages;

import org.openqa.selenium.WebDriver;

/**
 * The category page where articles are listed based on their category
 */
public class CategoryPage extends BasePage
{
    public static final String womenCategoryId = "id_category=3";
    public static final String dressesCategoryId = "id_category=8";
    public static final String tShirtsCategoryId = "id_category=5";

    public CategoryPage(WebDriver driver)
    {
        super(driver);
    }
}
