package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Integer.parseInt;

public class MainPage {
    private final WebDriver driver;

    @FindBy(className = "product_sort_container")
    private WebElement selectSort;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> products;

    @FindBy(xpath = "//span[text() = 'Products']")
    private WebElement lblProducts;

    @FindBy(className = "shopping_cart_badge")
    private List<WebElement> lblShoppingCartBadge;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement btnMenu;

    @FindBy(xpath = "//a[text() = 'Logout']")
    private WebElement btnLogout;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sortProductsByPrice_highToLow() {
        Select dropdown = new Select(selectSort);
        dropdown.selectByValue("hilo");
    }

    public void goToProductDetail(Integer num) {
        WebElement product = products.get(products.size() - num);
        product.click();
    }

    public boolean lblProductsIsDisplayed() {
        return lblProducts.isDisplayed();
    }

    public boolean lblShoppingCartBadgeIsEmpty() {
        return lblShoppingCartBadge.isEmpty();
    }

    public boolean lblShoppingCartBadgeHasThreeProducts() {
        return parseInt(lblShoppingCartBadge.get(0).getText()) == 3;
    }

    public void logout() {
        btnMenu.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(btnLogout));
        btnLogout.click();
    }
}
