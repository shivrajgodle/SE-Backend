package com.SE.controller;

import com.SE.dto.ApiResponseMessage;
import com.SE.dto.ItemDto;
import com.SE.dto.PageableResponse;
import com.SE.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto){
        ItemDto createdItem = itemService.saveItem(itemDto);
        return new ResponseEntity<ItemDto>(createdItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable Long id , @RequestBody ItemDto itemDto){
        ItemDto updatedItem = itemService.updateItem(id , itemDto);
        return new ResponseEntity<ItemDto>(updatedItem, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseMessage> deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
        ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder().message("Deleted Successfully !").status(HttpStatus.OK).success(true).build();
        return new ResponseEntity<>(apiResponseMessage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getItem(@PathVariable Long id){
        ItemDto updatedItem = itemService.get(id);
        return new ResponseEntity<ItemDto>(updatedItem, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PageableResponse<ItemDto>> getAll(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "title", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ) {
        PageableResponse<ItemDto> pageableResponse = itemService.getAll(pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(pageableResponse, HttpStatus.OK);
    }

}
