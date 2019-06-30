package com.briup.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.briup.bean.PhoneNumber;

/*
 * 定义 类型处理器，专门负责 转换自定义 PhoneNumber <--->  varchar2
 */
public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber> {

	//将 列的值String  映射成  对象中的addr属性 PhoneNumber
	//优先选择此方法   列[varchar2] -->  属性[PhoneNumber] 
	@Override
	public PhoneNumber getNullableResult(ResultSet rs, String colName) throws SQLException {
		//System.out.println("getNullableResult colName...");
		String addrStr = rs.getString(colName);
		
		return new PhoneNumber(addrStr);
	}

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, int colIndex) throws SQLException {
		//System.out.println("getNullableResult colIndex...");
		String addrStr = rs.getString(colIndex);
		
		return new PhoneNumber(addrStr);
	}

	//将addr Addr   -->   数据库中varchar2
	@Override
	public PhoneNumber getNullableResult(CallableStatement arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int index, PhoneNumber addr, JdbcType arg3)
			throws SQLException {
		//System.out.println("setNonNullParameter: addr --> varchar2");
		//先将addr转换成字符串
		String addrStr = addr.getAsString();
		ps.setString(index, addrStr);
	}

}
