package com.codehumane.web.item;

import java.util.function.Function;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.codehumane.domain.item.Item;
import com.codehumane.domain.item.ItemRepository;
import com.codehumane.web.PageModel;

/**
 * Created by chogh on 9/25/16.
 */
@Service
public class DefaultItemWebService implements ItemWebService {

    private ItemRepository itemRepository;

    @Autowired
    public DefaultItemWebService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public PageModel<ItemModel> list(Pageable pageable) {
        Page<Item> page = itemRepository.findAll(pageable);
        return new PageModel<ItemModel>(page, ItemModel::new);
    }

    @PostConstruct
    private void createSampleData() {
        Stream.of("a", "b", "c").forEach(this::createItem);
    }

    private void createItem(String name) {
        Item item = new Item();
        item.setName(name);
        itemRepository.save(item);
    }

}
