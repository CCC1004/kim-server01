package cn.stylefeng.guns.modular.weixin.controller;

import cn.stylefeng.guns.modular.system.model.KimUser;
import cn.stylefeng.guns.modular.weixin.properties.WxInfoProperties;
import cn.stylefeng.guns.modular.weixin.service.IKimUserService;
import cn.stylefeng.guns.modular.weixin.utils.HttpClientUtil;
import cn.stylefeng.guns.modular.weixin.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录
 *
 * @Author: superC
 * @Date: 2018/11/9 11:40
 */
@RestController
@RequestMapping("/wxLogin")
public class WxLoginController {

    private final static Logger logger = LoggerFactory.getLogger(WxLoginController.class);

    @Autowired
    private WxInfoProperties wxInfoProperties;

    @Autowired
    private IKimUserService userService;

    /**
     * 账户/密码登录
     */
    @RequestMapping(value = "/kimLogin")
    public ResultUtils login(@RequestParam(value = "username",required=false) String username,
                             @RequestParam(value = "password",required=false)String password){

        KimUser userInfo = userService.loginCheck(username, password);

        if(userInfo!=null){
            //存入session

            return ResultUtils.ok(userInfo);
        }else{
            return ResultUtils.errorMsg("账号/密码错误！");
        }
    }


    /**
     * 微信授权登录
     */
    @RequestMapping(value = "/wxLogin")
    public ResultUtils wxLogin(@RequestParam("code") String code) {

        System.out.println("wxlogin - code: " + code);

        String url = wxInfoProperties.getUrl();
        Map<String, String> param = new HashMap<>();
        param.put("appid", wxInfoProperties.getAppid());
        param.put("secret", wxInfoProperties.getSecret());
        param.put("js_code", code);
        param.put("grant_type", wxInfoProperties.getGrant_type());

        String wxResult = HttpClientUtil.doGet(url, param);
        System.out.println("json串：  " + wxResult);

//        转换为json对象
//        WxSessionModel model = JsonUtils.jsonToPojo(wxResult, WxSessionModel.class);

        // 存入session到redis


        return ResultUtils.ok();

    }

}
