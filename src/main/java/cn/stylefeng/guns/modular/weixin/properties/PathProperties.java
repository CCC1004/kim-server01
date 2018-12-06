package cn.stylefeng.guns.modular.weixin.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 路径参数
 * @Author: superC
 * @Date: 2018/12/6 16:41
 */
@Component
@ConfigurationProperties(prefix = "path")
@PropertySource(value = "classpath:resource.yml")
public class PathProperties {

    @Value("${kim_path}")
    private String kimPath;

    @Value("${coin_path}")
    private String coinPath;

    public String getKimPath() {
        return kimPath;
    }

    public void setKimPath(String kimPath) {
        this.kimPath = kimPath;
    }

    public String getCoinPath() {
        return coinPath;
    }

    public void setCoinPath(String coinPath) {
        this.coinPath = coinPath;
    }
}
