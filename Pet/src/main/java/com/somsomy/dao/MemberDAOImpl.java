package com.somsomy.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.somsomy.domain.MemberBean;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.somsomy.mapper.MemberMapper";

	@Override
	public MemberBean userCheck(MemberBean mb) {
		return sqlSession.selectOne(namespace + ".userCheck", mb);
	}

}
