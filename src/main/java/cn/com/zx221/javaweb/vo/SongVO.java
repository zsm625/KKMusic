package cn.com.zx221.javaweb.vo;

import java.sql.Timestamp;

import cn.com.zx221.javaweb.po.CdPo;
import cn.com.zx221.javaweb.po.SingerPo;
import cn.com.zx221.javaweb.po.SongPO;

public class SongVO extends SongPO {
	private SongPO songpo;
	// 扩展的属性
	private SingerPo singerpo;// 歌手po
	private CdPo cdpo;// 专辑po

	public SongVO(SongPO songpo) {
		this.songpo = songpo;
	}

	@Override
	public String getSongPicUrl() {
		// TODO Auto-generated method stub
		return songpo.getSongPicUrl();
	}

	@Override
	public int getSongId() {
		// TODO Auto-generated method stub
		return songpo.getSongId();
	}

	@Override
	public String getSongName() {
		// TODO Auto-generated method stub
		return songpo.getSongName();
	}

	@Override
	public int getSongSinger() {
		// TODO Auto-generated method stub
		return songpo.getSongSinger();
	}

	@Override
	public int getMvId() {
		// TODO Auto-generated method stub
		return songpo.getMvId();
	}

	@Override
	public int getCdId() {
		// TODO Auto-generated method stub
		return songpo.getCdId();
	}

	@Override
	public int getSongPlayCount() {
		// TODO Auto-generated method stub
		return songpo.getSongPlayCount();
	}

	@Override
	public int getSongDownLoadCount() {
		// TODO Auto-generated method stub
		return songpo.getSongDownLoadCount();
	}

	@Override
	public int getSongCollectionCount() {
		// TODO Auto-generated method stub
		return songpo.getSongCollectionCount();
	}

	@Override
	public Timestamp getSongPublishDate() {
		// TODO Auto-generated method stub
		return songpo.getSongPublishDate();
	}

	@Override
	public String getSongUrl() {
		// TODO Auto-generated method stub
		return songpo.getSongUrl();
	}

	@Override
	public String getCyricUrl() {
		// TODO Auto-generated method stub
		return songpo.getCyricUrl();
	}

	@Override
	public Timestamp getSongTime() {
		// TODO Auto-generated method stub
		return songpo.getSongTime();
	}

	@Override
	public int getSongTypeId() {
		// TODO Auto-generated method stub
		return songpo.getSongTypeId();
	}

}
