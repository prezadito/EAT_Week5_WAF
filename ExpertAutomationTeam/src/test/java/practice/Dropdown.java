package practice;

import base.CommonAPI;
import org.testng.annotations.Test;

public class Dropdown extends CommonAPI {

    @Test
    public void dropdownList() {
        click("//select[@name='cars']");
        click("//option[text()='Volvo']");
    }

    @Test
    public void dropDownListGroup() {

    }

}
