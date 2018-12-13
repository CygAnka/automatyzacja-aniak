package selenium.wordPresPages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.wordPresPages.pages.WpMainPage;
import selenium.wordPresPages.pages.WpNotePage;

import java.util.UUID;

public class WordPressTest extends BaseTest {

    @Test
    public void canAddCommentToFirstNote() {

        String comment = generateRandomText();
        String author = generateRandomText();
        String email = generateRandomEmail();


        WpMainPage mainPage = new WpMainPage(driver);
        WpNotePage latestNote = mainPage.openLatestNote();
        WpNotePage latestNoteWithComment = latestNote.addComment(comment, author, email);

        Assertions.assertTrue(latestNoteWithComment.commentExists(comment,author));
    }

    private String generateRandomEmail() {
        return generateRandomText() + "@test.com";
    }

    private String generateRandomText() {
        return UUID.randomUUID().toString();
    }
}
