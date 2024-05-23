package com.example.shoppingmall.Member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userId;
    private String pw;
    private String name;
    private String email;
    private String contact;

    public Member(String userId, String pw, String name, String email, String contact) {
    this.userId = userId;
    this.pw = pw;
    this.name = name;
    this.email = email;
    this.contact = contact;
    }
//    static public Member fromDtoToEntity(MemberDTO memberDto) {
//        return new Member(memberDto.getUserId(), memberDto.getPw(), memberDto.getName(), memberDto.getEmail(), memberDto.getContact());
//    }

    @Override
    public String toString() {
        return "Member{" +
                "userId='" + userId + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
