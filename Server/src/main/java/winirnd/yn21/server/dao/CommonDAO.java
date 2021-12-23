package winirnd.yn21.server.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonDAO {
	//insert
	public HashMap<String, Object> insertHashMap(HashMap<String, Object> common) throws Exception;
	
	//select
	public List<HashMap<String,Object>> selectAll() throws Exception;
	public HashMap<String, Object> selectCodeID(String codeID) throws Exception;
	
	//update
	public HashMap<String, Object> updateCommon(HashMap<String, Object> common) throws Exception;
	public HashMap<String, Object> updateDelete(String codeID) throws Exception;
	
	//delete
	public int deleteCodeID(String codeID) throws Exception;
}
