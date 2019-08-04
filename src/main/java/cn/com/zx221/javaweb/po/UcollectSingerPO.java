package cn.com.zx221.javaweb.po;

import java.sql.Timestamp;

public class UcollectSingerPO {
	private int uSingerId;
	private int userId;
	private int singerId;
	private Timestamp collectionDate;

	public int getuSingerId() {
		return uSingerId;
	}

	public void setuSingerId(int uSingerId) {
		this.uSingerId = uSingerId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSingerId() {
		return singerId;
	}

	public void setSingerId(int singerId) {
		this.singerId = singerId;
	}

	public Timestamp getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(Timestamp collectionDate) {
		this.collectionDate = collectionDate;
	}

}
