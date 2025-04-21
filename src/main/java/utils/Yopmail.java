package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;

/**
 * Classe pour interagir avec le site Yopmail.
 * Étend la classe {@link BasePage} pour hériter du WebDriver et des méthodes communes.
 */
public class Yopmail extends BasePage {

    // ---------- WebElements ----------

    @FindBy(id = "login")
    private WebElement emailField;

    @FindBy(xpath = "//button[@class = 'md']")
    private WebElement searchButton;

    @FindBy(xpath = "//span/a")
    private WebElement emailLink;

    @FindBy(id = "ifmail")
    private WebElement iframe;

    @FindBy(id = "refresh")
    private WebElement refreshButton;

    @FindBy(xpath = "//strong[text()='Password:']/parent::span/parent::span")
    private WebElement password;

    @FindBy(xpath = "//p[contains(text(), 'Autoriser')]/..")
    private WebElement acceptCookiesButton;

    @FindBy(xpath = "//div[@id='nbmail']")
    private WebElement nbrMail;

    // ---------- Constructeur ----------

    /**
     * Constructeur de la page Yopmail.
     *
     * @param driver le WebDriver utilisé pour l'automatisation.
     */
    public Yopmail(WebDriver driver) {
        super(driver);
    }

    // ---------- Getters ----------

    public WebElement getEmailLink() {
        return emailLink;
    }

    public WebElement getRefreshButton() {
        return refreshButton;
    }

    public WebElement getAcceptCookiesButton() {
        return acceptCookiesButton;
    }

    // ---------- Actions sur la page ----------

    /**
     * Saisit une adresse e-mail dans le champ prévu.
     *
     * @param email l'adresse e-mail à saisir.
     */
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    /**
     * Clique sur le bouton de recherche pour accéder à la boîte mail.
     */
    public void clickSearchButton() {
        searchButton.click();
    }

    /**
     * Récupère le mot de passe depuis l'e-mail reçu.
     *
     * @return le mot de passe en texte brut.
     */
    public String getPassword() {
        return password.getText();
    }

    // ---------- Navigation dans les iframes ----------

    /**
     * Bascule vers l'iframe contenant l'e-mail.
     */
    public void switchToIframe() {
        driver.switchTo().frame(iframe);
    }

    /**
     * Bascule vers le contenu principal hors iframe.
     */
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    // ---------- Gestion des onglets ----------

    /**
     * Bascule vers l'onglet d'origine (premier onglet ouvert).
     */
    public void switchToOriginTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    /**
     * Bascule vers le second onglet (supposé être la boîte Yopmail).
     */
    public void switchToMailTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    /**
     * Bascule vers le troisième onglet si présent.
     */
    public void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
    }

    /**
     * Ouvre un nouvel onglet avec la page d'accueil de Yopmail.
     */
    public void openYopmail() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://yopmail.com/fr/");
    }

    // ---------- Attente d'e-mails ----------

    /**
     * Attend jusqu'à ce qu'un e-mail soit détecté (affichage "1 mail").
     */
    public void waitmail1() {
        while (!nbrMail.getText().contains("1 mail")) {
            try {
                Thread.sleep(1000); // Attendre 1 seconde
                getRefreshButton().click();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Attend jusqu'à ce que deux e-mails soient détectés (affichage "2 mails").
     */
    public void waitmail2() {
        while (!nbrMail.getText().contains("2 mails")) {
            try {
                Thread.sleep(1000); // Attendre 1 seconde
                getRefreshButton().click();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
