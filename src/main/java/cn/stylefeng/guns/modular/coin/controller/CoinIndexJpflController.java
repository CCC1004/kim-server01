package cn.stylefeng.guns.modular.coin.controller;

import cn.stylefeng.guns.core.log.LogObjectHolder;
import cn.stylefeng.guns.modular.coin.service.ICoinIndexJpflService;
import cn.stylefeng.guns.modular.coin.service.ICoinResourcesService;
import cn.stylefeng.guns.modular.kim.utils.FileUtils;
import cn.stylefeng.guns.modular.kim.utils.GuidUtils;
import cn.stylefeng.guns.modular.system.model.CoinIndexJpfl;
import cn.stylefeng.guns.modular.system.model.CoinResources;
import cn.stylefeng.guns.modular.weixin.properties.PathProperties;
import cn.stylefeng.roses.core.base.controller.BaseController;
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

/**
 * 精品分类控制器
 *
 * @author fengshuonan
 * @Date 2018-12-06 15:48:56
 */
@Controller
@RequestMapping("/coinIndexJpfl")
public class CoinIndexJpflController extends BaseController {

    private String PREFIX = "/coin/coinIndexJpfl/";

    @Autowired
    private ICoinIndexJpflService coinIndexJpflService;
    
    @Autowired
    private ICoinResourcesService coinResourcesService;

    @Autowired
    private PathProperties pathProperties;

    /**
     * 跳转到精品分类首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "coinIndexJpfl.html";
    }

    /**
     * 跳转到添加精品分类
     */
    @RequestMapping("/coinIndexJpfl_add")
    public String coinIndexJpflAdd() {
        return PREFIX + "coinIndexJpfl_add.html";
    }

    /**
     * 跳转到修改精品分类
     */
    @RequestMapping("/coinIndexJpfl_update/{coinIndexJpflId}")
    public String coinIndexJpflUpdate(@PathVariable String coinIndexJpflId, Model model) {
        CoinIndexJpfl coinIndexJpfl = coinIndexJpflService.selectById(coinIndexJpflId);
        model.addAttribute("item",coinIndexJpfl);
        LogObjectHolder.me().set(coinIndexJpfl);
        return PREFIX + "coinIndexJpfl_edit.html";
    }

    /**
     * 获取精品分类列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        Wrapper<CoinIndexJpfl> wrapper = new EntityWrapper<CoinIndexJpfl>();
        wrapper.orderBy("fl_sort");
        return coinIndexJpflService.selectList(wrapper);
    }

    /**
     * 新增精品分类
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(CoinIndexJpfl coinIndexJpfl) {
        coinIndexJpflService.insert(coinIndexJpfl);
        return SUCCESS_TIP;
    }

    /**
     * 新增精品分类+上传图片
     */
    @RequestMapping(value = "/addJpfl")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public String addJptjAndUpload(@RequestParam("file") MultipartFile file,
                                   HttpServletRequest request,
                                   CoinIndexJpfl coinIndexJpfl){
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
        coinIndexJpfl.setGuid(GuidUtils.getGuid());
        coinIndexJpfl.setTs(GuidUtils.getCreateTime());
        //设置图片资源guid
        coinIndexJpfl.setFlImage(coinResources.getFileCd());
        coinIndexJpflService.insert(coinIndexJpfl);

        return PREFIX + "coinIndexJpfl_add.html";
    }


    /**
     * 删除精品分类
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String coinIndexJpflId) {
//        coinIndexJpflService.deleteById(coinIndexJpflId);
        coinIndexJpflService.deleteByIdAndRes(coinIndexJpflId);
        return SUCCESS_TIP;
    }

    /**
     * 修改精品分类
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(CoinIndexJpfl coinIndexJpfl) {
        coinIndexJpflService.updateById(coinIndexJpfl);
        return SUCCESS_TIP;
    }

    /**
     * 精品分类详情
     */
    @RequestMapping(value = "/detail/{coinIndexJpflId}")
    @ResponseBody
    public Object detail(@PathVariable("coinIndexJpflId") String coinIndexJpflId) {
        return coinIndexJpflService.selectById(coinIndexJpflId);
    }
}
