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
	//根据时间
//	public List<CdPo> findCDByDate(Timestamp startTime,Timestamp endTime);
	
	//根据地区查询
	public List<CdPo> findCD(Timestamp startTime,Timestamp endTime,String area,String singerName);
	
	//根据歌手查询，如华语群星则是影视OST
	
//	public List<CdPo> findCDBySinger(String singerName);
}
