package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Page_Options extends BrowserUtils {
    public static String id;
    public static String classname;
    public static String xpath;
    public static String cssSelector;
    public static DevTools devTools;
    public static String newLine = System.getProperty("line.separator");//This will retrieve line separator dependent on OS.;

    public static void navigatetourl(String URL) {
        setDriverChrome();
//        setDriverFirefox();
        driver.manage().window().maximize();
        driver.get(URL);    //enter url in this format only  "https://weatherstack.com/"
    }

    public static void scrollToTheBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight * 0.9)");
    }

    public static void scrollToTheBottomOfModal() {
        // Find the modal content element
        WebElement modalContent = driver.findElement(By.className("modal-content"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight",modalContent);
    }

    public static void PrintPageTitle() {
        System.out.println("The found Page is : " + driver.getTitle());
    }

    public static void scrollTo_ByXpath(String s) {
        WebElement element = driver.findElement(By.xpath(s));

        // Scroll the element into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", element);

    }

    public static String getToday() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();

        LocalDate today = LocalDate.now();
        String todayDate = dtf.format(today);
        return todayDate;
    }

    public static String getFutureDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now = LocalDateTime.now();

        LocalDate today = LocalDate.now();
        LocalDate lastMonthDate = today.plusYears(5);
        String date = dtf.format(lastMonthDate);
        return date;
    }

    public static String getTodaynTime() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Format the date and time with AM/PM
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyyyy'T'hh:mma");
        String formattedDateTime = currentDateTime.format(formatter);
//        System.out.println(formattedDateTime);
        return formattedDateTime;
    }

    public static String getFutureDatenTime() {
        // Format the date and time with AM/PM
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyyyy'T'hh:mma");
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime lastMonthDate = today.plusYears(10);
        String date = dtf.format(lastMonthDate);
        return date;
    }

    public static String getLastMonth() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate today = LocalDate.now();
        LocalDate lastMonthDate = today.minusMonths(1);
        String date = dtf.format(lastMonthDate);
        return date;
    }

    public static String getregularLastMonth() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();
        LocalDate lastMonthDate = today.minusMonths(1);
        String date = dtf.format(lastMonthDate);
        return date;
    }


    public static String getLastYear() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate today = LocalDate.now();
        LocalDate lastMonthDate = today.minusYears(1);
        String date = dtf.format(lastMonthDate);
        return date;
    }


    public static String getlastMonthAndTime() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime futureDateTime = currentDateTime.minusMonths(1);

        // Format the date and time with AM/PM
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyyyy'T'hh.mma");
        String formattedDateTime = futureDateTime.format(formatter);
//        System.out.println(formattedDateTime);
        return formattedDateTime;
    }

    public static void clearById(String id) {
        WebElement element = driver.findElement(By.id(id));
        element.clear();
    }

    public static void clearByXpath(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.clear();
    }

    public static void clearByid(String id) {
        WebElement element = driver.findElement(By.id(id));
        element.clear();
    }

    public static void clearByName(String s) {
        WebElement element = driver.findElement(By.name(s));
        element.clear();
    }

    public static void clearByCssSelector(String cssSelector) {
        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        element.clear();
    }

    public static void pressEnterbyXpath(String s) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath((s))));
        WebElement element = driver.findElement(By.xpath(s));
        element.sendKeys(Keys.ENTER);
    }

    public static void pressESCbyXpath(String s) {
        WebElement element = driver.findElement(By.xpath(s));
        element.sendKeys(Keys.ESCAPE);
    }

    public static void pressUPbyXpath(String s) {
        WebElement element = driver.findElement(By.xpath(s));
        element.sendKeys(Keys.ARROW_UP);
    }

    public static void pressDownbyXpath(String s) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(s)));
        WebElement element = driver.findElement(By.xpath(s));
        element.sendKeys(Keys.ARROW_DOWN);
    }

    public static void pressDownbyid(String s) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.id(s)));
        WebElement element = driver.findElement(By.id(s));
        element.sendKeys(Keys.ARROW_DOWN);
    }

    public static void pressDownbyCssSelector(String s) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(s)));
        WebElement element = driver.findElement(By.cssSelector(s));
        element.sendKeys(Keys.ARROW_DOWN);
    }


    public static void AlertAccept() throws InterruptedException {
        Thread.sleep(1000);
        //Wait for the alert to be displayed and store it in a variable
        driver.switchTo().alert().accept();
    }


    public static void switchTab() {
        String mainWindowHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break; // Switch to the first non-main window (new tab)
            }
        }
    }

    public static double getValuebyName(String s) {
        WebElement inputElement = driver.findElement(By.name(s));

        // Check if the input has a value
        String value = inputElement.getAttribute("value");
        double Value = Double.parseDouble(value);
        return Value;
    }

    public static double getValuebyXpath(String s) {
        WebElement inputElement = driver.findElement(By.xpath(s));

        // Check if the input has a value
        String value = inputElement.getAttribute("value");
        double Value = Double.parseDouble(value);
        return Value;
    }

    public static double getValuebyId(String s) {
        WebElement inputElement = driver.findElement(By.id(s));

        // Check if the input has a value
        String value = inputElement.getAttribute("value");
        double Value = Double.parseDouble(value);
        return Value;
    }

    public static double getText_double_byXpath(String s) {
        WebElement inputElement = driver.findElement(By.xpath(s));

        // Check if the input has a value
        String value = inputElement.getText();
        double Value = Double.parseDouble(value);
        return Value;
    }

    public static String getTextAttributebyXpath(String s) {
        WebElement inputElement = driver.findElement(By.xpath(s));
        String value = inputElement.getAttribute("value");
        return value;
    }

    public static String getTextbyXpath(String s) {
        WebElement inputElement = driver.findElement(By.xpath(s));
        String value = inputElement.getText();
        return value;
    }

    public static void Login_AIR(String username) {

        navigatetourl(Users.AIR);
        id = "username";
        inputbyid(id, username);
        id = "password";
        inputbyid(id, String.valueOf(Users.password));
        id = "login";
        clickbyId(id);
    }

    public static void Login_AIR2(String username) throws InterruptedException {

        navigatetourl(Users.AIR_2);
        id = "username";
        inputbyid(id, username);
        id = "password";
        inputbyid(id, String.valueOf(Users.password));
        id = "login";
        clickbyId(id);
        Thread.sleep(1000);
    }

    public static void Login_BPU(String username) throws InterruptedException {

        navigatetourl(Users.BPU);
        id = "username";
        inputbyid(id, username);
        id = "password";
        inputbyid(id, String.valueOf(Users.password));
        id = "login";
        clickbyId(id);
        Thread.sleep(1000);
    }

    public static void Login_AIR2_AIR(String username) {

        navigatetourl(Users.AIR_2_AIR);
        id = "username";
        inputbyid(id, username);
        id = "password";
        inputbyid(id, String.valueOf(Users.password));
        id = "login";
        clickbyId(id);
    }

    public static String randomTestString() {
        // Create a Random object
        Random random = new Random();
        // Generate a random number
        int randomNumber = random.nextInt(99999);
        // Concatenate the random number to the string
        String result = "TEST" + randomNumber;
        return result;
    }

    public static int randomnumber() {
        // Create a Random object
        Random random = new Random();
        // Generate a random number
        int randomNumber = random.nextInt(99999);

        return randomNumber;
    }

    public static void row_element_click_By_xpath_and_id(String xpath, String id) {
//        System.out.println(xpath +" , "+id);
        WebElement element1 = driver.findElement(By.xpath(xpath));
        WebElement Button = element1.findElement(By.id(id));
        Button.click();
    }

    public static String get_row_text_byXpath(String xpath) {
//        System.out.println(xpath +" , "+id);
        WebElement element1 = driver.findElement(By.xpath(xpath));
        String s = element1.getText();
        return s;
    }

    public static int getTotalRowCountByXpath(String xpath) throws InterruptedException {
        // Find all the rows in the table
        Thread.sleep(300);
        WebElement table = driver.findElement(By.xpath(xpath));
        int TotalRowCount = table.findElements(By.tagName("tr")).size();
//        System.out.println(TotalRowCount+" Total row count");
        return TotalRowCount;
    }

    public static String getAttributeByXpath(String xpath, String attributeName) throws InterruptedException {
        // Find the WebElement using XPath
        WebElement element = driver.findElement(By.xpath(xpath));

        // Get the attribute value
        String attributeValue = element.getAttribute(attributeName);
        return attributeValue;
    }

    public static int getTotalLiCountByXpath(String xpath) throws InterruptedException {
        // Find all the rows in the table
        Thread.sleep(300);
        WebElement table = driver.findElement(By.xpath(xpath));
        int TotalRowCount = table.findElements(By.tagName("li")).size();
        System.out.println(TotalRowCount + " Total Line count");
        return TotalRowCount;
    }

    public static String[][] viewButtonClickForMatchingRowsByXpathAndName(String Xpath, String name) throws InterruptedException {
        int totalrowCount = getTotalRowCountByXpath(Xpath);
        int matchedrows = 0;
        int tempcnt = 0;

        for (int i = 0; i < totalrowCount; i++) {

            WebElement nameElement = driver.findElement(By.xpath(Xpath + "/tr[" + (i + 1) + "]/td[2]/p"));
            WebElement dateElement = driver.findElement(By.xpath(Xpath + "/tr[" + (i + 1) + "]/td[4]/p"));
            WebElement viewButton = driver.findElement(By.xpath(Xpath + "/tr[" + (i + 1) + "]//a[@id='btn_view']"));

            String rowName = nameElement.getText();
            String rowDate = dateElement.getText();

            if (rowName.equals(name) && rowDate.isEmpty()) {
                matchedrows++;
            }
        }


        String[][] dataArray = new String[matchedrows][5];

        // Loop through each row and check the conditions
        for (int i = 0; i < totalrowCount; i++) {

            WebElement nameElement = driver.findElement(By.xpath(Xpath + "/tr[" + (i + 1) + "]/td[2]/p"));
            WebElement dateElement = driver.findElement(By.xpath(Xpath + "/tr[" + (i + 1) + "]/td[4]/p"));
            WebElement viewButton = driver.findElement(By.xpath(Xpath + "/tr[" + (i + 1) + "]//a[@id='btn_view']"));

            String rowName = nameElement.getText();
            String rowDate = dateElement.getText();

            if (rowName.equals(name) && rowDate.isEmpty()) {
                //click the view button
                viewButton.click();
                Thread.sleep(500);
                xpath = "//*[@id=\"part1_body\"]/tr[2]/td[2]/p";
                dataArray[tempcnt][0] = getTextAttributebyXpath(xpath);
                xpath = "//*[@id=\"part1_body\"]/tr[4]/td[2]/p";
                dataArray[tempcnt][1] = getTextAttributebyXpath(xpath);
                xpath = "//*[@id=\"part1_body\"]/tr[5]/td[2]/p";
                dataArray[tempcnt][2] = getTextAttributebyXpath(xpath);
                xpath = "//*[@id=\"part1_body\"]/tr[6]/td[2]/p";
                dataArray[tempcnt][3] = getTextAttributebyXpath(xpath);
                xpath = "//*[@id=\"part1_body\"]/tr[7]/td[2]/p";
                dataArray[tempcnt][4] = getTextAttributebyXpath(xpath);

                //close modal
                xpath = "//*[@id=\"modal_view\"]/div/div/div[3]/button";
                clickbyxpath(xpath);
                tempcnt++;
            }
        }
        return dataArray;
    }

    public static String getSelectedOptionNameByXpath(String xpath) {
        WebElement selectElement = driver.findElement(By.xpath(xpath));

// Create a Select object
        Select select = new Select(selectElement);

// Get the selected option
        WebElement selectedOption = select.getFirstSelectedOption();

// Get the text of the selected option
        String selectedText = selectedOption.getText();
        return selectedText;
    }


    public boolean ElementVisible(String s) {
        // Find the element using XPath
        WebElement element = driver.findElement(By.xpath(s));

        // Check if the element is visible
        return element.isDisplayed();

    }

    public void Click_from_leftSideBar(String s) throws InterruptedException {
        // Find the search input box and enter the search term "Damage Amount"
        id = "menu-search";
        waitById(id);
        Thread.sleep(200);
        inputbyid(id, s);

        // Then, click on the searched item "Damage Amount"
        WebElement webElement = driver.findElement(By.xpath("//span[text()='" + s + "']")); // Update the locator accordingly
        webElement.click();

        Thread.sleep(2000);
        System.out.println("Current page : " + driver.getTitle());
    }

    public void PrintConfirmationMessage() {
        // Wait for the modal dialog to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement modalDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("swal2-popup")));

        // Extract the confirmation message from the modal
        WebElement confirmationMessage = modalDialog.findElement(By.className("swal2-title"));
        String messageText = confirmationMessage.getText();
        System.out.println("Confirmation Message: " + messageText);
    }

    public String GetConfirmationMessage() {
        // Wait for the modal dialog to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement modalDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("swal2-popup")));

        // Extract the confirmation message from the modal
        WebElement confirmationMessage = modalDialog.findElement(By.className("swal2-title"));
        String messageText = confirmationMessage.getText();
        return messageText;
    }

    public double GrandTotalCalc(double [][]gt){
        double GrandTotal = 0;
        for (int i = 0; i < gt.length; i++) {
            GrandTotal = GrandTotal+(gt[i][0] * gt[i][1]);
        }
        return GrandTotal;
    }

    public void TakeScreenShot() throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\Users\\h.abul\\Pictures\\SS from automated tests\\screenshot"+randomnumber()+".png"));
    }

    public void PageUp() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(700);
    }
    public void PageDown() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(700);
    }
    public Boolean IsVisibleByXpath(String xpath) throws InterruptedException {
        Boolean visible = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

            // Check if the confirmation message is visible
            if (confirmationMessage.isDisplayed()) {
                visible = true;
            }

        }catch (TimeoutException e){
            System.out.println("There was a timeout exception that is caught");
        }

        return visible;
    }

    public void CaptureRequests () throws InterruptedException {
        System.out.println("Catch the requests");

    }
}