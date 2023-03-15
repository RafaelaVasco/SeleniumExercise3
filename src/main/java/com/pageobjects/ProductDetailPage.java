package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {
    private WebDriver driver;

    @FindBy(className = "inventory_details_name")
    private WebElement lblProductName;

    @FindBy(className = "inventory_details_desc")
    private WebElement lblProductDetail;

    @FindBy(className = "inventory_details_price")
    private WebElement lblProductPrice;

    @FindBy(xpath = "//button[text() = 'Add to cart']")
    private WebElement btnAddToCart;

    @FindBy(id = "back-to-products")
    private WebElement btnBackToProducts;

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void printProductDescriptionAndPrice() {
        System.out.println(">>> Name: " + lblProductName.getText());
        System.out.println(">>> Description: " + lblProductDetail.getText());
        System.out.println(">>> Price: " + lblProductPrice.getText());
        System.out.println("------------------------------------------------------------------------------");
    }

    public void addToCart() {
        btnAddToCart.click();
    }

    public void goBackToProductsList() {
        btnBackToProducts.click();
    }
}
