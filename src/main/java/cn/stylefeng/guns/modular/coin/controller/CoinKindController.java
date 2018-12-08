package cn.stylefeng.guns.modular.coin.controller;

import cn.stylefeng.guns.core.log.LogObjectHolder;
import cn.stylefeng.guns.modular.coin.service.ICoinIndexJpflService;
import cn.stylefeng.guns.modular.coin.service.ICoinKindService;
import cn.stylefeng.guns.modular.coin.service.ICoinResourcesService;
import cn.stylefeng.guns.modular.kim.utils.FileUtils;
import cn.stylefeng.guns.modular.kim.utils.GuidUtils;
import cn.stylefeng.guns.modular.system.model.CoinIndexJpfl;
import cn.stylefeng.guns.modular.system.model.CoinKind;
import cn.stylefeng.guns.modular.system.model.CoinResources;
import cn.stylefeng.guns.modular.weixin.properties.PathProperties;
import cn.stylefeng.guns.modular.weixin.service.WxIndexService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
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

    @Autowired
    private ICoinIndexJpflService coinIndexJpflService;

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

        String flNm = "";
        if(ToolUtil.isNotEmpty(coinKind.getFlId())){
            CoinIndexJpfl coinIndexJpfl = coinIndexJpflService.selectById(coinKind.getFlId());
            flNm = coinIndexJpfl.getFlName();
        }
        model.addAttribute("flNm",flNm);

        return PREFIX + "coinKind_edit.html";
    }

    /**
     * 获取品种信息列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        Wrapper<CoinKind> wrapper = new EntityWrapper<CoinKind>();
        wrapper.orderBy("fl_id");
        wrapper.orderBy("kind_sort");
        return coinKindService.selectList(wrapper);
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
    @RequestMapping(value = "/addKind")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public String addKindAndUpload(@RequestParam("img") MultipartFile imgFile,
                                   @RequestParam("img2") MultipartFile img2File,
                                   @RequestParam("img3") MultipartFile img3File,
                                   @RequestParam("img4") MultipartFile img4File,
                                   HttpServletRequest request,
                                   CoinKind coinKind,
                                   Model model){
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
        if (!img2File.isEmpty()){
            String imgFilePath2 = FileUtils.singleUpload(img2File, request, coinPath);
            //保存文件至数据库
            CoinResources coinResources2 = FileUtils.saveCoinResource(img2File,imgFilePath2);
            coinResourcesService.insert(coinResources2);
            //设置图片资源guid
            coinKind.setKindImage(coinResources2.getFileCd());
        }

        //上传品种图片2
        if (!img3File.isEmpty()){
            String imgFilePath3 = FileUtils.singleUpload(img3File, request, coinPath);
            //保存文件至数据库
            CoinResources coinResources3 = FileUtils.saveCoinResource(img3File,imgFilePath3);
            coinResourcesService.insert(coinResources3);
            //设置图片资源guid
            coinKind.setKindImage(coinResources3.getFileCd());
        }

        //上传品种图片2
        if (!img4File.isEmpty()){
            String imgFilePath4 = FileUtils.singleUpload(img4File, request, coinPath);
            //保存文件至数据库
            CoinResources coinResources4 = FileUtils.saveCoinResource(img4File,imgFilePath4);
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

        //获取精品分类列表
        String dataType = "2";
        List<Map<String, Object>> flList = wxIndexService.getJptjList(dataType);
        model.addAttribute("flList", flList);

        return PREFIX + "coinKind_add.html";
    }



    /**
     * 删除品种信息
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String coinKindId) {
//        coinKindService.deleteById(coinKindId);
        coinKindService.deleteKindAndRes(coinKindId);
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
