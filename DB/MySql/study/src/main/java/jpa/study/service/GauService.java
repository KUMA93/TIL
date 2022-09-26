package jpa.study.service;


import jpa.study.entity.Item;
import jpa.study.entity.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GauService {

    private final ItemRepository itemRepository;

    public void logic() {
        Item item = new Item();
        item.setName("테스트");

        itemRepository.save(item);
    }
}
