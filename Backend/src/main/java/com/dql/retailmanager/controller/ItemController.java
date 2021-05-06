package com.dql.retailmanager.controller;

import com.dql.retailmanager.dao.mapper.ItemPicDao;
import com.dql.retailmanager.entity.Item;
import com.dql.retailmanager.entity.ItemPic;
import com.dql.retailmanager.entity.form.SearchForm;
import com.dql.retailmanager.entity.page.PageRequest;
import com.dql.retailmanager.service.IItemService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping("/api/item")
@CrossOrigin
public class ItemController {
    @Resource
    IItemService itemService;

    @PostMapping("/itemImgUpload")
    public int itemImgUpload(@RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        return itemService.itemImgUpload(file);
    }

    @GetMapping("/itemShow")
    public void itemShow(HttpServletRequest req, HttpServletResponse resp, @RequestParam String picId) throws ServletException, IOException {
        ItemPic res = itemService.getItemPicById(picId);
        OutputStream outputStream = resp.getOutputStream();
        outputStream.write(res.getContent());
        outputStream.flush();
    }

    @GetMapping("/getItemPics")
    public int[] getItemPics(@RequestParam String ids) {
        return itemService.getItemPics(ids.split(","));
    }

    @GetMapping("/getItemById")
    public Item getItemById(@RequestParam int id) {
        return itemService.getItemById(id);
    }

    @GetMapping("/deleteItemById")
    public int deleteItemById(@RequestParam int id) {
        return itemService.deleteById(id);
    }

    @GetMapping("/deleteItemByIds")
    public int deleteItemByIds(@RequestParam int[] ids) {
        for (int id : ids) {
            itemService.deleteById(id);
        }
        return ids.length;
    }

    @PostMapping("/addItem")
    public int addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }

    @PostMapping("/updateItemById")
    public int updateItem(@RequestBody Item item) {
        return itemService.updateById(item);
    }

    @PostMapping("/listItemByPage")
    public Object listItemByPage(@RequestBody SearchForm pageRequest) {
        return itemService.listItemByPage(pageRequest);
    }

}
