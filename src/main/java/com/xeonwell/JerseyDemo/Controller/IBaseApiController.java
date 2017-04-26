package com.xeonwell.JerseyDemo.Controller;

import com.xeonwell.JerseyDemo.Enum.BlStatus;
import com.xeonwell.JerseyDemo.Model.BlResult;

/**
 * Created by xeonwell on 2017-04-25.
 */
public interface IBaseApiController {
    String MediaTypeUtf8Json = "application/json;charset=utf-8";

    default BlResult OK(Object o) {
        return new BlResult(BlStatus.OK, o);
    }

    default BlResult Fail(String msg) {
        return new BlResult(BlStatus.Fail, msg);
    }

    default BlResult NeedLogin() {
        return new BlResult(BlStatus.NeedLogin, null);
    }
}
