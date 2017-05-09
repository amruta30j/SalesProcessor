package com.salesprocessor.notification.model;

/**
 * Created by amrutaj on 07/05/2017.
 */
public class Product {

    private String productNmae;
    private Double productPrice;
    private int productQuantity;

    public String getProductNmae() {
        return productNmae;
    }

    public void setProductNmae(String productNmae) {
        this.productNmae = productNmae;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getProductQuantity() != product.getProductQuantity()) return false;
        if (!getProductNmae().equals(product.getProductNmae())) return false;
        return getProductPrice().equals(product.getProductPrice());
    }

    @Override
    public int hashCode() {
        int result = getProductNmae().hashCode();
        result = 31 * result + getProductPrice().hashCode();
        result = 31 * result + getProductQuantity();
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNmae='" + productNmae + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
