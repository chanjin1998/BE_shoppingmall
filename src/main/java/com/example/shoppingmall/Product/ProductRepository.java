package com.example.shoppingmall.Product;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    Map<Integer, Product> productTable = new HashMap<>();
    int id = 0;
    //등록하기
    public Product save(Product product) {
        // id 값이 1로 픽스가 되어있음 => 증가 시키기 위해
        product.setId(id++);
        productTable.put(product.getId(),product);
        System.out.println("Product Repository" + " " + productTable.get(id-1));
        return productTable.get(id-1);
    }

    //조회하기
    public Product findProduct(int id) {
        return productTable.get(id);
    }


//    public List<Product> findByCategoryId(Integer categoryId, Pageable pageable) {
//    }

    public List<Product> findProducts(int limit, int currentPage) {
        //MAP -> Stream -> List
        // limit 4이고 currentPage가 1일때 0~3 (currentPage - 1) * limit = 첫번쨰 index
        return productTable.values().stream().toList();
    }
    public List<Product> findProducts(int limit, int currentPage, int categoryId) {
//        List<Product> resultProducts = new ArrayList<>();
//        for (Product product : product_table.values()){
//            if (product.getCategoryId() == categoryId)
//                resultProducts.add(product);
//        }
        int startIdx = (currentPage - 1) * limit;
        int endIdx = Math.min(startIdx + limit, productTable.size());
        List<Product> productList = productTable.values().stream()
                .filter(product -> product.getCategoryId() == categoryId) // 해당 카테고리의 제품만 필터링
                .skip(startIdx)
                .limit(endIdx - startIdx)
                .toList();
        return productList;
    }

    public Product deleteProduct(int id) {
        productTable.remove(id);
        return productTable.get(id);
    }

    public void deleteProducts(List<Integer> productIds) {
        for (int i = 0; i < productIds.size(); i++){
            productTable.remove(productIds.get(i));
        }
    }
}
