package com.example.studybackend.controller;

import com.example.studybackend.domain.Member;
import com.example.studybackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // 프론트엔드 CORS 허용
public class MemberController {

    private final MemberRepository memberRepository;

    // 1. 전체 조회 (GET)
    @GetMapping
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    // 2. 멤버 저장 (POST) - role 추가 지원
    @PostMapping
    public Member createMember(@RequestBody Member member) {
        if (member.getRole() == null || member.getRole().isBlank()) {
            member.setRole("FE 개발자"); // role이 없는 경우 기본값
        }
        return memberRepository.save(member);
    }

    // 3. 멤버 삭제 (DELETE)
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberRepository.deleteById(id);
    }
}