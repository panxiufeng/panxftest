package com.pxf.project.common.util.page;


public class PageUtil {

    /**
     * 计算开始条目
     * 
     * @param pageNo 页码,第一页开始
     * @param pageSize 每页大小
     * @return
     */
    public static int calStartIndex(int pageNo, int pageSize) {
        int start = (pageNo - 1) * pageSize;
        return start >= 0 ? start : 0;
    }

    /**
     * 计算最后一条下标
     * 
     * @param pageNo
     * @param pageSize
     * @param totalCount
     * @return
     */
    public static int calEndIndex(int pageNo, int pageSize, int totalCount) {
        int end = calStartIndex(pageNo, pageSize) + pageSize - 1;
        return end >= totalCount ? totalCount - 1 : end;
    }

    /**
     * 根据首页计算
     * 
     * @param start
     * @param pageSize
     * @param totalCount
     * @return
     */
    public static int calEndIndexBystart(int start, int pageSize, int totalCount) {
        int end = start + pageSize - 1;
        return end >= totalCount ? totalCount - 1 : end;
    }

    /**
     * String to int 
     * 
     * @param pageNo
     * @return
     */
    public static int parsePageNo(String pageNo) {
        try {
            return Integer.parseInt(pageNo);
        } catch (Exception e) {
            return 1;
        }
    }

    public static int parsePageSize(String pageSize) {
        try {
            return Integer.parseInt(pageSize);
        } catch (Exception e) {
            return Page.DEFAULTPAGESIZE;
        }
    }

    public static void main(String[] args) {
        System.out.println(PageUtil.calEndIndex(7, 5, 31));
    }

}
