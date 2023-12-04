package com.test.store.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.store.domain.Store;
import com.test.store.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("store")
public class StoreController {
	private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
	@Autowired
	private StoreService storeService;

	@GetMapping("reduce")
	@SentinelResource("store-resource")
	public ResponseEntity<String> reduce(int goodsId) {
		Store store = storeService.getById(goodsId);
		store.setNum(store.getNum() - 1);
		storeService.updateById(store);
		logger.info("reduce {}", goodsId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("add")
	@SentinelResource("store-resource")
	public ResponseEntity<String> add(int goodsId) {
		Store store = storeService.getById(goodsId);
		store.setNum(store.getNum() + 1);
		storeService.updateById(store);
		logger.info("add {}", goodsId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("list")
	@SentinelResource("store-resource")
	public ResponseEntity<List<Store>> list(String goodsId) {
		QueryWrapper<Store> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("goodId", goodsId);
		return ResponseEntity.ok(storeService.list(queryWrapper));
	}
}
