package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportPage {

    @FindBy(id = "summary")
    private WebElement summaryInput;

    @FindBy(id = "description")
    private WebElement descriptionInput;

    @FindBy(css = "input[type='submit']")
    private WebElement submitButton;

    public ReportPage(WebDriver driver) {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public void addIssue(String summary, String description) {
        summaryInput.sendKeys(summary);
        descriptionInput.sendKeys(description);
        submitButton.click();
    }

}
