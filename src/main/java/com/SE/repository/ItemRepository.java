package com.SE.repository;

import com.SE.modal.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 public interface ItemRepository extends JpaRepository<Item, Long> {
}
