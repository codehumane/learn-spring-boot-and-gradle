package com.woowahan.web.item;

import com.woowahan.domain.item.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;

/**
 * Created by chogh on 9/24/16.
 */
@Slf4j
@RestController
@RequestMapping(value = "/products")
public class ItemController {

    public static final String PAGE_SORT_CREATED_AT = "createdAt";
    private ItemWebService itemWebService;

    @PostConstruct
    public void createSampleData() {
        itemWebService.createSample();
    }

    @Autowired
    public ItemController(ItemWebService itemWebService) {
        this.itemWebService = itemWebService;
    }

    @GetMapping(value = "/items")
    public List<ItemWebService.ItemModel> items(
            @PageableDefault(sort = PAGE_SORT_CREATED_AT, direction = DESC) Pageable pageable) {
        return itemWebService.list(pageable);
    }
}