package com.dql.retailmanager.service;

import com.dql.retailmanager.Utils.PageUtils;
import com.dql.retailmanager.dao.mapper.MemberDao;
import com.dql.retailmanager.entity.Member;
import com.dql.retailmanager.entity.form.SearchMemberForm;
import com.dql.retailmanager.entity.page.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberService {
    @Resource
    MemberDao memberDao;

    /**
     * @param id
     * @return
     */
    public Member findMemberById(int id) {
        return memberDao.selectByPrimaryKey(id);
    }

    /**
     * @param member
     * @return
     */
    public int createMember(Member member) {
        return memberDao.insert(member);
    }

    /**
     * @param id
     * @return
     */
    public int deleteMemberById(int id) {
        return memberDao.deleteByPrimaryKey(id);
    }

    /**
     * @param member
     * @return
     */
    public int updateMember(Member member) {
        return memberDao.updateByPrimaryKey(member);
    }


    public Object listMemberByPage(SearchMemberForm pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     *
     * @param pageRequest
     * @return
     */
    private PageInfo<Member> getPageInfo(SearchMemberForm pageRequest) {
        int pageNum = pageRequest.getPage();
        int pageSize = pageRequest.getLimit();
        PageHelper.startPage(pageNum, pageSize);
        List<Member> memberList = memberDao.selectPage(pageRequest);
        return new PageInfo<Member>(memberList);
    }
}
