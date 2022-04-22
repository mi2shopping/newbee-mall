package ltd.newbee.mall.newbeemall.service;

import java.util.List;

import ltd.newbee.mall.newbeemall.entity.MallUser;

public interface CheckUserExistsService {
	MallUser checkUserExists(Long userId);
	
	int checkUserExistsReturnCount(Long userId);
}