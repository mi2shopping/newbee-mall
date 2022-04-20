package ltd.newbee.mall.newbeemall.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ltd.newbee.mall.newbeemall.dao.IndexConfigMapper;
import ltd.newbee.mall.newbeemall.entity.IndexConfig;
import ltd.newbee.mall.newbeemall.entity.NewBeeMallGoods;
import ltd.newbee.mall.newbeemall.service.NewBeeMallIndexConfigService;

@Service
public class NewBeeMallIndexConfigServiceImpl implements NewBeeMallIndexConfigService {
	

	@Resource
    private IndexConfigMapper indexConfigMapper;
	
	@Override
	public List<NewBeeMallGoods> getConfigGoodsesForIndex(int configType,int number) {
		
		List<IndexConfig> idxConfList = indexConfigMapper.findIndexConfigsByTypeAndNum(configType, number);
		
		List<Long> ids = new ArrayList<Long>();
		// List<IndexConfig> => List<Long>
		for(IndexConfig iConf : idxConfList) {
			ids.add(iConf.getGoodsId());
		}
		List<NewBeeMallGoods>entityList=indexConfigMapper.selectByPrimaryKeys(ids);
		for(NewBeeMallGoods x:entityList) {
			
		}
		
		return indexConfigMapper.selectByPrimaryKeys(ids);
	}

}

