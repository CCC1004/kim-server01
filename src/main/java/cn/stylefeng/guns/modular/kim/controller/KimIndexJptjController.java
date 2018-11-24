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
import cn.stylefeng.guns.modular.system.model.KimIndexJptj;
import cn.stylefeng.guns.modular.kim.service.IKimIndexJptjService;

/**
 * 精品推荐控制器
 *
 * @author fengshuonan
 * @Date 2018-11-24 14:28:59
 */
@Controller
@RequestMapping("/kimIndexJptj")
public class KimIndexJptjController extends BaseController {

    private String PREFIX = "/kim/kimIndexJptj/";

    @Autowired
    private IKimIndexJptjService kimIndexJptjService;

    /**
     * 跳转到精品推荐首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "kimIndexJptj.html";
    }

    /**
     * 跳转到添加精品推荐
     */
    @RequestMapping("/kimIndexJptj_add")
    public String kimIndexJptjAdd() {
        return PREFIX + "kimIndexJptj_add.html";
    }

    /**
     * 跳转到修改精品推荐
     */
    @RequestMapping("/kimIndexJptj_update/{kimIndexJptjId}")
    public String kimIndexJptjUpdate(@PathVariable Integer kimIndexJptjId, Model model) {
        KimIndexJptj kimIndexJptj = kimIndexJptjService.selectById(kimIndexJptjId);
        model.addAttribute("item",kimIndexJptj);
        LogObjectHolder.me().set(kimIndexJptj);
        return PREFIX + "kimIndexJptj_edit.html";
    }

    /**
     * 获取精品推荐列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return kimIndexJptjService.selectList(null);
    }

    /**
     * 新增精品推荐
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(KimIndexJptj kimIndexJptj) {
        kimIndexJptjService.insert(kimIndexJptj);
        return SUCCESS_TIP;
    }

    /**
     * 删除精品推荐
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer kimIndexJptjId) {
        kimIndexJptjService.deleteById(kimIndexJptjId);
        return SUCCESS_TIP;
    }

    /**
     * 修改精品推荐
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(KimIndexJptj kimIndexJptj) {
        kimIndexJptjService.updateById(kimIndexJptj);
        return SUCCESS_TIP;
    }

    /**
     * 精品推荐详情
     */
    @RequestMapping(value = "/detail/{kimIndexJptjId}")
    @ResponseBody
    public Object detail(@PathVariable("kimIndexJptjId") Integer kimIndexJptjId) {
        return kimIndexJptjService.selectById(kimIndexJptjId);
    }
}
