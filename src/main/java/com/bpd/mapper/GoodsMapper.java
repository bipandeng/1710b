package com.bpd.mapper;

import java.util.List;
import java.util.Map;

import com.bpd.bean.Goods;
import com.bpd.bean.Type;

public interface GoodsMapper {

	/**
	 * 查询
	 * 
	 * @param map
	 * @return
	 */
	public List<Goods> queryGoods(Map<String, Object> map);

	/**
	 * 修改
	 * 
	 * @param goods
	 * @return
	 */
	public int updGoods(Goods goods);

	/**
	 * 添加
	 * 
	 * @param goods
	 * @return
	 */
	public int addGoods(Goods goods);

	/**
	 * 查询一个
	 * 
	 * @param id
	 * @return
	 */
	public Goods selectOne(int id);

	/**
	 * 下拉框
	 * 
	 * @return
	 */
	public List<Type> TypeList();

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int delGoods(Map<String, Object> map);

	public int del(int id);
}
