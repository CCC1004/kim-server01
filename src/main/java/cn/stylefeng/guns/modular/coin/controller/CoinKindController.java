package cn.stylefeng.guns.modular.coin.controller;

import cn.stylefeng.guns.core.common.constant.cache.Cache;
import cn.stylefeng.guns.core.common.constant.cache.CacheKey;
import cn.stylefeng.guns.core.util.CacheUtil;
import cn.stylefeng.guns.modular.coin.service.ICoinResourcesService;
import cn.stylefeng.guns.modular.kim.utils.FileUtils;
import cn.stylefeng.guns.modular.kim.utils.GuidUtils;
import cn.stylefeng.guns.modular.system.model.CoinResources;
import cn.stylefeng.guns.modular.system.model.KimIndexRmtp;
import cn.stylefeng.guns.modular.system.model.KimResources;
import cn.stylefeng.guns.modular.system.service.IKimResourcesService;
import cn.stylefeng.guns.modular.weixin.properties.PathProperties;
import cn.stylefeng.guns.modular.weixin.service.WxIndexService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.CoinKind;
import cn.stylefeng.guns.modular.coin.service.ICoinKindService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private WxIndexService wxIndexService;
    
    @Autowired
    private ICoinResourcesService coinResourcesService;
    
    @Autowired
    private PathProperties pathProperties;

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
    public String coinKindAdd(Model model) {

        //获取精品分类列表
        String dataType = "2";
        List<Map<String, Object>> flList = wxIndexService.getJptjList(dataType);
        model.addAttribute("flList", flList);

        return PREFIX + "coinKind_add.html";
    }

    /**
     * 跳转到修改品种信息
     */
    @RequestMapping("/coinKind_update/{coinKindId}")
    public String coinKindUpdate(@PathVariable String coinKindId, Model model) {
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
        coinKind.setGuid(GuidUtils.getGuid());
        coinKind.setTs(GuidUtils.getCreateTime());
        coinKindService.insert(coinKind);
        return SUCCESS_TIP;
    }

    /**
     * 新增精品推荐+上传图片
     */
    @RequestMapping(value = "/addRmtp")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public String addKindAndUpload(@RequestParam("kindImage") MultipartFile imgFile,
                                   @RequestParam("kindImage2") MultipartFile imgFile2,
                                   @RequestParam("kindImage3") MultipartFile imgFile3,
                                   @RequestParam("kindImage4") MultipartFile imgFile4,
                                   HttpServletRequest request,
                                   CoinKind coinKind){
        String coinPath = pathProperties.getCoinPath();

        if (!imgFile.isEmpty()){
            //上传品种图片1
            String imgFilePath = FileUtils.singleUpload(imgFile, request, coinPath);
            //保存文件至数据库
            CoinResources coinResources1 = FileUtils.saveCoinResource(imgFile,imgFilePath);
            coinResourcesService.insert(coinResources1);
            //设置图片资源guid
            coinKind.setKindImage(coinResources1.getFileCd());
        }

        //上传品种图片2
        if (!imgFile2.isEmpty()){
            String imgFilePath2 = FileUtils.singleUpload(imgFile2, request, coinPath);
            //保存文件至数据库
            CoinResources coinResources2 = FileUtils.saveCoinResource(imgFile2,imgFilePath2);
            coinResourcesService.insert(coinResources2);
            //设置图片资源guid
            coinKind.setKindImage(coinResources2.getFileCd());
        }

        //上传品种图片2
        if (!imgFile3.isEmpty()){
            String imgFilePath3 = FileUtils.singleUpload(imgFile3, request, coinPath);
            //保存文件至数据库
            CoinResources coinResources3 = FileUtils.saveCoinResource(imgFile3,imgFilePath3);
            coinResourcesService.insert(coinResources3);
            //设置图片资源guid
            coinKind.setKindImage(coinResources3.getFileCd());
        }

        //上传品种图片2
        if (!imgFile4.isEmpty()){
            String imgFilePath4 = FileUtils.singleUpload(imgFile4, request, coinPath);
            //保存文件至数据库
            CoinResources coinResources4 = FileUtils.saveCoinResource(imgFile4,imgFilePath4);
            coinResourcesService.insert(coinResources4);
            //设置图片资源guid
            coinKind.setKindImage(coinResources4.getFileCd());
        }

        /*
          保存热门图片信息
         */
        coinKind.setGuid(GuidUtils.getGuid());
        coinKind.setTs(GuidUtils.getCreateTime());
        coinKindService.insert(coinKind);


        return PREFIX + "coinKind_add.html";
    }



    /**
     * 删除品种信息
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String coinKindId) {
        coinKindService.deleteById(coinKindId);
        return SUCCESS_TIP;
    }

    /**
     * 修改品种信息
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(CoinKind coinKind) {
        coinKind.setTs(GuidUtils.getCreateTime());
        coinKindService.updateById(coinKind);
        return SUCCESS_TIP;
    }

    /**
     * 品种信息详情
     */
    @RequestMapping(value = "/detail/{coinKindId}")
    @ResponseBody
    public Object detail(@PathVariable("coinKindId") String coinKindId) {
        return coinKindService.selectById(coinKindId);
    }
}
