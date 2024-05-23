package com.example.shoppingmall.Product;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@Transactional
public class ProductRepository {

    private final ProductJPARepository productJPARepository;

    @Autowired
    public ProductRepository(ProductJPARepository productJPARepository) {
        this.productJPARepository = productJPARepository;
    }

    //등록하기
    public void save(Product product) {
        productJPARepository.save(product);
    }
    //조회하기
    public Optional<Product> findById(int id) {
        return productJPARepository.findById(id);
    }


//    public List<Product> findByCategoryId(Integer categoryId, Pageable pageable) {
//    }

//    public List<Product> findProducts(int limit, int currentPage) {
//        //MAP -> Stream -> List
//        // limit 4이고 currentPage가 1일때 0~3 (currentPage - 1) * limit = 첫번쨰 index
////        return productTable.values().stream().toList();
//        return productJPARepository.findProducts(limit,currentPage);
//    }
//    public List<Product> findProducts(int limit, int currentPage, int categoryId) {
////        List<Product> resultProducts = new ArrayList<>();
////        for (Product product : product_table.values()){
////            if (product.getCategoryId() == categoryId)
////                resultProducts.add(product);
////        }
//        int startIdx = (currentPage - 1) * limit;
//        int endIdx = Math.min(startIdx + limit, productTable.size());
//        List<Product> productList = productTable.values().stream()
//                .filter(product -> product.getCategoryId() == categoryId) // 해당 카테고리의 제품만 필터링
//                .skip(startIdx)
//                .limit(endIdx - startIdx)
//                .toList();
//        return productList;
//    }
//
//    public Product deleteProduct(int id) {
//        productTable.remove(id);
//        return productTable.get(id);
//    }
//
//    public void deleteProducts(List<Integer> productIds) {
//        for (int i = 0; i < productIds.size(); i++){
//            productTable.remove(productIds.get(i));
//        }
//    }
}
