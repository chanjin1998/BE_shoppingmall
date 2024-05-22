package com.example.shoppingmall.Member;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@Component
@Transactional
public class MemberRepository {
    private Map<String, Member> memberTable
            = new HashMap<>();

    @Autowired
    DataSource dataSource;

    @Autowired
    EntityManager entityManager;

    public void makeConnection() {
        DataSourceUtils.getConnection(dataSource);
    }

    public void save(Member member) {
//        memberTable.put(member.getUserId(), member);
        entityManager.persist(member);

//        Member savedMember = entityManager.find(Member.class, member.getId());
//        System.out.println("saved Mem: "+savedMember);

//        Member savedMember = memberTable.get(member.getUserId());ㅛ
//        return savedMember.getUserId();
    }

    public Member findByUserId(String userId) {
        String jpql = "SELECT m.id FROM Member m WHERE m.userId = :userId";
        return entityManager.createQuery(jpql, Member.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }

    public Member findById(String userId) {
        String jpql = "SELECT m FROM Member m WHERE m.userId = :userId";
        return entityManager.createQuery(jpql, Member.class)
                .setParameter("userId", userId)
                .getSingleResult();
    }
}