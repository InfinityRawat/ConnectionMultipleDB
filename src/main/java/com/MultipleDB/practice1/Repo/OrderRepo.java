package com.MultipleDB.practice1.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MultipleDB.practice1.Entity.Order;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
