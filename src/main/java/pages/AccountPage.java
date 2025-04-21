package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page "Mon Compte" permettant à l'utilisateur d'accéder aux différentes sections de gestion de compte.
 */
public class AccountPage extends BasePage
{
    // ---------- Constructeur ----------

    /**
     * Constructeur de la page AccountPage.
     *
     * @param driver le WebDriver utilisé pour l'automatisation.
     */
    public AccountPage(WebDriver driver)
    {
        super(driver);
    }

    // ---------- WebElements ----------

    @FindBy(className = "alert-success")
    private WebElement accountCreatedMessage;

    @FindBy(xpath = "//span[text()='Add my first address']/..")
    private WebElement addMyFirstAddressButton;

    @FindBy(xpath = "//span[text()='Order history and details']/..")
    private WebElement orderHistoryButton;

    @FindBy(xpath = "//span[text()='My credit slips']/..")
    private WebElement creditSlipsButton;

    @FindBy(xpath = "//span[text()='My addresses']/..")
    private WebElement myAddressesButton;

    @FindBy(xpath = "//span[text()='My personal information']/..")
    private WebElement personalInformationButton;

    // ---------- Getters ----------

    /**
     * Récupère le message de confirmation de création de compte.
     *
     * @return le WebElement contenant le message de succès.
     */
    public WebElement getAccountCreatedMessage()
    {
        return accountCreatedMessage;
    }

    // ---------- Actions sur la page ----------

    /**
     * Clique sur le bouton "Add my first address" pour ajouter une première adresse.
     */
    public void clickAddMyFirstAddressButton()
    {
        addMyFirstAddressButton.click();
    }

    /**
     * Clique sur le bouton "Order history and details" pour consulter l'historique des commandes.
     */
    public void clickOrderHistoryButton()
    {
        orderHistoryButton.click();
    }

    /**
     * Clique sur le bouton "My credit slips" pour accéder aux avoirs.
     */
    public void clickCreditSlipsButton()
    {
        creditSlipsButton.click();
    }

    /**
     * Clique sur le bouton "My addresses" pour accéder à la liste des adresses enregistrées.
     */
    public void clickMyAddressesButton()
    {
        myAddressesButton.click();
    }

    /**
     * Clique sur le bouton "My personal information" pour modifier les informations personnelles.
     */
    public void clickPersonalInformationButton()
    {
        personalInformationButton.click();
    }
}
