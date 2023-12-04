package com.test.order.task;

import com.test.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SellTask {
	@Autowired
	OrderService orderService;

	final int goodsId = 1;

	@Scheduled(fixedRate = 30000)
	public void reduce() {
		orderService.add(goodsId);
	}
}