package com.zehao.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class DateUtils {

	/**
	 * 每小时分钟数
	 */
	public static final int MINUTES_PER_HOUR = 60;
	
	/**
	 * 日期格式"y-M-d H:m:s.S"
	 */
	private static final DateFormat DF_DATE_TIME_MS = new SimpleDateFormat( "y-M-d H:m:s.S");
	/**
	 * 日期格式"yyyy-MM-dd HH:mm:ss"
	 */
	private static final DateFormat DF_DATE_TIME = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
	/**
	 * 日期格式"yyyy-MM-dd"
	 */
	private static final DateFormat DF_DATE = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 日期格式"yyyy/MM/dd"
	 */
	private static final DateFormat DF_DATE_SLASH = new SimpleDateFormat( "yyyy/MM/dd");
	/**
	 * 日期格式"yyyy-MM"
	 */
	private static final DateFormat DF_YEAR_MONTH = new SimpleDateFormat( "yyyy-MM");

	public static Date now() {
		return new Date(System.currentTimeMillis());
	}

	/**
	 * 验证字符串是否为yyyy-MM-dd格式的日期
	 * @param dateString 需处理字符串
	 * @return 正确与否
	 */
	public static boolean isValidDate(String dateString) {
		try {
			Date date = parse(DF_DATE, dateString);
			return date != null;
		} catch (ParseException e) {
			return false;
		}
	}

	/**
	 * 日期转换
	 * @param year 年
	 * @param month	月
	 * @param date 日
	 * @return 日期
	 */
	public static Date parse(String year, String month, String date) {
		StringBuffer sb = new StringBuffer(year + "-" + month);
		String dateString;
		if (date == null || date.length() == 0) {
			sb.append("-1");
			dateString = sb.toString();
		} else {
			sb.append("-" + date);
			dateString = sb.toString();
		}
		return formatStringToDate(dateString);
	}

	/**
	 * 将日期转换成字符串
	 * @param date 需处理的日期
	 * @return	日期字符串
	 */
	public static String formatDateToMS(Date date) {
		return parse(DF_DATE_TIME_MS, date);
	}

	/**
	 * 将日期转换成字符串
	 * @param date 需处理的日期
	 * @return	日期字符串
	 */
	public static String formatDateToString(Date date) {
		return parse(DF_DATE, date);
	}

	/**
	 * 将字符串转换成日期
	 * @param date 需处理的字符串
	 * @return	日期对象
	 */
	public static Date formatStringToDate(String date) {
		if (date.length() < 12) {
			return parseWithoutException(DF_DATE, date);
		}
		return parseWithoutException(DF_DATE_TIME, date);
	}

	/**
	 * 是否是过去日期
	 * @param date 日期字符串
	 * @return boolean值
	 */
	public static boolean isBeforeNow(String date) {
		return isBeforeNow(formatStringToDate(date));
	}

	/**
	 * 是否是过去日期
	 * @param date 日期对象
	 * @return	boolean值
	 */
	public static boolean isBeforeNow(Date date) {
		return isAfter(new Date(), date);
	}

	/**
	 * 比较日期先后顺序
	 * @param aDate 字符串型日期一
	 * @param bDate	字符串型日期二
	 * @return boolean值
	 */
	public static boolean isAfter(String aDate, String bDate) {
		try {
			return isAfter(formatStringToDate(aDate), formatStringToDate(bDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 比较日期先后顺序
	 * @param aDate 日期对象一
	 * @param bDate	日期对象二
	 * @return boolean值
	 */
	public static boolean isAfter(Date aDate, Date bDate) {
		if (aDate.after(bDate))
			return true;
		else
			return false;
	}

	/**
	 * 将字符串转换为日期+时间形式
	 * @param dateString 日期字符串
	 * @return 日期对象
	 */
	public static Date formatStringToDateAndTime(String dateString) {
		if (dateString.length() > 0) {
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return parseWithoutException(DF_DATE_TIME, dateString);
		}
		return null;
	}

	/**
	 * 日期标准化
	 * @param date 需转化的日期
	 * @param format 日期形式
	 * @return 转换后的日期
	 */
	public static String formatDate(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 日期转换成“yyyy-MM-dd”形式
	 * @param date 日期对象
	 * @return 转化后的日期
	 */
	public static String formatDate(Date date) {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return parse(DF_DATE, date);
	}

	/**
	 * 日期转换成“yyyy-MM-dd HH:mm:ss”形式
	 * @param date 日期对象
	 * @return 转化后的日期
	 */
	public static String formatDateAndTime(Date date) {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return parse(DF_DATE_TIME, date);
	}

	/**
	 * 日期转换成“yyyy/MM/dd”形式
	 * @param date 日期对象  
	 * @return 转化后的日期
	 */
	public static String formateDateWithSlash(Date date) {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return parse(DF_DATE_SLASH, date);
	}

	/**
	 * 日期转换成“yyyy-MM”形式
	 * @param date 日期对象  
	 * @return 转化后的日期
	 */
	public static String formatYearAndMonth(Date date) {
		return parse(DF_YEAR_MONTH, date);
	}

	/**
	 * 日期转换成“yyyy-MM-dd”
	 * @param date 日期对象  
	 * @return 转化后的日期
	 */
	public static String formatDateWithHyphen(Date date) {
		String strDate = getYear(date) + "-" + getMonth(date) + "-" + getDay(date);
		return strDate;
	}

	/**
	 * 日期转换
	 * @param fmt 转换形式
	 * @param s	转换字符串
	 * @return 日期对象
	 */
	public static Date parseWithoutException(DateFormat fmt, String s) {
		try {
			return parse(fmt, s);
		} catch (ParseException e) {
			throw LangUtils.wrapThrow(e);
		}
	}

	/**
	 * 日期转换成字符串
	 * @param fmt 日期格式
	 * @param d 日期对象
	 * @return 转换后的结果
	 */
	public static String parse(DateFormat fmt, Date d) {
		return ((DateFormat) fmt.clone()).format(d);
	}

	/**
	 * 日期转换
	 * @param fmt 日期格式
	 * @param s 需转换的字符串
	 * @return 转换后的日期对象
	 */
	public static Date parse(DateFormat fmt, String s) throws ParseException {
		return ((DateFormat) fmt.clone()).parse(s);
	}

	/**
	 * 获取年份
	 * @param date 日期对象
	 * @return 年份
	 */
	public static int getYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.YEAR);
	}

	/**
	 * 获取月份
	 * @param date 日期对象
	 * @return 月份(+1,Calendar获得月份比实际月份少1)
	 */
	public static int getMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.MONTH)+1;
	}

	/**
	 * 获取天数
	 * @param date 日期对象
	 * @return 天数
	 */
	public static int getDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取年份集合
	 * @param identification 标识
	 * @return 年份集合
	 */
	public static Map<String, String> getYearMap(int identification) {
		Map<String, String> yearMap = new LinkedHashMap<String, String>();
		Date current = new Date();
		int currentYear = DateUtils.getYear(current);
		yearMap.put("0", "年");
		if (identification == 0) {
			for (int i = 0; i < 50; i++)
				yearMap.put(String.valueOf(currentYear - i),
						String.valueOf(currentYear - i));
		} else if (identification == 1) {
			for (int i = 0; i < 50; i++)
				yearMap.put(String.valueOf(currentYear + 10 - i),
						String.valueOf(currentYear + 10 - i));
		}else if (identification == 4) {
			for (int i = 0; i < 50; i++)
				yearMap.put(String.valueOf(currentYear + 4 - i),
						String.valueOf(currentYear + 4 - i));
		}else if (identification == 5) {//生日 最小16岁
			for (int i = 0; i < 50; i++)
				yearMap.put(String.valueOf(currentYear - 16 - i),
						String.valueOf(currentYear -16 - i));
		}
		return yearMap;
	}

	/**
	 * 获取月份集合
	 * @return 月份集合
	 */
	public static Map<String, String> getMonthMap() {
		Map<String, String> monthMap = new LinkedHashMap<String, String>();
		monthMap.put("0", "月");
		for (int i = 0; i < 12; i++)
			monthMap.put(String.valueOf(12 - i), String.valueOf(12 - i));
		return monthMap;
	}
	/**
	 * 获取日期集合
	 * @return 日期集合
	 */
	public static Map<String, String> getDayMap() {
		Map<String, String> dayMap = new LinkedHashMap<String, String>();
		dayMap.put("0", "日");
		for (int i = 0; i < 31; i++)
			dayMap.put(String.valueOf(31 - i), String.valueOf(31 - i));
		return dayMap;
	}

	/**
	 * 将生日转换成年龄
	 * @param birthday 生日
	 * @return 年龄
	 */
	public static int birthToAge(Date birthday) {
		if(birthday!=null){
			Calendar c = Calendar.getInstance();
			int currentYear = c.get(Calendar.YEAR) ;
			c.setTime(birthday);
			int age = 0 ;
			if(DateUtils.getMonth(birthday)>DateUtils.getMonth(new Date())){
				age = currentYear - c.get(Calendar.YEAR)- 1;
			}else
				age = currentYear - c.get(Calendar.YEAR)  ;
			  
			return age;
		}else
			return 0;
	}
	/**
	 * 将年龄转换成生日
	 * @param age 年龄
	 * @return 此年龄段生日最大值（如：2010年1,10岁   返回 200001）
	 */
	public static int ageToBirth(int age) {
		if(age!=0){
			Calendar c = Calendar.getInstance();
			c.setTime(DateUtils.addYears(new Date(),-age));
			int nowMonth = c.get(Calendar.MONTH)+1 ;
			if(nowMonth<10){
				return Integer.valueOf(c.get(Calendar.YEAR)+"0"+nowMonth);
			}else{
				return Integer.valueOf(c.get(Calendar.YEAR)+""+nowMonth);
			}
		}else
			return Calendar.getInstance().get(Calendar.YEAR)*100;
	}
	/**
	 * 将生日字符串(作废，用DateTools.dateToString代替)
	 * @param birthday 生日
	 * @return 生日字符串 2012-5-1 输出201205
	 */
	public static String birthToString(Date birthday) {
		if(birthday!=null){
			Calendar c = Calendar.getInstance();
			c.setTime(birthday);
			int nowMonth = c.get(Calendar.MONTH)+1 ;
			int currentYear = c.get(Calendar.YEAR) ;
			if(nowMonth<10)
				return currentYear+"0"+nowMonth;
			else
				return currentYear+""+nowMonth;
		}
		return "";
	}

	/**
	 * 日期时间间隔
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @return 时间间隔
	 */
	public static long dateDiff(Date startDate, Date endDate) {
		long minutes = (endDate.getTime() - startDate.getTime()) / (60 * 1000);
		return minutes;
	}

	/** 以下方法来自apache commons-lang包 **/
	//-----------------------------------------------------------------------
  /**
   * Adds a number of years to a date returning a new object.
   * The original {@code Date} is unchanged.
   *
   * @param date  the date, not null
   * @param amount  the amount to add, may be negative
   * @return the new {@code Date} with the amount added
   * @throws IllegalArgumentException if the date is null
   */
  public static Date addYears(Date date, int amount) {
      return add(date, Calendar.YEAR, amount);
  }
  
	// -----------------------------------------------------------------------
	/**
	 * Adds a number of months to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 * 
	 * @param date
	 *          the date, not null
	 * @param amount
	 *          the amount to add, may be negative
	 * @return the new {@code Date} with the amount added
	 * @throws IllegalArgumentException
	 *           if the date is null
	 */
	public static Date addMonths(Date date, int amount) {
		return add(date, Calendar.MONTH, amount);
	}

	// -----------------------------------------------------------------------
	/**
	 * Adds a number of weeks to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 * 
	 * @param date
	 *          the date, not null
	 * @param amount
	 *          the amount to add, may be negative
	 * @return the new {@code Date} with the amount added
	 * @throws IllegalArgumentException
	 *           if the date is null
	 */
	public static Date addWeeks(Date date, int amount) {
		return add(date, Calendar.WEEK_OF_YEAR, amount);
	}

	// -----------------------------------------------------------------------
	/**
	 * Adds a number of days to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 * 
	 * @param date
	 *          the date, not null
	 * @param amount
	 *          the amount to add, may be negative
	 * @return the new {@code Date} with the amount added
	 * @throws IllegalArgumentException
	 *           if the date is null
	 */
	public static Date addDays(Date date, int amount) {
		return add(date, Calendar.DAY_OF_MONTH, amount);
	}

	// -----------------------------------------------------------------------
	/**
	 * Adds a number of hours to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 * 
	 * @param date
	 *          the date, not null
	 * @param amount
	 *          the amount to add, may be negative
	 * @return the new {@code Date} with the amount added
	 * @throws IllegalArgumentException
	 *           if the date is null
	 */
	public static Date addHours(Date date, int amount) {
		return add(date, Calendar.HOUR_OF_DAY, amount);
	}

	// -----------------------------------------------------------------------
	/**
	 * Adds a number of minutes to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 * 
	 * @param date
	 *          the date, not null
	 * @param amount
	 *          the amount to add, may be negative
	 * @return the new {@code Date} with the amount added
	 * @throws IllegalArgumentException
	 *           if the date is null
	 */
	public static Date addMinutes(Date date, int amount) {
		return add(date, Calendar.MINUTE, amount);
	}

	// -----------------------------------------------------------------------
	/**
	 * Adds a number of seconds to a date returning a new object. The original
	 * {@code Date} is unchanged.
	 * 
	 * @param date
	 *          the date, not null
	 * @param amount
	 *          the amount to add, may be negative
	 * @return the new {@code Date} with the amount added
	 * @throws IllegalArgumentException
	 *           if the date is null
	 */
	public static Date addSeconds(Date date, int amount) {
		return add(date, Calendar.SECOND, amount);
	}

	// -----------------------------------------------------------------------
	/**
	 * Adds a number of milliseconds to a date returning a new object. The
	 * original {@code Date} is unchanged.
	 * 
	 * @param date
	 *          the date, not null
	 * @param amount
	 *          the amount to add, may be negative
	 * @return the new {@code Date} with the amount added
	 * @throws IllegalArgumentException
	 *           if the date is null
	 */
	public static Date addMilliseconds(Date date, int amount) {
		return add(date, Calendar.MILLISECOND, amount);
	}
	
	private static Date add(Date date, int calendarField, int amount) {
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null");
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(calendarField, amount);
		return c.getTime();
	}
	
//-----------------------------------------------------------------------
  /**
   * Sets the years field to a date returning a new object.
   * The original {@code Date} is unchanged.
   *
   * @param date  the date, not null
   * @param amount the amount to set
   * @return a new {@code Date} set with the specified value
   * @throws IllegalArgumentException if the date is null
   * @since 2.4
   */
  public static Date setYears(Date date, int amount) {
      return set(date, Calendar.YEAR, amount);
  }

  //-----------------------------------------------------------------------
  /**
   * Sets the months field to a date returning a new object.
   * The original {@code Date} is unchanged.
   *
   * @param date  the date, not null
   * @param amount the amount to set
   * @return a new {@code Date} set with the specified value
   * @throws IllegalArgumentException if the date is null
   * @since 2.4
   */
  public static Date setMonths(Date date, int amount) {
      return set(date, Calendar.MONTH, amount);
  }

  //-----------------------------------------------------------------------
  /**
   * Sets the day of month field to a date returning a new object.
   * The original {@code Date} is unchanged.
   *
   * @param date  the date, not null
   * @param amount the amount to set
   * @return a new {@code Date} set with the specified value
   * @throws IllegalArgumentException if the date is null
   * @since 2.4
   */
  public static Date setDays(Date date, int amount) {
      return set(date, Calendar.DAY_OF_MONTH, amount);
  }

  //-----------------------------------------------------------------------
  /**
   * Sets the hours field to a date returning a new object.  Hours range 
   * from  0-23.
   * The original {@code Date} is unchanged.
   *
   * @param date  the date, not null
   * @param amount the amount to set
   * @return a new {@code Date} set with the specified value
   * @throws IllegalArgumentException if the date is null
   * @since 2.4
   */
  public static Date setHours(Date date, int amount) {
      return set(date, Calendar.HOUR_OF_DAY, amount);
  }

  //-----------------------------------------------------------------------
  /**
   * Sets the minute field to a date returning a new object.
   * The original {@code Date} is unchanged.
   *
   * @param date  the date, not null
   * @param amount the amount to set
   * @return a new {@code Date} set with the specified value
   * @throws IllegalArgumentException if the date is null
   * @since 2.4
   */
  public static Date setMinutes(Date date, int amount) {
      return set(date, Calendar.MINUTE, amount);
  }
  
  //-----------------------------------------------------------------------
  /**
   * Sets the seconds field to a date returning a new object.
   * The original {@code Date} is unchanged.
   *
   * @param date  the date, not null
   * @param amount the amount to set
   * @return a new {@code Date} set with the specified value
   * @throws IllegalArgumentException if the date is null
   * @since 2.4
   */
  public static Date setSeconds(Date date, int amount) {
      return set(date, Calendar.SECOND, amount);
  }

  //-----------------------------------------------------------------------
  /**
   * Sets the miliseconds field to a date returning a new object.
   * The original {@code Date} is unchanged.
   *
   * @param date  the date, not null
   * @param amount the amount to set
   * @return a new {@code Date} set with the specified value
   * @throws IllegalArgumentException if the date is null
   * @since 2.4
   */
  public static Date setMilliseconds(Date date, int amount) {
      return set(date, Calendar.MILLISECOND, amount);
  } 
  
  //-----------------------------------------------------------------------
  /**
   * Sets the specified field to a date returning a new object.  
   * This does not use a lenient calendar.
   * The original {@code Date} is unchanged.
   *
   * @param date  the date, not null
   * @param calendarField  the {@code Calendar} field to set the amount to
   * @param amount the amount to set
   * @return a new {@code Date} set with the specified value
   * @throws IllegalArgumentException if the date is null
   * @since 2.4
   */
  private static Date set(Date date, int calendarField, int amount) {
      if (date == null) {
          throw new IllegalArgumentException("The date must not be null");
      }
      // getInstance() returns a new object, so this method is thread safe.
      Calendar c = Calendar.getInstance();
      c.setLenient(false);
      c.setTime(date);
      c.set(calendarField, amount);
      return c.getTime();
  }   
  /**
   * 获取当前日期
   * @return 当前日期
   */
  public static Date getDate(){
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.setLenient(false);
		c.set(Calendar.MILLISECOND, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.HOUR_OF_DAY, 0);
		return c.getTime();
	}
  /**
   * 获取时间间隔（天数）
   * @param start 开始日期
   * @param end 结束日期
   * @return 天数
   */
  public static long daysBetweenDates(Date start, Date end){
  	long days = ( end.getTime() - start.getTime() ) / ( 60 * 60 * 24 * 1000);
  	return days;
  }
}

