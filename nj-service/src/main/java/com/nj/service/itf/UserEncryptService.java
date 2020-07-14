package com.nj.service.itf;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nj.core.base.dao.BaseDao;

@Service("userEncryptService")
public class UserEncryptService {
	
	@Resource(name="BaseDao")
	private BaseDao dao;
	
	public String encrypt(String toEncrypt, String userId){
		return null;
	}
	
	public String decrypt(String toDecrypt,String userId){
		return null;
	}
}
