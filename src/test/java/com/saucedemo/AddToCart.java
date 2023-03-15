package com.saucedemo;

import com.dataprovider.LoginDataProvider;
import com.pageobjects.LoginFormPage;
import com.pageobjects.MainPage;
import com.pageobjects.ProductDetailPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddToCart extends Base {
    private LoginFormPage loginFormPage;
    private MainPage mainPage;
    private ProductDetailPage productDetailPage;

    @BeforeTest
    public void initialize() {
        driver = initializeDriver();
        loginFormPage = new LoginFormPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(loginFormPage.getUrl());
        loginFormPage.loginUser(LoginDataProvider.USERNAME, LoginDataProvider.PASSWORD);
    }

    @Test
    public void testAddToCart() {
        mainPage = new MainPage(driver);
        productDetailPage = new ProductDetailPage(driver);

        Assert.assertTrue(mainPage.lblProductsIsDisplayed());
        Assert.assertTrue(mainPage.lblShoppingCartBadgeIsEmpty());

        for (int i = 1; i <= 3; i++) {
            mainPage.sortProductsByPrice_highToLow();
            mainPage.goToProductDetail(i);

            productDetailPage.printProductDescriptionAndPrice();
            productDetailPage.addToCart();
            productDetailPage.goBackToProductsList();
        }

        Assert.assertTrue(mainPage.lblShoppingCartBadgeHasThreeProducts());
    }

    @AfterMethod
    public void afterMethod() {
        mainPage.logout();
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }

}
