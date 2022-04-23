package ltd.newbee.mall.newbeemall.service;

import java.util.List;

import ltd.newbee.mall.newbeemall.vo.NewBeeMallGoodsDetailVO;

public interface RescentCheckGoodsService {
	List<NewBeeMallGoodsDetailVO> getRescChkGoodses(long userId, int limit);
}