package com.cbat.exceptionhandler.util;


import org.springframework.lang.Nullable;

import javax.validation.constraints.NotNull;

public class Assert {
    /**
     * 对象非null
     * @param object
     * @param code 错误码
     */
    public static void notNull( Object object, @NotNull String code) {
        if (null == object ) {
            throw new CbatException(code);
        }
    }

    /**
     * 字符串不能为空
     * @param code 错误码
     * @param str
     */
    public static void notEmpty( String str, @NotNull String code ){
            if (str== null||"".equals(str)) {
                throw new CbatException(code);
            }


    }


}
