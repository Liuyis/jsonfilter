package com.liuyis.jsonfilter;

import com.liuyis.jsonfilter.advice.JsonFilterResponseBodyAdvice;
import com.liuyis.jsonfilter.configuration.FastJsonConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author liuyis
 * @date 02/02/2019
 */
@Configuration
@Import({JsonFilterResponseBodyAdvice.class, FastJsonConfiguration.class})
public class JsonfilterAutoConfiguration {
    private Logger logger = LoggerFactory.getLogger(JsonfilterAutoConfiguration.class);
    public JsonfilterAutoConfiguration() {
        logger.info("Initializing Jsonfilter...");
    }
}
