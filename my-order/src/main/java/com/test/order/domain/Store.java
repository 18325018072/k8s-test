package com.test.order.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @TableName store
 */
@Data
public class Store implements Serializable {
	/**
	 * 商品编号
	 */
	private Integer goodid;

	/**
	 * 库存数量
	 */
	private Integer num;

	private static final long serialVersionUID = 1L;

}