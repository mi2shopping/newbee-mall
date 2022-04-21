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

@Controller
public class IndexController {
	@Resource
	private NewBeeMallIndexConfigService newBeeMallIndexConfigService;
	
	@Resource
	private NewBeeMallCategoryService newBeeMallCategoryService;
	
	@Resource
	private NewBeeMallCategoryService NewBeeMallCarouselService;
	
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
	
	
	@GetMapping("/Carousels")
    @ResponseBody
    public Result getCarousel() {
		
        return ResultGenerator.genSuccessResult(NewBeeMallCarouselService.getCategoriesForIndex());
    }
}