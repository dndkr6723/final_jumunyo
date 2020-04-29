package com.finalp.jumunyo.service;

import java.util.HashMap;
import java.util.List;

import com.finalp.jumunyo.vo.CategoryVO;
import com.finalp.jumunyo.vo.MenuVO;
import com.finalp.jumunyo.vo.OrderVO;
import com.finalp.jumunyo.vo.QuestionCategoryVO;
import com.finalp.jumunyo.vo.QuestionVO;
import com.finalp.jumunyo.vo.ReplyVO;
import com.finalp.jumunyo.vo.RestaurantVO;
import com.finalp.jumunyo.vo.ReviewVO;
import com.finalp.jumunyo.vo.RoomVO;
import com.finalp.jumunyo.vo.UserVO;

public interface MainService {
	
	public List<UserVO> selectAll();
	
	// 자신의 이름이 적힌 주석 '사이에' 코드 적어주세요~
	
		//<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 이종명 start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
 	
 	
	 	//<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 이종명 end ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
	 	
	 	
		
	 	
	 	//<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 최원준 start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
	 	
	 	
	 	//<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 최원준 end ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
	 	
	 	
		
	 	
	 	//<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 이보라 start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
	 	
	 	
	 	//<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 이보라 end ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
	 	
	 	
		
	 	
	 	//<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 권세현 start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
	
	public List<CategoryVO> goentrance();
	
	public void entrance_request(RestaurantVO rvo);
	
	public List<QuestionVO> question_list(UserVO uuvo);
	
	public List<QuestionCategoryVO> getQuestionCategory();
	
	public void question_send(QuestionVO qvo);
	
	public List<OrderVO> dealorder_list(RestaurantVO rvo);
	
	public List<OrderVO> order_search_detail(HashMap<String, Object> hm);
	
	public List<MenuVO> menu_list(RestaurantVO rvo);
	
	public MenuVO go_menu_modify(MenuVO mvo);
	
	public void menu_add(MenuVO mvo);
	
	public void menu_modify(MenuVO mvo);
	
	public void menu_delete(MenuVO mvo);
	
	public List<RoomVO> go_roomlist(RestaurantVO rvo);
	
	public List<ReviewVO> review_list(RestaurantVO rvo);
	
	public List<ReplyVO> reply_list(RestaurantVO rvo);
	
	
	 	//<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 권세현 end ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->

}