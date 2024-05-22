package com.example.shoppingmall.Member;

import com.example.shoppingmall.utils.ApiUtils;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.example.shoppingmall.utils.ApiUtils.error;
import static com.example.shoppingmall.utils.ApiUtils.success;

@Slf4j
@AllArgsConstructor
@RestController
public class MemberController {

    MemberService memberService;

    @GetMapping("/data")
    public void makeConnection(){
        memberService.makeConnection();
    }

    //    @PostMapping("/join/res/en") // Before
//    public ResponseEntity<String> joinByResponseEntity(@RequestBody Member member) {
//        log.info(member.toString());
//
//        if(isDuplicateId(member))
//            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
//
//        String userId = memberService.join(member);
//        return new ResponseEntity<>(userId, HttpStatus.OK);
//    }

    @PostMapping("/join") // After
    public ApiUtils.ApiResult join(@Valid @RequestBody MemberDTO memberDto) {
//        log.info(member.toString());

        if(isDuplicateId(memberDto))
            return error("아이디 중복", HttpStatus.CONFLICT);

        Member requestMember = memberDto.convertToEntity();
        String userId = memberService.join(requestMember);
        return success(userId);
        /**
         * {
         * 	“success” : True,
         * 	“response” : 응답 데이터(객체),
         * 	“error” : null
         * }
         */
    }
    @PostMapping("login")
    public void login(@RequestBody LoginDTO loginDTO){
        boolean loginResult = memberService.login(loginDTO.getUserId(), loginDTO.getPw());

//        if (loginResult) {
//            // 로그인 성공 시 홈 페이지로 리디렉션
//            System.out.println("로그인 성공");;
//        } else {
//            // 로그인 실패 시 에러 메시지와 함께 로그인 페이지로 리디렉션
//            redirectAttributes.addFlashAttribute("error", "Invalid username or password");
//            System.out.println("로그인 실패");;
//        }
    }

    // 유효성 검사하다가 에러가 터지면 호출되는 예외 처리 메소드
    // MethodArgumentNotValidException 예외 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiUtils.ApiResult handleValidationExceptions(MethodArgumentNotValidException errors) {
        Map<String, String> errorMessages = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()){
            String errorField = error.getField(); //예외 필드
            String errorMessage = error.getDefaultMessage(); // 예외 메세지
            errorMessages.put(errorField,errorMessage);
        }
        return error(errorMessages, HttpStatus.BAD_REQUEST);
    }

    private boolean isDuplicateId(MemberDTO memberDto) {
        return memberService.checkDuplicateId(memberDto.getUserId());
    }
}
