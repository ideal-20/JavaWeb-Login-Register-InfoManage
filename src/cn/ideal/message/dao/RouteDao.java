package cn.ideal.message.dao;

import cn.ideal.message.domain.User;

import java.util.List;
import java.util.Map;

public interface RouteDao {

    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    public int findTotalCount(Map<String, String[]> condition);

    /**
     * 根据 start pageSize 查询当前页的数据集合
     * @param start
     * @param pageSize
     * @param condition
     * @return
     */
    public List<User> findByPage(int start, int pageSize, Map<String, String[]> condition);
}
