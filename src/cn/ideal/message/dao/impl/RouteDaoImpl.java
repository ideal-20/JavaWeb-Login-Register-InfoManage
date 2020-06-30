package cn.ideal.message.dao.impl;

import cn.ideal.message.dao.RouteDao;
import cn.ideal.message.domain.User;
import cn.ideal.message.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RouteDaoImpl implements RouteDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 查询总记录数
     *
     * @param condition
     * @return
     */
    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //定义模板初始化sql
        String sql = "SELECT COUNT(*) FROM user_info WHERE 1 = 1";
        StringBuilder sb = new StringBuilder(sql);

        //遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> paramValues = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(key) || "pageSize".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append(" AND " + key + " LIKE ? ");
                // ? 的值
                paramValues.add("%"+value+"%");
            }
        }
        System.out.println(sb.toString());
        System.out.println(paramValues);

        return template.queryForObject(sb.toString(), Integer.class, paramValues.toArray());
    }

    /**
     * 根据 start pageSize 查询当前页的数据集合
     *
     * @param start
     * @param pageSize
     * @param condition
     * @return
     */
    @Override
    public List<User> findByPage(int start, int pageSize, Map<String, String[]> condition) {
        String sql = "SELECT * FROM user_info WHERE 1 = 1";
//        String sql = "SELECT * FROM user_info LIMIT ? , ?";
        StringBuilder sb = new StringBuilder(sql);

        //遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> paramValues = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(key) || "pageSize".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append(" AND " + key + " LIKE ? ");
                // ? 的值
                paramValues.add("%"+value+"%");
            }
        }

        //添加分页的查询
        sb.append(" LIMIT ? , ? ");
        //添加分页查询参数值
        paramValues.add(start);
        paramValues.add(pageSize);

        System.out.println(sb.toString());
        return template.query(sb.toString(), new BeanPropertyRowMapper<User>(User.class), paramValues.toArray());
    }
}
