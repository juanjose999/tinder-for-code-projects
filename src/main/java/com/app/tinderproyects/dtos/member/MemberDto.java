package com.app.tinderproyects.dtos.member;

import com.app.tinderproyects.entity.Project;
import com.app.tinderproyects.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    private Project project;

    private User user;
}
