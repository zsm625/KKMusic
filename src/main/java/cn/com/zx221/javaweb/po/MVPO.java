package cn.com.zx221.javaweb.po;

import java.sql.Timestamp;

/**
 * @author hj
 * @time 2019年8月1日下午4:13:08 state：
 */
public class MVPO {
	private int mvId;
	private String mvName;
	private String mvArea;
	private String mvType;
	private int mvPlayCount;
	private String mvIntroduce;
	private Timestamp mvIssue;// 发行时间
	private String mvSingerName;
	public int getMvId() {
		return mvId;
	}
	public void setMvId(int mvId) {
		this.mvId = mvId;
	}
	public String getMvName() {
		return mvName;
	}
	public void setMvName(String mvName) {
		this.mvName = mvName;
	}
	public String getMvArea() {
		return mvArea;
	}
	public void setMvArea(String mvArea) {
		this.mvArea = mvArea;
	}
	public String getMvType() {
		return mvType;
	}
	public void setMvType(String mvType) {
		this.mvType = mvType;
	}
	public int getMvPlayCount() {
		return mvPlayCount;
	}
	public void setMvPlayCount(int mvPlayCount) {
		this.mvPlayCount = mvPlayCount;
	}
	public String getMvIntroduce() {
		return mvIntroduce;
	}
	public void setMvIntroduce(String mvIntroduce) {
		this.mvIntroduce = mvIntroduce;
	}
	public Timestamp getMvIssue() {
		return mvIssue;
	}
	public void setMvIssue(Timestamp mvIssue) {
		this.mvIssue = mvIssue;
	}
	public String getMvSingerName() {
		return mvSingerName;
	}
	public void setMvSingerName(String mvSingerName) {
		this.mvSingerName = mvSingerName;
	}
	
	
}
