package com.qin.util;

/**
 * @program: my-blog
 * @description: 分页工具类
 * @author: qinda
 * @create: 2020-04-14 22:15
 **/
import com.github.pagehelper.PageInfo;
import com.qin.pojo.PageRequest;
import com.qin.pojo.PageResult;

public class PageUtil {

    /**
     * 将分页信息封装到统一的接口
     * @param pageRequest
     * @param pageInfo
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}