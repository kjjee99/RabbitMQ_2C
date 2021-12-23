package winirnd.yn21.server.ctrl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import winirnd.yn21.server.service.CommonService;
import winirnd.yn21.server.vo.CommonCodeVO;

@RestController
@RequestMapping("/yn21")
public class CommonController {
	
	@Autowired
	private CommonService service;
	
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping("/selectCommonAll")
	public ModelAndView selectAll() {
		List<HashMap<String, Object>> list = service.selectAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("commons", list);
		mav.setViewName("Common/selectCommonAll");
		return mav;
	}
	@GetMapping("/inputSelectID")
	public ModelAndView inputSelectID() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("codeID", new String());
		mav.setViewName("Common/inputSelectID");
		return mav;
	}
	@GetMapping("/selectCommonID")
	public ModelAndView selectCodeID(@RequestParam("codeID") String codeID) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> map = service.selectCodeID(codeID);
		mav.addObject("common", map);
		mav.setViewName("Common/selectCommonID");
		return mav;
	}
	@RequestMapping("/inputInsertCmmn")
	public ModelAndView inputInsert() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("common", new CommonCodeVO());
		mav.setViewName("Common/inputInsert");
		return mav;
	}
	@PostMapping("/insertCommon")
	public ModelAndView insertHashMap(@ModelAttribute("common") CommonCodeVO common) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("codeID", common.getCodeID());
		map.put("codeName", common.getCodeName());
		map.put("upperID", common.getUpperID());
		HashMap<String, Object> result = service.insertHashMap(map);
		mav.addObject("common", result);
		mav.setViewName("Common/insertCommon");
		return mav;
	}
	
	@RequestMapping(value="/inputUdCommon")
	public ModelAndView inputCommon() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("common", new CommonCodeVO());
		mav.setViewName("Common/inputUdCommon");
		return mav;
	}
	@PostMapping(value="/updateCommon")
	public ModelAndView updateCommon(@ModelAttribute("common") CommonCodeVO common) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("codeID", common.getCodeID());
		map.put("codeName", common.getCodeName());
		map.put("upperID", common.getUpperID());
		HashMap<String, Object> result = service.updateCommon(map);
		mav.addObject("common", result);
		mav.setViewName("Common/updateCommon");
		return mav;
	}
	@RequestMapping("/inputCmmnDel")
	public ModelAndView inputCmmnDel() {
		ModelAndView mav = new ModelAndView();
//		mav.addObject("common", new CommonCodeVO());
		mav.setViewName("Common/inputCmmnDel");
		return mav;
	}
	@PostMapping("/updateCmmnDel")
	public ModelAndView updateDelete(@RequestParam("codeID") String codeID){
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> result = service.updateDelete(codeID);
		mav.addObject("common",	result);
		mav.setViewName("Common/updateCmmnDel");
		return mav;
	}
	@RequestMapping("/inputDelete")
	public ModelAndView inputDelete() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Common/inputDelete");
		return mav;
	}
	@DeleteMapping("/deleteCommon")
	public ModelAndView deleteCodeID(@RequestParam("codeID") String codeID){
		ModelAndView mav = new ModelAndView();
		service.deleteName(codeID);
		List<HashMap<String, Object>> list = service.selectAll();
		mav.addObject("commons", list);
		mav.setViewName("Common/deleteCommon");
		return mav;
	}
}
