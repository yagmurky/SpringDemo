package com.yagmur.controller;

import com.yagmur.entity.Product;
import com.yagmur.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @RequestMapping("/save")
    public Product save(Product product){
        return productService.save(product);
    }

    @GetMapping("/find-all")
    public List<Product> findAll(){
        return productService.findAll();
    }

    @GetMapping("/find-by-id")
    public Optional<Product> findById(Long id){
        return productService.findById(id);
    }

    @GetMapping("/update")
    public Product update(Product product){
        return productService.update(product);
    }

    /**
     * # Ürün ismine göre ürünü bulunuz.
     * # Ürün isminin içerdiği harf veya kelimeye göre ürünü bulunuz.
     * # Belirli fiyat aralığındaki ürünleri listeleyiniz.
     *
     *
     *
     * Girilen fiyatın üstündeki ürünleri listeleyiniz.
     * Belirli bir stok adedinin üzerindeki ürünleri listeleyiniz.
     *
     * Belirli bir fiyata eşit ve bu fiyatın üstündeki ürünleri listeleyiniz.
     * Bir kategoriye ait kaç adet ürün olduğunu listeleyiniz.
     * Bir üründen kaç tane olduğunu listeleyiniz.
     * Girilen kategorinin varlığını kontrol ediniz. (true,false)
     * Kategorisi 'null' olan ürünleri listeleyiniz.
     * Baş harfi girilen kategoriye ait ürünleri listeleyiniz.
     */

    //localhost:8080/product/find-product-by-name?productName=Samsung
    @GetMapping("/find-product-by-name")
    public Optional<Product> findProductByproductName(String productName){
        return productService.findProductByName(productName);
    }

    //localhost:8080/product/find-product-by-price-between?minPrice=9000&maxPrice=15000
    @GetMapping("/find-product-by-price-between")
    public List<Product> findAllByProductPriceBetween(Double minPrice, Double maxPrice){
        return productService.findAllByProductPriceBetween(minPrice, maxPrice);
    }

    //localhost:8080/product/find-product-by-name-containing?productName=bu
    @GetMapping("/find-product-by-name-containing")
    public List<Product> findByProductNameContainingIgnoreCase (String productName){
        return productService.findByProductNameContainingIgnoreCase(productName);
    }

    //localhost:8080/product/find-product-by-name-ignore-case?productName=buzdolabı
    @GetMapping("/find-product-by-name-ignore-case")
    public Optional<Product> findByProductNameIgnoreCase (String productName){
        return productService.findByProductNameIgnoreCase(productName);
    }

    //localhost:8080/product/find-product-by-price-greater-than-equal?minPrice=9000
    @GetMapping("/find-product-by-price-greater-than-equal")
    public List<Product> findByProductPriceGreaterThanEqual(Double minPrice){
        return productService.findByProductPriceGreaterThanEqual(minPrice);
    }

    //localhost:8080/product/find-product-by-price-less-than-equal?maxPrice=15000
    @GetMapping("/find-product-by-price-less-than-equal")
    public List<Product> findByProductPriceLessThanEqual(Double maxPrice){
        return productService.findByProductPriceLessThanEqual(maxPrice);
    }
    ////


    //localhost:8080/product/find-product-by-unit-in-stock-greater-than-equal?minStock=5
    @GetMapping("/find-product-by-unit-in-stock-greater-than-equal")
    public List<Product> findByProductUnitInStockGreaterThanEqual(Integer minStock){
        return productService.findByProductUnitInStockGreaterThanEqual(minStock);
    }

    //localhost:8080/product/find-product-by-price-greater-than?minPrice=9000
    @GetMapping("/find-product-by-price-greater-than")
    public List<Product> findByProductPriceGreaterThan(Double minPrice){
        return productService.findByProductPriceGreaterThan(minPrice);
    }

    //localhost:8080/product/find-product-by-price-less-than-and-price-greater-than?minPrice=9000&maxPrice=15000
    @GetMapping("/find-product-by-price-less-than-and-price-greater-than")
    public List<Product> findByProductPriceGreaterThanEqualAndProductPriceLessThanEqual(Double minPrice, Double maxPrice){
        return productService.findByProductPriceGreaterThanEqualAndProductPriceLessThanEqual(minPrice, maxPrice);
    }


   @GetMapping("/count-product-by-category")
    //localhost:8080/product/count-product-by-category?category=Electronics
    //Bir kategoriye ait kaç adet ürün olduğunu listeleyiniz.
    public Integer countByProductCategory(String category){
        return productService.countByProductCategory(category);
    }

    @GetMapping("/count-product-by-product-name")
    //localhost:8080/product/count-product-by-product-name?productName=Samsung
    //Bir üründen kaç tane olduğunu listeleyiniz.
    public Integer countByProductName(String productName){
        return productService.countByProductName(productName);
    }

    @GetMapping("/exists-by-product-category")
    //localhost:8080/product/exists-by-product-category?category=Electronics
    //Girilen kategorinin varlığını kontrol ediniz.
    public boolean existsByProductCategory(String category){
        return productService.existsByProductCategory(category);
    }

    @GetMapping("/find-by-product-category-is-null")
    //localhost:8080/product/find-by-product-category-is-null
    //Kategorisi 'null' olan ürünleri listeleyiniz.
    public List<Product> findByProductCategoryIsNull(){
        return productService.findByProductCategoryIsNull();
    }

    @GetMapping("/find-by-product-category-starting-with")
    //localhost:8080/product/find-by-product-category-starting-with?categoryPrefix=Electronics
    //Baş harfi girilen kategoriye ait ürünleri listeleyiniz.
    public List<Product> findByProductCategoryStartingWith(String categoryPrefix){
        return productService.findByProductCategoryStartingWith(categoryPrefix);
    }




}
