package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class BrowserUtils extends ReadJson {
    public static WebDriver driver;
    public static ChromeOptions co;
    public static String[] returnedarray = ReadJson.readJsonData();  //This is just to call the function to read the files.
    // This is not going to be used anywhere but the json data will be


    public static void setDriverChrome() {
        System.setProperty("webdriver.chrome.driver", "C:/BrowserDriver/chromedriver.exe");
        co = new ChromeOptions();
        co.setBinary("C:/BrowserDriver/chrome-win64/chrome-win64/chrome.exe");
        // Disable cookies
        co.addArguments("--disable-cookies");
        driver = new ChromeDriver(co);
    }

    public static void setDriverFirefox() {
        // Setup Firefox WebDriver using webdrivermanager
        System.setProperty("webdriver.gecko.driver", "D:/Software/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:/Users/h.abul/AppData/Local/Mozilla Firefox/firefox.exe");
        driver = new FirefoxDriver(options);
    }

    public static void closedriver() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    public static void cssSelectorPressEnter(String cssSelector) {
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        element.sendKeys(Keys.ENTER);
    }

    public static void pressEnterById(String id) {
        WebElement element = driver.findElement(By.id(id));
        element.sendKeys(Keys.ENTER);
    }

    public static void waitById(String id) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    public static void waitByxpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static void waitByCssSelector(String cssSelector) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
    }

    public static void clickbyxpath(String s) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(s)));
        WebElement element = driver.findElement(By.xpath(s));
        element.click();
        Thread.sleep(200);
    }


    public static void inputbyxpath(String xpath, String s) {
        waitByxpath(xpath);
        WebElement element = driver.findElement(By.xpath(xpath));
        //element.click();
        element.sendKeys(s);
    }

    public static void clickbyId(String s) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id(s)));
        WebElement element = driver.findElement(By.id(s));
        element.click();
    }


    public static void inputbyid(String id, String s) {
        WebElement element = driver.findElement(By.id(id));
        //element.click();
        waitById(id);
        element.sendKeys(s);

    }


    public static void clickbycssselector(String s) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(s)));
        WebElement element = driver.findElement(By.cssSelector(s));
        element.click();
    }


    public static void inputbycssselector(String cssSelector, String s) {
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        // element.click();
        element.sendKeys(s);
    }

    public static void inputbyName(String name, String s) {
        WebElement element = driver.findElement(By.name(name));
        // element.click();
        element.sendKeys(s);
    }

    public static void clickByName(String name) {
        WebElement element = driver.findElement(By.name(name));
        element.click();
    }

    public static void clickByClassName(String name) {
        WebElement element = driver.findElement(By.className(name));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.className(name)));
        element.click();
    }

    public static void RowCount(String name) {
        WebElement element = driver.findElement(By.className(name));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.className(name)));
        element.click();
    }

    public static void SetToday(String xpath) throws InterruptedException {
        // Get current date and time
        Thread.sleep(100);
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm a");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println(formattedDateTime);

        // Click on the input field to focus on it
        WebElement dateTimeInput = driver.findElement(By.xpath(xpath));
        dateTimeInput.click();
        Actions actions = new Actions(driver);
        for (int i = 0; i < 6; i++) {
            actions.sendKeys(Keys.ARROW_LEFT).build().perform();
        }

        // Split the formatted date-time into parts
        String[] parts = formattedDateTime.split(" ");
        String datePart = parts[0]; // Date part
        String timePart = parts[1]; // Time part
        String amPmPart = parts[2]; // AM/PM part

        // Split the date part into year, month, and day
        String[] dateParts = datePart.split("-");
        int desiredMonth = Integer.parseInt(dateParts[0]);
        int desiredDay = Integer.parseInt(dateParts[1]);
        int desiredYear = Integer.parseInt(dateParts[2]);

        // Split the time part into hour and minute
        String[] timeParts = timePart.split(":");
        int desiredHour = Integer.parseInt(timeParts[0]);
        int desiredMinute = Integer.parseInt(timeParts[1]);


        // Navigate to the desired month

        actions.sendKeys(Keys.BACK_SPACE).build().perform();
        for (int currentMonth = 00; currentMonth != desiredMonth; currentMonth++) {
            if (currentMonth < desiredMonth) {
                actions.sendKeys(Keys.ARROW_UP).build().perform();
            } else {
                actions.sendKeys(Keys.ARROW_DOWN).build().perform();
            }
        }
        actions.sendKeys(Keys.ARROW_RIGHT).build().perform();

        // Navigate to the desired day
        actions.sendKeys(Keys.BACK_SPACE).build().perform();
        for (int currentDay = 00; currentDay != desiredDay; currentDay++) {
            if (currentDay > desiredDay) {
                actions.sendKeys(Keys.ARROW_DOWN).build().perform();
            } else {
                actions.sendKeys(Keys.ARROW_UP).build().perform();
            }
        }
        actions.sendKeys(Keys.ARROW_RIGHT).build().perform();


        // Navigate to the desired year
        actions.sendKeys(Keys.ARROW_UP).build().perform();
        actions.sendKeys(Keys.ARROW_RIGHT).build().perform();

//        // Navigate to the desired hour
//        actions.sendKeys(Keys.BACK_SPACE).build().perform();
//        for (int currentHour = 00; currentHour != desiredHour; currentHour ++) {
//            if (currentHour > desiredHour) {
//                actions.sendKeys(Keys.ARROW_DOWN).build().perform();
//            } else {
//                actions.sendKeys(Keys.ARROW_UP).build().perform();
//            }
//        }
//        actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
//
//        // Navigate to the desired minute
//        actions.sendKeys(Keys.BACK_SPACE).build().perform();
//        for (int currentMinute = 00; currentMinute != desiredMinute; currentMinute ++) {
//            if (currentMinute > desiredMinute) {
//                actions.sendKeys(Keys.ARROW_DOWN).build().perform();
//            } else {
//                actions.sendKeys(Keys.ARROW_UP).build().perform();
//            }
//        }
//        actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
//
//        // Toggle AM/PM if needed
//        actions.sendKeys(Keys.BACK_SPACE).build().perform();
//        if (Objects.equals(amPmPart, "PM")) {
//            actions.sendKeys(Keys.ARROW_DOWN).build().perform();
//        } else {
//            actions.sendKeys(Keys.ARROW_UP).build().perform();
//        }
    }
    public static void Setaday(String xpath , String date) throws InterruptedException {
        String formattedDateTime = date;
        System.out.println(formattedDateTime);

        // Click on the input field to focus on it
        WebElement dateTimeInput = driver.findElement(By.xpath(xpath));
        dateTimeInput.click();
        Actions actions = new Actions(driver);

        //go to top left
        for (int i = 0; i < 4; i++) {
            actions.sendKeys(Keys.ARROW_LEFT).build().perform();
        }

        // Split the formatted date-time into parts
        String[] parts = formattedDateTime.split(" ");
        String datePart = parts[0]; // Date part

        // Split the date part into year, month, and day
        String[] dateParts = datePart.split("/");
        int desiredMonth = Integer.parseInt(dateParts[0]);
        int desiredDay = Integer.parseInt(dateParts[1]);
        int desiredYear = Integer.parseInt(dateParts[2]);

        // Navigate to the desired month

        actions.sendKeys(Keys.BACK_SPACE).build().perform();
        for (int currentMonth = 00; currentMonth != desiredMonth; currentMonth++) {
            if (currentMonth < desiredMonth) {
                actions.sendKeys(Keys.ARROW_UP).build().perform();
            } else {
                actions.sendKeys(Keys.ARROW_DOWN).build().perform();
            }
        }
        actions.sendKeys(Keys.ARROW_RIGHT).build().perform();

        // Navigate to the desired day
        actions.sendKeys(Keys.BACK_SPACE).build().perform();
        for (int currentDay = 00; currentDay != desiredDay; currentDay++) {
            if (currentDay > desiredDay) {
                actions.sendKeys(Keys.ARROW_DOWN).build().perform();
            } else {
                actions.sendKeys(Keys.ARROW_UP).build().perform();
            }
        }
        actions.sendKeys(Keys.ARROW_RIGHT).build().perform();


        // Navigate to the desired year
        actions.sendKeys(Keys.ARROW_UP).build().perform();
        actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
    }

    public static void SetPreviousDate(String xpath) throws InterruptedException {
//        // Get current date and time
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm a");
        String formattedDateTime = "04-20-2023 00:00 a";
        System.out.println(formattedDateTime);

        // Click on the input field to focus on it
        WebElement dateTimeInput = driver.findElement(By.xpath(xpath));
        dateTimeInput.click();
        Actions actions = new Actions(driver);
        for (int i = 0; i < 6; i++) {
            actions.sendKeys(Keys.ARROW_LEFT).build().perform();
        }

        // Split the formatted date-time into parts
        String[] parts = formattedDateTime.split(" ");
        String datePart = parts[0]; // Date part
        String timePart = parts[1]; // Time part
        String amPmPart = parts[2]; // AM/PM part

        // Split the date part into year, month, and day
        String[] dateParts = datePart.split("-");
        int desiredMonth = Integer.parseInt(dateParts[0]);
        int desiredDay = Integer.parseInt(dateParts[1]);
        int desiredYear = Integer.parseInt(dateParts[2]);

        // Split the time part into hour and minute
        String[] timeParts = timePart.split(":");
        int desiredHour = Integer.parseInt(timeParts[0]);
        int desiredMinute = Integer.parseInt(timeParts[1]);


        // Navigate to the desired month

        actions.sendKeys(Keys.BACK_SPACE).build().perform();
        for (int currentMonth = 00; currentMonth != desiredMonth; currentMonth++) {
            if (currentMonth < desiredMonth) {
                actions.sendKeys(Keys.ARROW_UP).build().perform();
            } else {
                actions.sendKeys(Keys.ARROW_DOWN).build().perform();
            }
        }
        actions.sendKeys(Keys.ARROW_RIGHT).build().perform();

        // Navigate to the desired day
        actions.sendKeys(Keys.BACK_SPACE).build().perform();
        for (int currentDay = 00; currentDay != desiredDay; currentDay++) {
            if (currentDay > desiredDay) {
                actions.sendKeys(Keys.ARROW_DOWN).build().perform();
            } else {
                actions.sendKeys(Keys.ARROW_UP).build().perform();
            }
        }
        actions.sendKeys(Keys.ARROW_RIGHT).build().perform();


        // Navigate to the desired year
        actions.sendKeys(Keys.BACK_SPACE).build().perform();
        int Year = Calendar.getInstance().get(Calendar.YEAR);
        actions.sendKeys(Keys.ARROW_UP).build().perform();
        for (int currentYear = Year; currentYear < desiredYear; currentYear++) {
            actions.sendKeys(Keys.ARROW_UP).build().perform();
        }
        for (int currentYear = Year; currentYear > desiredYear; currentYear--) {
            actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        }

        actions.sendKeys(Keys.ARROW_RIGHT).build().perform();

//        // Navigate to the desired hour
//        actions.sendKeys(Keys.BACK_SPACE).build().perform();
//        for (int currentHour = 00; currentHour != desiredHour; currentHour ++) {
//            if (currentHour > desiredHour) {
//                actions.sendKeys(Keys.ARROW_DOWN).build().perform();
//            } else {
//                actions.sendKeys(Keys.ARROW_UP).build().perform();
//            }
//        }
//        actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
//
//        // Navigate to the desired minute
//        actions.sendKeys(Keys.BACK_SPACE).build().perform();
//        for (int currentMinute = 00; currentMinute != desiredMinute; currentMinute ++) {
//            if (currentMinute > desiredMinute) {
//                actions.sendKeys(Keys.ARROW_DOWN).build().perform();
//            } else {
//                actions.sendKeys(Keys.ARROW_UP).build().perform();
//            }
//        }
//        actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
//
//        // Toggle AM/PM if needed
//        actions.sendKeys(Keys.BACK_SPACE).build().perform();
//        if (Objects.equals(amPmPart, "PM")) {
//            actions.sendKeys(Keys.ARROW_DOWN).build().perform();
//        } else {
//            actions.sendKeys(Keys.ARROW_UP).build().perform();
//        }
    }

    public static void SetFutureDate(String xpath) throws InterruptedException {
        // Get current date and time
        LocalDateTime currentDateTime = LocalDateTime.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm a");
        String formattedDateTime = currentDateTime.format(formatter);

        System.out.println(formattedDateTime);

        // Click on the input field to focus on it
        WebElement dateTimeInput = driver.findElement(By.xpath(xpath));
        dateTimeInput.click();
        Actions actions = new Actions(driver);
        for (int i = 0; i < 6; i++) {
            actions.sendKeys(Keys.ARROW_LEFT).build().perform();
        }

        // Split the formatted date-time into parts
        String[] parts = formattedDateTime.split(" ");
        String datePart = parts[0]; // Date part
        String timePart = parts[1]; // Time part
        String amPmPart = parts[2]; // AM/PM part

        // Split the date part into year, month, and day
        String[] dateParts = datePart.split("-");
        int desiredMonth = Integer.parseInt(dateParts[0]);
        int desiredDay = Integer.parseInt(dateParts[1]);
        int desiredYear = Integer.parseInt(dateParts[2]);

        // Split the time part into hour and minute
        String[] timeParts = timePart.split(":");
        int desiredHour = Integer.parseInt(timeParts[0]);
        int desiredMinute = Integer.parseInt(timeParts[1]);


        // Navigate to the desired month

        actions.sendKeys(Keys.BACK_SPACE).build().perform();
        for (int currentMonth = 00; currentMonth != desiredMonth; currentMonth++) {
            if (currentMonth < desiredMonth) {
                actions.sendKeys(Keys.ARROW_UP).build().perform();
            } else {
                actions.sendKeys(Keys.ARROW_DOWN).build().perform();
            }
        }
        actions.sendKeys(Keys.ARROW_RIGHT).build().perform();

        // Navigate to the desired day
        actions.sendKeys(Keys.BACK_SPACE).build().perform();
        for (int currentDay = 00; currentDay != desiredDay; currentDay++) {
            if (currentDay > desiredDay) {
                actions.sendKeys(Keys.ARROW_DOWN).build().perform();
            } else {
                actions.sendKeys(Keys.ARROW_UP).build().perform();
            }
        }
        actions.sendKeys(Keys.ARROW_RIGHT).build().perform();


        // Navigate to the desired year
        actions.sendKeys(Keys.BACK_SPACE).build().perform();
        int Year = Calendar.getInstance().get(Calendar.YEAR);
        actions.sendKeys(Keys.ARROW_UP).build().perform();
        for (int currentYear = Year; currentYear < desiredYear; currentYear++) {
            actions.sendKeys(Keys.ARROW_UP).build().perform();
        }
        for (int currentYear = Year; currentYear > desiredYear; currentYear--) {
            actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        }

        actions.sendKeys(Keys.ARROW_RIGHT).build().perform();

//        // Navigate to the desired hour
//        actions.sendKeys(Keys.BACK_SPACE).build().perform();
//        for (int currentHour = 00; currentHour != desiredHour; currentHour ++) {
//            if (currentHour > desiredHour) {
//                actions.sendKeys(Keys.ARROW_DOWN).build().perform();
//            } else {
//                actions.sendKeys(Keys.ARROW_UP).build().perform();
//            }
//        }
//        actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
//
//        // Navigate to the desired minute
//        actions.sendKeys(Keys.BACK_SPACE).build().perform();
//        for (int currentMinute = 00; currentMinute != desiredMinute; currentMinute ++) {
//            if (currentMinute > desiredMinute) {
//                actions.sendKeys(Keys.ARROW_DOWN).build().perform();
//            } else {
//                actions.sendKeys(Keys.ARROW_UP).build().perform();
//            }
//        }
//        actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
//
//        // Toggle AM/PM if needed
//        actions.sendKeys(Keys.BACK_SPACE).build().perform();
//        if (Objects.equals(amPmPart, "PM")) {
//            actions.sendKeys(Keys.ARROW_DOWN).build().perform();
//        } else {
//            actions.sendKeys(Keys.ARROW_UP).build().perform();
//        }
    }
}