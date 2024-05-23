package com.example.shoppingmall.Member;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberService {

    MemberRepository memberRepository;
    @Transactional
    public String join(Member member) {
        // 회원 정보를 저장
        memberRepository.save(member);

        // 저장된 회원의 ID를 반환
        // Optional 처리를 통해 더 안정적인 코드로 변경
        return memberRepository.findByUserId(member.getUserId())
                .map(Member::getUserId)
                .orElseThrow(() -> new IllegalStateException("회원 가입 후 ID를 찾을 수 없습니다."));
    }

    public boolean checkDuplicateId(String userId) {
        // findByUserId의 결과는 Optional이므로, isPresent를 사용하여 존재 여부를 확인
        return memberRepository.findByUserId(userId).isPresent();
    }
//    public boolean checkDuplicateId(String userId) {
//        Member existMember
//            = memberRepository.findByUserId(userId);
//
//        if (existMember == null)
//            return false;
//        else
//            return true;
//    }


//    public void makeConnection() {
//        memberRepository.makeConnection();
//    }

//    public boolean login(String userId, String pw) {
//        return true;
//    }
}
