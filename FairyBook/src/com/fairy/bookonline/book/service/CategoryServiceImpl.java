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
	
	//��ȡͼ������
	public List<Category> getList(){
		return this.cateogryDaoImpl.getList();
	}
	//���ͼ������
	public void Add(Category category) {
		this.cateogryDaoImpl.save(category);
	}
	//�޸�ͼ������
	public void change(Category category) {
		this.cateogryDaoImpl.upDate(category);
	}
	//ɾ��ͼ������
	public void delete(Category category) {
		this.cateogryDaoImpl.delete(category);
	}
	//Idɾ��
	public void deleteById(int id ) {
		this.cateogryDaoImpl.deleteById(id);
	}
	//Nameɾ��
	public void deleteByName(String CategoryName) {
		this.deleteByName(CategoryName);
	}
}







