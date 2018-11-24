package cn.stylefeng.guns.modular.system.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.KimResources;
import cn.stylefeng.guns.modular.system.service.IKimResourcesService;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2018-11-24 14:51:03
 */
@Controller
@RequestMapping("/kimResources")
public class KimResourcesController extends BaseController {

    private String PREFIX = "/system/kimResources/";

    @Autowired
    private IKimResourcesService kimResourcesService;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "kimResources.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/kimResources_add")
    public String kimResourcesAdd() {
        return PREFIX + "kimResources_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/kimResources_update/{kimResourcesId}")
    public String kimResourcesUpdate(@PathVariable Integer kimResourcesId, Model model) {
        KimResources kimResources = kimResourcesService.selectById(kimResourcesId);
        model.addAttribute("item",kimResources);
        LogObjectHolder.me().set(kimResources);
        return PREFIX + "kimResources_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return kimResourcesService.selectList(null);
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(KimResources kimResources) {
        kimResourcesService.insert(kimResources);
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer kimResourcesId) {
        kimResourcesService.deleteById(kimResourcesId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(KimResources kimResources) {
        kimResourcesService.updateById(kimResources);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{kimResourcesId}")
    @ResponseBody
    public Object detail(@PathVariable("kimResourcesId") Integer kimResourcesId) {
        return kimResourcesService.selectById(kimResourcesId);
    }
}
