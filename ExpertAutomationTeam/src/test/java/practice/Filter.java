package practice;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Filter extends CommonAPI {

    @Test
    public void filter() {
        Assert.assertEquals(getTitle(), "Practice Page | QA Automation");
        type("//input[@class='form-control']", "select");
        Assert.assertEquals(driver.getPageSource().contains("select"), Boolean.TRUE);
    }

}
