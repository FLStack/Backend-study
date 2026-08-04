package com.example.studybackend.controller;

import com.example.studybackend.domain.Member;
import com.example.studybackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // 프론트엔드 통신 허용
public class MemberController {

    private final MemberRepository memberRepository;

    // 프론트에서 이름을 보내면 DB에 저장
    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    // DB에 저장된 모든 목록 조회
    @GetMapping
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }
}