package com.example.demo.member.service;

import com.example.demo.member.dto.MemberResponse;
import com.example.demo.member.exception.MemberException;
import com.example.demo.member.model.Member;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberResponseBuildService {

    private MemberService memberService;

    public MemberResponseBuildService(MemberService memberService) {
        this.memberService= memberService;
    }


    public Map<Integer, Member> getAllMember() {
        return memberService.getAllMember();
    }

    public MemberResponse addMember(Member member) {

        try {
            Member addedMember = memberService.addMember(member);
            return MemberResponse.of(addedMember);
        } catch (MemberException e) {
            return MemberResponse.of(e.getMessage());
        }

    }

    public MemberResponse getMember(Integer id) {
        return MemberResponse.of(memberService.getMember(id));
    }

    public MemberResponse deleteMember(Integer id) {
        try {
            memberService.deleteMember(id);
            return MemberResponse.of("delete Succeeded");
        } catch (MemberException e) {
            return MemberResponse.of(e.getMessage());
        }
    }

    public MemberResponse updateMember(Member member) {
        try {
            Member updatedMember = memberService.updateMember(member);
            return MemberResponse.of(updatedMember);
        } catch (MemberException e) {
            return MemberResponse.of(e.getMessage());
        }
    }
}
