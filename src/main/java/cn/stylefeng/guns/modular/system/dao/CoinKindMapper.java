package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.CoinKind;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 品种信息表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-08
 */
public interface CoinKindMapper extends BaseMapper<CoinKind> {

    List<Map<String, Object>> searchKindListByflid(@Param("flid") String flid);

    List<Map<String, Object>> selectKindPage(@Param("page") Page page,
                                             @Param("kindName") String kindName,
                                             @Param("kindValue") String kindValue,
                                             @Param("flId") String flId
    );
}
