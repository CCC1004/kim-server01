package cn.stylefeng.guns.modular.coin.controller;

import cn.stylefeng.guns.core.log.LogObjectHolder;
import cn.stylefeng.guns.modular.coin.service.ICoinIndexLbService;
import cn.stylefeng.guns.modular.coin.service.ICoinResourcesService;
import cn.stylefeng.guns.modular.kim.utils.FileUtils;
import cn.stylefeng.guns.modular.kim.utils.GuidUtils;
import cn.stylefeng.guns.modular.system.model.CoinIndexLb;
import cn.stylefeng.guns.modular.system.model.CoinResources;
import cn.stylefeng.guns.modular.weixin.properties.PathProperties;
import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 轮播图控制器
 *
 * @author fengshuonan
 * @Date 2018-12-06 15:51:12
 */
@Controller
@RequestMapping("/coinIndexLb")
public class CoinIndexLbController extends BaseController {

    private String PREFIX = "/coin/coinIndexLb/";

    @Autowired
    private ICoinIndexLbService coinIndexLbService;

    @Autowired
    private ICoinResourcesService coinResourcesService;

    @Autowired
    private PathProperties pathProperties;

    /**
     * 跳转到轮播图首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "coinIndexLb.html";
    }

    /**
     * 跳转到添加轮播图
     */
    @RequestMapping("/coinIndexLb_add")
    public String coinIndexLbAdd() {
        return PREFIX + "coinIndexLb_add.html";
    }

    /**
     * 跳转到修改轮播图
     */
    @RequestMapping("/coinIndexLb_update/{coinIndexLbId}")
    public String coinIndexLbUpdate(@PathVariable String coinIndexLbId, Model model) {
        CoinIndexLb coinIndexLb = coinIndexLbService.selectById(coinIndexLbId);
        model.addAttribute("item",coinIndexLb);
        LogObjectHolder.me().set(coinIndexLb);
        return PREFIX + "coinIndexLb_edit.html";
    }

    /**
     * 获取轮播图列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return coinIndexLbService.selectList(null);
    }

    /**
     * 新增轮播图
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(CoinIndexLb coinIndexLb) {
        coinIndexLbService.insert(coinIndexLb);
        return SUCCESS_TIP;
    }


    /**
     * 新增轮播图信息+上传图片
     */
    @RequestMapping(value = "/addLb")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public String addJptjAndUpload(@RequestParam("file") MultipartFile file,
                                   HttpServletRequest request,
                                   CoinIndexLb coinIndexLb){
        /*
            上传图片
         */
        String coinPath = pathProperties.getCoinPath();
        String filePath = FileUtils.singleUpload(file, request, coinPath);

        /*
            保存文件至数据库
         */
        CoinResources coinResources = new CoinResources();
        coinResources.setFileCd(GuidUtils.getGuid());
        //图片名字
        String fileName = file.getOriginalFilename();
        coinResources.setFileNm(fileName);
        //资源类型，图片为2
        coinResources.setMulTp("2");

        //图片类型
        String contentType = file.getContentType();
        coinResources.setFileExt(contentType);
        coinResources.setFilePath(filePath);
        coinResources.setTs(GuidUtils.getCreateTime());
        coinResourcesService.insert(coinResources);

        /*
          保存精品推荐信息
         */
        coinIndexLb.setGuid(GuidUtils.getGuid());
        coinIndexLb.setTs(GuidUtils.getCreateTime());
        //设置图片资源guid
        coinIndexLb.setLbImage(coinResources.getFileCd());
        coinIndexLbService.insert(coinIndexLb);

//        return SUCCESS_TIP;
        return PREFIX + "coinIndexLb_add.html";
    }



    /**
     * 删除轮播图
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String coinIndexLbId) {
//        coinIndexLbService.deleteById(coinIndexLbId);
        coinIndexLbService.deleteLbAndRes(coinIndexLbId);
        return SUCCESS_TIP;
    }

    /**
     * 修改轮播图
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(CoinIndexLb coinIndexLb) {
        coinIndexLbService.updateById(coinIndexLb);
        return SUCCESS_TIP;
    }

    /**
     * 轮播图详情
     */
    @RequestMapping(value = "/detail/{coinIndexLbId}")
    @ResponseBody
    public Object detail(@PathVariable("coinIndexLbId") String coinIndexLbId) {
        return coinIndexLbService.selectById(coinIndexLbId);
    }
}
