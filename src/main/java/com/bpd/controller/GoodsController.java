package com.bpd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bpd.bean.Goods;
import com.bpd.bean.Type;
import com.bpd.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class GoodsController {

	@Resource
	private  GoodsService   goodsService ;
	
	//查询
	@RequestMapping("list")
	public    String  queryGoods(Model mod,@RequestParam(defaultValue="1")int pageNum,@RequestParam(defaultValue="")String name,@RequestParam(defaultValue="")String start,@RequestParam(defaultValue="")String end){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("name", name);
		map.put("start", start);
		map.put("end", end);
		PageHelper.startPage(pageNum, 2);
		List<Goods> list = goodsService.queryGoods(map);
		PageInfo<Goods> pp = new PageInfo<Goods>(list);
		mod.addAttribute("pp", pp);
		mod.addAttribute("name", name);
		return "list";
	}
	
	@RequestMapping("updGoods")
	public    String   update(Goods goods){
		 int i = goodsService.updGoods(goods);
		 if(i>0){
			 return  "redirect:list";
		 }
		 return   "updGoods";
	}
	/**
	 * 添加
	 * @param goods
	 * @return
	 */
	@RequestMapping("addGoods")
	public   String    addGoods(Goods goods){
		
		int i = goodsService.addGoods(goods);
		if(i>0){
			return  "redirect:list";
		}
		    return  "addGoods";
	}
	/**
	 * 查询一个
	 * @param id
	 * @return
	 */
	@RequestMapping("showone")
	@ResponseBody
	public    Goods selectOne(int id){
		System.out.println(id);
		Goods goods = goodsService.selectOne(id);
		return  goods;
	}
	/**
	 * 下拉
	 * @return
	 */
	@RequestMapping("sellist")
	@ResponseBody
	public   List<Type> selList(){
		List<Type> list = goodsService.TypeList();
		return list;
	}
	/**
	 * 批删
	 * @param ids
	 * @return
	 */
	@RequestMapping("delGoods")
	@ResponseBody
	public   Boolean   delGoods(String ids){
		System.err.println(ids);
		String[] split = ids.split(",");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("ids", split);
		int i = goodsService.delGoods(map);
		if(i>0){
			return  true;
		}
		return  false;
	}
	@RequestMapping("del")
	public   String   del(int id){
		int i = goodsService.del(id);
		if(i>0){
			return "redirect:list";
		}
		return "index";
	}
}
