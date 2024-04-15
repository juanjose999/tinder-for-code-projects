package com.app.tinderproyects.service.member;

import com.app.tinderproyects.dtos.member.MemberDto;
import com.app.tinderproyects.dtos.member.MemberResponseDto;
import com.app.tinderproyects.entity.Manager;
import com.app.tinderproyects.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MembersService {

    List<MemberResponseDto> allMembers();
    Optional<MemberResponseDto> findProjectMemberById(Long id);
    MemberResponseDto saveMember(MemberDto memberDto);
    MemberResponseDto updateMember(Long id, MemberDto memberDto);
    Boolean deleteMemberById(Long id);

}
