package com.test.order.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.test.order.domain.Store;
import com.test.order.feign.StoreClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
	private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

	@Autowired
	StoreClient storeClient;

	@SentinelResource("buy-resource")
	public ResponseEntity<String> reduce(int goodsId) {
		ResponseEntity<String> response = storeClient.reduce(goodsId);
		if (response.getStatusCode() == HttpStatus.OK) {
			logger.info("reduce ok {}", goodsId);
		} else {
			logger.error("reduce fail {}", goodsId);
		}
		return response;
	}

	@SentinelResource("buy-resource")
	public ResponseEntity<String> add(int goodsId) {
		ResponseEntity<String> response = storeClient.add(goodsId);
		if (response.getStatusCode() == HttpStatus.OK) {
			logger.info("add ok {}", goodsId);
		} else {
			logger.error("add fail {}", goodsId);
		}
		return response;
	}


	public List<Store> list(String goodsId) {
		return storeClient.list(goodsId).getBody();
	}
}
