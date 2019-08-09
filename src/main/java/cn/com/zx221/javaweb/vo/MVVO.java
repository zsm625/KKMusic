package cn.com.zx221.javaweb.vo;

import java.sql.Timestamp;

import cn.com.zx221.javaweb.po.MVPO;

/**
 * 
 * @author hj
 * @time 2019年8月2日 下午5:42:26
 */
public class MVVO extends MVPO{
    private MVPO mvPO;
    public MVVO() {
    	super();
    }
    public MVVO(MVPO mvPO) {
    	this.mvPO = mvPO;
    }
	@Override
	public int getMvId() {
		return mvPO.getMvId();
	}
	@Override
	public String getMvName() {
		return mvPO.getMvName();
	}
	@Override
	public String getMvArea() {
		return mvPO.getMvArea();
	}
	@Override
	public String getMvType() {
		return mvPO.getMvType();
	}
	@Override
	public int getMvPlayCount() {
		return mvPO.getMvPlayCount();
	}
	@Override
	public String getMvIntroduce() {
		return mvPO.getMvIntroduce();
	}
	@Override
	public Timestamp getMvIssue() {
		return mvPO.getMvIssue();
	}
	@Override
	public String getMvSingerName() {
		return mvPO.getMvSingerName();
	}
	@Override
	public String getMvUrl() {
		return mvPO.getMvUrl();
	}
	
}
