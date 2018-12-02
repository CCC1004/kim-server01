package cn.stylefeng.guns.modular.kim.service;

import cn.stylefeng.guns.modular.system.model.KimIndexJptj;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 精品推荐表 服务类
 * </p>
 *
 * @author superc
 * @since 2018-11-24
 */
public interface IKimIndexJptjService extends IService<KimIndexJptj> {

    boolean deleteJptjAndRes(String kimIndexJptjId);
}
