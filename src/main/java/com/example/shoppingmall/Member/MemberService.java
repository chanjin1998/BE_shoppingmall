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
        memberRepository.save(member);

        return memberRepository.findByUserId(member.getUserId()).getUserId();
    }

    public boolean checkDuplicateId(String userId) {
        Member existMember
            = memberRepository.findByUserId(userId);

        if (existMember == null)
            return false;
        else
            return true;
    }

    public void makeConnection() {
        memberRepository.makeConnection();
    }

    public boolean login(String userId, String pw) {
        return true;
    }
}
