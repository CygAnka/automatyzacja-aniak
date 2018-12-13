package selenium.wordPresPages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WpMainPage {
    private static final String WORDPRESS_PAGE_URL = "https://automatyzacja.benedykt.net/";
    private final WebDriver driver;

    public WpMainPage(WebDriver driver) {
        this.driver = driver;

        // here you open wordpress page
        this.driver.get(WORDPRESS_PAGE_URL);



    }

    public WpNotePage openLatestNote() {
        // here you find and open latest note (first note)
        WebElement entry = driver.findElement(By.cssSelector(".entry-title > a"));
        entry.click();

        return new WpNotePage(driver);


    }
}
