
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
public class NewBeeMallCategoryServiceImpl implements NewBeeMallCategoryService {

	@Resource
	private GoodsCategoryMapper GoodsCategoryMapper;

	@Override
	public List<NewBeeMallIndexCategoryVO> getCategoriesForIndex() {
		List<Long> lev1ParentsList= new ArrayList<Long>();
		lev1ParentsList.add(0l);
		List<GoodsCategory> lev1CateList= new ArrayList<GoodsCategory>();
		lev1CateList= GoodsCategoryMapper.selectByLevelAndParentIdsAndNumber(lev1ParentsList,1,100);
		 List<Long> cateList1= new ArrayList<Long>();
		 for(GoodsCategory gc: lev1CateList) {
			 cateList1.add(gc.getCategoryId());
			 
		 }
		List<GoodsCategory> lev2CateList=new ArrayList<GoodsCategory>();
		 
		lev2CateList = GoodsCategoryMapper.selectByLevelAndParentIdsAndNumber(cateList1, 2, 100);
		List<Long> cateList2=new ArrayList<Long>();
		for(GoodsCategory gc: lev2CateList) {
			cateList2.add(gc.getCategoryId());
			
			
		}
		List<GoodsCategory> lev3CateList=new ArrayList<GoodsCategory>();
		
		lev3CateList = GoodsCategoryMapper.selectByLevelAndParentIdsAndNumber(cateList2, 3,100);
		
		
		List<NewBeeMallIndexCategoryVO> rsList=new ArrayList<NewBeeMallIndexCategoryVO>();
		for (GoodsCategory gc :lev1CateList) {
			NewBeeMallIndexCategoryVO vo =new NewBeeMallIndexCategoryVO();
			
			vo.setCategoryId(gc.getCategoryId());
			vo.setCategoryLevel(gc.getCategoryLevel());
			vo.setCategoryName(gc.getCategoryName());	
			
			
			
			// 第二级别的category.parentID = gc.getCategoryId()
			List<SecondLevelCategoryVO> Level2CateVoList=new ArrayList<SecondLevelCategoryVO>();
			for(GoodsCategory gc2 : lev2CateList) {
				SecondLevelCategoryVO  levl2CateVo=new SecondLevelCategoryVO();
				if(gc2.getParentId()==gc.getCategoryId()) {
					levl2CateVo.setCategoryId(gc.getCategoryId());
					levl2CateVo.setCategoryLevel(gc2.getCategoryLevel());
					levl2CateVo.setCategoryName(gc2.getCategoryName());
					levl2CateVo.setParentId(gc2.getParentId());
					
					List<ThirdLevelCategoryVO> levl3VoList=new ArrayList<ThirdLevelCategoryVO>();
					for(GoodsCategory gc3:lev3CateList) {
						ThirdLevelCategoryVO levl3CateVo = new ThirdLevelCategoryVO(); 
						if(gc3.getParentId()==gc2.getCategoryId()) {
							levl3CateVo.setCategoryId(gc3.getCategoryId());
							levl3CateVo.setCategoryLevel(gc3.getCategoryLevel());
							levl3CateVo.setCategoryName(gc3.getCategoryName());
							levl3VoList.add(levl3CateVo);
							levl2CateVo.setThirdLevelCategoryVOS(levl3VoList);
						}
						
						
					}
					Level2CateVoList.add(levl2CateVo);
				}
				
				
			}
			vo.setSecondLevelCategoryVOS(Level2CateVoList);
			rsList.add(vo);
			}

	       return rsList;
}
}
