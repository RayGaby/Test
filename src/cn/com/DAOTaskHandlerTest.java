package cn.com;

import java.util.HashMap;

import cn.com.jdls.foundation.action.BaseVO;
import cn.com.jdls.foundation.dao.DataRow;
import cn.com.jdls.foundation.dao.DataSet;
import cn.com.jdls.foundation.logic.LogicManager;
import cn.com.jdls.foundation.startup.AppMgr;

public class DAOTaskHandlerTest {
	public static void main(String[] args) {
		AppMgr.initialization("WebContent/WEB-INF/config");
		
		//1.0组织输入参数
		HashMap<String,String> inmap=new HashMap<String, String>();
		inmap.put("name","Ray");
		inmap.put("sex","男");
		BaseVO yhxxvo=new BaseVO();
		yhxxvo.setRequestDataMap(inmap);
		//2.0调用
		LogicManager.getInstance().handle("welcome_dzda_fxjkg",yhxxvo);
		//3.0获取返回
		HashMap<String,DataSet> outmap=yhxxvo.getResponseDataMap();
		DataSet dataSet=(DataSet) outmap.get("output");
		
		while (dataSet.hasNext()) {
			DataRow dr = (DataRow) dataSet.next();
			System.out.println("id:"+dr.getFieldValueByName("id"));
			System.out.println("name:"+dr.getFieldValueByName("name"));
			System.out.println("sex:"+dr.getFieldValueByName("sex"));
			System.out.println("tel:"+dr.getFieldValueByName("tel"));
			System.out.println("address:"+dr.getFieldValueByName("address"));
		}
		//System.out.println(dataSet);

	}
}
