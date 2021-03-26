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
    }

    public void enterEmailAddress(String emailAddress) {
        this.emailField.click();
        this.emailField.sendKeys(emailAddress);
    }

    public void enterPassword(String password) {
        this.passwordField.click();
        this.passwordField.sendKeys(password);
    }

    public void clickAgeRange() {
        this.adultButton.click();
    }

    public void clickObligatoryConsent() {
        this.obligatoryConsent.click();
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void registerConfirmation(String redirectURL) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(mailIcon));
        Assertions.assertEquals(redirectURL, driver.getCurrentUrl(),
                "You have not been redirected to " + redirectURL);
    }


}

