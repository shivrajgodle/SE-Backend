package com.SE.service;

import com.SE.dto.ItemDto;
import com.SE.dto.PageableResponse;
import com.SE.dto.PagebleResponse;
public interface ItemService {
     ItemDto saveItem(ItemDto item);
     void deleteItem(Long id);
     ItemDto updateItem(Long id, ItemDto item);
     ItemDto get(Long id);

    //get all
    PageableResponse<ItemDto> getAll(int pageNumber, int pageSize, String sortBy, String sortDir);

}
