package com.example.demo.serviceImpl;
import com.example.demo.bean.mysql.IntentEntity;
import com.example.demo.service.IntentServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;

@Service("intentService")
@Transactional
public class IntentServiceImpl  implements IntentServiceI {
	@Override
	public InputStream enText2Voice(String text) {
		return null;
	}

	@Override
	public Object cnText2Voice(String text) {
		return null;
	}

	@Override
	public Object getintenAll() {
		return null;
	}

	@Override
	public Object getintenpage() {
		return null;
	}

	@Override
	public void delintentionByID() {

	}
}