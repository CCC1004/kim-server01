package cn.stylefeng.guns.modular.kim.controller;

import cn.stylefeng.guns.core.common.constant.cache.Cache;
import cn.stylefeng.guns.core.common.constant.cache.CacheKey;
import cn.stylefeng.guns.core.util.CacheUtil;
import cn.stylefeng.guns.modular.kim.utils.FileUtils;
import cn.stylefeng.guns.modular.kim.utils.GuidUtils;
import cn.stylefeng.guns.modular.system.model.KimIndexJptj;
import cn.stylefeng.guns.modular.system.model.KimResources;
import cn.stylefeng.guns.modular.system.service.IKimResourcesService;
import cn.stylefeng.guns.modular.weixin.properties.PathProperties;
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
import cn.stylefeng.guns.modular.system.model.KimIndexRmtp;
import cn.stylefeng.guns.modular.kim.service.IKimIndexRmtpService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

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

    @Autowired
    private IKimResourcesService kimResourcesService;

    @Autowired
    private PathProperties pathProperties;

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
    public String kimIndexRmtpUpdate(@PathVariable String kimIndexRmtpId, Model model) {
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
     * 新增精品推荐+上传图片
     */
    @RequestMapping(value = "/addRmtp")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public String addRmtpAndUpload(@RequestParam("img") MultipartFile imgFile,
                                   @RequestParam("headImg") MultipartFile headImgFile,
                                   HttpServletRequest request,
                                   KimIndexRmtp kimIndexRmtp){
        String kimPath = pathProperties.getKimPath();

        //上传图片
        if(!imgFile.isEmpty()){
            String imgFilePath = FileUtils.singleUpload(imgFile, request, kimPath);
            //保存文件至数据库
            KimResources imgKimResources = FileUtils.saveKimResource(imgFile,imgFilePath);
            kimResourcesService.insert(imgKimResources);
            //设置图片资源guid
            kimIndexRmtp.setRmImage(imgKimResources.getFileCd());
        }

        //上传头像
        if(!headImgFile.isEmpty()){
            String headImgFilePath = FileUtils.singleUpload(headImgFile, request, kimPath);
            //保存文件至数据库
            KimResources headKimResources = FileUtils.saveKimResource(headImgFile,headImgFilePath);
            kimResourcesService.insert(headKimResources);
            //设置图片资源guid
            kimIndexRmtp.setRmHeadImg(headKimResources.getFileCd());
        }

        /*
          保存热门图片信息
         */
        kimIndexRmtp.setGuid(GuidUtils.getGuid());
        kimIndexRmtp.setTs(GuidUtils.getCreateTime());

        kimIndexRmtpService.insert(kimIndexRmtp);

        //删除缓存数据
        CacheUtil.remove(Cache.INDEX, CacheKey.WX_INDEX_RM+"1");

        return PREFIX + "kimIndexRmtp_add.html";
    }


    /**
     * 删除热门图片
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String kimIndexRmtpId) {
        kimIndexRmtpService.deleteById(kimIndexRmtpId);

        //删除缓存数据
        CacheUtil.remove(Cache.INDEX, CacheKey.WX_INDEX_RM+"1");
        return SUCCESS_TIP;
    }

    /**
     * 修改热门图片
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(KimIndexRmtp kimIndexRmtp) {
        kimIndexRmtpService.updateById(kimIndexRmtp);

        //删除缓存数据
        CacheUtil.remove(Cache.INDEX, CacheKey.WX_INDEX_RM+"1");
        return SUCCESS_TIP;
    }

    /**
     * 热门图片详情
     */
    @RequestMapping(value = "/detail/{kimIndexRmtpId}")
    @ResponseBody
    public Object detail(@PathVariable("kimIndexRmtpId") String kimIndexRmtpId) {
        return kimIndexRmtpService.selectById(kimIndexRmtpId);
    }
}
