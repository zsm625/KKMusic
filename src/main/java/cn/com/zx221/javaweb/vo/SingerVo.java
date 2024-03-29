package cn.com.zx221.javaweb.vo;

import java.sql.Timestamp;
import java.util.List;

import cn.com.zx221.javaweb.po.SingerPo;

public class SingerVo extends SingerPo {
	private SingerPo singerPo;
	//扩展属性
	private int countCD;
	private int countSong;
	private int countMV;
	private List<SongVo> songList;
	private String cdName;
	private List<CdVo> cdList;
	private List<MVVO> mvList;
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
	public int getCountSong() {
		return countSong;
	}
	public void setCountSong(int countSong) {
		this.countSong = countSong;
	}
	
	public int getCountMV() {
		return countMV;
	}
	public void setCountMV(int countMV) {
		this.countMV = countMV;
	}
	public List<SongVo> getSongList() {
		return songList;
	}
	public void setSongList(List<SongVo> songList) {
		this.songList = songList;
	}
	public List<CdVo> getCdList() {
		return cdList;
	}
	public void setCdList(List<CdVo> cdList) {
		this.cdList = cdList;
	}
	public List<MVVO> getMvList() {
		return mvList;
	}
	public void setMvList(List<MVVO> mvList) {
		this.mvList = mvList;
	}
	
}
