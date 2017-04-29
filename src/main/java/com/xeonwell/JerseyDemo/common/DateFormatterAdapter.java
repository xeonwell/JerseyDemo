package com.xeonwell.JerseyDemo.common;

import javax.ws.rs.ext.Provider;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by xeonwell on 2017-04-28.
 * format Date type in json output
 */
@Provider
public class DateFormatterAdapter extends XmlAdapter<String, Date> {
    @Override
    public Date unmarshal(String v) throws Exception {
        Timestamp timestamp = new Timestamp(new Long(v));
        Date date = new Date(timestamp.getTime());
        return date;
    }

    @Override
    public String marshal(Date v) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(v);
    }
}
