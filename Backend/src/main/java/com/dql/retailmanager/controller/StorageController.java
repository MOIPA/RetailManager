package com.dql.retailmanager.controller;

import com.dql.retailmanager.entity.Item;
import com.dql.retailmanager.entity.ItemAndStorageInfo;
import com.dql.retailmanager.entity.ItemStorage;
import com.dql.retailmanager.entity.Storage;
import com.dql.retailmanager.entity.form.SearchForm;
import com.dql.retailmanager.entity.page.PageRequest;
import com.dql.retailmanager.service.IStorageService;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/storage")
@CrossOrigin
public class StorageController {
    @Resource
    IStorageService storageService;

    @GetMapping("/getStorageById")
    public Storage getStorageById(@RequestParam int id) {
        return storageService.selectByPrimaryId(id);
    }

    @GetMapping("/deleteStorageById")
    public int deleteStorageById(@RequestParam int id) {
        return storageService.deleteById(id);
    }

    @GetMapping("/deleteStorageByIds")
    public int deleteStorageByIds(@RequestParam int[] ids) {
        for (int id : ids) {
            storageService.deleteById(id);
        }
        return ids.length;
    }

    @PostMapping("/addStorage")
    public int addStorage(@RequestBody Storage storage) {
        return storageService.addStorage(storage);
    }

    @PostMapping("/updateStorageById")
    public int updateStorage(@RequestBody Storage storage) {
        return storageService.updateById(storage);
    }

    @PostMapping("/listStorageByPage")
    public Object listStorageByPage(@RequestBody SearchForm pageRequest) {
        return storageService.listStorageByPage(pageRequest);
    }

    @PostMapping("/putItemInStorage")
    public String putItemInStorage(@RequestBody List<ItemStorage> record) {
        // clear all
        if (record.size() > 0) {
            storageService.deleteAllItem(record.get(0).getStorageId());
        }
        try {
            record.forEach(x -> {
                x.setUpdateTime(new Date());
                storageService.putItemInStorage(x);
            });
        } catch (Exception e) {
            return "failed";
        }
        return "success";
    }

    @GetMapping("/getItemFromStorage")
    public List<ItemAndStorageInfo> getItemFromStorage(@RequestParam int storageId) {
        return storageService.getItemFromStorage(storageId);
    }

    @PostMapping("/getItemFromStorageByPage")
    public Object getItemFromStorageByPage(@RequestBody SearchForm pageRequest) {
        return storageService.getItemFromStorageByPage(pageRequest);
    }

    @GetMapping("/deleteItemFromStorage")
    public int deleteItemFromStorage(@RequestParam int[] itemIds, @RequestParam int storageId) {
        storageService.deleteItemFromStorage(itemIds, storageId);
        return 1;
    }
}
