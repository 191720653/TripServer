package com.zehao.util;

import com.zehao.constant.CONSTANT;

/**
 * < TODO：工具类 >
 * 
 * @ClassName: Tool
 * @author pc-hao
 * @date 2016年3月10日 上午11:16:57
 * @version V 1.0
 */
public class Tool {

	/**
	 * 非空校验，返回原字符串或者空白字符串 ""
	 * 
	 * @param source
	 * @return
	 */
	public static String NVL(String source) {
		return ((source == null) || (source.equals(CONSTANT.NULL_STRING)) ? CONSTANT.NULL_STRING
				: source);
	}

}
