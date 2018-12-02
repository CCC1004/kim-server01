package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.KimUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * kim小程序用户表 Mapper 接口
 * </p>
 *
 * @author superc
 * @since 2018-12-02
 */
public interface KimUserMapper extends BaseMapper<KimUser> {

    KimUser findByUsernameAndPassword(@Param("username") String username,
                                      @Param("password") String password);
}
