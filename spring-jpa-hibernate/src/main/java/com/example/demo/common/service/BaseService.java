package com.example.demo.common.service;

import com.example.demo.common.entity.BaseEntity;
import com.example.demo.common.entity.Pager;
import com.example.demo.common.query.SqlQueryParams;

import java.awt.print.Pageable;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Author xu.xiaojing
 * @Date 2018/9/16 10:36
 * @Email xu.xiaojing@frontsurf.com
 * @Description
 */

public interface BaseService<T extends BaseEntity<ID>,ID extends Serializable> {

    /**
     * 新增或更新
     */
    T save(T t);

    /**
     * 新增或更新
     * 使用BeanUtil.copyProperties
     */
    T saveOrUpdate(T t);

    /**
     * 批量新增
     */
    Iterable<T> save(Iterable<T> entities);

    /**
     * 根据ID删除
     */
    void del(ID id);

    /**
     * 根据实体删除
     */
    void del(T t);

    /**
     * 根据ID查找对象
     */
    T findById(ID id);

    /**
     * 查找全部
     */
    List<T> findAll();

    /**
     * 分页排序获取数据
     * 禁止使用该接口进行count操作
     * Pageable pageable = new PageRequest(0, 10, new Sort(Sort.Direction.DESC,"id"));
     * @param pageable
     * @return
     */
    List<T> findAll(Pageable pageable);


    /**
     * 多条件查询
     * 注：多个条件间是and关系 & 参数是属性对应的类型 使用时注意避免结果集过大
     * @param params {"username:like":"test"} 键的格式为字段名:过滤方式,过滤方式见{@code QueryTypeEnum}
     * @return
     */
    List<T> list(List<SqlQueryParams> params);

    /**
     * 分页多条件查询
     * 注：多个条件间是and关系 & 参数是属性对应的类型
     * @param params {"username:like":"test"} 键的格式为字段名:过滤方式,过滤方式见{@code QueryTypeEnum}
     * @param pageable 分页信息 new PageRequest(page, size,new Sort(Direction.DESC, "updateTime"))
     * @return
     */
    Pager<T> list(List<SqlQueryParams> params, Pageable pageable);
}
