package com.SE.service.impl;

import com.SE.dto.ItemDto;
import com.SE.dto.PageableResponse;
import com.SE.dto.PagebleResponse;
import com.SE.exceptions.ResourseNotFoundException;
import com.SE.helper.Helper;
import com.SE.modal.Item;
import com.SE.repository.ItemRepository;
import com.SE.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ItemDto saveItem(ItemDto itemDto) {
       Item item = mapper.map(itemDto, Item.class);
       Item saveItem = itemRepository.save(item);
       return mapper.map(saveItem,ItemDto.class);
    }

    @Override
    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("Item not found of given id: " + id));
        itemRepository.delete(item);
    }

    @Override
    public ItemDto updateItem(Long id, ItemDto itemDto) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Item not found of given id: " + id));
        item.setItemName(itemDto.getItemName());
        item.setPrice(itemDto.getPrice());
        item.setQuantity(itemDto.getQuantity());
        item.setStockAvailable(itemDto.isStockAvailable());
        Item newItem = itemRepository.save(item);
        return mapper.map(newItem,ItemDto.class);
    }

    @Override
    public ItemDto get(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("Item not found of given id: " + id));
        return mapper.map(item,ItemDto.class);
    }

    @Override
    public PageableResponse<ItemDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort = (sortDir.equalsIgnoreCase("desc")) ? (Sort.by(sortBy).descending()) : (Sort.by(sortBy).ascending());
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Item> page = itemRepository.findAll(pageable);
        return Helper.getPageableResponse(page, ItemDto.class);
    }




}
