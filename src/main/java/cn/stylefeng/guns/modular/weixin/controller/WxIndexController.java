package cn.stylefeng.guns.modular.weixin.controller;

import cn.stylefeng.guns.modular.weixin.service.WxIndexService;
import cn.stylefeng.guns.modular.weixin.utils.ResultUtils;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 小程序首页
 * @Author: superC
 * @Date: 2018/11/13 22:09
 */
@RestController
@RequestMapping("/index")
public class WxIndexController {

    Logger logger = LoggerFactory.getLogger(WxIndexController.class);

    @Autowired
    private WxIndexService wxIndexService;

    /**
     * 获取轮播图列表
     */
    @ApiOperation(value="轮播图列表", httpMethod="GET", notes="获取轮播图列表",response=String.class)
    @GetMapping("/getLbList/{dataType}")
    public ResultUtils getLbList(@PathVariable("dataType") String dataType){
        ResultUtils result = new ResultUtils();
        List<Map<String,Object>> list = null;
        if(dataType.equals("1")){
            list = wxIndexService.getLbList();
            logger.info(list.toString());
        }else if(dataType.equals("2")){
            list = wxIndexService.getCoinLbList();
        }

        if(list!=null && list.size()>0){
            result = ResultUtils.ok(list);
        }else{
            result = ResultUtils.errorMsg("数据为空");
        }
        return result;
    }

    /**
     * 获取精品推荐列表
     */
    @ApiOperation(value="精品推荐列表", httpMethod="GET", notes="获取精品推荐列表",response=String.class)
    @GetMapping("/getJptjList/{dataType}")
    public ResultUtils getJptjList(@PathVariable("dataType") String dataType){
        ResultUtils result = new ResultUtils();
        List<Map<String,Object>> list = null;
        if(dataType.equals("1")){
            list = wxIndexService.getJptjList();
            logger.info(list.toString());
        }else if(dataType.equals("2")){
            list = wxIndexService.getCoinJptjList();
        }

        if(list!=null && list.size()>0){
            result = ResultUtils.ok(list);
        }else{
            result = ResultUtils.errorMsg("数据为空");
        }
        return result;
    }

    /**
     * 获取热门图片列表
     */
    @ApiOperation(value="热门图片列表", httpMethod="GET", notes="获取热门图片列表",response=String.class)
    @GetMapping("/getRmtpList")
    public ResultUtils getRmtpList(){
        ResultUtils result = new ResultUtils();
        List<Map<String,Object>> list = wxIndexService.getRmtpList();
        logger.info(list.toString());

        if(list!=null && list.size()>0){
            result = ResultUtils.ok(list);
        }else{
            result = ResultUtils.errorMsg("数据为空");
        }
        return result;
    }


    /**
     * 根据分类id，获取分类详情列表页
     *
     */
    @GetMapping("/searchDetailByGuid")
    public ResultUtils searchDetailByGuid(){
        ResultUtils result = new ResultUtils();

        return result;
    }



}
