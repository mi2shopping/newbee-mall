package ltd.newbee.mall.newbeemall.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ltd.newbee.mall.newbeemall.dao.IndexConfigMapper;
import ltd.newbee.mall.newbeemall.entity.IndexConfig;
import ltd.newbee.mall.newbeemall.entity.NewBeeMallGoods;
import ltd.newbee.mall.newbeemall.service.NewBeeMallIndexConfigService;
import ltd.newbee.mall.newbeemall.vo.NewBeeMallGoodsDetailVO;
import ltd.newbee.mall.newbeemall.vo.NewBeeMallIndexCategoryVO;

@Service
public class NewBeeMallIndexConfigServiceImpl implements NewBeeMallIndexConfigService {

	@Resource
	private IndexConfigMapper indexConfigMapper;

	@Override
	public List<NewBeeMallGoodsDetailVO> getConfigGoodsesForIndex(int configType, int number) {

		List<IndexConfig> idxConfList = indexConfigMapper.findIndexConfigsByTypeAndNum(configType, number);

		List<Long> ids = new ArrayList<Long>();
		// List<IndexConfig> => List<Long>
		for (IndexConfig iConf : idxConfList) {
			ids.add(iConf.getGoodsId());
		}
		List<NewBeeMallGoods> entityList = indexConfigMapper.selectByPrimaryKeys(ids);

		List< NewBeeMallGoodsDetailVO> voList = new ArrayList<NewBeeMallGoodsDetailVO>();

		for (NewBeeMallGoods x : entityList) {
			NewBeeMallGoodsDetailVO vo = new NewBeeMallGoodsDetailVO();
			vo.setGoodsId(x.getGoodsId());
			
			vo.setGoodsName(x.getGoodsName());
			
			vo.setGoodsIntro(x.getGoodsIntro());
			
			vo.setGoodsCoverImg(x.getGoodsCoverImg());
			
			vo.setSellingPrice(x.getSellingPrice());
			
			String name = vo.getGoodsName();
			
			if (name.length() > 30) {
				vo.setGoodsName(name.substring(0,30) + "...");
			}
			
			voList.add(vo);
		}
					
		return voList;		
	}
		@Override
		
		public List<NewBeeMallIndexCategoryVO> getCategoriesForIndex(){
			
			
			
			return null;
		}
	}


