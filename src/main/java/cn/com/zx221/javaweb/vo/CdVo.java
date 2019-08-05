package cn.com.zx221.javaweb.vo;

import java.sql.Timestamp;
import java.util.List;

import cn.com.zx221.javaweb.po.CdPo;

/**
 * 页面显示的专辑实体
 * @author ZSM
 *
 * @time 2019年8月2日下午10:39:15
 */
public class CdVo extends CdPo{
	
	private CdPo po;
	private List<String> songName;
	private List<String> songUrl;
	private String singerName;
	private List<String> songTime;
	private String mvUrl;
	private String cdPublisher;
	public String getCdPublisher() {
		return cdPublisher;
	}
	public void setCdPublisher(String cdPublisher) {
		this.cdPublisher = cdPublisher;
	}
	public CdVo(CdPo po) {
		this.po = po;
	}
	
	public String getSingerName() {
		return singerName;
	}
	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}
	
	public List<String> getSongName() {
		return songName;
	}
	public void setSongName(List<String> songName) {
		this.songName = songName;
	}
	public List<String> getSongUrl() {
		return songUrl;
	}
	public void setSongUrl(List<String> songUrl) {
		this.songUrl = songUrl;
	}
	public List<String> getSongTime() {
		return songTime;
	}
	public void setSongTime(List<String> songTime) {
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
