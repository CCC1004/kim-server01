package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.KimIndexRmtp;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 热门图片信息 Mapper 接口
 * </p>
 *
 * @author superc
 * @since 2018-11-24
 */
public interface KimIndexRmtpMapper extends BaseMapper<KimIndexRmtp> {

    List<Map<String, Object>> getRmtpList();
}
