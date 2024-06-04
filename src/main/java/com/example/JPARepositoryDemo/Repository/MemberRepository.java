package com.example.JPARepositoryDemo.Repository;

import com.example.JPARepositoryDemo.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByName(String name);
    List<Member> findByAgeAndGrade(int age, String gender);
    List<Member> findByAgeBetween(int start, int end);
}