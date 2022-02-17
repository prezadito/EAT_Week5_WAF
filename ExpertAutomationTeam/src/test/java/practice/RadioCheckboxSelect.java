package practice;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class RadioCheckboxSelect extends CommonAPI {

    @Test
    public void radioButton() {
        click("//input[@id='appleRadiobtn']");
        click("//input[@id='orangeRadiobtn']");
        click("//input[@id='pineappleRadiobtn']");
    }

    @Test
    public void checkbox() {
        WebElement chk1 = driver.findElement(By.xpath("//input[@id='bmwCheckbox']"));
        WebElement chk2 = driver.findElement(By.xpath("//input[@id='mercedesCheckbox']"));
        WebElement chk3 = driver.findElement(By.xpath("//input[@id='bentleyCheckbox']"));
        chk1.click();
        chk2.click();
        chk3.click();
    }

    @Test
    public void selectMultipleItems() {
        Actions act = new Actions(driver);
        List<WebElement> list = driver.findElements(By.cssSelector("select#selectingMultipleItems *"));
        act.clickAndHold(list.get(0)).clickAndHold(list.get(1)).clickAndHold(list.get(2)).release().build().perform();
    }

}
