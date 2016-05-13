package com.panda.base.dao;

import java.util.Map;

public class HqlAndNamedParams {
    public String hql;
    public Map<String, Object> params;

    public String getHql() {
        return hql;
    }

    public void setHql(String hql) {
        this.hql = hql;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public HqlAndNamedParams() {

    }

    public HqlAndNamedParams(String shql, Map<String, Object> values) {
        this.hql = shql;
        this.params = values;
    }
}
