package com.bpd.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bpd.bean.Goods;
import com.bpd.bean.Type;
import com.bpd.mapper.GoodsMapper;

@Service
@Transactional
public class GoodsServiceImpl  implements GoodsService{

	@Resource
	public   GoodsMapper goodMapper ;
	public List<Goods> queryGoods(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return goodMapper.queryGoods(map);
	}
	public int addGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodMapper.addGoods(goods);
	}
	public Goods selectOne(int id) {
		// TODO Auto-generated method stub
		return goodMapper.selectOne(id);
	}
	public List<Type> TypeList() {
		// TODO Auto-generated method stub
		return goodMapper.TypeList();
	}
	public int updGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodMapper.updGoods(goods);
	}
	public int delGoods(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return goodMapper.delGoods(map);
	}
	public int del(int id) {
		// TODO Auto-generated method stub
		return goodMapper.del(id);
	}
	

	  
	  
}
