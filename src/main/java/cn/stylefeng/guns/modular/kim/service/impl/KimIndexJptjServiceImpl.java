package cn.stylefeng.guns.modular.kim.service.impl;

import cn.stylefeng.guns.modular.system.dao.KimResourcesMapper;
import cn.stylefeng.guns.modular.system.model.KimIndexJptj;
import cn.stylefeng.guns.modular.system.dao.KimIndexJptjMapper;
import cn.stylefeng.guns.modular.kim.service.IKimIndexJptjService;
import cn.stylefeng.guns.modular.system.model.KimResources;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 精品推荐表 服务实现类
 * </p>
 *
 * @author superc
 * @since 2018-11-24
 */
@Service
public class KimIndexJptjServiceImpl extends ServiceImpl<KimIndexJptjMapper, KimIndexJptj> implements IKimIndexJptjService {

    @Autowired
    private KimResourcesMapper kimResourcesMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteJptjAndRes(String kimIndexJptjId) {
        KimIndexJptj kimIndexJptj = this.baseMapper.selectById(kimIndexJptjId);
        boolean b = this.deleteById(kimIndexJptjId);
        if(b && ToolUtil.isNotEmpty(kimIndexJptj.getJpImage())){
            KimResources kimResources = kimResourcesMapper.selectById(kimIndexJptj.getJpImage());
            if(ToolUtil.isNotEmpty(kimResources)){
                kimResourcesMapper.deleteById(kimIndexJptj.getJpImage());
            }
        }
        return true;
    }
}
