package cn.com.zx221.javaweb.vo;

import cn.com.zx221.javaweb.po.SongListPO;
import cn.com.zx221.javaweb.po.UserPO;

public class SongListVO extends SongListPO {
	private SongListPO songlistpo;
	// 扩展的属性
	private UserPO userPO;

	public void setUserPO(UserPO userPO) {
		this.userPO = userPO;
	}

	public UserPO getUserPO() {
		return userPO;
	}

	public SongListVO(SongListPO songlistpo) {
		this.songlistpo = songlistpo;
	}

	@Override
	public String getSonglistPicUrl() {
		// TODO Auto-generated method stub
		return songlistpo.getSonglistPicUrl();
	}

	@Override
	public int getSonglistId() {
		// TODO Auto-generated method stub
		return songlistpo.getSonglistId();
	}

	@Override
	public int getSonglistUserId() {
		// TODO Auto-generated method stub
		return songlistpo.getSonglistUserId();
	}

	@Override
	public String getSonglistName() {
		// TODO Auto-generated method stub
		return songlistpo.getSonglistName();
	}

	@Override
	public int getSonglistTypeId() {
		// TODO Auto-generated method stub
		return songlistpo.getSonglistTypeId();
	}

	@Override
	public int getSonglistAccessCount() {
		// TODO Auto-generated method stub
		return songlistpo.getSonglistAccessCount();
	}

	@Override
	public String getSonglistIntroduce() {
		// TODO Auto-generated method stub
		return songlistpo.getSonglistIntroduce();
	}

	@Override
	public int getSonglistCollection() {
		// TODO Auto-generated method stub
		return songlistpo.getSonglistCollection();
	}

	@Override
	public String getSonglistTags() {
		// TODO Auto-generated method stub
		return songlistpo.getSonglistTags();
	}

}
