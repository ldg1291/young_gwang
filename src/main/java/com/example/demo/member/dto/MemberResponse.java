package com.example.demo.member.dto;

import com.example.demo.member.model.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class MemberResponse {

    private String message;
    private Member member;

    private MemberResponse (String message, Member member) {
        this.member = member;
        this.message = message;
    }

    public static MemberResponse of(Member member) {
        return new MemberResponse(null, member);
    }

    public static MemberResponse of(String message) {
        return new MemberResponse(message, null);
    }
}
