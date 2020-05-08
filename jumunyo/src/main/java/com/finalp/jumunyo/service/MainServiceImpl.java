package com.finalp.jumunyo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

@Repository
public class MainServiceImpl implements MainService {
	
	@Autowired
	SqlSessionTemplate my;

	@Override
	public List<UserVO> selectAll() {
		return  my.selectList("Main.selectAll");
	}

	
	// 자신의 이름이 적힌 주석 '사이에' 코드 적어주세요~
	
			//<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 이종명 start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
	 	
	 	
		 	//<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 이종명 end ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
		 	
		 	
			
		 	
		 	//<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 최원준 start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
		 	
		 	
		 	//<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 최원준 end ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
		 	
		 	
			
		 	
		 	//<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 이보라 start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
		 	
		 	
		 	//<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 이보라 end ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
		 	
		 	
			
		 	
		 	//<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 권세현 start ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
	
	@Override
	public List<CategoryVO> goentrance() {
		// db에서 카테고리 목록 대리고 입점신청 페이지로 이동
		return my.selectList("Main.goentrance");
	}
	
	@Override
	public void entrance_request(RestaurantVO rvo) {
		// 입점신청
		my.insert("Main.entrance_request", rvo);
	}


	@Override
	public List<QuestionVO> question_list(UserVO uuvo) {
		// 현재 접속한 사람의 1:1 문의 리스트 가져오기
		return my.selectList("Main.question_list",uuvo);
	}


	@Override
	public List<QuestionCategoryVO> getQuestionCategory() {
		// 문의 카테고리 리스트 전부 가져오기
		return my.selectList("Main.getQuestionCategory");
	}

	@Override
	public void question_send(QuestionVO qvo) {
		// 사장님이 관리자에게 문의보내기
		my.insert("Main.question_send",qvo);
		
	}

	@Override
	public List<OrderVO> dealorder_list(RestaurantVO rvo) {
		// 사장님 매장id값으로 거래내역 모두 출력
		return my.selectList("Main.dealorder_list",rvo);
	}


	@Override
	public List<OrderVO> order_search_detail(HashMap<String, Object> hm) {
		// 거래내역 조건 검색
		return my.selectList("Main.order_search_detail",hm);
	}


	@Override
	public List<MenuVO> menu_list(RestaurantVO rvo) {
		// 매장 id 값으로 매장 메뉴 전체 출력
		return my.selectList("Main.menu_list",rvo);
	}


	@Override
	public MenuVO go_menu_modify(MenuVO mvo) {
		// 메뉴의 id 값으로 메뉴의 정보를 들고 수정페이지로 이동
		return my.selectOne("Main.go_menu_modify",mvo);
	}


	@Override
	public void menu_add(MenuVO mvo) {
		// 메뉴추가 메소드
		my.insert("Main.menu_add",mvo);
	}


	@Override
	public void menu_modify(MenuVO mvo) {
		// 메뉴의 아이디 값으로 메뉴의 정보 수정
		my.update("Main.menu_modify",mvo);
		
	}


	@Override
	public void menu_delete(MenuVO mvo) {
		// 메뉴의 아이디 값으로 메뉴 삭제
		my.delete("Main.menu_delete",mvo);
		
	}


	@Override
	public List<RoomVO> go_roomlist(RestaurantVO rvo) {
		// 매장 id 값으로 매장 좌석정보 전부출력
		return my.selectList("Main.go_roomlist",rvo);
	}


	@Override
	public HashMap<String, Object[]> review_list(RestaurantVO rvo) {
		// 매장 id 값으로 해당 매장의 리뷰 전부 출력
		HashMap<String, Object[]> result = new HashMap<>(); // 매장의 리뷰와 그 리뷰의 댓글을 넣을 해쉬맵
		Object [] review_reply = {}; // result 해쉬맵에 담기위해 리뷰와 대응하는 리뷰댓글 넣을 배열
		System.out.println("서비스단  시작");
		List<ReviewVO> rvlist = my.selectList("Main.review_list",rvo);
		System.out.println("리뷰 리스트 부름");
		for(int i=0; i<rvlist.size(); i++) {
			int reviews_id = rvlist.get(i).getReview_id();
			ReplyVO rpvo = my.selectOne("Main.reply_one",reviews_id); // 리뷰의 아이디 값에 대응하는 리뷰 댓글 한개 가져오기
			System.out.println(rpvo.getReply_content());
			ReviewVO rvvo = rvlist.get(i);
			review_reply[0] = rvvo; // review_reply 배열에 각각 review 정보와
			review_reply[1] = rpvo; // 그에따른 댓글 정보를 담음
			
			result.put(""+i, review_reply);
		}
		System.out.println(result.get("1"));
		System.out.println(result.get("2"));
		System.out.println(result.get("3"));
		
		
		return result;
	}

	@Override
	public String room_delete(RoomVO rmvo) {
		// room id 값으로 해당 좌석 데이터 삭제
		RoomVO check = my.selectOne("Main.room_check", rmvo);
		
		if(check.getRoom_check()==1) {
			return "예약이 있는 테이블은 삭제 할 수 없습니다.";
		} else {
			my.update("Main.room_delete",rmvo);
			return "삭제완료";
		}
	}
	
	@Override
	public String room_modify(RoomVO rmvo) {
		// room id 값으로 해당 좌석 데이터 수정
		RoomVO check = my.selectOne("Main.room_check", rmvo);
		
		if(check.getRoom_check()==1) {
			return "예약이 있는 테이블은 수정 할 수 없습니다.";
		} else {
			my.update("Main.room_modify",rmvo);
			return "수정완료";
		}
	}


	@Override
	public void room_add(RoomVO rmvo) {
		// session 매장 id 값과 함께 매장 좌석 추가
		my.insert("Main.room_add",rmvo);
		
	}


	@Override
	public HashMap<String, Object[]> menu_sales_top(RestaurantVO rvo, int term_select, String date) {
		// session 에서 매장 id 값 가져와서 매출현황 페이지 최고매출 디폴트 값 출력(오늘 하루)
		String first_split [] = null;
		String second_split [] = null;

		Map<String, Integer> sales  = new HashMap<String, Integer>(); // 메뉴 별 수량 담는 맵
		Map<String, Integer> mount_price = new HashMap<String, Integer>();// 메뉴 별 총매출액 담는 맵
		HashMap<String, Object[]> name_img = new HashMap<String, Object[]>();// 메뉴 별 이미지와 이름 담는 맵
		HashMap<String, Object[]> result = new HashMap<String, Object[]>();// 메뉴 별 결과를 담는 맵
		
		SimpleDateFormat string_to_date = new SimpleDateFormat("yyyy-MM-dd"); // 날아온 date 값을  String -> date로 바꾸기위해
		SimpleDateFormat date_to_string = new SimpleDateFormat("yy-MM-dd"); // 정제한 date 값을 다시 xml에 날리기위해 String으로
		
		Date select_date = null; // date를 String 에서 date로 전환할때 담을 공간
		Date ago_date = null; // term 의 기간이 계산된 예전날짜를 넣을 공간
		String date_str = null; // xml에 보낼 date를 string 으로 담을 공간
		
		// 기준이될 select date , ago date 정제
		if(date != null) {
			try {
				select_date = string_to_date.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			ago_date = select_date;
			date_str = date_to_string.format(select_date);
		} else if(date == null) {
			select_date = new Date(System.currentTimeMillis());
			ago_date = new Date(System.currentTimeMillis());
			date_str = date_to_string.format(select_date);
		}
		
		HashMap<String, String> time = new HashMap<>();// xml에 term 조건 주기위해 해쉬맵 이용
		if(term_select==1) {
			time.put("term", "one");	//하루
		}else if(term_select==2) {
			ago_date.setDate(ago_date.getDate()-6);
			String ago_str = date_to_string.format(ago_date);
			
			time.put("ago_str", ago_str);
			time.put("term", "two");	//일주일
		}else if(term_select==3) {
			ago_date.setDate(ago_date.getDate()-29);
			String ago_str = date_to_string.format(ago_date);
			
			time.put("ago_str", ago_str);
			time.put("term", "two");	//한달
		}
		time.put("date_str", date_str);
		
		// 해당 term 동안의 날짜동안의 order 데이터 다 댈고오기
		List<OrderVO> ovol = my.selectList("Main.menu_sales_default", time);
		
		// menu id 를 키값으로 수량을 누적하는 hasp 맵 작성
		for(int i=0; i<ovol.size(); i++) {
			first_split = ovol.get(i).getMenu_list().split(",");
			
			for(int j=0; j<first_split.length; j++) {
				second_split = first_split[j].split("x");
				
				if(sales.containsKey(second_split[0])) {
					sales.put(second_split[0], (sales.get(second_split[0]) + Integer.parseInt(second_split[1])));
				} else {
					sales.put(second_split[0], Integer.parseInt(second_split[1]));
				}
			}
		}
		
		// 오늘 팔린 각각 메뉴의 수량x가격
		Set<String> keys = sales.keySet();

		for (String key : keys) {
			int value = sales.get(key); 
			MenuVO mvo = my.selectOne("Main.menu_price",key);
			Integer sum = mvo.getMenu_price()*value;
			mount_price.put(key,sum); // 총금액 맵 채우고
			
			Object [] nameimg = {mvo.getMenu_name(),mvo.getMenu_image()};
			name_img.put(key, nameimg); // 이미지랑 메뉴이름 맵 채우고
		}
		
		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(mount_price.entrySet());

		// 비교함수 Comparator를 사용하여 내림차순으로 정렬
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			// compare로 값을 비교
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				// 내림 차순 정렬
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
		
		// 마지막 result 맵에 담아서 controller로
		int count = 1;
		for(Entry<String, Integer> entry : list_entries) {
			Integer id = Integer.parseInt(entry.getKey());
			Object[] nameimg = name_img.get(entry.getKey());
			Object[] imsi = {id, entry.getValue(), sales.get(entry.getKey()), nameimg[0], nameimg[1]};
			// [메뉴의 id, 메뉴가격X수량, 메뉴의 수량]
			result.put(""+count, imsi);
			count++;
		}
		
		return result;
		
	}
	
	@Override
	public HashMap<String, Integer> menu_sales_time(RestaurantVO rvo, String sdate,String cdate) {
		// 시간대별 매출그래프 로직
		int a = 0; int A = 0; //09~10:59 소문자는 고른날, 대문자는 대비날짜
		int b = 0; int B = 0; //11~12:59
		int c = 0; int C = 0; //13~14:59
		int d = 0; int D = 0; //15~16:59 
		int e = 0; int E = 0; //17~18:59
		int f = 0; int F = 0; //19~20:59
		int g = 0; int G = 0; //21~22:59
		
		// xml 에 보낼 값을 담을 해쉬맵 생성
		HashMap<String, String> date_values = new HashMap<String, String>();
		HashMap<String, String> select_values = new HashMap<String, String>();
		
		SimpleDateFormat time_form_hour = new SimpleDateFormat("HH");
		SimpleDateFormat string_to_date = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat date_to_string = new SimpleDateFormat("yy-MM-dd");
		Date select_date = null; // select_date를 String 에서 date로 전환할때 담을 공간
		try {
			select_date = string_to_date.parse(sdate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		sdate = date_to_string.format(select_date);
		String compare_date ="";
		
		if(cdate.equals("없음")) {
			compare_date = date_to_string.format(select_date); //새롭게 정제된 cdate
		}else if(cdate.equals("전날")) {
			select_date.setDate(select_date.getDate()-1); // cdate 를 비교날짜에 맞는 date로 정제
			compare_date = date_to_string.format(select_date);
		}else if(cdate.equals("일주일")) {
			select_date.setDate(select_date.getDate()-6);
			compare_date = date_to_string.format(select_date);
		}else if(cdate.equals("한달")) {
			select_date.setDate(select_date.getDate()-29);
			compare_date = date_to_string.format(select_date);
		}
		date_values.put("sdate", sdate); 
		date_values.put("compare_date",compare_date);
		select_values.put("sdate", sdate);
		
		// 받아온 날짜의 시간대별로 뽑기
		List<OrderVO> ovol_select = my.selectList("Main.menu_sales_graph_select",select_values); // 정한날짜 데이터
		List<OrderVO> ovol_compare = my.selectList("Main.menu_sales_graph_compare", date_values); // 대비 데이터	
		
		// 고른날짜의 시간별 매출액정제
		for(int i=0;i<ovol_select.size();i++) {
			String time_str = time_form_hour.format(ovol_select.get(i).getOrder_date());
			int time_int = Integer.parseInt(time_str);
			time_str = Integer.toString((time_int+1)/2);
			// switch 문을 간결하게 하기위해 시간값 정제
			switch (time_str) {
			
			case "5":
				a = a + ovol_select.get(i).getOrder_price();
				break;
			case "6":
				b = b + ovol_select.get(i).getOrder_price();
				break;
			case "7":
				c = c + ovol_select.get(i).getOrder_price();
				break;
			case "8":
				d = d + ovol_select.get(i).getOrder_price();
				break;
			case "9":
				e = e + ovol_select.get(i).getOrder_price();
				break;
			case "10":
				f = f + ovol_select.get(i).getOrder_price();
				break;
			case "11":
				g = g + ovol_select.get(i).getOrder_price();
				break;
			}
		}
		HashMap<String, Integer> time_sales = new HashMap<>();
		time_sales.put("1", a);
		time_sales.put("2", b);
		time_sales.put("3", c);
		time_sales.put("4", d);
		time_sales.put("5", e);
		time_sales.put("6", f);
		time_sales.put("7", g);
		
		// 비교날짜의 시간별 매출액정제
		for(int i=0;i<ovol_compare.size();i++) {
			String time_str = time_form_hour.format(ovol_compare.get(i).getOrder_date());
			int time_int = Integer.parseInt(time_str);
			time_str = Integer.toString((time_int+1)/2);
			// switch 문을 간결하게 하기위해 시간값 정제
			switch (time_str) {
					
			case "5":
				A = A + ovol_compare.get(i).getOrder_price();
				break;
			case "6":
				B = B + ovol_compare.get(i).getOrder_price();
				break;
			case "7":
				C = C + ovol_compare.get(i).getOrder_price();
				break;
			case "8":
				D = D + ovol_compare.get(i).getOrder_price();
				break;
			case "9":
				E = E + ovol_compare.get(i).getOrder_price();
				break;
			case "10":
				F = F + ovol_compare.get(i).getOrder_price();
				break;
			case "11":
				G = G + ovol_compare.get(i).getOrder_price();
				break;
			}	
		}
		if(cdate.equals("없음")) {
			A=0; B=0; C=0; D=0; E=0; F=0; G=0;
		}if(cdate.equals("일주일")) {
			A = A/7; B = B/7; C = C/7; D = D/7;
			E = E/7; F = F/7; G = G/7;
		}if(cdate.equals("한달")) {
			A = A/30; B = B/30; C = C/30; D = D/30;
			E = E/30; F = F/30; G = G/30;
		}
		time_sales.put("11", A);
		time_sales.put("12", B);
		time_sales.put("13", C);
		time_sales.put("14", D);
		time_sales.put("15", E);
		time_sales.put("16", F);
		time_sales.put("17", G);
		return time_sales;
		
	}
	
	
		 	//<!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 권세현 end ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->

}
