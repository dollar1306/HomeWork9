import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class HomeWork9 {
    private static ChromeDriver chromeDriver;
    private static FirefoxDriver firefoxDriver;


        @BeforeClass
        public static void runBeforeClass() {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\Alex\\AppData\\Local\\Google\\Chrome\\chromedriver.exe");
            chromeDriver = new ChromeDriver();
            //chromeDriver.get("https://www.walla.co.il");

            System.setProperty("webdriver.gecko.driver",
                    "C:\\Users\\Alex\\AppData\\Local\\Mozilla\\Firefox\\geckodriver.exe");
            firefoxDriver = new FirefoxDriver();
            firefoxDriver.manage().window().maximize();
            //firefoxDriver.get("https://www.ynet.co.il");
        }



        @Test
    public void test1(){
            chromeDriver.get("https://www.walla.co.il");
            firefoxDriver.get("https://www.ynet.co.il");
        }

        @Test
    public void test2(){
            String checkChromeTitle = chromeDriver.getTitle();
            System.out.println(checkChromeTitle);
            chromeDriver.navigate().refresh();
            String checkFirefoxTitle = firefoxDriver.getTitle();
            System.out.println(checkFirefoxTitle);
            firefoxDriver.navigate().refresh();

            if(checkChromeTitle.equals(checkFirefoxTitle)){
                System.out.println("They equal");
                System.out.println("Chrome title: "+checkChromeTitle);
                System.out.println("Firefox title: "+checkFirefoxTitle);
            }else{
                System.out.println("They not equal");
                System.out.println("Chrome title: "+checkChromeTitle);
                System.out.println("Firefox title: "+checkFirefoxTitle);
            }
        }


        @Test
    public void test3(){
            String googleUrl = "https://www.walla.co.il/";
            String wallaUrl = chromeDriver.getCurrentUrl();
            Assert.assertEquals(wallaUrl,googleUrl);

        }


    @Test
    public void test4(){
            chromeDriver.get("https://translate.google.co.il/");
            System.out.println(chromeDriver.findElement(By.className("er8xn")));
            System.out.println(chromeDriver.findElement(By.tagName("textarea")));
    }

    @Test
    public void test5(){
            firefoxDriver.get("https://youtube.com/");
            System.out.println(firefoxDriver.findElements(By.id("search-icon-legacy")));
    }


    @Test
    public void test6(){
         firefoxDriver.get("http://www.seleniumhq.org/");
        WebElement elementSearch = firefoxDriver.findElement(By.name("search"));
        System.out.println(elementSearch);
        elementSearch.sendKeys("selenium");

        chromeDriver.get("http://www.seleniumhq.org/");
        WebElement hsel = chromeDriver.findElement(By.name("search"));
        System.out.println(hsel);
        hsel.sendKeys("selenium");
    }



    @Test
    public void test7(){
            chromeDriver.get("https://www.amazon.com/");
            String amazonTitleChrome = chromeDriver.getTitle();
            firefoxDriver.get("https://www.amazon.com/");
            String amazonTitleFirefox = firefoxDriver.getTitle();

        Assert.assertEquals(amazonTitleChrome,amazonTitleFirefox);
        chromeDriver.findElement(By.id("twotabsearchtextbox")).sendKeys("Leather shoes");
        firefoxDriver.findElement(By.id("twotabsearchtextbox")).sendKeys("Leather shoes");
    }



    @Test
    public void test8(){
            chromeDriver.get("https://translate.google.co.il/");
            firefoxDriver.get("https://translate.google.co.il/");

            chromeDriver.findElement(By.className("er8xn")).sendKeys("שלום עולם, מה שלום כולם");
            chromeDriver.findElement(By.className("er8xn")).click();

        firefoxDriver.findElement(By.className("er8xn")).sendKeys("מישהו הצילו אותי");
        firefoxDriver.findElement(By.className("er8xn")).click();
    }



    @Test
    public void test9(){
        chromeDriver.get("https://www.youtube.com");
        chromeDriver.findElement(By.id("search")).sendKeys("Purple Noise");
        chromeDriver.findElement(By.id("search-icon-legacy")).click();
    }



    @Test
    public void test10(){
        chromeDriver.get("https://dgotlieb.github.io/Controllers/");
        List<WebElement> buttonsList = chromeDriver.findElements(By.name("group1"));
        for(WebElement temp : buttonsList){
            if(temp.getAttribute("value").equals("Cheese")){
                temp.click();
            }
            System.out.println(temp.getAttribute("value"));
        }
        Select selection = new Select(chromeDriver.findElement(By.name("dropdownmenu")));
        selection.selectByValue("Butter");
        for (int i = 0; i < selection.getOptions().size(); i++) {
            System.out.println(selection.getOptions().get(i).getText());
        }
    }


    @Test
    public void test11(){
        chromeDriver.get("https://www.facebook.com/");
        chromeDriver.findElement(By.id("email")).sendKeys("dollar1306@gmail.com");
        chromeDriver.findElement(By.id("pass")).sendKeys("admin");
        chromeDriver.findElement(By.name("login")).click();
    }


    @Test
    public void test12(){
            chromeDriver.get("https://dgotlieb.github.io/WebCalculator/");
        System.out.println(chromeDriver.findElement(By.id("seven")).getSize());
        System.out.println(chromeDriver.findElement(By.id("six")).isDisplayed());

        chromeDriver.findElement(By.id("nine")).click();
        chromeDriver.findElement(By.id("minus")).click();
        chromeDriver.findElement(By.id("eight")).click();
        chromeDriver.findElement(By.id("equal")).click();


        String result = chromeDriver.findElement(By.id("screen")).getText();
        String expectedResult = "1";
        Assert.assertEquals(expectedResult,result);
    }



    @Test
    public void test13(){
        chromeDriver.get("https://dgotlieb.github.io/WebCalculator/");
        System.out.println(chromeDriver.findElement(By.id("two")).getRect().getHeight());
        System.out.println(chromeDriver.findElement(By.id("six")).getRect().getWidth());
    }


    @Test
    public void test14(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-all-extensions");
        WebDriver driver = new ChromeDriver(options);
    }

    @AfterClass
    public void afterClass(){
            chromeDriver.quit();
            firefoxDriver.quit();
    }
}
