package com.panda.base.util;

public class PageInfo {
	private int totalRows;
    private int pageSize;
    private int pageNo;

    public PageInfo() {
        totalRows = 0;
        pageSize = 20;
        pageNo = 1;
    }

    public PageInfo(int pn, int ps) {
        totalRows = 0;
        pageSize = ps;
        pageNo = pn;
    }

    public PageInfo(int pn, int ps, int tr) {
        totalRows = tr;
        pageSize = ps;
        pageNo = pn;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getRowStart() {
        return (pageNo - 1 > 0 ? pageNo - 1 : 0) * pageSize;
    }
}
