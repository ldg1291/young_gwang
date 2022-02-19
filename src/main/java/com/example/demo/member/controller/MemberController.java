package com.example.demo.member.controller;

import com.example.demo.member.dto.MemberResponse;
import com.example.demo.member.model.Member;
import com.example.demo.member.service.MemberResponseBuildService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MemberController {

    private MemberResponseBuildService memberService;

    public MemberController(MemberResponseBuildService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public Map<Integer, Member> getAllMembers() {
        return  memberService.getAllMember();
    }

    @PostMapping("/members")
    public MemberResponse addMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    @GetMapping("/members/{id}")
    public MemberResponse getMember(@PathVariable Integer id) {
        return memberService.getMember(id);
    }

    @DeleteMapping("/members/{id}")
    public MemberResponse deleteMember(@PathVariable Integer id) {
        return memberService.deleteMember(id);
    }

    @PutMapping("/members")
    public MemberResponse updateMember(@RequestBody Member member) {
        return memberService.updateMember(member);
    }
}
