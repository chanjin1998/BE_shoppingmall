package com.example.shoppingmall.Product;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shoppingmall.utils.Validator;

import java.util.List;
import java.util.Map;

//@Slf4j
@RestController
@AllArgsConstructor
public class ProductController {

    //    @Autowired // DI
    ProductService productService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    // 상품 개별 등록
    @PostMapping("/products")
    public ResponseEntity registerProduct(@RequestBody Product product) {
        // * 유효성 검사 : name(영어), price(숫자)
        // Validator 통해서 유효성 검사
        if (Validator.isAlpha(product.getName()) && Validator.isNumber(product.getPrice())) {

            System.out.println("/products : controller - " + product.getName());
            Product savedProduct = productService.registerProduct(product);

            try {
                System.out.println("res" + savedProduct.getName());
            } catch (NullPointerException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(HttpStatus.CREATED);

        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // 상품 전체, 카테고리별 조회
    // 상품 전체조회
    @GetMapping("/products")
    public ResponseEntity<List<Product>> findProducts(@RequestParam ("limit") int limit, @RequestParam("currentPage") int currentPage, @RequestParam(value="categoryId",required=false) Integer categoryId) {

        log.info("limit = {}", limit);
        log.info("currentPage = {}", currentPage);
        log.info("categoryId = {}", categoryId);

        List<Product> products;

        if (categoryId == null){
            products = productService.findProducts(limit, currentPage);
        }
        products = productService.findProducts(limit, currentPage);
        return new ResponseEntity<>(products,HttpStatus.OK);

    }

    // 상품 개별 조회
    // 상품 찾는 방법

    // 상품 한개 삭제
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable(value="id") int id){
        if (!Validator.isNumber(id))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        productService.deleteProduct(id);
        Product product = productService.findProduct(id);

        if (product == null)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
//     상품 여러개 삭제
    @PostMapping("/products/delete")
    public ResponseEntity<Product> deleteProducts(@RequestBody Map<String, List<Integer>> deleteRequest){
        List<Integer> productIds = deleteRequest.get("productIds");
        if (productIds.isEmpty()) {
            log.info("productsIds가 없어");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        productService.deleteProducts(productIds);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // intellij 메서드 단축키
    // alt + shift + enter

    // 1인 과제
    // 1. Product 반환 필드 : id가 없다.
    // 2. id 숫자만 들어온 거 맞는지 유효성 검사 추가

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable(value = "id") int id) {
        Product resultProduct = productService.findProduct(id);
        if (resultProduct == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(resultProduct,HttpStatus.OK);
    }
}