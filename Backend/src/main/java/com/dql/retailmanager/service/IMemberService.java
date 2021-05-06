package com.dql.retailmanager.service;

import com.dql.retailmanager.entity.Member;
import com.dql.retailmanager.entity.User;
import com.dql.retailmanager.entity.form.SearchForm;
import com.dql.retailmanager.entity.form.UpdateMemberForm;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public interface IMemberService {

 Member findMemberById(int id);

 /**
  * @param member
  * @return
  */
 int createMember(Member member);

 /**
  * @param id
  * @return
  */
 int deleteMemberById(int id);

 /**
  * @param member
  * @return
  */
 int updateMember(Member member);

 Object listMemberByPage(SearchForm pageRequest);

 /**
  * 调用分页插件完成分页
  *
  * @param pageRequest
  * @return
  */
 PageInfo<Member> getPageInfo(SearchForm pageRequest);

 int updateMemberPass(UpdateMemberForm memberForm);

 Member findMemberByName(String name);
}
