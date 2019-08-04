package cn.com.zx221.javaweb.dao;

import java.sql.Timestamp;
import java.util.List;

import cn.com.zx221.javaweb.po.CdPo;

/**
 * 专辑数据库操作
 * @author ZSM
 *
 * @time 2019年8月2日下午12:03:13
 */
public interface ICdDAO {
	//根据id查询具体的某一个专辑
	public CdPo findCDById(int cdId);
	
	//根据地区查询
	public List<CdPo> findCD(Timestamp startTime,Timestamp endTime,String area,String singerName);
	
	//根据歌手类型查找
	public List<CdPo> findCDBySingerType(Timestamp startTime,Timestamp endTime,String singerType);
	
	//根据专辑名找专辑
	public List<CdPo> findCDByName(String cdName);
	
}
