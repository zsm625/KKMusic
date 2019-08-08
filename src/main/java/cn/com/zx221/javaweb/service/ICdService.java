package cn.com.zx221.javaweb.service;

import java.util.List;

import cn.com.zx221.javaweb.vo.CdVo;

/**
 * 专辑业务层
 * 
 * @author ZSM
 *
 * @time 2019年8月3日上午9:36:16
 */
public interface ICdService {

	/**
	 * 理清思路：现在是只需要向页面输出数据
	 */
	public List<CdVo> findCd(String keyword);

	public CdVo findCdById(int cdId);

}
