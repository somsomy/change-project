package com.somsomy.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.somsomy.domain.SupporterBean;

@Repository
public class SupportDAOImpl implements SupportDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.somsomy.mapper.SupporterMapper";

	@Override
	public Integer getMaxNum() {
		return sqlSession.selectOne(namespace + ".getMaxNum");
	}

	@Override
	public void insertSupporter(SupporterBean sb) {
		sqlSession.insert(namespace + ".insertSupporter", sb);
	}

}
