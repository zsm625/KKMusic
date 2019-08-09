package cn.com.zx221.javaweb.vo;

import java.sql.Timestamp;

import cn.com.zx221.javaweb.po.SlsongListPO;

public class SlsongListVO extends SlsongListPO {
	private SlsongListPO slsongListPO;
	private SongVo songVo;

	public SongVo getSongVo() {
		return songVo;
	}

	public void setSongVo(SongVo songVo) {
		this.songVo = songVo;
	}

	public SlsongListPO getSlsongListPO() {
		return slsongListPO;
	}

	public void setSlsongListPO(SlsongListPO slsongListPO) {
		this.slsongListPO = slsongListPO;
	}

	public SlsongListVO(SlsongListPO slsongListPO) {
		this.slsongListPO = slsongListPO;
	}

	@Override
	public int getSlsongId() {
		return slsongListPO.getSlsongId();
	}

	@Override
	public int getSonglistId() {
		return slsongListPO.getSonglistId();
	}

	@Override
	public int getSongId() {
		return slsongListPO.getSongId();
	}

	@Override
	public Timestamp getCollectionDate() {
		return slsongListPO.getCollectionDate();
	}

}
