package cn.stylefeng.guns.modular.kim.service;

import cn.stylefeng.guns.modular.system.model.KimIndexLb;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 轮播图信息 服务类
 * </p>
 *
 * @author superc
 * @since 2018-11-24
 */
public interface IKimIndexLbService extends IService<KimIndexLb> {

    boolean deleteLbAndRes(String kimIndexLbId);
}
