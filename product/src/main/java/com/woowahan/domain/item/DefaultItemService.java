package com.woowahan.domain.item;

import exception.Exceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by chogh on 9/24/16.
 */
public class DefaultItemService implements ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public DefaultItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Item get(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            return item.get();
        }

        throw Exceptions.NOT_FOUND_EXCEPTION;
    }

    @Override
    @Transactional
    public Item create(String name) {
        Item item = new Item();
        item.setName(name);
        return item;
    }
}
