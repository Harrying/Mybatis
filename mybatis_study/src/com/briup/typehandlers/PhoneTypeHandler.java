package com.briup.typehandlers;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.briup.bean.PhoneNumber;

/*
 * ���� ���ʹ�������ר�Ÿ��� ת���Զ��� PhoneNumber <--->  varchar2
 */
public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber> {

	//�� �е�ֵString  ӳ���  �����е�addr���� PhoneNumber
	//����ѡ��˷���   ��[varchar2] -->  ����[PhoneNumber] 
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

	//��addr Addr   -->   ���ݿ���varchar2
	@Override
	public PhoneNumber getNullableResult(CallableStatement arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNonNullParameter(PreparedStatement ps, int index, PhoneNumber addr, JdbcType arg3)
			throws SQLException {
		//System.out.println("setNonNullParameter: addr --> varchar2");
		//�Ƚ�addrת�����ַ���
		String addrStr = addr.getAsString();
		ps.setString(index, addrStr);
	}

}
