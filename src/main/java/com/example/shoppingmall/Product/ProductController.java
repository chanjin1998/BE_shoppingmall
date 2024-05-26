package com.example.shoppingmall.Product;

import com.example.shoppingmall.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.shoppingmall.utils.Validator;

import java.util.List;
import java.util.Map;

import static com.example.shoppingmall.utils.ApiUtils.error;
import static com.example.shoppingmall.utils.ApiUtils.success;

//@Slf4j
@RestController
@AllArgsConstructor
public class ProductController {

    //    @Autowired // DI
    ProductService productService;
    private final Logger log = LoggerFactory.getLogger(getClass());

    // 상품 개별 등록
    @PostMapping("/products")
    public ApiUtils.ApiResult registerProduct(@Valid @RequestBody ProductDTO productDto) {
        // * 유효성 검사 : name(영어), price(숫자)
        // Validator 통해서 유효성 검사
        if (Validator.isNumber(productDto.getCategoryId()) && Validator.isAlpha(productDto.getName()) && Validator.isNumber(productDto.getPrice())) {

            System.out.println("/products : controller - " + productDto.getName());

            Product requestProduct = productDto.converToEntity();
            int id = productService.registerProduct(requestProduct);
//            Product savedProduct = productService.registerProduct(requestProduct);

            return success(id);

        } else
            return error("상품명과 가격이 잘못되었습니다.",HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable(value = "id") int id) {
        Product resultProduct = productService.findProduct(id);
        if (resultProduct == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(resultProduct,HttpStatus.OK);
    }
//    }
    // 상품 전체, 카테고리별 조회
    @GetMapping("/products")
    public ResponseEntity<List<Product>> findProducts(
            @RequestParam("limit") int limit,
            @RequestParam("currentPage") int currentPage,
            @RequestParam(value = "categoryId", required = false) Integer categoryId
    ) {
        log.info("limit = {}", limit);
        log.info("currentPage = {}", currentPage);
        log.info("categoryId = {}", categoryId);

        // TODO null 체크는 어디서 해야할까?
        if(categoryId == null) {
            List<Product> products = productService.findProducts();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            List<Product> products = productService.findProducts(categoryId);
            System.out.println(products.get(0));
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
    }

    // 상품 개별 조회
    // 상품 찾는 방법

    // 상품 한개 삭제
//    @DeleteMapping("/products/{id}")
//    public ResponseEntity<Product> deleteProduct(@PathVariable(value="id") int id){
//        if (!Validator.isNumber(id))
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//
//        productService.deleteProduct(id);
//        Product product = productService.findProduct(id);
//
//        if (product == null)
//            return new ResponseEntity<>(HttpStatus.OK);
//        else
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//     상품 여러개 삭제
//    @PostMapping("/products/delete")
//    public ResponseEntity<Product> deleteProducts(@RequestBody Map<String, List<Integer>> deleteRequest){
//        List<Integer> productIds = deleteRequest.get("productIds");
//        if (productIds.isEmpty()) {
//            log.info("productsIds가 없어");
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        productService.deleteProducts(productIds);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
    // intellij 메서드 단축키
    // alt + shift + enter

    // 1인 과제
    // 1. Product 반환 필드 : id가 없다.
    // 2. id 숫자만 들어온 거 맞는지 유효성 검사 추가
}