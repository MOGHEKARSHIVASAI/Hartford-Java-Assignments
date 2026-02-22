package org.example;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ProductManagementUsingList {
    private List<Product> products;
    public ProductManagementUsingList(){
        products = new ArrayList<>();
    }
    public void adProduct(Product product){
        products.add(product);
    }
    public List<Product> getProducts(){
        return products;
    }
    public Product getProductsById(int id){
        for(Product p:products){
            if(p.getPid()==id){
                return p;
            }
        }
        return null;
    }
    public boolean removeProductById(int id){
        return products.remove(getProductsById(id));
    }
    public List<Product> getProductsByBrand(String brand) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getBrand().equalsIgnoreCase(brand)) {
                result.add(p);
            }
        }
        return result;
    }

    public void sortByNameAsc(){
        Collections.sort(products,(a,b)->a.getName().compareToIgnoreCase(b.getName()));
    }
    public void sortByNameDsc(){
        Collections.sort(products,(a,b)->b.getName().compareToIgnoreCase(a.getName()));
    }
    public void sortByPriceAsc(){
        Collections.sort(products,(a,b)->Double.compare(a.getPrice(),b.getPrice()));

    }
    public void sortByPriceDsc(){
        Collections.sort(products,(a,b)->Double.compare(b.getPrice(),a.getPrice()));
    }
    public void sortByRatingAsc(){
        Collections.sort(products,(a,b)->Integer.compare(a.getRating(),b.getRating()));
    }
    public void sortByRatingDsc(){
        Collections.sort(products,(a,b)->Integer.compare(b.getRating(),a.getRating()));
    }
    public void sortByDiscountAsc(){
        Collections.sort(products,(a,b)->Double.compare(a.getDiscount(),b.getDiscount()));
    }
    public void sortByDiscountDsc(){
        Collections.sort(products,(a,b)->Double.compare(b.getDiscount(),a.getDiscount()));
    }

    public List<Product> filterByCategory(String category){
        List<Product> result=new ArrayList<>();
        for(Product p:products){
            if(p.getCategory().equalsIgnoreCase(category)){
                result.add(p);
            }
        }
        return result;
    }
    public List<Product> filterByName(String name){
        List<Product> result=new ArrayList<>();
        for(Product p: products){
            if(p.getName().equalsIgnoreCase(name)){
                result.add(p);
            }
        }
        return result;
    }
    public List<Product> filterByPriceRange(double minPrice, double maxPrice){
        List<Product> result=new ArrayList<>();
        for(Product p:products){
            if(p.getPrice()>=minPrice && p.getPrice()<=maxPrice){
                result.add(p);
            }
        }
        return result;
    }

    public List<Product> filterByBrand(String brand){
        List<Product> result=new ArrayList<>();
        for(Product p:products){
            if(p.getCategory().equalsIgnoreCase(brand)){
                result.add(p);
            }
        }
        return result;

    }
    public List<Product> filterByNameUsingStream(String name){
        return products.stream().filter(p->p.getName().equalsIgnoreCase(name)).toList();
    }
    public Product getByIdUsingStream(int id){
        return products.stream().filter(p->p.getPid()==id).findFirst().orElse(null);
    }




}
