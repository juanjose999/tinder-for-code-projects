package com.app.tinderproyects.service.member;

import com.app.tinderproyects.dtos.manager.ManagerDto;
import com.app.tinderproyects.dtos.manager.ManagerMapper;
import com.app.tinderproyects.dtos.manager.ManagerResponseDto;
import com.app.tinderproyects.dtos.member.MemberDto;
import com.app.tinderproyects.dtos.member.MemberMapper;
import com.app.tinderproyects.dtos.member.MemberResponseDto;
import com.app.tinderproyects.dtos.member.MemberResponseListAddMember;
import com.app.tinderproyects.entity.Member;
import com.app.tinderproyects.repository.members.MembersRepository;
import com.app.tinderproyects.service.manager.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class MembersServiceImpl implements MembersService {

    private final MembersRepository membersRepository;

    @Override
    public List<MemberResponseDto> allMembers() {
        List<MemberResponseDto> memberList = new ArrayList<>();
        membersRepository.allMembers().forEach(member -> memberList.add(MemberMapper.memberToMemberResponseDto(member)));
        return memberList;
    }

    @Override
    public Optional<MemberResponseDto> findProjectMemberById(Long id) {
        Member member = membersRepository.findProjectMemberById(id).orElseThrow(() -> new RuntimeException("Erro in find menber by id: " + id));
        return Optional.of(MemberMapper.memberToMemberResponseDto(member));
    }

    @Override
    public MemberResponseListAddMember saveMember(MemberDto memberDto) {
        return MemberMapper.memberResponseListAddMember(membersRepository.saveMember(MemberMapper.memberDtoToMember(memberDto)));
    }

    @Override
    public MemberResponseDto updateMember(Long id, MemberDto memberDto) {
        return MemberMapper.memberToMemberResponseDto(membersRepository.updateMember(id, MemberMapper.memberDtoToMember(memberDto)));
    }

    @Override
    public Boolean deleteMemberById(Long id) {
        return membersRepository.deleteMemberById(id);
    }
}
