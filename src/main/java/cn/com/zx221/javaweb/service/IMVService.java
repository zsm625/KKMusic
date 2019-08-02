package cn.com.zx221.javaweb.service;

import java.util.List;

import cn.com.zx221.javaweb.vo.MVVo;
/**
 * @author hj
 * @time 2019年8月2日 下午5:41:05
 */
public interface IMVService {
	/**
	 * 从数据库中,根据条件查询当前页码所要显示的MV list
	 * 1.验证页码的有效性
	 *   1>基于dao查询出所有食品的数量
	 *   2>根据每页显示的食品数计算出总页码
	 *   3>根据总页码,调整有效的当前页码
	 * 2.获取有效页码对应的MV List(PO)
	 *   1>调用DAO的条件查询方法,获取当前页的PO List(当前页码)
	 * 3.
	 * @param currPageNo
	 * @param keyword
	 * @return
	 */
    public List<MVVo> SelectMV(int currPageNo,String keyword);
}
