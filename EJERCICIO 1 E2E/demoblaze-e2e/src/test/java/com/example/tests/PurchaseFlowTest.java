package com.example.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

@RunWith(SerenityRunner.class)
public class PurchaseFlowTest {

    @Test
    public void realizarCompra() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chrome-win64");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.demoblaze.com/");

        // Agregar primer producto
        driver.findElement(By.linkText("Samsung galaxy s6")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.navigate().back();

        // Agregar segundo producto
        driver.findElement(By.linkText("Nokia lumia 1520")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.navigate().back();

        // Visualizar carrito
        driver.findElement(By.id("cartur")).click();
        Thread.sleep(2000);

        // Completar formulario de compra
        driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("name")).sendKeys("Juan Perez");
        driver.findElement(By.id("country")).sendKeys("Argentina");
        driver.findElement(By.id("city")).sendKeys("Buenos Aires");
        driver.findElement(By.id("card")).sendKeys("1234 5678 9012 3456");
        driver.findElement(By.id("month")).sendKeys("12");
        driver.findElement(By.id("year")).sendKeys("2025");

        // Finalizar compra
        driver.findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();
        Thread.sleep(3000);

        // Verificar mensaje de confirmación
        String confirmation = driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]")).getText();
        assertTrue(confirmation.contains("Thank you for your purchase!"));

        driver.quit();
    }
}
