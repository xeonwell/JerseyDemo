package com.xeonwell.JerseyDemo.Common;

import com.xeonwell.JerseyDemo.Enum.BlStatus;
import com.xeonwell.JerseyDemo.Model.BlResult;

/**
 * Created by xeonwell on 2017-04-25.
 */
public interface IBaseApiController {
    String MediaTypeUtf8Json = "application/json;charset=utf-8";

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
