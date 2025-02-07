package mantis.tests;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class ViewIssuesTest extends BaseTest{
    private MantisSite mantisSite;

    @Test
    public void fiftyRecordsTest() {
        mantisSite = new MantisSite(driver);
        mantisSite.getLoginPage().login("admin");
        mantisSite.getPasswordPage().login("admin20");
        mantisSite.getMainPage().goToViewIssuesPage();
        int issuesCount = mantisSite.getViewIssuesPage().countIssues();
        Assertions.assertEquals(50, issuesCount);
    }
}
