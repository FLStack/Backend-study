package com.example.studybackend.controller;

import com.example.studybackend.domain.Member;
import com.example.studybackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:5173", "https://frontend-nu-coral-33.vercel.app"}, allowCredentials = "true")
public class MemberController {

    private final MemberRepository memberRepository;

    @Transactional
    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    @GetMapping
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Transactional // DB 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}