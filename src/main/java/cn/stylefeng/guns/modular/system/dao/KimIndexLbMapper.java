package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.KimIndexLb;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 轮播图信息 Mapper 接口
 * </p>
 *
 * @author superc
 * @since 2018-11-24
 */
public interface KimIndexLbMapper extends BaseMapper<KimIndexLb> {

    List<Map<String,Object>> getLbList();
}
