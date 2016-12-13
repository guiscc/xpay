package com.xpay.admin.common.control;

import java.util.HashMap;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 *
 */
public class BaseController {

    /**
     *
     * @param pageSize
     * @param currentPageNum
     * @param isContainsTotalCount
     * @return
     */
    public PageBounds buildPageBounds(Integer pageSize, Integer currentPageNum,
                                      Boolean isContainsTotalCount) {
        if (null == pageSize) {
            pageSize = 10;
        }
        if (null == currentPageNum) {
            currentPageNum = 1;
        }
        if (null == isContainsTotalCount) {
            isContainsTotalCount = true;
        }
        PageBounds pageBounds = new PageBounds();
        pageBounds.setPage(currentPageNum);
        pageBounds.setLimit(pageSize);
        pageBounds.setContainsTotalCount(isContainsTotalCount);
        return pageBounds;
    }

    /**
     *
     * @param pageSize
     * @param currentPageNum
     * @param ret
     * @return
     */
    public Map<String, Object> buildResult(Integer pageSize, Integer currentPageNum, PageList<?> ret) {

        if (null == pageSize) {
            pageSize = 10;
        }
        if (null == currentPageNum) {
            currentPageNum = 1;
        }

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("rows", ret);
        if (null != ret && null != ret.getPaginator()) {
            result.put("total", ret.getPaginator().getTotalCount());
        }
        return result;
    }

    /**
     *
     * @param ret
     * @return
     */
    public Map<String, Object> buildResult(Object ret) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", ret);
        return result;
    }

    /**
     *
     * @param pageSize
     * @param currentPageNum
     * @param ret
     * @param income
     * @param outcome
     * @return
     */
    public Map<String, Object> buildResult(Integer pageSize, Integer currentPageNum,
                                           PageList<?> ret, String income, String outcome) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("income", income);
        result.put("outcome", outcome);
        result.put("rows", ret);
        result.put("total", ret.getPaginator().getTotalCount());
        return result;
    }

    /**
     *
     * @return
     */
    public Map<String, Object> buildResult() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        return result;
    }

    /**
     *
     * @param errorMsg
     * @return
     */
    public Map<String, Object> buildErrorResult(String errorMsg) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);
        result.put("errorMsg", errorMsg);
        return result;
    }

}
