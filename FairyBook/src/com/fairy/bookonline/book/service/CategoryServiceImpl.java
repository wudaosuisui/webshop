package com.fairy.bookonline.book.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.fairy.bookonline.book.dao.CategoryDaoImpl;
import com.fairy.bookonline.entity.Category;

@Repository
public class CategoryServiceImpl {
	@Resource
	private CategoryDaoImpl cateogryDaoImpl;
	
	//获取图书种类
	public List<Category> getList(){
		return this.cateogryDaoImpl.getList();
	}
	//添加图书种类
	public void Add(Category category) {
		this.cateogryDaoImpl.save(category);
	}
	//修改图书种类
	public void change(Category category) {
		this.cateogryDaoImpl.upDate(category);
	}
	//删除图书种类
	public void delete(Category category) {
		this.cateogryDaoImpl.delete(category);
	}
	//Id删除
	public void deleteById(int id ) {
		this.cateogryDaoImpl.deleteById(id);
	}
	//Name删除
	public void deleteByName(String CategoryName) {
		this.deleteByName(CategoryName);
	}
}







