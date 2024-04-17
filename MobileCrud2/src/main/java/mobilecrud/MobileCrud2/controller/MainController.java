package mobilecrud.MobileCrud2.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mobilecrud.MobileCrud2.entity.Mobile;
import mobilecrud.MobileCrud2.repository.MobileRepository;
@Controller
public class MainController {
	@Autowired
	MobileRepository rep;
	
	@RequestMapping("mobilestore")
	public String home(@Autowired Model model) {
		List<Mobile> mobiles=null;
		mobiles=rep.findAll();
		model.addAttribute("mobileList", mobiles);
		return "Home";
	}
	@RequestMapping("/add-mobile")
	public ModelAndView AddMobile() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("AddMobile");
		return mv;
	}
	@PostMapping("save-mobile")
	public String saveMobile(Mobile mobile,@Autowired Model model) {
		rep.save(mobile);
		return "redirect:mobilestore";
	}
	@GetMapping("/delete-mobile/{id}")
	public String deleteMobile(@PathVariable int id) {
		rep.deleteById(id);
		return "redirect:/mobilestore";
	}
	@GetMapping("/update-mobile/{id}")
	public String toUpdatePage(@PathVariable int id,Model model) {
		Optional<Mobile> mobiles=rep.findById(id);
		model.addAttribute("mobile", mobiles);
		return "Update";
	}
//	@GetMapping("/error")
//	public String error(Model model) {
//		
//	}

}
