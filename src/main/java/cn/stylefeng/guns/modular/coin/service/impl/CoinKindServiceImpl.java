package cn.stylefeng.guns.modular.coin.service.impl;

import cn.stylefeng.guns.modular.system.dao.CoinResourcesMapper;
import cn.stylefeng.guns.modular.system.model.CoinKind;
import cn.stylefeng.guns.modular.system.dao.CoinKindMapper;
import cn.stylefeng.guns.modular.coin.service.ICoinKindService;
import cn.stylefeng.guns.modular.system.model.CoinResources;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 品种信息表 服务实现类
 * </p>
 *
 * @author superc
 * @since 2018-12-07
 */
@Service
public class CoinKindServiceImpl extends ServiceImpl<CoinKindMapper, CoinKind> implements ICoinKindService {

    @Autowired
    private CoinResourcesMapper coinResourcesMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteKindAndRes(String coinKindId) {

        CoinKind coinKind = this.baseMapper.selectById(coinKindId);
        boolean b = this.deleteById(coinKindId);
        if(b && ToolUtil.isNotEmpty(coinKind)){
            if(ToolUtil.isNotEmpty(coinKind.getKindImage())){
                CoinResources coinResources = coinResourcesMapper.selectById(coinKind.getKindImage());
                if(ToolUtil.isNotEmpty(coinResources)){
                    coinResourcesMapper.deleteById(coinKind.getKindImage());
                }
            }
            if(ToolUtil.isNotEmpty(coinKind.getKindImage2())){
                CoinResources coinResources = coinResourcesMapper.selectById(coinKind.getKindImage2());
                if(ToolUtil.isNotEmpty(coinResources)){
                    coinResourcesMapper.deleteById(coinKind.getKindImage2());
                }
            }
            if(ToolUtil.isNotEmpty(coinKind.getKindImage3())){
                CoinResources coinResources = coinResourcesMapper.selectById(coinKind.getKindImage3());
                if(ToolUtil.isNotEmpty(coinResources)){
                    coinResourcesMapper.deleteById(coinKind.getKindImage3());
                }
            }
            if(ToolUtil.isNotEmpty(coinKind.getKindImage4())){
                CoinResources coinResources = coinResourcesMapper.selectById(coinKind.getKindImage4());
                if(ToolUtil.isNotEmpty(coinResources)){
                    coinResourcesMapper.deleteById(coinKind.getKindImage4());
                }
            }
            return true;
        }else{
            return false;
        }

    }
}
