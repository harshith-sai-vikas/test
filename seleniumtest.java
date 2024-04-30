import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        // Set the path to chromedriver executable
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to Instagram login page
        driver.get("https://www.instagram.com/accounts/login/");

        // Find username and password input fields
        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));

        // Enter username and password
        usernameInput.sendKeys("your_username");
        passwordInput.sendKeys("your_password");

        // Find and click the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Wait for the home page to load
        try {
            Thread.sleep(5000); // Wait for 5 seconds (you can use more sophisticated waiting strategies)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify that login was successful (check for presence of the profile icon)
        WebElement profileIcon = driver.findElement(By.xpath("//span[@aria-label='Profile']"));
        if (profileIcon.isDisplayed()) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }

        // Close the browser
        driver.quit();
    }
}
