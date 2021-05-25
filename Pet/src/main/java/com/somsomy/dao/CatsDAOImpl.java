package com.somsomy.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.somsomy.domain.CatsBean;
import com.somsomy.domain.PageBean;

@Repository
public class CatsDAOImpl implements CatsDAO{
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.somsomy.mapper.CatsMapper";

	@Override
	public List<CatsBean> getCatList(PageBean pb) {
		return sqlSession.selectList(namespace + ".getCatList", pb);
	}

	@Override
	public Integer getCatCount() {
		return sqlSession.selectOne(namespace + ".getCatCount");
	}

	@Override
	public CatsBean findByCatId(int catId) {
		return sqlSession.selectOne(namespace + ".findByCatId", catId);
	}

}
