package com.test.order.feign;

import com.test.order.domain.Store;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("store")
public interface StoreClient {

	@GetMapping("add")
	ResponseEntity<String> add(@RequestParam("goodsId") int goodsId);

	@GetMapping("reduce")
	ResponseEntity<String> reduce(@RequestParam("goodsId") int goodsId);

	@GetMapping("list")
	ResponseEntity<List<Store>> list(@RequestParam("goodsId") String goodsId);
}