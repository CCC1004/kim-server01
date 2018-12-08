package cn.stylefeng.guns.modular.coin.service.impl;

import cn.stylefeng.guns.modular.system.dao.CoinResourcesMapper;
import cn.stylefeng.guns.modular.system.model.CoinIndexJpfl;
import cn.stylefeng.guns.modular.system.dao.CoinIndexJpflMapper;
import cn.stylefeng.guns.modular.coin.service.ICoinIndexJpflService;
import cn.stylefeng.guns.modular.system.model.CoinResources;
import cn.stylefeng.guns.modular.system.model.KimIndexJptj;
import cn.stylefeng.guns.modular.system.model.KimResources;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 精品分类表 服务实现类
 * </p>
 *
 * @author superc
 * @since 2018-12-06
 */
@Service
public class CoinIndexJpflServiceImpl extends ServiceImpl<CoinIndexJpflMapper, CoinIndexJpfl> implements ICoinIndexJpflService {

    @Autowired
    private CoinIndexJpflMapper coinIndexJpflMapper;

    @Autowired
    private CoinResourcesMapper coinResourcesMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteByIdAndRes(String coinIndexJpflId) {
        CoinIndexJpfl coinIndexJpfl = this.baseMapper.selectById(coinIndexJpflId);
        boolean b = this.deleteById(coinIndexJpflId);
        if(b && ToolUtil.isNotEmpty(coinIndexJpfl.getFlImage())){
            CoinResources coinResources = coinResourcesMapper.selectById(coinIndexJpfl.getFlImage());
            if(ToolUtil.isNotEmpty(coinResources)){
                coinResourcesMapper.deleteById(coinIndexJpfl.getFlImage());
            }
        }
        return true;
    }

    @Override
    public List<Map<String, Object>> getCoinJptjPage(Page page, Wrapper<CoinIndexJpfl> wrapper) {
        return coinIndexJpflMapper.getCoinJptjPage(page);
    }
}
