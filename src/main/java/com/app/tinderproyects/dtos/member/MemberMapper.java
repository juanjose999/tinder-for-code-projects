package com.app.tinderproyects.dtos.member;

import com.app.tinderproyects.entity.Member;
import com.app.tinderproyects.entity.User;
import org.apache.coyote.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberMapper {
    public static Member memberDtoToMember(MemberDto memberDto){
        Member member = new Member();
        member.setUser(memberDto.getUser());
        member.setProject(memberDto.getProject());
        return member;
    }

    public static MemberResponseDto memberToMemberResponseDto(Member member){
        MemberResponseDto memberResponseDto = new MemberResponseDto();
        memberResponseDto.setId_members(member.getId_members());
        memberResponseDto.setUser(member.getUser());
        memberResponseDto.setProject(member.getProject());
        return memberResponseDto;
    }

    public static MemberResponseListAddMember memberResponseListAddMember(Member member){
          MemberResponseListAddMember member1 = new MemberResponseListAddMember();
//        member1.setId_member(member.getId_members());
//        member1.setId_project(member.getProject().getId_project());
//        member1.setName_project(member.getProject().getName_project());
//        member1.setDescription_project(member.getProject().getDescription());
//        member1.setName_user(member.getUser().getUser_name());
//        member1.setEmail_user(member.getUser().getEmail());
//        return member1;
          member1.setResponse("Has sido agregado al grupo correctamente");
        return member1;
    }

}
