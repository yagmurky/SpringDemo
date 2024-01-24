package com.yagmur.repository;

import com.yagmur.entity.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByProductName(String productName);
    Optional<Product> findByProductNameIgnoreCase(String productName);
    List<Product> findAllByProductCategory(String productCategory);
    List<Product> findAllByProductPriceBetween(Double minPrice, Double maxPrice);
    List<Product> findByProductNameContainingIgnoreCase(String keyword);


    //Belirli bir fiyata eşit ve bu fiyatın üstündeki ürünleri listeleyiniz.
    List<Product> findByProductPriceGreaterThanEqual(Double minPrice);
    List<Product> findByProductPriceLessThanEqual(Double maxPrice);
    List<Product> findByProductUnitInStockGreaterThanEqual(Integer minStock);
    List<Product> findByProductPriceGreaterThan(Double minPrice);
    List<Product> findByProductPriceGreaterThanEqualAndProductPriceLessThanEqual(Double minPrice, Double maxPrice);


    //Bir kategoriye ait kaç adet ürün olduğunu listeleyiniz.
    Integer countByProductCategory(String category);

    //Bir üründen kaç tane olduğunu listeleyiniz.
    Integer countByProductName(String productName);

    //Girilen kategorinin varlığını kontrol ediniz.
    boolean existsByProductCategory(String category);

    //Kategorisi 'null' olan ürünleri listeleyiniz.
    List<Product> findByProductCategoryIsNull();

    //Baş harfi girilen kategoriye ait ürünleri listeleyiniz.
    List<Product> findByProductCategoryStartingWith(String categoryPrefix);













}
