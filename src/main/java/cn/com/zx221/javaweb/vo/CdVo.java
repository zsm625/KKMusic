package cn.com.zx221.javaweb.vo;

import java.sql.Timestamp;

import cn.com.zx221.javaweb.po.CdPo;

/**
 * 页面显示的专辑实体
 * @author ZSM
 *
 * @time 2019年8月2日下午10:39:15
 */
public class CdVo extends CdPo{
	
	private CdPo po;
	private String songName;
	private String songUrl;
	private String singerName;
	private String songTime;
	private String mvUrl;
	public CdVo(CdPo po) {
		this.po = po;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getSongUrl() {
		return songUrl;
	}
	public void setSongUrl(String songUrl) {
		this.songUrl = songUrl;
	}
	public String getSingerName() {
		return singerName;
	}
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
	public String getSongTime() {
		return songTime;
	}
	public void setSongTime(String songTime) {
		this.songTime = songTime;
	}
	public String getMvUrl() {
		return mvUrl;
	}
	public void setMvUrl(String mvUrl) {
		this.mvUrl = mvUrl;
	}
	@Override
	public String getCd_company() {
		return po.getCd_company();
	}
	@Override
	public int getCd_id() {
		return po.getCd_id();
	}
	@Override
	public String getCd_name() {
		return po.getCd_name();
	}
	@Override
	public String getCd_coverUrl() {
		return po.getCd_coverUrl();
	}
	@Override
	public int getCd_songCount() {
		return po.getCd_songCount();
	}
	@Override
	public Timestamp getCd_publishDate() {
		return po.getCd_publishDate();
	}
	@Override
	public int getCd_singerId() {
		return po.getCd_singerId();
	}
	@Override
	public String getCd_introduce() {
		return po.getCd_introduce();
	}
	@Override
	public int getCd_collectionCount() {
		return po.getCd_collectionCount();
	}
	@Override
	public String getCd_synopsis() {
		return po.getCd_synopsis();
	}
	
}
