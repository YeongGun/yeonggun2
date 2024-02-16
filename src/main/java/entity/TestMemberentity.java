package com.example.jpatest.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestMemberentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    @Column
    private String tel;

        public static TestMemberEntity toEntity(MemberDto memberDto){
            return TestMemberEntity.builder()
                    .email(memberDto.getEmail())
                    .name(memberDto.getName())
                    .tel(memberDto.gettTel())
                    .password(memberDto.getPassword())
                    .id(memberDto.getId())
                    .build();
        }


}
