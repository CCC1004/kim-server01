package cn.stylefeng.guns.modular.weixin.controller;

import cn.stylefeng.guns.core.common.constant.cache.Cache;
import cn.stylefeng.guns.core.common.constant.cache.CacheKey;
import cn.stylefeng.guns.modular.weixin.service.WxIndexService;
import cn.stylefeng.guns.modular.weixin.utils.ResultUtils;
import cn.stylefeng.roses.core.util.ToolUtil;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

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
     *  获取轮播图列表
     * @param dataType 数据类型：1：kim; 2:coin
     * @return
     */
    @ApiOperation(value="轮播图列表", httpMethod="GET", notes="获取轮播图列表",response=String.class)
    @GetMapping("/getLbList/{dataType}")
    public ResultUtils getLbList(@PathVariable("dataType") String dataType){
        ResultUtils result = new ResultUtils();
        List<Map<String,Object>> list = wxIndexService.getLbList(dataType);

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
        List<Map<String,Object>> list = wxIndexService.getJptjList(dataType);

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
    @Cacheable(value = Cache.INDEX, key = "'" + CacheKey.WX_INDEX_RM + "'+#dataType")
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
     * 根据分类id，获取品种列表页
     * @param flid 分类id
     * @return
     */
    @GetMapping("/searchKindListByflid")
    public ResultUtils searchKindListByflid(@RequestParam("flid") String flid){
        ResultUtils result = new ResultUtils();

        if(ToolUtil.isNotEmpty(flid)){
            List<Map<String,Object>> list = wxIndexService.searchKindListByflid(flid);

            if(list!=null && list.size()>0){
                result = ResultUtils.ok(list);
            }else{
                result = ResultUtils.errorMsg("数据为空");
            }
        }

        return result;
    }



}
