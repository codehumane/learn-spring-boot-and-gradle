package com.woowahan.domain.item;

/**
 * Created by chogh on 9/23/16.
 */
public interface ItemService {

    Item get(Long id);
    Item create(String name);

}
