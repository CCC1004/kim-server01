package cn.stylefeng.guns.modular.coin.service.impl;

import cn.stylefeng.guns.modular.system.model.CoinKind;
import cn.stylefeng.guns.modular.system.dao.CoinKindMapper;
import cn.stylefeng.guns.modular.coin.service.ICoinKindService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
