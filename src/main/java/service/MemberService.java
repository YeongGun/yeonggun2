package com.example.jpatest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    com.example.jpatest.repository.TestMemberRepository;

    public void memberInsert(MemberDto memberDto){


        TestMemberEntit testMemberEntit = TestMemberEntity.toEntity(memberDto) ;

        testMemberRepository.save( testMemberEnetity );
    }

    // 로그인 처리 메서드
    public MemberDto memberLogin(MemberDto memberDto){
        TestMemberEntity testMemberEntity = testMemberRepository.findByEmailAndPassword(
                memberDto.getEmail(), memberDto.getPassword());
        if(testMemberEntity != null) {
            return MemberDto. toDto(testMemberEntity);
        }
        return null; //이메일과 패스워드가 틀리다면
    }
}



