package com.example.JPARepositoryDemo.Controller;

import com.example.JPARepositoryDemo.Entity.Member;
import com.example.JPARepositoryDemo.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/register")
    public void newStudent(@RequestBody Member member){
        memberService.saveStudent(member);
    }

    @GetMapping("/printAll")
    public List<Member> getAllStudent(){
        return memberService.getAllStudent();
    }

    @GetMapping("/printStud")
    public Optional<Member> getStudentById(@RequestParam("id") Long id){
        return memberService.getStudentById(id);
    }

    @GetMapping("/printStudInfo")
    public Optional<Member> getStudentByName(@RequestParam("name") String name){
        return memberService.getStudentByName(name);
    }

    @GetMapping("printStudGrade")
    public List<Member> getStudentByAgeAndGrade(@RequestParam("age") int age, @RequestParam("grade") String grade){
        return memberService.getStudentByAgeAndGrade(age, grade);
    }

    @GetMapping("/printStudBetweenAge")
    public List<Member> getStudentByAgeBetween(@RequestParam("start") int start, @RequestParam("end") int end){
        return memberService.getStudentByAgeBetween(start, end);
    }

    @PostMapping("/removeStud")
    public List<Member> removeStudent(@RequestParam("id") long id){
        return memberService.removeStudent(id);
    }

    @PostMapping("/editGrade")
    public Optional<Member> editStudent(@RequestParam("id") long id, @RequestParam("grade") String grade) {
        memberService.editGrade(id, grade);
        return memberService.getStudentById(id);
    }

}
