package selenium.basic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordpressTest {

    private WebDriver driver;

    @BeforeEach
    public void startDriver() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void CanAddCommentToNote() {
        driver.get("https://automatyzacja.benedykt.net/");
        WebElement entry = driver.findElement(By.cssSelector(".entry-title > a"));
        entry.click();

        WebElement comment = driver.findElement(By.id("comment"));

        String mycomment = UUID.randomUUID().toString();
        comment.sendKeys(mycomment);

        WebElement author = driver.findElement(By.id("author"));
        author.sendKeys("AniaK");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("kraa@gmail.pl");

        WebElement sendComment = driver.findElement(By.cssSelector("#submit"));

        sendComment.submit();


        Stream<WebElement> listOfComments=  driver.findElements(By.className("comment-content"))
                .stream()
                //filtorowanie, zwroci nam nadal liste strimow, ale przefiltorwana.listOfNotes.filter(warunek logiczny dla kazdego elementu n ma byc spelniony taki warunek ->. n to iterator elementow)
                .filter(n -> n.findElement(By.tagName("p")).getText().equals(mycomment) );


        List<WebElement> filteredNotes = listOfComments.collect(Collectors.toList());
        Assertions.assertEquals(1, filteredNotes.size(), "comment was added");


        ////div[@class="comment-content"]/p[text()="e5e00758-edfc-40ae-b2b7-3f55b8c7b67a"]






    }







    @AfterEach
    public void closeDriver() {
        // Close Chrome browser
        driver.quit();
    }
}