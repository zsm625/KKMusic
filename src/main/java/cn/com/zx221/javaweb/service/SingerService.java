package cn.com.zx221.javaweb.service;

import java.util.List;

import cn.com.zx221.javaweb.po.SingerPo;
import cn.com.zx221.javaweb.vo.SingerVo;

public interface SingerService {
    public List<SingerVo> findSinger(int currPageNo,String singer_initial, String areaId, String singer_sex, String singer_type);
<<<<<<< HEAD
    public int PageNumber(String singer_initial, String areaId, String singer_sex, String singer_type);
=======
  //  public List<SingerVo> findSingerTxt(int currPageNo,String singer_initial, String areaId, String singer_sex, String singer_type);
>>>>>>> refs/remotes/origin/master
}
