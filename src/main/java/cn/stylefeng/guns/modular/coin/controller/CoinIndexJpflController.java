package cn.stylefeng.guns.modular.coin.controller;

import cn.stylefeng.guns.core.common.constant.cache.Cache;
import cn.stylefeng.guns.core.common.constant.cache.CacheKey;
import cn.stylefeng.guns.core.common.constant.factory.PageFactory;
import cn.stylefeng.guns.core.common.page.PageInfoBT;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import cn.stylefeng.guns.core.util.CacheUtil;
import cn.stylefeng.guns.modular.coin.service.ICoinIndexJpflService;
import cn.stylefeng.guns.modular.coin.service.ICoinResourcesService;
import cn.stylefeng.guns.modular.kim.utils.FileUtils;
import cn.stylefeng.guns.modular.kim.utils.GuidUtils;
import cn.stylefeng.guns.modular.system.model.CoinIndexJpfl;
import cn.stylefeng.guns.modular.system.model.CoinResources;
import cn.stylefeng.guns.modular.weixin.properties.PathProperties;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
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

        CoinResources coinResources = new CoinResources();
        if(ToolUtil.isNotEmpty(coinIndexJpfl.getFlImage())){
            coinResources = coinResourcesService.selectById(coinIndexJpfl.getFlImage());
        }
        model.addAttribute("coinResources",coinResources);

        return PREFIX + "coinIndexJpfl_edit.html";
    }

    /**
     * 获取精品分类列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
//        Wrapper<CoinIndexJpfl> wrapper = new EntityWrapper<CoinIndexJpfl>();
//        wrapper.orderBy("fl_sort");
//        return coinIndexJpflService.selectList(wrapper);

        Page<Map<String, Object>> page = new PageFactory<Map<String, Object>>().defaultPage();
        List<Map<String, Object>> list = coinIndexJpflService.getCoinJptjPage(page, null);
        page.setRecords(list);
        return new PageInfoBT<>(page);
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
        if(!file.isEmpty()){
            String coinPath = pathProperties.getCoinPath();
            String filePath = FileUtils.singleUpload(file, request, coinPath);
            //保存文件至数据库
            CoinResources coinResources = FileUtils.saveCoinResource(file,filePath);
            coinResourcesService.insert(coinResources);
            //设置图片资源guid
            coinIndexJpfl.setFlImage(coinResources.getFileCd());
        }

        /*
          保存精品推荐信息
         */
        coinIndexJpfl.setGuid(GuidUtils.getGuid());
        coinIndexJpfl.setTs(GuidUtils.getCreateTime());

        coinIndexJpflService.insert(coinIndexJpfl);

        //删除缓存数据
        CacheUtil.remove(Cache.INDEX, CacheKey.WX_INDEX_JP+"2");

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

        //删除缓存数据
        CacheUtil.remove(Cache.INDEX, CacheKey.WX_INDEX_JP+"2");
        return SUCCESS_TIP;
    }

    /**
     * 修改精品分类
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(CoinIndexJpfl coinIndexJpfl) {
        coinIndexJpflService.updateById(coinIndexJpfl);

        //删除缓存数据
        CacheUtil.remove(Cache.INDEX, CacheKey.WX_INDEX_JP+"2");
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
