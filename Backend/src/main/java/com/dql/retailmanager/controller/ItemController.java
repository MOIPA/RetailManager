package com.dql.retailmanager.controller;

import com.dql.retailmanager.entity.Item;
import com.dql.retailmanager.entity.form.SearchForm;
import com.dql.retailmanager.entity.page.PageRequest;
import com.dql.retailmanager.service.IItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/item")
@CrossOrigin
public class ItemController {
    @Resource
    IItemService itemService;

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
