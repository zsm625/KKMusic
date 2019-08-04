package cn.com.zx221.javaweb.dao;

import java.util.List;

import cn.com.zx221.javaweb.po.SingerPo;

public interface SingerDAO {
public List<SingerPo> findSinger(int currPageNo,int number,String singerInitial,String areaId,String singerSex,String singerType);
//public List<SingerPo> findSingerTxt(int currPageNo,int number,String singer_initial, String areaId, String singer_sex, String singer_type);
public int singerCount(String singer_initial, String areaId, String singer_sex, String singer_type);
}
