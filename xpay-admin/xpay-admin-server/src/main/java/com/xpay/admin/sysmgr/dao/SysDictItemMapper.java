package com.xpay.admin.sysmgr.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.xpay.admin.sysmgr.entity.SysDictItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 字典项数据访问接�?
 *
 * @author wangzhenlei
 */
@Component("dictItemMapper")
public interface SysDictItemMapper extends BaseMapper {

    /**
     * 根据字典类型编码和字典项目代码获取字典项的显示名�?
     *
     * @param typeCode 字典类型代码
     * @param itemCode 字典项目代码
     * @throws Exception
     */
    public SysDictItem getDictItem(String typeCode, String itemCode) throws Exception;

    /**
     * 分页条件查询字典�?
     *
     * @param params
     * @param pageBounds
     * @return
     * @throws Exception
     */
    public PageList<SysDictItem> queryWithPage(Map<String, Object> params, PageBounds pageBounds) throws Exception;

    /**
     * 根据查询参数获取�?��字典�?
     *
     * @param params
     * @return
     * @throws Exception
     */
    public List<SysDictItem> queryByParams(Map<String, Object> params) throws Exception;

    /**
     * 根据ID获取字典�?
     *
     * @param id
     * @return
     * @throws Exception
     */
    public SysDictItem getDictItemById(long id) throws Exception;

    /**
     * 插入字典�?
     *
     * @param dictItem
     * @return
     * @throws Exception
     */
    public Long insertDictItem(SysDictItem dictItem) throws Exception;

    /**
     * 修改字典�?
     *
     * @param dictItem
     * @return
     * @throws Exception
     */
    public Long updateDictItem(SysDictItem dictItem) throws Exception;

    /**
     * 删除字典�?
     *
     * @param id
     * @throws Exception
     */
    public void delDictItem(Long id) throws Exception;

}
