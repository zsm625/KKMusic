package cn.com.zx221.javaweb.dao;

import java.util.List;

import cn.com.zx221.javaweb.po.MVPO;

public interface IMVDao {
       public int MVCount(String keyword);
       /**
        * 
        * @param currPageNo当前页码
        * @param number每页显示的MV数量
        * @param keyword查询条件(区域   版本)
        * @return
        */
       public List<MVPO> searchCurrPageMV(int currPageNo,int number,String keyword);
}
