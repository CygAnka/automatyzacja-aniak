package selenium.pageobjects.pages;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import selenium.pageobjects.pages.GoogleResultPage;
import selenium.pageobjects.pages.GoogleMainPage;
import selenium.pageobjects.pages.BaseTest;


public class GoogleTests extends BaseTest {

    @Test
    public void canFindScrumOrgOnGoogle() {
        String scrumOrgUrl = "https://www.scrum.org/";
        String scrumOrgPageTitle = "Scrum.org: Homepage";

        GoogleMainPage googlePage = new GoogleMainPage(driver);
        GoogleResultPage resultPage = googlePage.search("Scrum.org");

        assertTrue(resultPage.contains(scrumOrgUrl));
        assertTrue(resultPage.containsResultWithTitle(scrumOrgUrl, scrumOrgPageTitle),
                "Scrum.org page has correct title");
    }

    @Test
    public void canFindCodeSprinters() {
        String csUrl = "http://agileszkolenia.pl/";
        String csPageTitle = "Code Sprinters - Agile Experts -";

        GoogleMainPage googlePage = new GoogleMainPage(driver);
        GoogleResultPage resultPage = googlePage.search("Code Sprinters");

        assertTrue(resultPage.contains(csUrl));
        assertTrue(resultPage.containsResultWithTitle(csUrl, csPageTitle));
    }

}