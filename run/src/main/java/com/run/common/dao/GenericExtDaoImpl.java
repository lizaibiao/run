package com.run.common.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.run.common.entity.Page;


@Repository
public class GenericExtDaoImpl<T> implements IGenericExtDao<T> {

	public final String selectAcountNamespace = "com.square.framework.common.entities.selectAcount";

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<T> queryListByCondition(String namespace,
			Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace, condition);
	}

	@Override
	public List<T> queryListByEntities(String namespace, T entity) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace, entity);
	}

	@Override
	public T queryObject(String namespace, T entity) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne(namespace, entity);
	}

	@Override
	public void insert(String namespace, T entity) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert(namespace, entity);
	}

	@Override
	public void insertBatch(String namespace, Collection<T> list) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert(namespace, list);
	}

	@Override
	public Page queryEntitiesWithPage(String namespace,
			Map<String, Object> map, Page page) {
		page = page == null ? new Page() : page;
		// 1銆佽幏鍙栨瘡椤垫樉绀虹殑鏁版嵁锛�0鏉★級
		RowBounds row = new RowBounds((page.getCurrentPage() - 1)
				* page.getShowCount(), page.getShowCount());
		page.setDataList(sqlSessionTemplate.selectList(namespace, map, row));
		// 2銆佸皢鑾峰彇鐨勬�璁板綍鏁版斁杩沺ageCount
		page.setTotalResult(pageCount(namespace, map));
		return page;
	}

	private int pageCount(String namespace, Map<String, Object> map) {
		// 1.1銆佽幏鍙栨煡璇㈢殑sql璇彞
		// 1.1.1銆佽幏鍙杝ql璇彞鏄犲皠
		MappedStatement mapper = sqlSessionTemplate.getConfiguration()
				.getMappedStatement(namespace);
		// 1.1.2銆佽幏鍙栨槧灏勭殑淇℃伅
		BoundSql bound = mapper.getBoundSql(map);
		// 鑾峰彇sql璇彞鐨勫弬鏁颁俊鎭紝瀵瑰簲鐨勮繕鏈塕esultMapping锛屼篃灏辨槸杩斿洖鐨勭粨鏋滀俊鎭�
		List<ParameterMapping> list = bound.getParameterMappings();
		// 1.1.3銆佽幏鍙杝ql璇彞
		String querySql = bound.getSql();
		if (!list.isEmpty()) {
			/**
			 * 灏唖ql璇彞涓殑闂彿锛堜篃灏辨槸鍙傛暟鍊硷紝璧峰垵鐢扁�锛熲�琛ㄧず锛夎浆鎹负灞炴�鍚嶇О锛屽叾涓殑鈥淺\鈥濇槸杞箟瀛楃
			 * 鍋囪涓婅瘔鐨剄uerySql鏄痵elect AreaId from area where AreaId=?
			 * 缁忚繃涓嬮潰鐨勮鍙ヨ浆鎹㈠悗鏄細select AreaId from area where AreaId=#{areaId}
			 */
			for (ParameterMapping p : list) {
				querySql = querySql.replaceFirst("\\?", "#{" + p.getProperty()
						+ "}");
			}
		}
		Map<String, Object> param = new HashMap<String, Object>();
		// 1.2銆佸皢sql璇彞鏀惧叆map
		param.put("querySql", querySql);
		if (!map.isEmpty()) {
			param.putAll(map);
		}
		// 1.3銆佽幏鍙栨�璁板綍鏁�
		int count = ((Integer) sqlSessionTemplate.selectOne(
				selectAcountNamespace, param)).intValue();
		return count;
	}

	@Override
	public void deleteByPrimaryKey(String namespace, T entity) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete(namespace, entity);
	}

	@Override
	public void deleteBatchByPrimaryKey(List<T> list, String namespace) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete(namespace, list);
	}

	@Override
	public void updateByPrimaryKey(String namespace, T entity) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update(namespace, entity);
	}

	@Override
	public Integer queryCount(String namespace, T entity) {
		List<Object> count = sqlSessionTemplate.selectList(namespace, entity);
		return count.size();
	}

	@Override
	public void updateBatch(String namespace, Collection<T> list) {
		sqlSessionTemplate.update(namespace, list);
	}

	/* (non-Javadoc)
	 * @see com.square.common.dao.IGenericExtDao#queryByList(java.lang.String, java.util.List)
	 */
	@Override
	public List<T> queryByList(String namespace, List<T> list) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList(namespace, list);
	}

	/* (non-Javadoc)
	 * @see com.square.common.dao.IGenericExtDao#deleteBatchByCondition(java.lang.String, java.util.Map)
	 */
	@Override
	public void deleteBatchByCondition(String namespace,
			Map<String, Object> condition) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete(namespace, condition);
	}

}
