package ltd.newbee.mall.newbeemall.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ltd.newbee.mall.newbeemall.dao.RescentCheckGoodsMapper;
import ltd.newbee.mall.newbeemall.entity.NewBeeMallGoods;
import ltd.newbee.mall.newbeemall.service.RescentCheckGoodsService;
import ltd.newbee.mall.newbeemall.vo.NewBeeMallGoodsDetailVO;

@Service
public class RescentCheckGoodsServiceImpl implements RescentCheckGoodsService {

	@Resource
	RescentCheckGoodsMapper rescentCheckGoodsMapper;

	@Override
	public List<NewBeeMallGoodsDetailVO> getRescChkGoodses(long userId, int limit) {

		List<NewBeeMallGoodsDetailVO> list = new ArrayList<NewBeeMallGoodsDetailVO>();

		List<NewBeeMallGoods> eList = rescentCheckGoodsMapper.getRescentCheckGoodses(userId, limit);

		if (eList != null) {
			for (NewBeeMallGoods newBeeMallGoods : eList) {
				NewBeeMallGoodsDetailVO vo = new NewBeeMallGoodsDetailVO();
				vo.setGoodsId(newBeeMallGoods.getGoodsId());
				
				vo.setGoodsName(newBeeMallGoods.getGoodsName());
				
				vo.setOriginalPrice(newBeeMallGoods.getOriginalPrice());
				
				list.add(vo);
			}
		}

		return list;

	}
}