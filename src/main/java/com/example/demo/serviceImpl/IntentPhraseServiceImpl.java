package com.example.demo.serviceImpl;
import com.example.demo.bean.mysql.EmailSellResponseEnd;
import com.example.demo.bean.mysql.IntentPhraseEntity;
import com.example.demo.service.IntentPhraseServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service("intentPhraseService")
@Transactional
public class IntentPhraseServiceImpl  implements IntentPhraseServiceI {

	@Override
	public void delete(IntentPhraseEntity entity) throws Exception {

	}

	@Override
	public int save(IntentPhraseEntity entity) throws Exception {
		return 0;
	}

	@Override
	public void saveOrUpdate(IntentPhraseEntity entity) throws Exception {

	}

	@Override
	public void delete(int id) throws Exception {

	}

	@Override
	public long totalSum() {
		return 0;
	}

	@Override
	public List<IntentPhraseEntity> queryStudentsBySql(int currPage, int pageSize) {
		return null;
	}



}