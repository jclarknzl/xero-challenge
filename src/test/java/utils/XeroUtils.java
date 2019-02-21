package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class XeroUtils {

    public static WebElement waitFor(WebDriver d, By e){
        WebDriverWait wait = new WebDriverWait(d, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(e));
        return d.findElement(e);
    }

    public static void scrollTo(WebDriver d, WebElement e){
        ((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(true);", e);
    }
}
