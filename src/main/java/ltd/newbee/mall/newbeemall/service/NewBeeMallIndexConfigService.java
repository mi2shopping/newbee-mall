package ltd.newbee.mall.newbeemall.service;

import java.util.List;
import ltd.newbee.mall.newbeemall.entity.NewBeeMallGoods;

public interface NewBeeMallIndexConfigService {
	List<NewBeeMallGoods> getConfigGoodsesForIndex(int configType ,int number);
}