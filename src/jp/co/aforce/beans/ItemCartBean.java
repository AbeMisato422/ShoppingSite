package jp.co.aforce.beans;

public class ItemCartBean implements java.io.Serializable{

	private int count;
	private ItemBean itemBean;

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ItemBean getItemBean() {
		return itemBean;
	}
	public void setItemBean(ItemBean itemBean) {
		this.itemBean = itemBean;
	}


}
