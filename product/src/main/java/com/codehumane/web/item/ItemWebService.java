package com.codehumane.web.item;

import com.codehumane.domain.item.Item;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

/**
 * Created by chogh on 9/25/16.
 */
public interface ItemWebService {

    List<ItemModel> list(Pageable pageable);

    void createSample();

    @Getter
    @Setter
    public class ItemModel {

        private Long id;
        private String name;
        private Date createdAt;
        private Date updatedAt;

        public ItemModel(Item item) {
            this.id = item.getId();
            this.name = item.getName();
            this.createdAt = item.getCreatedAt();
            this.updatedAt = item.getUpdatedAt();
        }
    }

}
