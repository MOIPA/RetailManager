package com.dql.retailmanager.service.impl;

import com.dql.retailmanager.Utils.PageUtils;
import com.dql.retailmanager.Utils.Uuid;
import com.dql.retailmanager.dao.mapper.ItemDao;
import com.dql.retailmanager.dao.mapper.ItemPicDao;
import com.dql.retailmanager.entity.Item;
import com.dql.retailmanager.entity.ItemPic;
import com.dql.retailmanager.entity.form.SearchForm;
import com.dql.retailmanager.service.IItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@Service
public class ItemService implements IItemService {
    @Resource
    ItemDao dao;

    @Resource
    ItemPicDao itemPicDao;

    @Override
    public int deleteById(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int addItem(Item record) {
        List<Item> list = dao.getItemByName(record.getName());
        if (list.size() > 0) return -2;
        record.setItemCode(Uuid.generateUUID());
        return dao.insert(record);
    }

    @Override
    public int insertSelective(Item record) {
        return dao.insertSelective(record);
    }

    @Override
    public Item getItemById(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Item record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateById(Item record) {
        return dao.updateByPrimaryKey(record);
    }

    @Override
    public Object listItemByPage(SearchForm pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    @Override
    public int itemImgUpload(MultipartFile file) throws IOException {
        ItemPic itemPic = new ItemPic(file.getBytes());
        if (file != null) {
            itemPicDao.insert(itemPic);
            return itemPic.getId();
        }
        return -1;
    }

    @Override
    public ItemPic getItemPicById(String picId) {
        ItemPic itemPic = itemPicDao.selectByPrimaryKey(Integer.parseInt(picId));
        return itemPic;
    }

    @Override
    public int[] getItemPics(String[] ids) {
        int[] res = new int[ids.length];
        for (int i = 0; i < ids.length; i++) {
            res[i] = this.dao.getItemPicById(Integer.parseInt(ids[i]));
        }
        return res;
    }

    public PageInfo<Item> getPageInfo(SearchForm pageRequest) {
        int pageNum = pageRequest.getPage();
        int pageSize = pageRequest.getLimit();
        PageHelper.startPage(pageNum, pageSize);
        List<Item> itemList = dao.selectPage(pageRequest);
        return new PageInfo<Item>(itemList);
    }

}
