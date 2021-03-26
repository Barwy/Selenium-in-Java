import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInNoCredentials extends PageObject{
    @FindBy(css = "button[data-role='accept-consent']")
    private WebElement cookiesButton;

    @FindBy(css = "button[role=\"button\"][type=\"submit\"]")
    private WebElement logInButton;

    public LogInNoCredentials(WebDriver driver) {
        super(driver);
    }

    public void acceptCookies() {
        this.cookiesButton.click();
    }

    public void pressLogIn() {
        this.logInButton.click();
    }




}
