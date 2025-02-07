package mantis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ViewIssuesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#buglist tbody tr")
    private List<WebElement> bugItems;
    By summarySelector = By.cssSelector(".column-summary");

    public ViewIssuesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }

    public int countIssues() {
        return bugItems.size();
    }

    public int getIssueId(String summary) {

        By idSelector = By.cssSelector(".column-id");
        WebElement issueRecord = getIssueRecord(summary);
        return Integer.parseInt(issueRecord.findElement(idSelector).getText());
    }

    public WebElement getIssueRecord(String summary) {
        wait.until(ExpectedConditions.visibilityOfAllElements(bugItems));
        for (WebElement bugRow : bugItems) {
            if (bugRow.findElement(summarySelector).getText().contains(summary)) {
                return bugRow;
            }
        }
        return null;
    }

    public boolean isIssuePresent(String summary) {
        return getIssueRecord(summary) != null;
    }

}
