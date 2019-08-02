package cn.com.zx221.javaweb.po;

import java.sql.Timestamp;

public class UcollectCdPO {
	private int uCdId;

	public int getuCdId() {
		return uCdId;
	}

	public void setuCdId(int uCdId) {
		this.uCdId = uCdId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCdId() {
		return cdId;
	}

	public void setCdId(int cdId) {
		this.cdId = cdId;
	}

	public Timestamp getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(Timestamp collectionDate) {
		this.collectionDate = collectionDate;
	}

	private int userId;
	private int cdId;
	private Timestamp collectionDate;

}
