package cn.stylefeng.guns.modular.weixin.controller;

import cn.stylefeng.guns.core.log.LogObjectHolder;
import cn.stylefeng.guns.modular.system.model.KimUser;
import cn.stylefeng.guns.modular.weixin.service.IKimUserService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 微信用户控制器
 *
 * @author fengshuonan
 * @Date 2018-12-02 19:51:05
 */
@Controller
@RequestMapping("/kimUser")
public class KimUserController extends BaseController {

    private String PREFIX = "/weixin/kimUser/";

    @Autowired
    private IKimUserService kimUserService;

    /**
     * 跳转到微信用户首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "kimUser.html";
    }

    /**
     * 跳转到添加微信用户
     */
    @RequestMapping("/kimUser_add")
    public String kimUserAdd() {
        return PREFIX + "kimUser_add.html";
    }

    /**
     * 跳转到修改微信用户
     */
    @RequestMapping("/kimUser_update/{kimUserId}")
    public String kimUserUpdate(@PathVariable Integer kimUserId, Model model) {
        KimUser kimUser = kimUserService.selectById(kimUserId);
        model.addAttribute("item",kimUser);
        LogObjectHolder.me().set(kimUser);
        return PREFIX + "kimUser_edit.html";
    }

    /**
     * 获取微信用户列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return kimUserService.selectList(null);
    }

    /**
     * 新增微信用户
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(KimUser kimUser) {
        kimUserService.insert(kimUser);
        return SUCCESS_TIP;
    }

    /**
     * 删除微信用户
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer kimUserId) {
        kimUserService.deleteById(kimUserId);
        return SUCCESS_TIP;
    }

    /**
     * 修改微信用户
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(KimUser kimUser) {
        kimUserService.updateById(kimUser);
        return SUCCESS_TIP;
    }

    /**
     * 微信用户详情
     */
    @RequestMapping(value = "/detail/{kimUserId}")
    @ResponseBody
    public Object detail(@PathVariable("kimUserId") Integer kimUserId) {
        return kimUserService.selectById(kimUserId);
    }
}
