package ParisAUT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Base {

    private static WebDriver driver;

        By xPopup = By.className("dy-lb-close");
        By inicioSesion = By.className("header-customer__subheading");
        By btnInicioSesion = By.xpath("/html/body/header/div[2]/div/nav/div[3]/div/div/div[1]/div/div/div/div/div/div[1]/button");
        By logoPage = By.className("ml-mob");
        By correoInicioSesionPopup = By.id("dwfrm_login_username");
        By passwdInicioSesionPopup = By.name("dwfrm_login_password");
        By botonInicioSesionPopup = By.name("dwfrm_login_login");
        By validadorPopupInicioSesion = By.className("form-notification__body");


    public static void SetDriver() {

        System.setProperty("webdriver.chrome.driver","C:\\ProyectosAUT\\ParisAUT\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.paris.cl");
        driver.manage().window().maximize();
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);

    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public String setText(String txt, By locator){

        WebElement input=driver.findElement(locator);
        input.sendKeys(txt);

        return null;
    }

    public void type(String inputText, By locator){

        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){

        driver.findElement(locator).click();
    }

    public boolean isDisplayed (By locator){

        boolean isPresent;

        if (this.findElement(locator).isDisplayed()) {
            isPresent = true;
            System.out.println("Elemento existe_" + locator);
        }else{
            isPresent = false;
            System.out.println("Elemento no existe o esta mal referenciado_" + locator);
        }

        return isPresent;
    }

    @Test
    public void aperturaPagina() throws InterruptedException {

        SetDriver();

        String actualURL = driver.getCurrentUrl();

        Thread.sleep(2000);

        if (isDisplayed(logoPage)) {
            System.out.println("Elemento Logo existe, pagina desplegada OK_" + logoPage);
        } else {
            System.out.println("Elemento Logo no existe o esta mal referenciado, pagina con problemas de desplegue_" + logoPage);
        }
        System.out.println("actual url: "+actualURL);
        Assert.assertEquals("https://www.paris.cl/", actualURL);
    }

    public void setUsuarioPasswd(String user, String passwd) throws InterruptedException {

        WebElement username=driver.findElement(correoInicioSesionPopup);
        WebElement password=driver.findElement(passwdInicioSesionPopup);
        WebElement login=driver.findElement(botonInicioSesionPopup);

        Thread.sleep(2000);

        click(correoInicioSesionPopup);
        Thread.sleep(2000);
        setText(user, correoInicioSesionPopup);
        Thread.sleep(2000);

        click(passwdInicioSesionPopup);
        Thread.sleep(2000);
        setText(passwd, passwdInicioSesionPopup);
        login.click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(validadorPopupInicioSesion).getText());
        Thread.sleep(2000);


        }

    }

 //Base
