package cn.com.zx221.javaweb.vo;

import java.sql.Timestamp;

import cn.com.zx221.javaweb.po.CdPo;
import cn.com.zx221.javaweb.po.SingerPo;
import cn.com.zx221.javaweb.po.SongPO;

/**
 * 页面歌曲列表的VO 歌曲名、歌手、时长、专辑名、mv地址
 * 
 * @author ZSM
 *
 * @time 2019年8月5日下午4:54:39
 */
public class SongVo extends SongPO {
	private SongPO po;

	private CdPo cdPo;
	private SingerPo singerpo;
	private String cd_name;

	public SingerPo getSingerpo() {
		return singerpo;
	}

	public void setSingerpo(SingerPo singerpo) {
		this.singerpo = singerpo;
	}

	public String getCd_name() {
		return cd_name;
	}

	public void setCd_name(String cd_name) {
		this.cd_name = cd_name;
	}

	@Override
	public int getSongPlayCount() {
		return super.getSongPlayCount();
	}

	@Override
	public Timestamp getSongPublishDate() {
		return super.getSongPublishDate();
	}

	@Override
	public int getSongTypeId() {
		return super.getSongTypeId();
	}

	public void setSingerPo(SingerPo singerpo) {
		this.singerpo = singerpo;
	}

	public SingerPo getSingerPo() {
		return singerpo;
	}

	public SongVo(SongPO po) {
		this.po = po;
	}

	@Override
	public String getSongPicUrl() {
		return po.getSongPicUrl();
	}

	@Override
	public int getSongId() {
		return po.getSongId();
	}

	@Override
	public String getSongName() {
		return po.getSongName();
	}

	@Override
	public int getSongSinger() {
		return po.getSongSinger();
	}

	@Override
	public int getMvId() {
		return po.getMvId();
	}

	@Override
	public int getCdId() {
		return po.getCdId();
	}

	@Override
	public int getSongDownLoadCount() {
		return po.getSongDownLoadCount();
	}

	@Override
	public int getSongCollectionCount() {
		return po.getSongCollectionCount();
	}

	@Override
	public String getSongUrl() {
		return po.getSongUrl();
	}

	@Override
	public String getCyricUrl() {
		return po.getCyricUrl();
	}

	@Override
	public String getSongTime() {
		return po.getSongTime();
	}

	public CdPo getCdPo() {
		return cdPo;
	}

	public void setCdPo(CdPo cdPo) {
		this.cdPo = cdPo;
	}
}
