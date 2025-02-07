package mantis.tests;

import mantis.pages.MantisSite;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;

public class AddDeleteIssueTest extends BaseTest {

    private MantisSite mantisSite;
    private String summary;
    private String description;

    @Test
    public void addDeleteIssueTest() {
        long tmstmp = Instant.now().getEpochSecond();
        summary = "TestSummary" + tmstmp;
        description = "Testdescription";
        mantisSite = new MantisSite(driver);
        mantisSite.getLoginPage().login("admin");
        mantisSite.getPasswordPage().login("admin20");
        mantisSite.getMainPage().goToReportIssuesPage();
        mantisSite.getReportPage().addIssue(summary, description);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(mantisSite.getViewIssuesPage().isIssuePresent(summary));
        softAssertions.assertAll();
        int issueId = mantisSite.getViewIssuesPage().getIssueId(summary);
        mantisSite.getViewIssuePage().viewIssue(issueId);
        mantisSite.getViewIssuePage().deleteIssue();
        Assertions.assertFalse(mantisSite.getViewIssuesPage().isIssuePresent(summary), "Test issue is not deleted, still found");

    }
}
