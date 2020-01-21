package cn.edu.zust.dmt.tkm.models.responds;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

import org.json.JSONObject;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.models.responds
 * @description $
 * @time 1/12/2020 20:02
 * copyright(c) all rights reserved by MR.M
 **/
public class BaseRespondModel {
    private String retcode;
    private Object obj;
    private String error;

    public BaseRespondModel(String retcode, Object obj, String error) {
        this.retcode = retcode;
        this.obj = obj;
        this.error = error;
    }

    public <T> T getDataModel(Class<T> dataModelClass) {
        return (new Gson()).fromJson(JsonParser.parseString(obj.toString()), dataModelClass);
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}