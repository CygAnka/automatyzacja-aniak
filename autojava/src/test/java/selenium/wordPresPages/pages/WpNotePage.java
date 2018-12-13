package selenium.wordPresPages.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WpNotePage {
    private final WebDriver driver;

    public WpNotePage(WebDriver driver) {
        this.driver = driver;
    }

    public WpNotePage addComment(String comment, String author, String email) {

        driver.findElement(By.id("comment")).sendKeys(comment);
        driver.findElement(By.id("author")).sendKeys(author);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.cssSelector("#submit")).submit();



        return new WpNotePage(driver);
    }

    public boolean commentExists(String comment, String author) {

        Stream<WebElement> listOfComments=  driver.findElements(By.cssSelector(".comment-list > .comment"))
                .stream()
                //filtorowanie, zwroci nam nadal liste strimow, ale przefiltorwana.listOfNotes.filter(warunek logiczny dla kazdego elementu n ma byc spelniony taki warunek ->. n to iterator elementow)
                .filter(n -> n.findElement(By.cssSelector(".comment-author > b")).getText().equals(author) )
                .filter(n -> n.findElement(By.tagName("p")).getText().equals(comment) );


        List<WebElement> filteredNotes = listOfComments.collect(Collectors.toList());
        return  filteredNotes.size() > 0;

    }
}
