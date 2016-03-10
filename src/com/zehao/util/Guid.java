package com.zehao.util;

import java.util.UUID;

/**
 * 
 * @author zehao
 * 此类主要用来返回一个永不重复的Id
 * 
 */

public class Guid {
	
	public static String produceGuid(){
		UUID uuid = UUID.randomUUID();  				 //生成guid
		String id = uuid.toString();    				 //将guid转变为字符串
		id = id.toUpperCase().replace("-", "");          //将小写字母转为大写
		return id;                      				 //返回生成的id
	}
	
	/*public static void main(String args[]){
		System.out.println(Guid.produceGuid());
	}*/
	
}
