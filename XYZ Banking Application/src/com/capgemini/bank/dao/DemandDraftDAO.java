package com.capgemini.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.bank.bean.DemandDraft;
import com.capgemini.bank.constant.JdbcConstant;
import com.capgemini.bank.dbConnection.DbUtil;
import com.capgemini.bank.exception.ErrorException;

public class DemandDraftDAO implements IDemandDraftDAO {

	Connection conn = null;
	PreparedStatement pStatement = null;
	ResultSet rSet = null;
	DemandDraft dDraft = null;
	int tran_id;

	@Override
	public int addDemandDraftDetails(DemandDraft demandDraft)
			throws ErrorException {

		conn = DbUtil.getConnection();
		System.out.println(conn);

		try {
			pStatement = conn.prepareStatement(JdbcConstant.INSERTSQL);

			pStatement.setString(1, demandDraft.getCustomer_name());
			pStatement.setString(2, demandDraft.getIn_favor_of());
			pStatement.setString(3, demandDraft.getPhone_number());
			pStatement.setInt(4, demandDraft.getDd_amount());
			if (demandDraft.getDd_amount() <= 5000)
				pStatement.setInt(5, 10);
			else if (demandDraft.getDd_amount() <= 10000)
				pStatement.setInt(5, 41);
			else if (demandDraft.getDd_amount() <= 100000)
				pStatement.setInt(5, 51);
			else if (demandDraft.getDd_amount() <= 500000)
				pStatement.setInt(5, 306);

			pStatement.setString(6, demandDraft.getDd_description());

			pStatement.executeQuery();

			pStatement.execute();
			pStatement.close();

			pStatement = conn.prepareStatement(JdbcConstant.IDSQL);
			rSet = pStatement.executeQuery();

			if (rSet.next()) {
				tran_id = rSet.getInt(1);
			}
			pStatement.close();
		} catch (Exception error) {
			error.printStackTrace();
		} finally {
			return tran_id;
		}

	}

	@Override
	public DemandDraft getDemandDraftDetails(int transactionId) throws ErrorException {

		try {
			conn = DbUtil.getConnection();

			pStatement = conn.prepareStatement(JdbcConstant.DISPLAYSQL);
			pStatement.setInt(1, transactionId);
			rSet = pStatement.executeQuery();

			if(rSet.next()) {
				dDraft = new DemandDraft();
				dDraft.setDd_amount(rSet.getInt("dd_amount"));
				dDraft.setDd_commission(rSet.getInt("dd_commission"));
				dDraft.setDd_description(rSet.getString("dd_description"));

			}
			else
				throw new ErrorException("ID not Found");
			return dDraft;

		} catch (SQLException exception) {
				exception.printStackTrace();
		}
		return dDraft;

	}
}

