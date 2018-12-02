package cn.stylefeng.guns.modular.weixin.service.impl;

import cn.stylefeng.guns.modular.system.model.KimUser;
import cn.stylefeng.guns.modular.system.dao.KimUserMapper;
import cn.stylefeng.guns.modular.weixin.service.IKimUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * kim小程序用户表 服务实现类
 * </p>
 *
 * @author superc
 * @since 2018-12-02
 */
@Service
public class KimUserServiceImpl extends ServiceImpl<KimUserMapper, KimUser> implements IKimUserService {

    @Autowired
    private KimUserMapper kimUserMapper;

    @Override
    public KimUser loginCheck(String username, String password) {
        kimUserMapper.findByUsernameAndPassword(username, password);
        return null;
    }
}
