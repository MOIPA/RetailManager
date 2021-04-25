package com.dql.retailmanager.entity.form;

import lombok.Data;

@Data
public class UpdateMemberForm {
    private String name;
    private String oldpass;
    private String newpass;
}
