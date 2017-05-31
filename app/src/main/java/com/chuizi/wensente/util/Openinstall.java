package com.chuizi.wensente.util;

import com.chuizi.healthJS.model.BaseBean;

/**
 * Created by Administrator on 2017/5/27 0027.
 */

public class Openinstall extends BaseBean{
    private String fatherId;
    private String fatherType;

    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    public String getFatherType() {
        return fatherType;
    }

    public void setFatherType(String fatherType) {
        this.fatherType = fatherType;
    }
}
