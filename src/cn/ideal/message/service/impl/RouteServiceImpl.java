package cn.ideal.message.service.impl;

import cn.ideal.message.dao.RouteDao;
import cn.ideal.message.dao.impl.RouteDaoImpl;
import cn.ideal.message.domain.PageBean;
import cn.ideal.message.domain.User;
import cn.ideal.message.service.RouteService;

import java.util.List;
import java.util.Map;

public class RouteServiceImpl implements RouteService {

    private RouteDao routeDao = new RouteDaoImpl();

    /**
     * 分页查询
     *
     * @param currentPage
     * @param pageSize
     * @param condition
     * @return
     */
    @Override
    public PageBean<User> pageQuery(int currentPage, int pageSize, Map<String, String[]> condition) {

        //创建pageBean对象
        PageBean<User> pageBean = new PageBean<User>();
        //设置参数
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        //调用dao查询总记录数
        int totalCount = routeDao.findTotalCount(condition);
        pageBean.setTotalCount(totalCount);
        //调用dao查询List集合
        int start = (currentPage - 1) * pageSize;
        List<User> list = routeDao.findByPage(start, pageSize, condition);
        pageBean.setList(list);

        //计算总页码
        int totalPage = (totalCount % pageSize) == 0 ? totalCount / pageSize : (totalCount / pageSize + 1);
        pageBean.setTotalPage(totalPage);

        return pageBean;
    }
}
