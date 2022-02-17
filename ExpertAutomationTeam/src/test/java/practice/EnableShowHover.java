package practice;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EnableShowHover extends CommonAPI {

    @Test
    public void enableDisableButton() {
        WebElement field = driver.findElement(By.xpath("//input[@id='enableDisableField']"));
        WebElement enableBtn = driver.findElement(By.xpath("//button[@id='enableField']"));
        WebElement disableBtn = driver.findElement(By.xpath("//button[@id='disableField']"));
        if (field.isEnabled()) {
            act.moveToElement(disableBtn).click().perform();
            act.moveToElement(enableBtn).click().perform();
        } else {
            act.moveToElement(enableBtn).click().perform();
        }
    }

    @Test
    public void showHideElement() {

    }

    @Test
    public void mouseHover() {

    }

}
