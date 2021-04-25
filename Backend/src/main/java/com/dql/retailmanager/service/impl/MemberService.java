package com.dql.retailmanager.service.impl;

import com.dql.retailmanager.Utils.PageUtils;
import com.dql.retailmanager.dao.mapper.MemberDao;
import com.dql.retailmanager.entity.Member;
import com.dql.retailmanager.entity.form.SearchForm;
import com.dql.retailmanager.entity.form.UpdateMemberForm;
import com.dql.retailmanager.service.IMemberService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberService implements IMemberService {
    @Resource
    MemberDao memberDao;

    /**
     * @param id
     * @return
     */
    @Override
    public Member findMemberById(int id) {
        return memberDao.selectByPrimaryKey(id);
    }

    /**
     * @param member
     * @return
     */
    @Override
    public int createMember(Member member) {
        return memberDao.insert(member);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public int deleteMemberById(int id) {
        return memberDao.deleteByPrimaryKey(id);
    }

    /**
     * @param member
     * @return
     */
    @Override
    public int updateMember(Member member) {
        return memberDao.updateByPrimaryKey(member);
    }


    @Override
    public Object listMemberByPage(SearchForm pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     *
     * @param pageRequest
     * @return
     */
    @Override
    public PageInfo<Member> getPageInfo(SearchForm pageRequest) {
        int pageNum = pageRequest.getPage();
        int pageSize = pageRequest.getLimit();
        PageHelper.startPage(pageNum, pageSize);
        List<Member> memberList = memberDao.selectPage(pageRequest);
        return new PageInfo<Member>(memberList);
    }

    @Override
    public int updateMemberPass(UpdateMemberForm memberForm) {
        Member m = memberDao.selectByName(memberForm.getName(), memberForm.getOldpass());
        if (m == null) return -2;
        m.setPwd(memberForm.getNewpass());
        return memberDao.updateByPrimaryKey(m);
    }
}
