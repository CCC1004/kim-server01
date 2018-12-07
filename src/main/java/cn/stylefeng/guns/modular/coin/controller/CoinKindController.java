package cn.stylefeng.guns.modular.coin.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.CoinKind;
import cn.stylefeng.guns.modular.coin.service.ICoinKindService;

/**
 * 品种信息控制器
 *
 * @author fengshuonan
 * @Date 2018-12-07 18:11:22
 */
@Controller
@RequestMapping("/coinKind")
public class CoinKindController extends BaseController {

    private String PREFIX = "/coin/coinKind/";

    @Autowired
    private ICoinKindService coinKindService;

    /**
     * 跳转到品种信息首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "coinKind.html";
    }

    /**
     * 跳转到添加品种信息
     */
    @RequestMapping("/coinKind_add")
    public String coinKindAdd() {
        return PREFIX + "coinKind_add.html";
    }

    /**
     * 跳转到修改品种信息
     */
    @RequestMapping("/coinKind_update/{coinKindId}")
    public String coinKindUpdate(@PathVariable Integer coinKindId, Model model) {
        CoinKind coinKind = coinKindService.selectById(coinKindId);
        model.addAttribute("item",coinKind);
        LogObjectHolder.me().set(coinKind);
        return PREFIX + "coinKind_edit.html";
    }

    /**
     * 获取品种信息列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return coinKindService.selectList(null);
    }

    /**
     * 新增品种信息
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(CoinKind coinKind) {
        coinKindService.insert(coinKind);
        return SUCCESS_TIP;
    }

    /**
     * 删除品种信息
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer coinKindId) {
        coinKindService.deleteById(coinKindId);
        return SUCCESS_TIP;
    }

    /**
     * 修改品种信息
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(CoinKind coinKind) {
        coinKindService.updateById(coinKind);
        return SUCCESS_TIP;
    }

    /**
     * 品种信息详情
     */
    @RequestMapping(value = "/detail/{coinKindId}")
    @ResponseBody
    public Object detail(@PathVariable("coinKindId") Integer coinKindId) {
        return coinKindService.selectById(coinKindId);
    }
}
