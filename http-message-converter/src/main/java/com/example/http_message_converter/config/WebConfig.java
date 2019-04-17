package com.example.http_message_converter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;

/**
 * HttpMessageConverter can determine what response to send back based on Accept header in request body.
 * */

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    /**
     * Return XML when Accept: application/xml
     * */

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MarshallingHttpMessageConverter xmlConverter =new MarshallingHttpMessageConverter();
        XStreamMarshaller xstream = new XStreamMarshaller();
        xmlConverter.setMarshaller(xstream);
        xmlConverter.setUnmarshaller(xstream);
        converters.add(xmlConverter);
        converters.add(converter());
    }

    /**
     * Return JSON when Accept: application/json
     * */

    @Bean
    MappingJackson2HttpMessageConverter converter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        return converter;
    }
}