package pages;

import org.openqa.selenium.WebDriver;

/**
 * The category page where articles are listed based on their category
 * This page allows navigation to specific product categories such as Women, Dresses, or T-shirts
 */
public class CategoryPage extends BasePage
{
    public static final String womenCategoryId = "id_category=3";
    public static final String dressesCategoryId = "id_category=8";
    public static final String tShirtsCategoryId = "id_category=5";

    /**
     * Constructor that initializes the category page with the given WebDriver.
     * @param driver The WebDriver instance used to interact with the page.
     */
    public CategoryPage(WebDriver driver)
    {
        super(driver);
    }
}
