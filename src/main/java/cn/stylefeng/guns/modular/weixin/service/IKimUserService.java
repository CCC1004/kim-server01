package cn.stylefeng.guns.modular.weixin.service;

import cn.stylefeng.guns.modular.system.model.KimUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * kim小程序用户表 服务类
 * </p>
 *
 * @author superc
 * @since 2018-12-02
 */
public interface IKimUserService extends IService<KimUser> {

    KimUser loginCheck(String username, String password);

}
