package cn.stylefeng.guns.modular.weixin.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: superC
 * @Date: 2018/11/11 11:24
 */
@Component
@ConfigurationProperties(prefix = "wx")
@PropertySource(value = "classpath:resource.yml")
public class WxInfoProperties {

    @Value("${url}")
    private String url;

    @Value("${appid}")
    private String appid;

    @Value("${secret}")
    private String secret;

    @Value("${grant_type}")
    private String grant_type;


    public String getUrl() {
        return url;
    }

    public String getAppid() {
        return appid;
    }

    public String getSecret() {
        return secret;
    }

    public String getGrant_type() {
        return grant_type;
    }

}
