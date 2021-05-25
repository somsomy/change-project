package com.somsomy.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.somsomy.domain.AdoptBean;
import com.somsomy.domain.PageBean;

@Repository
public class AdoptDAOImpl implements AdoptDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.somsomy.mapper.AdoptMapper";

	@Override
	public Integer getMaxNum() {
		return sqlSession.selectOne(namespace + ".getMaxNum");
	}

	@Override
	public List<AdoptBean> getBoardList(PageBean pb) {
		return sqlSession.selectList(namespace + ".getBoardList", pb);
	}

}
