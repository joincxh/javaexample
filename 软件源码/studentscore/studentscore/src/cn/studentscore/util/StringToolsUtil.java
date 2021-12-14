package cn.studentscore.util;

/*
 * 处理字符串
 * 工具类
*/
public class StringToolsUtil {
	//判断是否为空
	public static boolean isEmpty(String str) {
		if (str==null||"".equals(str.trim())) {//判空条件
			return true;
			
		}else {
			return false;
		}
	}
	//判断不是为空
	
	public static boolean isNotEmpty(String str) {
		if ((str!=null)&&!"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
}
