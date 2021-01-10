package com.cls.dao;

import java.util.List;

import com.cls.model.Tel;

public interface TelDAO {
	public void addTel( Tel tel );
	public void deleteTel( int telId );
	public void updateTel( Tel tel );
	public List<Tel> getAllTels();
	public Tel getTelById( int telId );
}