package com.dql.retailmanager.service;

import com.dql.retailmanager.Utils.PageUtils;
import com.dql.retailmanager.dao.mapper.MemberDao;
import com.dql.retailmanager.entity.Member;
import com.dql.retailmanager.entity.form.SearchMemberForm;
import com.dql.retailmanager.entity.form.UpdateMemberForm;
import com.dql.retailmanager.entity.page.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

 Object listMemberByPage(SearchMemberForm pageRequest);

 /**
  * 调用分页插件完成分页
  *
  * @param pageRequest
  * @return
  */
 PageInfo<Member> getPageInfo(SearchMemberForm pageRequest);

 int updateMemberPass(UpdateMemberForm memberForm);
}
