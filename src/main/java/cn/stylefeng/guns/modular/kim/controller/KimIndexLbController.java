package cn.stylefeng.guns.modular.kim.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.KimIndexLb;
import cn.stylefeng.guns.modular.kim.service.IKimIndexLbService;

/**
 * 轮播图控制器
 *
 * @author fengshuonan
 * @Date 2018-11-24 14:37:10
 */
@Controller
@RequestMapping("/kimIndexLb")
public class KimIndexLbController extends BaseController {

    private String PREFIX = "/kim/kimIndexLb/";

    @Autowired
    private IKimIndexLbService kimIndexLbService;

    /**
     * 跳转到轮播图首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "kimIndexLb.html";
    }

    /**
     * 跳转到添加轮播图
     */
    @RequestMapping("/kimIndexLb_add")
    public String kimIndexLbAdd() {
        return PREFIX + "kimIndexLb_add.html";
    }

    /**
     * 跳转到修改轮播图
     */
    @RequestMapping("/kimIndexLb_update/{kimIndexLbId}")
    public String kimIndexLbUpdate(@PathVariable String kimIndexLbId, Model model) {
        KimIndexLb kimIndexLb = kimIndexLbService.selectById(kimIndexLbId);
        model.addAttribute("item",kimIndexLb);
        LogObjectHolder.me().set(kimIndexLb);
        return PREFIX + "kimIndexLb_edit.html";
    }

    /**
     * 获取轮播图列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return kimIndexLbService.selectList(null);
    }

    /**
     * 新增轮播图
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(KimIndexLb kimIndexLb) {
        kimIndexLbService.insert(kimIndexLb);
        return SUCCESS_TIP;
    }

    /**
     * 删除轮播图
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String kimIndexLbId) {
        kimIndexLbService.deleteById(kimIndexLbId);
        return SUCCESS_TIP;
    }

    /**
     * 修改轮播图
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(KimIndexLb kimIndexLb) {
        kimIndexLbService.updateById(kimIndexLb);
        return SUCCESS_TIP;
    }

    /**
     * 轮播图详情
     */
    @RequestMapping(value = "/detail/{kimIndexLbId}")
    @ResponseBody
    public Object detail(@PathVariable("kimIndexLbId") String kimIndexLbId) {
        return kimIndexLbService.selectById(kimIndexLbId);
    }
}
