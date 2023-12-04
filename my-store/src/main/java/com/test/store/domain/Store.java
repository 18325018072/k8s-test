package com.test.store.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName store
 */
@TableName(value = "store")
@Data
public class Store implements Serializable {
	/**
	 * 商品编号
	 */
	@TableId
	private Integer goodid;

	/**
	 * 库存数量
	 */
	private Integer num;

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (that == null) {
			return false;
		}
		if (getClass() != that.getClass()) {
			return false;
		}
		Store other = (Store) that;
		return (this.getGoodid() == null ? other.getGoodid() == null : this.getGoodid().equals(other.getGoodid()))
				&& (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getGoodid() == null) ? 0 : getGoodid().hashCode());
		result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append(" [");
		sb.append("Hash = ").append(hashCode());
		sb.append(", goodid=").append(goodid);
		sb.append(", num=").append(num);
		sb.append(", serialVersionUID=").append(serialVersionUID);
		sb.append("]");
		return sb.toString();
	}
}