package com.liuyis.jsonfilter.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.liuyis.jsonfilter.bean.JsonFilterObject;
import com.liuyis.jsonfilter.filter.SimpleSerializerFilter;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by Liuyis on 2016/2/11.
 */
public class JsonFilterHttpMessageConverter extends FastJsonHttpMessageConverter{

    private Charset charset;
    private SerializerFeature[] features;

    public JsonFilterHttpMessageConverter() {
        super();
        setSupportedMediaTypes(Arrays.asList(
                new MediaType("application", "json", UTF8),
                new MediaType("application", "*+json", UTF8),
                new MediaType("application", "jsonp", UTF8),
                new MediaType("application", "*+jsonp", UTF8)));
        setCharset(UTF8);
        setFeatures(SerializerFeature.DisableCircularReferenceDetect,SerializerFeature.WriteMapNullValue);
    }

    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        if(obj instanceof JsonFilterObject){
            JsonFilterObject jsonFilterObject = (JsonFilterObject) obj;
            OutputStream out = outputMessage.getBody();
            SimpleSerializerFilter simpleSerializerFilter = new SimpleSerializerFilter(jsonFilterObject.getIncludes(), jsonFilterObject.getExcludes());
            String text = JSON.toJSONString(jsonFilterObject.getJsonObject(),simpleSerializerFilter,features);
            byte[] bytes = text.getBytes(this.charset);
            out.write(bytes);
        }else {
            OutputStream out = outputMessage.getBody();
            String text = JSON.toJSONString(obj, this.features);
            byte[] bytes = text.getBytes(this.charset);
            out.write(bytes);
        }
    }

    @Override
    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    @Override
    public void setFeatures(SerializerFeature... features) {
        this.features = features;
    }
}
