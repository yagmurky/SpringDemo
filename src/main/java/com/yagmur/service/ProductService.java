package com.yagmur.service;

import com.yagmur.entity.Product;
import com.yagmur.repository.ProductRepository;
import com.yagmur.utility.IService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService implements IService<Product, Long> {

    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(Product.builder()
                        .productName(product.getProductName())
                        .productUnitInStock(product.getProductUnitInStock())
                        .productPrice(product.getProductPrice())
                        .productCategory(product.getProductCategory())
                        .productDescription(product.getProductDescription())
                .build());
    }

    @Override
    public Product update(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public Iterable<Product> saveAll(Iterable<Product> entities) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void delete(Product entity) {
        productRepository.delete(entity);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Optional<Product> findProductByName(String productName){
        return productRepository.findByProductName(productName);
    }

    public List<Product> findAllByProductPriceBetween(Double minPrice, Double maxPrice){
        return productRepository.findAllByProductPriceBetween(minPrice,maxPrice);
    }
    public List<Product> findAllByProductCategory(String productCategory){
        return productRepository.findAllByProductCategory(productCategory);
    }
    public List<Product> findByProductNameContainingIgnoreCase(String productName){
        return productRepository.findByProductNameContainingIgnoreCase(productName);
    }

    public Optional<Product> findByProductNameIgnoreCase(String productName){
        return productRepository.findByProductNameIgnoreCase(productName);
    }


    public List<Product> findByProductPriceGreaterThanEqual(Double minPrice){
        return productRepository.findByProductPriceGreaterThanEqual(minPrice);
    }

    public List<Product> findByProductPriceLessThanEqual(Double maxPrice){
        return productRepository.findByProductPriceLessThanEqual(maxPrice);
    }
    public List<Product> findByProductUnitInStockGreaterThanEqual(Integer minStock){
        return productRepository.findByProductUnitInStockGreaterThanEqual(minStock);
    }

    public List<Product> findByProductPriceGreaterThan(Double minPrice){
        return productRepository.findByProductPriceGreaterThan(minPrice);
    }
    public List<Product> findByProductPriceGreaterThanEqualAndProductPriceLessThanEqual(Double minPrice, Double maxPrice){
        return productRepository.findByProductPriceGreaterThanEqualAndProductPriceLessThanEqual(minPrice,maxPrice);
    }

    //Bir kategoriye ait kaç adet ürün olduğunu listeleyiniz.
    public Integer countByProductCategory(String category){
        return productRepository.countByProductCategory(category);
    }

    //Bir üründen kaç tane olduğunu listeleyiniz.
    public Integer countByProductName(String productName){
        return productRepository.countByProductName(productName);
    }

    //Girilen kategorinin varlığını kontrol ediniz.
    public boolean existsByProductCategory(String category){
        return productRepository.existsByProductCategory(category);
    }

    //Kategorisi 'null' olan ürünleri listeleyiniz.
    public List<Product> findByProductCategoryIsNull(){
        return productRepository.findByProductCategoryIsNull();
    }

    //Baş harfi girilen kategoriye ait ürünleri listeleyiniz.
    public List<Product> findByProductCategoryStartingWith(String categoryPrefix){
        return productRepository.findByProductCategoryStartingWith(categoryPrefix);
    }




}
