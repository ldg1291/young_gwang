package com.example.demo.member.service;

import com.example.demo.member.exception.MemberException;
import com.example.demo.member.model.Member;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class MemberService {

    private Map<Integer, Member> members = new HashMap<>();

    public Member getMember(Integer id) {
        return members.get(id);
    }

    public Map<Integer, Member> getAllMember() {
        return members;
    }

    public Member addMember(Member member) {
        Optional.ofNullable(members.get(member.getId())).ifPresentOrElse(m -> {
            throw new MemberException("있어 시발아.");
        }, () -> {
            members.put(member.getId(), member);
        });

        return members.get(member.getId());
    }

    public void deleteMember(Integer id) {
        Optional.ofNullable(members.get(id)).ifPresentOrElse(m -> {
            members.remove(id);
        }, () -> {
            throw new MemberException("없어 시발아.");
        });
    }

    public Member updateMember(Member member) {
        Optional.ofNullable(members.get(member.getId())).ifPresentOrElse(m -> {
            members.remove(member.getId());
            members.put(member.getId(), member);
        }, () -> {
            throw new MemberException("없어 시발아.");
        });

        return members.get(member.getId());
    }
}
