package cn.stylefeng.guns.modular.kim.controller;

import cn.stylefeng.guns.core.common.constant.cache.Cache;
import cn.stylefeng.guns.core.common.constant.cache.CacheKey;
import cn.stylefeng.guns.core.util.CacheUtil;
import cn.stylefeng.guns.modular.kim.utils.FileUtils;
import cn.stylefeng.guns.modular.kim.utils.GuidUtils;
import cn.stylefeng.guns.modular.system.model.KimResources;
import cn.stylefeng.guns.modular.system.service.IKimResourcesService;
import cn.stylefeng.guns.modular.weixin.properties.PathProperties;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.util.ToolUtil;
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
import cn.stylefeng.guns.modular.system.model.KimIndexJptj;
import cn.stylefeng.guns.modular.kim.service.IKimIndexJptjService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.tools.Tool;

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

    @Autowired
    private IKimResourcesService kimResourcesService;

    @Autowired
    private PathProperties pathProperties;

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
//        return PREFIX + "kimIndexJptj_add.html";
        return PREFIX + "kimIndexJptj_add2.html";
    }

    /**
     * 跳转到修改精品推荐
     */
    @RequestMapping("/kimIndexJptj_update/{kimIndexJptjId}")
    public String kimIndexJptjUpdate(@PathVariable String kimIndexJptjId, Model model) {
        KimIndexJptj kimIndexJptj = kimIndexJptjService.selectById(kimIndexJptjId);
        if(ToolUtil.isNotEmpty(kimIndexJptj.getJpImage())){
            KimResources kimResources = kimResourcesService.selectById(kimIndexJptj.getJpImage());
            if(ToolUtil.isNotEmpty(kimResources.getFilePath())){
                model.addAttribute("filePath",kimResources.getFilePath());
            }
        }
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
     * 新增精品推荐+上传图片
     */
    @RequestMapping(value = "/addJptj")
//    @ResponseBody
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public String addJptjAndUpload(@RequestParam("file") MultipartFile file,
                                   HttpServletRequest request,
                                   KimIndexJptj kimIndexJptj){
        /*
            上传图片
         */
        if(!file.isEmpty()){
            String kimPath = pathProperties.getKimPath();
            String filePath = FileUtils.singleUpload(file, request, kimPath);
            // 保存文件至数据库
            KimResources kimResources = FileUtils.saveKimResource(file, filePath);
            kimResourcesService.insert(kimResources);
            //设置图片资源guid
            kimIndexJptj.setJpImage(kimResources.getFileCd());
        }

        /*
          保存精品推荐信息
         */
        kimIndexJptj.setGuid(GuidUtils.getGuid());
        kimIndexJptj.setTs(GuidUtils.getCreateTime());

        kimIndexJptjService.insert(kimIndexJptj);

        //删除缓存数据
        CacheUtil.remove(Cache.INDEX, CacheKey.WX_INDEX_JP+"1");

//        return SUCCESS_TIP;
        return PREFIX + "kimIndexJptj_add2.html";
    }


    /**
     * 删除精品推荐
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String kimIndexJptjId) {
//        kimIndexJptjService.deleteById(kimIndexJptjId);
        kimIndexJptjService.deleteJptjAndRes(kimIndexJptjId);

        //删除缓存数据
        CacheUtil.remove(Cache.INDEX, CacheKey.WX_INDEX_JP+"1");
        return SUCCESS_TIP;
    }

    /**
     * 修改精品推荐
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(KimIndexJptj kimIndexJptj) {
        kimIndexJptjService.updateById(kimIndexJptj);

        //删除缓存数据
        CacheUtil.remove(Cache.INDEX, CacheKey.WX_INDEX_JP+"1");
        return SUCCESS_TIP;
    }

    /**
     * 精品推荐详情
     */
    @RequestMapping(value = "/detail/{kimIndexJptjId}")
    @ResponseBody
    public Object detail(@PathVariable("kimIndexJptjId") String kimIndexJptjId) {
        return kimIndexJptjService.selectById(kimIndexJptjId);
    }
}
