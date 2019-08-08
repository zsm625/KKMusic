package cn.com.zx221.javaweb.service;

import java.util.List;

import cn.com.zx221.javaweb.vo.SingerVo;

public interface SingerService {
	public List<SingerVo> findSinger(int currPageNo, String singer_initial, String areaId, String singer_sex,
			String singer_type);

	public int PageNumber(String singer_initial, String areaId, String singer_sex, String singer_type);

	public SingerVo findSingerById(int singer_id);

}
