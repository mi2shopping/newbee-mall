
package ltd.newbee.mall.newbeemall.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ltd.newbee.mall.newbeemall.dao.CarouselMapper;
import ltd.newbee.mall.newbeemall.entity.Carousel;
import ltd.newbee.mall.newbeemall.service.NewBeeMallCarouselService;
import ltd.newbee.mall.newbeemall.vo.NewBeeMallIndexCarouselVO;


@Service
public class NewBeeMallCarouselServiceImpl implements NewBeeMallCarouselService {

	@Resource
	private CarouselMapper carouselMapper;

	@Override
	public List<NewBeeMallIndexCarouselVO> getCarouselsForIndex(int number) {
		// TODO Auto-generated method stub
		
		List<Carousel> entityList = new ArrayList<>();
		entityList =carouselMapper.findCarouselsByNum(number);
		
		List<NewBeeMallIndexCarouselVO> url = new ArrayList<NewBeeMallIndexCarouselVO>();
		
		for(Carousel x : entityList) {
			
			NewBeeMallIndexCarouselVO vo = new NewBeeMallIndexCarouselVO();
			vo.setCarouselUrl(x.getCarouselUrl());
			vo.setRedirectUrl(x.getRedirectUrl());	
			url.add(vo);
			
		}
		return url;
	}
	
}
	/*
	 * private String carouselUrl;
	 * 
	 * private String redirectUrl;
	 */
	

