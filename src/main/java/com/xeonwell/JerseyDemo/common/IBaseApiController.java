package com.xeonwell.JerseyDemo.common;

import com.xeonwell.JerseyDemo.enums.BlStatus;
import com.xeonwell.JerseyDemo.model.BlResult;

/**
 * Created by xeonwell on 2017-04-25.
 */
public interface IBaseApiController {
    String MediaTypeUtf8Json = "application/json;charset=utf-8";

    default BlResult ok() {
        return new BlResult(BlStatus.OK, "");
    }
    default BlResult ok(Object o) {
        return new BlResult(BlStatus.OK, o);
    }

    default BlResult fail(String msg) {
        return new BlResult(BlStatus.Fail, msg);
    }

    default BlResult needLogin() {
        return new BlResult(BlStatus.NeedLogin, null);
    }
}
