import io.cucumber.java.en.Given;
import org.example.Page_Options;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class test extends Page_Options {
    SoftAssert softAssert = new SoftAssert();

    @Given("test1brumbrum")
    public void test1brumbrum() {
        softAssert.assertEquals("yo", "Open this page in Chrome11");
    }

    @Given("test2brumbrum")
    public void test2() throws InterruptedException {
        navigatetourl("https://weatherstack.com/");
        PrintPageTitle();
        waitByxpath("/html/body/div/section[1]/div/div/div[1]/a");
        CaptureRequests();
        closedriver();
    }

    @Given("huhu")
    public void huhu() {
        try {
            System.out.println("this is expected");
            softAssert.assertAll();
        } catch (AssertionError | TimeoutException e) {
            // Handle the TimeoutException
            System.out.println("TimeoutException occurred: " + e.getMessage());
            throw e;
        }
    }

    @Test
    public void tata() throws InterruptedException {
        int j = randomnumber();
        String Store_type_name = StoreType.FullName + j;
        for (int i = 0; i < 5; i++) {

            System.out.println(Store_type_name);
        }
    }

    @Test
    public void tatat() throws InterruptedException {

    }
}
