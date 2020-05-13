package com.cbat.exception.util;

import com.cbat.exception.annotation.StatuCode;
import com.cbat.exception.bean.exception.CbatIllegalStateException;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Assert {
    /**
     * 对象非null
     * @param object
     * @param msg 消息
     */
    public static void notNull( Object object, @NotNull String msg) {
        if (null == object ) {
            throw new CbatIllegalStateException(StatuCode.ILLEGAL_STATE.getCode(),msg);
        }
    }

    /**
     * 字符串不能为空
     * @param msg 消息
     * @param str
     */
    public static void notEmpty( String str, @NotNull String msg ){
        if (str== null||"".equals(str)) {
            throw new CbatIllegalStateException(StatuCode.ILLEGAL_STATE.getCode(),msg);
        }
    }

    /**
     * 集合不能为空
     * @param msg 消息
     * @param list
     */
    public static void notNull(List list, @NotNull String msg ){
        if (null == list ||0 == list.size()) {
            throw new CbatIllegalStateException(StatuCode.ILLEGAL_STATE.getCode(),msg);
        }


    }
}
