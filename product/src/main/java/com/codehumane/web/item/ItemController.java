package com.codehumane.web.item;

import com.codehumane.web.PageModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.domain.Sort.Direction.DESC;

/**
 * Created by chogh on 9/24/16.
 */
@RestController
@RequestMapping(value = "/products")
public class ItemController {

    private static final String PAGE_SORT_CREATED_AT = "createdAt";
    private ItemWebService itemWebService;

    @Autowired
    public ItemController(ItemWebService itemWebService) {
        this.itemWebService = itemWebService;
    }

    @GetMapping(value = "/items")
    public PageModel<ItemWebService.ItemModel> items(
            @PageableDefault(sort = PAGE_SORT_CREATED_AT, direction = DESC) Pageable pageable) {
        return itemWebService.list(pageable);
    }
}
