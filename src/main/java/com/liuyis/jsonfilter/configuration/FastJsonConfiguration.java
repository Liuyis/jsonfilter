package com.liuyis.jsonfilter.configuration;

import com.liuyis.jsonfilter.converter.JsonFilterHttpMessageConverter;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Liuyis on 2016/2/12.
 */
@Configuration
public class FastJsonConfiguration {
    @Bean
    public HttpMessageConverters customConverters() {
        Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        JsonFilterHttpMessageConverter jsonFilterHttpMessageConverter = new JsonFilterHttpMessageConverter();
        messageConverters.add(jsonFilterHttpMessageConverter);
        return new HttpMessageConverters(true, messageConverters);
    }
}
