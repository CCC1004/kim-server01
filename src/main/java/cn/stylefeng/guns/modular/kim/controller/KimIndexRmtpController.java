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
import cn.stylefeng.guns.modular.system.model.KimIndexRmtp;
import cn.stylefeng.guns.modular.kim.service.IKimIndexRmtpService;

/**
 * 热门图片控制器
 *
 * @author fengshuonan
 * @Date 2018-11-24 22:52:06
 */
@Controller
@RequestMapping("/kimIndexRmtp")
public class KimIndexRmtpController extends BaseController {

    private String PREFIX = "/kim/kimIndexRmtp/";

    @Autowired
    private IKimIndexRmtpService kimIndexRmtpService;

    /**
     * 跳转到热门图片首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "kimIndexRmtp.html";
    }

    /**
     * 跳转到添加热门图片
     */
    @RequestMapping("/kimIndexRmtp_add")
    public String kimIndexRmtpAdd() {
        return PREFIX + "kimIndexRmtp_add.html";
    }

    /**
     * 跳转到修改热门图片
     */
    @RequestMapping("/kimIndexRmtp_update/{kimIndexRmtpId}")
    public String kimIndexRmtpUpdate(@PathVariable Integer kimIndexRmtpId, Model model) {
        KimIndexRmtp kimIndexRmtp = kimIndexRmtpService.selectById(kimIndexRmtpId);
        model.addAttribute("item",kimIndexRmtp);
        LogObjectHolder.me().set(kimIndexRmtp);
        return PREFIX + "kimIndexRmtp_edit.html";
    }

    /**
     * 获取热门图片列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return kimIndexRmtpService.selectList(null);
    }

    /**
     * 新增热门图片
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(KimIndexRmtp kimIndexRmtp) {
        kimIndexRmtpService.insert(kimIndexRmtp);
        return SUCCESS_TIP;
    }

    /**
     * 删除热门图片
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer kimIndexRmtpId) {
        kimIndexRmtpService.deleteById(kimIndexRmtpId);
        return SUCCESS_TIP;
    }

    /**
     * 修改热门图片
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(KimIndexRmtp kimIndexRmtp) {
        kimIndexRmtpService.updateById(kimIndexRmtp);
        return SUCCESS_TIP;
    }

    /**
     * 热门图片详情
     */
    @RequestMapping(value = "/detail/{kimIndexRmtpId}")
    @ResponseBody
    public Object detail(@PathVariable("kimIndexRmtpId") Integer kimIndexRmtpId) {
        return kimIndexRmtpService.selectById(kimIndexRmtpId);
    }
}
