package com.fire.action.manage;

import com.fire.po.Police;
import com.fire.po.PoliceStation;
import com.fire.po.User;
import com.fire.service.UserService;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fire.po.PoliceInfo;
import com.fire.service.PoliceManageService;

import java.util.List;

@Controller
public class PoliceManageAction {
	@Autowired
	PoliceManageService policeManageService;
	@Autowired
	UserService userService;

	// 客户端用户登录
	@RequestMapping("/login")
	@ResponseBody
	public JSONObject userLogin(String tel, String password) {

		JSONObject Result = new JSONObject();
		JSONObject jsonObject1 = new JSONObject();

		PoliceInfo police = policeManageService.findPoliceByName(tel);

		if (police != null) {
			if (police.getPassword().equals(password)) {
				// 登录成功
				police.setState("success");

				Result.put("result", police);
				return Result;

			} else {
				// 密码错误
				jsonObject1.put("state", "密码错误");
				Result.put("result", jsonObject1);
				return Result;
			}
		} else {
			// 用户名不存在
			jsonObject1.put("state", "用户名不存在");

			Result.put("result", jsonObject1);

			return Result;
		}

	}

	/**
	 * 得到警员列表
	 * @return
	 */
	public List<User> getPoliceList(){

		return null;
	}

	/**
	 * 得到派出所列表
	 * @return
	 */
	@RequestMapping(value = "getPoliceStationList")
	@ResponseBody
	public List<PoliceStation> getPoliceStationList(){
		return policeManageService.getPoliceStationList();
	}

	/**
	 * 增加警员
	 * @param user
	 */
	@RequestMapping("insertPolice")
	@ResponseBody
	public void insertPolice(User user){
		userService.insertPolice(user);
	}
}
