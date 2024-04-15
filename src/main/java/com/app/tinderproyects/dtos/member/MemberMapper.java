package com.app.tinderproyects.dtos.member;

import com.app.tinderproyects.entity.Member;

public class MemberMapper {
    public static Member memberDtoToMember(MemberDto memberDto){
        Member member = new Member();
        member.setUser(memberDto.getUser());
        member.setProject(memberDto.getProject());
        return member;
    }

    public static MemberResponseDto memberToMemberResponseDto(Member member){
        MemberResponseDto memberResponseDto = new MemberResponseDto();
        memberResponseDto.setUser(member.getUser());
        memberResponseDto.setProject(member.getProject());
        return memberResponseDto;
    }

}
