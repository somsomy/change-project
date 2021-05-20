package com.somsomy.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.somsomy.domain.PageBean;
import com.somsomy.domain.QnaBean;

@Repository
public class QnaDAOImpl implements QnaDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.somsomy.mapper.QnaMapper";
	
	@Override
	public Integer getQnaCount() {
		return sqlSession.selectOne(namespace + ".getQnaCount");
	}

	@Override
	public List<QnaBean> getQnaList(PageBean pb) {
		return sqlSession.selectList(namespace + ".getQnaList", pb);
	}

	@Override
	public Integer getMaxNum() {
		return sqlSession.selectOne(namespace + ".getMaxNum");
	}

	@Override
	public void qnaWrtie(QnaBean qb) {
		sqlSession.insert(namespace + ".qnaWrite", qb);
	}

	@Override
	public void updateReadcount(int num) {
		sqlSession.update(namespace + ".updateReadcount", num);
	}

	@Override
	public QnaBean getQna(int num) {
		return sqlSession.selectOne(namespace + ".getQna", num);
	}

	@Override
	public void updateQna(QnaBean qb) {
		sqlSession.update(namespace + ".updateQna", qb);
	}


}
