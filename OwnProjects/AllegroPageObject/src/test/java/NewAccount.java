import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccount extends PageObject {

    @FindBy(css = "button[data-role='accept-consent']")
        private WebElement cookiesButton;

    @FindBy(css = "input[id='email']")
        private WebElement emailField;

    @FindBy(id = "password")
        private WebElement passwordField;

    @FindBy(css = "label[for=\"isAdultYES\"]")
        private WebElement adultButton;

    @FindBy(css = "label[for=\"agreementTerm\"]")
        private WebElement obligatoryConsent;

    @FindBy(css = "button[role=\"button\"][type=\"submit\"]")
        private WebElement submitButton;

    @FindBy(css = "img[class=\"ilg07 i1efi _44753_17QDo\"][alt=\"mail icon\"]")
        private WebElement mailIcon;

   public NewAccount(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        this.cookiesButton.click();
        Assertions.assertFalse(driver.getPageSource().contains("label class=\"m-label\" for=\"radio1\""),
                "You are on business account tab");
    }

    public void enterEmailAddress(String emailAddress) {
        this.emailField.click();
        this.emailField.sendKeys(emailAddress);
    }

    public void enterPassword(String password) {
        this.passwordField.click();
        Assertions.assertTrue(driver.getPageSource().contains("class=\"ozg4u ftsdx f1sm5\""),
                "Invalid e-mail address");
        this.passwordField.sendKeys(password);
        Assertions.assertTrue(driver.getPageSource().contains("span class=\"ht13u6 c1tzf\">min. 8 znaków"),
                "Password too short");
        Assertions.assertTrue(driver.getPageSource().contains("span class=\"ht13u6 c1tzf\">wielka litera"),
                "Capital letter missing");
        Assertions.assertTrue(driver.getPageSource().contains("span class=\"ht13u6 c1tzf\">mała litera"),
                "Lowercase letter missing");
        Assertions.assertTrue(driver.getPageSource().contains("span class=\"ht13u6 c1tzf\">cyfra"),
                "Digit missing");
    }

    public void clickAgeRange() {
        this.adultButton.click();
    }

    public void clickObligatoryConsent() {
        this.obligatoryConsent.click();
    }

    public void clickSubmit() {
        submitButton.click();
        Assertions.assertFalse(driver.getPageSource().contains("class=\"_1dd5x mgmw_1p _44753_3g4PV\""),
                "Obligatory consent has not ben ticked");
    }

    public void rregisterConfirmation(String redirectURL) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(mailIcon));
        Assertions.assertEquals(redirectURL, driver.getCurrentUrl(), "You have not been redirected to " + redirectURL);
    }


}

