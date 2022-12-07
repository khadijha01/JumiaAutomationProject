import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JumiaAutomationTestProject {
//Import the Jumia Webdriver
private WebDriver driver;
@BeforeTest
public void start() {
//Locate where the Chrome driver is
    System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
//Open your Chrome browser
    driver = new ChromeDriver();
}
@Test(priority = 0)
public void getURL() throws InterruptedException {
    //Open your selected app URL (https://www.jumia.com.ng/)
    driver.get("https://www.jumia.com.ng/");
    if (driver.getCurrentUrl().contains("https://www.jumia.com.ng/"))
//pass
        System.out.println("correct webpage");
    else
//fail
        System.out.println("wrong webpage");
//Add delay command before loading the next page
    Thread.sleep(2000);
}
@Test(priority = 1)
 public void getPageTitle() throws InterruptedException {
//Test2:Confirm the page title
    String expectedTitle = "Jumia Nigeria/Online Shopping";
    String actualTitle = driver.getTitle();
    if (actualTitle.contains(expectedTitle))
//pass
        System.out.println("correct webpage");
    else
//fail
        System.out.println("wrong webpage");
//Maximize the window
    driver.manage().window().maximize();
//Added delay command before loading the next page
    Thread.sleep(2000);
}
 @Test(priority = 2)
public void signIn()throws InterruptedException {
     //Click on Account to locate the sign-in button
     driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
//Click the sign-in button
     driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
//Added delay command before loading the next page
     Thread.sleep(2000);
//Test3:Confirm that user was redirected to the correct sign-in page
     driver.getCurrentUrl();
     if (driver.getCurrentUrl().contains("https://my.jumia.com.ng/interaction/0_NwRHRb6rpJYrDmx836O/en-ng/sign-in/email"))
//pass
         System.out.println("correct SignIn page");
     else
//fail
         System.out.println("wrong SignIn page");
 }
@Test(priority = 3)
public void positiveSignIn() throws InterruptedException {
//Input your Email
    driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys("qhadeejha01@gmail.com");
//Click on continue button
    driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
//Input your password
    driver.findElement(By.xpath("//*[@id=\"passwordForm\"]/div[2]/div[3]/label/input")).sendKeys("Khadijah01");
//Click on login button
    driver.findElement(By.xpath("//*[@id=\"loginButton\"]/span[3]")).click();
//Test4:Verify that user was redirected to the homepage after sign-in
    driver.getCurrentUrl();
    if (driver.getCurrentUrl().contains("\"https://www.jumia.com.ng/\""))
//pass
        System.out.println("Hi,Khadijah");
    else
        //fail
        System.out.println("Login failed");
    //Added delay command before loading the next page
    Thread.sleep(2000);
    //Click on the name header label
    driver.findElement(By.xpath("//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")).click();
    //Click on logout
    driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/form/button")).click();
    //Added delay command before loading the next page
    Thread.sleep(2000);
}
@Test(priority = 4)
public void negativeSignInEmail() throws InterruptedException {
//Test5: Verify that user can not sigIn with invalid Email Address
    driver.get("https://www.jumia.com.ng/");
    // Click on Account to locate the sign-in button
    driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/label")).click();
    //Click on the sign-in
    driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
    //Added delay command before loading the next page
    Thread.sleep(2000);
    //Input your Email
    driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys("12345@gmail.com");
    //Click on continue button
    driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
    //Input your password
    driver.findElement(By.xpath("//*[@id=\"passwordForm\"]/div[2]/div[3]/label/input")).sendKeys("Khadijah01");
    //click on login button
    driver.findElement(By.xpath("//*[@id=\"loginButton\"]/span[3]")).click();
}
@Test(priority = 5)
public void negativeSignInPassword() throws InterruptedException {
    //Test6: Verify that user can not sigIn with password
    driver.get("https://www.jumia.com.ng/");
    // Click on Account to locate the sign-in button
    driver.findElement(By.xpath("/html/body/div[1]/header/section/div[2]/div[1]/label")).click();
    //Click on the sign-in
    driver.findElement(By.xpath("//*[@id=\"dpdw-login-box\"]/div/div/a")).click();
    //Added delay command before loading the next page
    Thread.sleep(2000);
    //Input your Email
    driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[2]/label/input")).sendKeys("qhadeejha01@gmail.com");
    //Click on continue button
    driver.findElement(By.xpath("/html/body/div/div[4]/form/div[2]/div[3]/div/button/span[3]")).click();
    //Input your password
    driver.findElement(By.xpath("//*[@id=\"passwordForm\"]/div[2]/div[3]/label/input")).sendKeys("Admin");
    //click on login button
    driver.findElement(By.xpath("//*[@id=\"loginButton\"]/span[3]")).click();
}
@AfterTest
    public void closeBrowser(){
    //quit the browser
    driver.quit();

}


}
