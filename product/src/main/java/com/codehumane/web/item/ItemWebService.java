package com.codehumane.web.item;

import com.codehumane.domain.item.Item;
import com.codehumane.web.PageModel;

import org.springframework.data.domain.Pageable;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 상품의 항목(Item)을 웹에서 다루기 위한 서비스<br/>
 * Created by chogh on 9/25/16.
 */
interface ItemWebService {

    PageModel<ItemModel> list(Pageable pageable);

    @Getter
    @Setter
    class ItemModel {

        private Long id;
        private String name;
        private Date createdAt;
        private Date updatedAt;

        ItemModel(Item item) {
            this.id = item.getId();
            this.name = item.getName();
            this.createdAt = item.getCreatedAt();
            this.updatedAt = item.getUpdatedAt();
        }
    }

}
