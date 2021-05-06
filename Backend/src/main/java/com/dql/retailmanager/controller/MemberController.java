package com.dql.retailmanager.controller;

import com.dql.retailmanager.dao.mapper.SessionDao;
import com.dql.retailmanager.entity.Member;
import com.dql.retailmanager.entity.User;
import com.dql.retailmanager.entity.form.SearchForm;
import com.dql.retailmanager.entity.form.UpdateMemberForm;
import com.dql.retailmanager.service.IMemberService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/member")
@CrossOrigin
public class MemberController {
    @Resource
    IMemberService memberService;
    @Resource
    SessionDao sessionDao;


    @GetMapping("/memberLogin")
    public Member getUserById(@RequestParam String name, @RequestParam String pwd, @RequestParam String sessionToken) {
        Member member = memberService.findMemberByName(name);
        if (member != null && member.getPwd().equals(pwd.trim())) {
            // 存储用户session
//            sessionDao.deleteSessionByUserId(member.getId());
//            sessionDao.insertSession(member.getId(), sessionToken);
            return member;
        }
        return null;
    }


    @GetMapping("/getMemberById")
    public Member getMemberById(@RequestParam int id) {
        return memberService.findMemberById(id);
    }

    @GetMapping("/deleteMemberById")
    public int deleteMemberById(@RequestParam int id) {
        return memberService.deleteMemberById(id);
    }

    @GetMapping("/deleteMemberByIds")
    public int deleteMemberByIds(@RequestParam int[] ids) {
        for (int id : ids) {
            memberService.deleteMemberById(id);
        }
        return ids.length;
    }

    @PostMapping("/addMember")
    public int addMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @PostMapping("/updateMmeber")
    public int updateMember(@RequestBody Member member) {
        return memberService.updateMember(member);
    }

    @PostMapping("/listMemberByPage")
    public Object listMemberByPage(@RequestBody SearchForm pageRequest) {
        return memberService.listMemberByPage(pageRequest);
    }

    @PostMapping("/updateMemberPass")
    public int updateMemberPass(@RequestBody UpdateMemberForm memberForm) {
        return memberService.updateMemberPass(memberForm);
    }
}
