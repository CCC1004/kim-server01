package cn.stylefeng.guns.modular.coin.service.impl;

import cn.stylefeng.guns.modular.system.dao.CoinResourcesMapper;
import cn.stylefeng.guns.modular.system.dao.KimResourcesMapper;
import cn.stylefeng.guns.modular.system.model.CoinIndexLb;
import cn.stylefeng.guns.modular.system.dao.CoinIndexLbMapper;
import cn.stylefeng.guns.modular.coin.service.ICoinIndexLbService;
import cn.stylefeng.guns.modular.system.model.CoinResources;
import cn.stylefeng.guns.modular.system.model.KimResources;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 轮播图信息 服务实现类
 * </p>
 *
 * @author superc
 * @since 2018-12-06
 */
@Service
public class CoinIndexLbServiceImpl extends ServiceImpl<CoinIndexLbMapper, CoinIndexLb> implements ICoinIndexLbService {

    @Autowired
    private CoinResourcesMapper coinResourcesMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteLbAndRes(String coinIndexLbId) {

        CoinIndexLb coinIndexLb = this.baseMapper.selectById(coinIndexLbId);
        boolean b = this.deleteById(coinIndexLbId);
        if(b && ToolUtil.isNotEmpty(coinIndexLb) && ToolUtil.isNotEmpty(coinIndexLb.getLbImage())){
            CoinResources coinResources = coinResourcesMapper.selectById(coinIndexLb.getLbImage());
            if(ToolUtil.isNotEmpty(coinResources)){
                coinResourcesMapper.deleteById(coinIndexLb.getLbImage());
            }
        }

    }

    @Override
    public List<Map<String, Object>> getCoinLbPage(Page page) {
        return this.baseMapper.getCoinLbPage(page);
    }
}
