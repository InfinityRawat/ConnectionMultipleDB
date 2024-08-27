package com.MultipleDB.practice1;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.MultipleDB.practice1.Entity.Order;
import com.MultipleDB.practice1.ProductEntity.Product;
import com.MultipleDB.practice1.ProductRepository.ProductRepo;
import com.MultipleDB.practice1.Repo.OrderRepo;

@SpringBootApplication
public class MultipleDbApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDbApplication.class, args);
	}

	@Autowired
	ProductRepo repo;
	
	@Autowired
	OrderRepo objectRepo;
	
	
	
	@Override
	public void run(String... arg) throws Exception {
		
		Product p = Product.builder().name("Shampoo").price(1345.34).build();
		Order order = new Order();
		order.setId(1);
		order.setDate(LocalDate.now());
		order.setProductName(p.getName());
		order.setQuant(12);
		Product save = repo.save(p);
		Order save2 = objectRepo.save(order);
		System.out.println(save);
		System.out.println(save2);
			
	}
}
