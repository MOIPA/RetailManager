package com.dql.retailmanager.service;

import com.dql.retailmanager.entity.Item;
import com.dql.retailmanager.entity.ItemPic;
import com.dql.retailmanager.entity.form.SearchForm;
import com.dql.retailmanager.entity.page.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface IItemService {
    int deleteById(Integer id);

    int addItem(Item record);

    int insertSelective(Item record);

    Item getItemById(Integer id);

    int updateByPrimaryKeySelective(Item record);

    int updateById(Item record);

    Object listItemByPage(SearchForm pageRequest);

    int itemImgUpload(MultipartFile file) throws IOException;

    ItemPic getItemPicById(String picId);
}
