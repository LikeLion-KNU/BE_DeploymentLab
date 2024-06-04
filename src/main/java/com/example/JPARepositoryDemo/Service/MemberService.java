package com.example.JPARepositoryDemo.Service;

import com.example.JPARepositoryDemo.Entity.Member;
import com.example.JPARepositoryDemo.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.metal.MetalMenuBarUI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public Member saveStudent(Member member){
        return memberRepository.save(member);
    }

    public List<Member> getAllStudent(){
        return memberRepository.findAll();
    }

    public Optional<Member> getStudentById(Long id){
        return memberRepository.findById(id);
    }

    public Optional<Member> getStudentByName(String name){
        return memberRepository.findByName(name);
    }

    public List<Member> getStudentByAgeAndGrade(int age, String grade){
        return memberRepository.findByAgeAndGrade(age, grade);
    }

    public List<Member> getStudentByAgeBetween(int start, int end){
        return memberRepository.findByAgeBetween(start, end);
    }

    public List<Member> removeStudent(long id){
        memberRepository.deleteById(id);
        return memberRepository.findAll();
    }

    public void editGrade(long id, String grade){
        try{
            Member Student = memberRepository.findById(id).get();
            Student.setGrade(grade);
            memberRepository.save(Student);
        } catch (NoSuchElementException e) {
        }
    }
}
