package com.example.deliverySpring.Repository;

import com.example.deliverySpring.Entidades.ItemMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMenuRepository extends JpaRepository<ItemMenu, Integer> {
}
