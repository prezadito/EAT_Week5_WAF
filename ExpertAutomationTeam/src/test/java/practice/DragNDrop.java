package practice;

import base.CommonAPI;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragNDrop extends CommonAPI {

    @Test
    public void dND() {
        Assert.assertEquals(getTitle(), "Practice Page | QA Automation");
        dragAndDrop("//img[@ondragstart='drag(event)']", "//div[@ondrop='drop(event)']");
    }

}
