package cn.com.zx221.javaweb.vo;

import java.sql.Timestamp;

import cn.com.zx221.javaweb.po.SingerPo;

public class SingerVo extends SingerPo {
	private SingerPo singerPo;
	//扩展属性
	private int countCD;
	public SingerVo(SingerPo singerPo) {
		this.singerPo = singerPo;
	}
	@Override
	public int getSinger_id() {
		// TODO Auto-generated method stub
		return singerPo.getSinger_id();
	}
	@Override
	public String getSinger_name() {
		// TODO Auto-generated method stub
		return singerPo.getSinger_name();
	}
	@Override
	public int getSinger_accessCount() {
		// TODO Auto-generated method stub
		return singerPo.getSinger_accessCount();
	}
	@Override
	public int getSinger_collection() {
		// TODO Auto-generated method stub
		return singerPo.getSinger_collection();
	}
	@Override
	public String getSinger_areaId() {
		// TODO Auto-generated method stub
		return singerPo.getSinger_areaId();
	}
	@Override
	public String getSinger_introduce() {
		// TODO Auto-generated method stub
		return singerPo.getSinger_introduce();
	}
	@Override
	public Timestamp getSinger_birthday() {
		// TODO Auto-generated method stub
		return singerPo.getSinger_birthday();
	}
	@Override
	public String getSinger_photoUrl() {
		// TODO Auto-generated method stub
		return singerPo.getSinger_photoUrl();
	}
	@Override
	public String getSinger_sex() {
		// TODO Auto-generated method stub
		return singerPo.getSinger_sex();
	}
	@Override
	public String getSinger_initial() {
		// TODO Auto-generated method stub
		return singerPo.getSinger_initial();
	}
	@Override
	public String getSinger_type() {
		// TODO Auto-generated method stub
		return singerPo.getSinger_type();
	}
	public int getCountCD() {
		return countCD;
	}
	public void setCountCD(int countCD) {
		this.countCD = countCD;
	}
	
}
