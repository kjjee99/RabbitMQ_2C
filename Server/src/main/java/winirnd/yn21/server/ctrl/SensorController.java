package winirnd.yn21.server.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@EnableScheduling
@RequestMapping("/test")
public class SensorController{
	
	@Autowired
	RestTemplate template;
	String message;
	
	@RequestMapping("/sock")
	public ModelAndView show() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("socket");
		return mav;
	}
	
	@RequestMapping(value="/send.do")
	public void listen(@RequestBody String body) {
		log.info(body);
	}
}
