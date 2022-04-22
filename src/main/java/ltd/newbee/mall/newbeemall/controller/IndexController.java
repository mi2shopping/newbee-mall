package ltd.newbee.mall.newbeemall.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ltd.newbee.mall.newbeemall.service.NewBeeMallCategoryService;
import ltd.newbee.mall.newbeemall.service.NewBeeMallIndexConfigService;
import ltd.newbee.mall.newbeemall.util.Result;
import ltd.newbee.mall.newbeemall.util.ResultGenerator;
import ltd.newbee.mall.newbeemall.service.NewBeeMallCarouselService;
import ltd.newbee.mall.newbeemall.entity.MallUser;
import ltd.newbee.mall.newbeemall.service.CheckUserExistsService;
@Controller
public class IndexController {
	@Resource
	private NewBeeMallIndexConfigService newBeeMallIndexConfigService;
	
	@Resource
	private NewBeeMallCategoryService newBeeMallCategoryService;
	
	@Resource
	private NewBeeMallCarouselService newBeeMallCarouselService;
	
	@Resource
	private CheckUserExistsService checkUserExistsService;
	
	@GetMapping("/goodses")
    @ResponseBody
    public Result getGooodses(int configType) {
		
        return ResultGenerator.genSuccessResult(newBeeMallIndexConfigService.getConfigGoodsesForIndex(configType, 5));
    }
	
	@GetMapping("/categories")
    @ResponseBody
    public Result getCategories() {
		
        return ResultGenerator.genSuccessResult(newBeeMallCategoryService.getCategoriesForIndex());
    }
	
	
	@GetMapping("/carousels")
    @ResponseBody
    public Result getCarousel(int number) {
		
        return ResultGenerator.genSuccessResult(newBeeMallCarouselService.getCarouselsForIndex(number));
    }
	
	@GetMapping("/user")
    @ResponseBody
    public Result user(long userId) {
		//MallUser user = checkUserExistsService.checkUserExists(userId);
		int count = checkUserExistsService.checkUserExistsReturnCount(userId);
		if(count == 0 ) {
			return ResultGenerator.genFailResult("failed");
		}else {
			return ResultGenerator.genSuccessResult("success");
			//List<vo> = xxxService.xxxMethod();
			//return List
		}

    }
}