package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewIssuePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "input[value='Delete']")
    private WebElement deleteButton;

    @FindBy(css = "input[value='Delete Issues']")
    private WebElement deleteConfirmButton;

    public ViewIssuePage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, 5);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void viewIssue(int issueId) {
        this.driver.get("https://academ-it.ru/mantisbt/view.php?id=" + issueId);
    }

    public void deleteIssue() {
        deleteButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(deleteConfirmButton)).click();
    }
}
