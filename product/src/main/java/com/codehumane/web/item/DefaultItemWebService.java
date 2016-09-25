package com.codehumane.web.item;

import com.codehumane.domain.item.Item;
import com.codehumane.domain.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public List<ItemModel> list(Pageable pageable) {
        Page<Item> page = itemRepository.findAll(pageable);
        Stream<ItemModel> stream = page.getContent().stream().map(ItemModel::new);
        return stream.collect(Collectors.toList());
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
