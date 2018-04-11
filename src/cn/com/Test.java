package cn.com;

import cn.com.jdls.foundation.dao.DAOFactory;
import cn.com.jdls.foundation.dao.DAOParamGenerator;
import cn.com.jdls.foundation.dao.DAOResult;
import cn.com.jdls.foundation.dao.DataRow;
import cn.com.jdls.foundation.dao.DataSet;
import cn.com.jdls.foundation.dao.IDAO;
import cn.com.jdls.foundation.startup.AppMgr;

public class Test {
	public static void main(String[] args) {
		//不调用logic
		AppMgr.initialization("WebContent/WEB-INF/config");//启动startup
		IDAO dao = DAOFactory.getInstance().getDao();
		DAOParamGenerator generator = new DAOParamGenerator();
		generator.addFirstSqlParam("Ray");
		DAOResult daoResult = dao.select("example_select_mysql", generator.getDAOParam());
		if (daoResult.isSuccess()) {
			DataSet ds = daoResult.toDataSet(0);
			while (ds.hasNext()) {
				DataRow dr = (DataRow) ds.next();
				System.out.println(dr.getFieldValueByName("id"));
				System.out.println(dr.getFieldValueByName("name"));
				System.out.println(dr.getFieldValueByName("sex"));
				System.out.println("tel:"+dr.getFieldValueByName("tel"));
				System.out.println("address:"+dr.getFieldValueByName("address"));
			}
		} else {
			System.out.println("sql语句运行错误！");
		}
	}

}
