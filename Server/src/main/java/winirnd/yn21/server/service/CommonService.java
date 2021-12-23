package winirnd.yn21.server.service;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import winirnd.yn21.server.dao.CommonDAO;

@Slf4j
@Service
public class CommonService {

	@Autowired
	private CommonDAO dao;
	
	public List<HashMap<String, Object>> selectAll() {
		List<HashMap<String, Object>> resu = null;
		try {
			resu = dao.selectAll();
			resu.forEach(i -> {
				i.forEach((j, c) -> {
					if(c != null)
						log.info(j + ": " + c.toString());
					else {
						log.info(j +": null");
					}
				});
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resu;
		
	}
	
	public HashMap<String, Object> selectCodeID(String codeID) {
		HashMap<String, Object> result = null;
		try {
			result = dao.selectCodeID(codeID);
			log.info("result of- "+codeID);
			result.forEach((j, c) -> {
				if(c == null) {
					log.info(j + ": null");
				}else
					log.info(j + ": " + c.toString());
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public HashMap<String, Object> insertHashMap(HashMap<String, Object> common) {
		HashMap<String, Object> map = null;
		try {
			map = dao.insertHashMap(common);
			if(map != null) {
				log.info("DB upsert에 성공했습니다.");
			}
			else {
				log.info("DB upsert에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public HashMap<String, Object> updateCommon(HashMap<String, Object> common) {
		HashMap<String, Object> map = null;
		try {
			map = dao.updateCommon(common);
			if(map != null)
				log.info("DB update에 성공했습니다.");
			else
				log.info("DB update에 실패했습니다.");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public HashMap<String, Object> updateDelete(String codeID) {
		HashMap<String, Object> result = null;
		try {
			result = dao.updateDelete(codeID);
			if(result != null) {
				log.info("DB update에 성공했습니다.");
			}else {
				log.info("DB update에 실패했습니다.");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void deleteName(String codeID) {
		int result = 0;
		try {
			result = dao.deleteCodeID(codeID);
			if(result != 0) {
				log.info("DB delete에 성공했습니다.");
			}else {
				log.info("DB delete에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
}
