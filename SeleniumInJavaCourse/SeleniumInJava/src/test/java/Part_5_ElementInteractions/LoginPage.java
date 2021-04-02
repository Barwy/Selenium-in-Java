package Part_5_ElementInteractions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(css = "a[class=\"woocommerce-store-notice__dismiss-link\"]")
    private WebElement infoBarButton;

    @FindBy(css = "input[id=\"username\"]")
    private WebElement loginEmailField;

    @FindBy(css = "input[id=\"password\"]")
    private WebElement loginPasswordField;

    @FindBy(css = "button[name=\"login\"]")
    private WebElement loginButton;

    @FindBy(css = "input[id=\"reg_email\"]")
    private WebElement registerEmailField;

    @FindBy(css = "input[id=\"reg_password\"]")
    private WebElement registerPasswordField;

    @FindBy(css = "button[name=\"register\"]")
    private WebElement registerButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void closeInfoBar() {
        this.infoBarButton.click();
    }

    public void inputLoginEmail(String loginEmail) {
        this.loginEmailField.click();
        this.loginEmailField.sendKeys(loginEmail);
    }

    public void inputLoginPassword(String loginPassword) {
        this.loginPasswordField.click();
        this.loginPasswordField.sendKeys(loginPassword);
    }

    public void hitEnterInLoginEmail() {
        this.loginEmailField.sendKeys(Keys.chord(Keys.ENTER));
    }

    public void hitEnterInRegisterEmail() {
        this.registerEmailField.sendKeys(Keys.chord(Keys.ENTER));
    }

    public void clickLoginButton() {
        this.loginButton.click();
    }

    public void inputRegisterEmail(String registerEmail) {
        this.registerEmailField.click();
        this.registerEmailField.sendKeys(registerEmail);
    }

    public void inputRegisterPassword(String registerPassword) {
        this.registerPasswordField.click();
        this.registerPasswordField.sendKeys(registerPassword);
    }

    public void clickRegisterButton() {
        this.registerButton.click();
    }
}
