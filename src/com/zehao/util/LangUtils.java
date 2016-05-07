package com.zehao.util;

import java.lang.reflect.InvocationTargetException;

/**
 * 描述：数据处理工具类
 * 
 */
public class LangUtils {

	/**
	 * 为空的Long型对象型数组
	 */
	public static final Long[] EMPTY_LONG_OBJECT_ARRAY = new Long[0];

	/**
	 * String类型数组转化为Long行数组
	 * @param array String型数组
	 * @return Long型数组
	 */
	public static Long[] toLongArray( String[] array){
		if( array == null)
			return null;
		else if( array.length == 0)
			return EMPTY_LONG_OBJECT_ARRAY;
		final Long[] result = new Long[array.length];
		for(int i = 0; i < array.length; i++){
			result[i] = Long.parseLong(array[i]);
		}
		return result;
	}
	/**
	 * 判断String值是否是带有小数的数字
	 * @param str 待判断的String值
	 * @return 判断的结果的布尔值
	 */
	public static boolean isNumericDecimal(String str){
		int dot = str.indexOf('.');
		if( dot == str.length() - 1)
			return false;
		if( dot == -1){
			return isNumeric( str );
		}
		else{
			String[] array = str.split(".");
			if( array.length > 2)
				return false;
			if( !isNumeric( array[0]))
				return false;
			if( !isNumeric( array[1]))
				return false;
		}
		return true;
	}
	/**
	 * 判断一个字符是否是数字
	 * @param cs 待判断的字符
	 * @return 判断结果的布尔值
	 */
	public static boolean isNumeric(CharSequence cs){
		if( cs == null || cs.length() == 0)
			return false;
		int sz = cs.length();
		for( int i = 0; i < sz; i++){
			if( Character.isDigit( cs.charAt(i)) == false )
				return false;
		}
		return true;
	}
	/**
	 * 抛出运行时异常
	 * @param e 可抛出对象
	 * @return 运行时异常
	 */
	public static RuntimeException wrapThrow(Throwable e){
		if( e instanceof RuntimeException)
			return (RuntimeException ) e;
		if( e instanceof InvocationTargetException )
			return wrapThrow( ((InvocationTargetException)e).getTargetException());
		return new RuntimeException(e);
	}
	/**
	 * 去掉字符串首尾的单双引号
	 * @param str 待处理字符串
	 * @return 处理后的结果
	 */
	public static String cleanQuotationMarks(String str){
		if(str.startsWith("\"") || str.startsWith("'")){
			str = str.substring(1, str.length()-1);
		}
		if(str.endsWith("\"") || str.endsWith("'")) {
			str = str.substring(0, str.length()-2);
		}
		return str;
	}
}
