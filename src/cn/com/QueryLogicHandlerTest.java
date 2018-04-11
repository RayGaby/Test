package cn.com;

import java.util.HashMap;

import cn.com.jdls.foundation.action.BaseVO;
import cn.com.jdls.foundation.dao.DataSet;
import cn.com.jdls.foundation.logic.LogicManager;
import cn.com.jdls.foundation.startup.AppMgr;

public class QueryLogicHandlerTest {
	public static void main(String[] args) {
		AppMgr.initialization("WebContent/WEB-INF/config");
		
		//1.0组织输入参数
		HashMap inmap=new HashMap();
		inmap.put("ParamName","Ray");
		inmap.put("ParamSex","男");
		BaseVO yhxxvo=new BaseVO();
		yhxxvo.setRequestDataMap(inmap);
		//2.0调用
		LogicManager.getInstance().handle("queryYhxx",yhxxvo);
		//3.0获取返回
		HashMap outmap=yhxxvo.getResponseDataMap();
		DataSet dataSet=(DataSet) outmap.get("queryresult");
		System.out.println(dataSet);
	}
}
