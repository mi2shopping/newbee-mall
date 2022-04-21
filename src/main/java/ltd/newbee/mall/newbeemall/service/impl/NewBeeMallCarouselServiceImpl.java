
package ltd.newbee.mall.newbeemall.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ltd.newbee.mall.newbeemall.dao.GoodsCategoryMapper;
import ltd.newbee.mall.newbeemall.entity.GoodsCategory;

import ltd.newbee.mall.newbeemall.service.NewBeeMallCategoryService;
import ltd.newbee.mall.newbeemall.vo.SecondLevelCategoryVO;
import ltd.newbee.mall.newbeemall.vo.NewBeeMallIndexCategoryVO;
import ltd.newbee.mall.newbeemall.vo.ThirdLevelCategoryVO;

@Service
public class NewBeeMallCarouselServiceImpl implements NewBeeMallCarouselService {

	@Resource
	private CarouselMapper carouselMapper;

	@Override
	public List<NewBeeMallIndexCarouselVO> getCategoriesForIndex(int num) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
