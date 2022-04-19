package ltd.newbee.mall.newbeemall.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ltd.newbee.mall.newbeemall.dao.IndexConfigMapper;
import ltd.newbee.mall.newbeemall.entity.IndexConfig;
import ltd.newbee.mall.newbeemall.service.NewBeeMallIndexConfigService;

@Service
public class NewBeeMallIndexConfigServiceImpl implements NewBeeMallIndexConfigService {
	
	@Resource
    private IndexConfigMapper indexConfigMapper;
	
	@Override
	public List<IndexConfig> getConfigGoodsesForIndex(int configType,int number) {
		
		 List<IndexCongfig> idxConfList=indexConfigMapper.findIndexConfigsByTypeAndNum(configType, number);
		List<Long> ids=new ArrayList<Long>();
		for(IndexConfig e:idxConfList) {
			ids.add(e,getGoodsId());
			
		}
		return indexConfigMapper.selectByPrimarkeys(ids);
	}

}