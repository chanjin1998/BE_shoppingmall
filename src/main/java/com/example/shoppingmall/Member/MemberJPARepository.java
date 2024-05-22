package com.example.shoppingmall.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Optional;

public interface MemberJPARepository extends JpaRepository<Member,Integer> {
    Optional<Member> findByUserId(String userId){

    }
}