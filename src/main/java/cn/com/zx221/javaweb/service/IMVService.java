package cn.com.zx221.javaweb.service;

import java.util.List;

import cn.com.zx221.javaweb.vo.MVVO;

/**
 * @author hj
 * @time 2019年8月2日 下午5:41:05
 */
public interface IMVService {
	/**
	 * @param currPageNo
	 * @param keyword
	 * @return
	 */
	public List<MVVO> selectMV(int currPageNo, int number, String mvArea, String mvType);

}
