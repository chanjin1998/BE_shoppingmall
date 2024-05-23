//package com.example.shoppingmall.Member;
//
//import jakarta.persistence.EntityManager;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.datasource.DataSourceUtils;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
//@Repository
//@Transactional
//public class MemberRepository {
//    private Map<String, Member> memberTable
//            = new HashMap<>();
//
//    @Autowired
//    DataSource dataSource;
//
//    @Autowired
//    EntityManager entityManager;
//
//    public void makeConnection() {
//        DataSourceUtils.getConnection(dataSource);
//    }
//
//    public void save(Member member) {
////        memberTable.put(member.getUserId(), member);
//        entityManager.persist(member);
//
////        Member savedMember = entityManager.find(Member.class, member.getId());
////        System.out.println("saved Mem: "+savedMember);
//
////        Member savedMember = memberTable.get(member.getUserId());ㅛ
////        return savedMember.getUserId();
//    }
//
////    public Member findByUserId(String userId) {
////        String jpql = "SELECT m.id FROM Member m WHERE m.userId = :userId";
////        return entityManager.createQuery(jpql, Member.class)
////                .setParameter("userId", userId)
////                .getSingleResult();
////    }
//    public Optional<Member> findByUserId(String userId) {
//        String jpql = "SELECT m FROM Member m WHERE m.userId = :userId";
//        return  entityManager.createQuery(jpql, Member.class)
//                .setParameter("userId", userId)
//                .getResultList().stream().findAny();
//    }
//
//    public Member findById(String userId) {
//        String jpql = "SELECT m FROM Member m WHERE m.userId = :userId";
//        return entityManager.createQuery(jpql, Member.class)
//                .setParameter("userId", userId)
//                .getSingleResult();
//    }
//}

package com.example.shoppingmall.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

import java.util.Optional;

@Repository
@Transactional
public class MemberRepository {

    private final MemberJPARepository memberJPARepository;

    @Autowired
    public MemberRepository(MemberJPARepository memberJPARepository) {
        this.memberJPARepository = memberJPARepository;
    }

    public void save(Member member) {
        memberJPARepository.save(member);
    }

    public Optional<Member> findByUserId(String userId) {
        return memberJPARepository.findByUserId(userId);
    }

    // findById 메소드는 더 이상 필요하지 않습니다.
    // MemberJPARepository에서 제공하는 기본 메소드 findById를 사용하면 됩니다.
    // 예: memberJPARepository.findById(id);
}
