package com.app.tinderproyects.controller;

import com.app.tinderproyects.dtos.member.MemberDto;
import com.app.tinderproyects.dtos.member.MemberResponseDto;
import com.app.tinderproyects.dtos.member.MemberResponseListAddMember;
import com.app.tinderproyects.service.member.MembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {

    private final MembersService membersService;

    @GetMapping
    public ResponseEntity<List<MemberResponseDto>> allMembers(){
        return ResponseEntity.ok(membersService.allMembers());
    }

    @GetMapping("{id}")
    public ResponseEntity<MemberResponseDto> findMemberById(@PathVariable Long id){
        return ResponseEntity.of(membersService.findProjectMemberById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<MemberResponseListAddMember> saveMember(@RequestBody MemberDto memberDto){
        return ResponseEntity.ok(membersService.saveMember(memberDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<MemberResponseDto> updateMember(@PathVariable Long id, @RequestBody MemberDto memberDto){
        return ResponseEntity.ok(membersService.updateMember(id, memberDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteMember(@PathVariable Long id){
        return ResponseEntity.ok(membersService.deleteMemberById(id));
    }

}
