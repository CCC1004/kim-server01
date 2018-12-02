package cn.stylefeng.guns.modular.kim.controller;

import cn.stylefeng.guns.modular.kim.utils.FileUtils;
import cn.stylefeng.guns.modular.kim.utils.GuidUtils;
import cn.stylefeng.guns.modular.system.model.KimIndexJptj;
import cn.stylefeng.guns.modular.system.model.KimResources;
import cn.stylefeng.guns.modular.system.service.IKimResourcesService;
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
import cn.stylefeng.guns.modular.system.model.KimIndexLb;
import cn.stylefeng.guns.modular.kim.service.IKimIndexLbService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 轮播图控制器
 *
 * @author fengshuonan
 * @Date 2018-11-24 14:37:10
 */
@Controller
@RequestMapping("/kimIndexLb")
public class KimIndexLbController extends BaseController {

    private String PREFIX = "/kim/kimIndexLb/";

    @Autowired
    private IKimIndexLbService kimIndexLbService;


    @Autowired
    private IKimResourcesService kimResourcesService;

    /**
     * 跳转到轮播图首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "kimIndexLb.html";
    }

    /**
     * 跳转到添加轮播图
     */
    @RequestMapping("/kimIndexLb_add")
    public String kimIndexLbAdd() {
        return PREFIX + "kimIndexLb_add.html";
    }

    /**
     * 跳转到修改轮播图
     */
    @RequestMapping("/kimIndexLb_update/{kimIndexLbId}")
    public String kimIndexLbUpdate(@PathVariable String kimIndexLbId, Model model) {
        KimIndexLb kimIndexLb = kimIndexLbService.selectById(kimIndexLbId);
        model.addAttribute("item",kimIndexLb);
        LogObjectHolder.me().set(kimIndexLb);
        return PREFIX + "kimIndexLb_edit.html";
    }

    /**
     * 获取轮播图列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return kimIndexLbService.selectList(null);
    }

    /**
     * 新增轮播图
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(KimIndexLb kimIndexLb) {
        kimIndexLbService.insert(kimIndexLb);
        return SUCCESS_TIP;
    }


    /**
     * 新增轮播图信息+上传图片
     */
    @RequestMapping(value = "/addLb")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public String addJptjAndUpload(@RequestParam("file") MultipartFile file,
                                   HttpServletRequest request,
                                   KimIndexLb kimIndexLb){
        /*
            上传图片
         */
        String filePath = FileUtils.singleUpload(file, request);

        /*
            保存文件至数据库
         */
        KimResources kimResources = new KimResources();
        kimResources.setFileCd(GuidUtils.getGuid());
        //图片名字
        String fileName = file.getOriginalFilename();
        kimResources.setFileNm(fileName);
        //资源类型，图片为2
        kimResources.setMulTp("2");

        //图片类型
        String contentType = file.getContentType();
        kimResources.setFileExt(contentType);
        kimResources.setFilePath(filePath);
        kimResources.setTs(GuidUtils.getCreateTime());
        kimResourcesService.insert(kimResources);

        /*
          保存精品推荐信息
         */
        kimIndexLb.setGuid(GuidUtils.getGuid());
        kimIndexLb.setTs(GuidUtils.getCreateTime());
        //设置图片资源guid
        kimIndexLb.setLbImage(kimResources.getFileCd());
        kimIndexLbService.insert(kimIndexLb);

//        return SUCCESS_TIP;
        return PREFIX + "kimIndexLb_add.html";
    }



    /**
     * 删除轮播图
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String kimIndexLbId) {
        kimIndexLbService.deleteById(kimIndexLbId);
        kimIndexLbService.deleteLbAndRes(kimIndexLbId);
        return SUCCESS_TIP;
    }

    /**
     * 修改轮播图
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(KimIndexLb kimIndexLb) {
        kimIndexLbService.updateById(kimIndexLb);
        return SUCCESS_TIP;
    }

    /**
     * 轮播图详情
     */
    @RequestMapping(value = "/detail/{kimIndexLbId}")
    @ResponseBody
    public Object detail(@PathVariable("kimIndexLbId") String kimIndexLbId) {
        return kimIndexLbService.selectById(kimIndexLbId);
    }
}
