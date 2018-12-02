package cn.stylefeng.guns.modular.kim.service.impl;

import cn.stylefeng.guns.modular.system.dao.KimResourcesMapper;
import cn.stylefeng.guns.modular.system.model.KimIndexLb;
import cn.stylefeng.guns.modular.system.dao.KimIndexLbMapper;
import cn.stylefeng.guns.modular.kim.service.IKimIndexLbService;
import cn.stylefeng.guns.modular.system.model.KimResources;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 轮播图信息 服务实现类
 * </p>
 *
 * @author superc
 * @since 2018-11-24
 */
@Service
public class KimIndexLbServiceImpl extends ServiceImpl<KimIndexLbMapper, KimIndexLb> implements IKimIndexLbService {

    @Autowired
    private KimResourcesMapper kimResourcesMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteLbAndRes(String kimIndexLbId) {
        KimIndexLb kimIndexLb = this.baseMapper.selectById(kimIndexLbId);
        boolean b = this.deleteById(kimIndexLbId);
        if(b && ToolUtil.isNotEmpty(kimIndexLb)){
            KimResources kimResources = kimResourcesMapper.selectById(kimIndexLb.getLbImage());
            if(ToolUtil.isNotEmpty(kimResources)){
                kimResourcesMapper.deleteById(kimIndexLb.getLbImage());
            }
        }

        return false;
    }
}
