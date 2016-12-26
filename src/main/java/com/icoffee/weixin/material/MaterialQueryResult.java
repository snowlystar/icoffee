/**
 * 
 */
package com.icoffee.weixin.material;

/**
 * @author lixiaojing
 *
 */
public class MaterialQueryResult<T extends MaterialItem> {
	private int total_count, item_count;
	T item[];
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	public int getItem_count() {
		return item_count;
	}
	public void setItem_count(int item_count) {
		this.item_count = item_count;
	}
	public T[] getItem() {
		return item;
	}
	public void setItem(T[] item) {
		this.item = item;
	}
}
