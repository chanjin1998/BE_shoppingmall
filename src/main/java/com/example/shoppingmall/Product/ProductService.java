package com.example.shoppingmall.Product;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
// @Component or @Service , 얘는 Service 야 명시의 목적이 가장 크다, 특별한 기능 없음.
public class ProductService {

    ProductRepository productRepository;
    @Transactional
    public int registerProduct(Product product) {
        productRepository.save(product);
        System.out.println("Product Service" + " " + product.getName());
        return productRepository.findById(product.getId())
                .map(Product::getId)
                .orElseThrow(() -> new IllegalStateException("상품명이 없습니다."));

    }

//    public Product findProduct(int id) {
//        return productRepository.findByProductId(id);
//    }

//    public List<Product> findProductsByCategoryId(Integer categoryId, int limit, int currentPage) {
//        Pageable pageable = PageRequest.of(currentPage - 1, limit);
//        // 카테고리별 상품 조회
//        return productRepository.findByCategoryId(categoryId, pageable);
//    }

//    public List<Product> findProducts(int limit, int currentPage) {
////        Pageable pageable = PageRequest.of(currentPage - 1, limit);
//        // 전체 상품 조회
//        return productRepository.findProducts(limit,currentPage);
//    }
//
//    public List<Product> findProducts(int limit, int currentPage, int categoryId) {
//        return productRepository.findProducts(limit,currentPage,categoryId);
//    }
//
//    public Product deleteProduct(int id) {
//        return productRepository.deleteProduct(id);
//    }
//
//    public void deleteProducts(List<Integer> productIds) {
//        productRepository.deleteProducts(productIds);
//    }
}
