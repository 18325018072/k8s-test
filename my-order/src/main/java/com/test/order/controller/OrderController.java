package com.test.order.controller;

import com.test.order.domain.Store;
import com.test.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@GetMapping("reduce")
	public ResponseEntity<String> reduce(int goodsId) {
		return orderService.reduce(goodsId);
	}

	@GetMapping("add")
	public ResponseEntity<String> add(int goodsId) {
		return orderService.add(goodsId);
	}

	@GetMapping("list")
	public CompletableFuture<List<Store>> list(String goodsId) {
		return CompletableFuture.supplyAsync(() -> orderService.list(goodsId));
	}
}
