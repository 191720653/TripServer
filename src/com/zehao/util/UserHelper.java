package com.zehao.util;

import java.util.HashMap;

import com.zehao.model.Users;

/**
 * 
 * @author zehao
 * 此类为工具类，主要用来缓存用户每次登录后的相关信息
 *
 */

public class UserHelper {
	
	public static HashMap<String,Users> users_map = new HashMap<String,Users>();
	
	/**
	 * 根据用户每次登录后绑定的唯一Id返回缓存用户的信息
	 * @param token
	 * @return
	 */
	public static Users findUsers(String token){
		return users_map.get(token);
	}
	/**
	 * 用户登录后，缓存用户的信息
	 * @param user
	 * @return
	 */
	public synchronized static boolean addUsers(Users users){
		users_map.put(users.getToken(), users);
		return Boolean.TRUE;
	}
	/**
	 * 用户下线后，删除缓存的用户信息
	 * @param token
	 * @return
	 */
	public synchronized static boolean deleteUsers(String token){
		users_map.remove(token);
		return Boolean.TRUE;
	}
	/**
	 * 用户是否登录
	 * @param token
	 * @return
	 */
	public synchronized static boolean hasUsers(String token){
		return users_map.containsKey(token);
	}
	/**
	 * 返回在线的用户人数
	 * @return
	 */
	public static int size(){
		return users_map.size();
	}
	
	public static HashMap<String, Users> getMap(){
		return users_map;
	}

}
