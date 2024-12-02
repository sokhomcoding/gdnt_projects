package kh.gov.treasury.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.gov.treasury.utils.UserReqeustDetails;

@Controller
@RequestMapping("/product")
public class ProductControler {

	@Autowired private UserReqeustDetails uReqDtl;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("uReqDtl", uReqDtl.getUserRequestDetails());
		return "product/product_list";
	}
	
	@GetMapping("/distribute")
	public String distribute(Model model) {
		model.addAttribute("uReqDtl", uReqDtl.getUserRequestDetails());
		return "product/product_distribute";
	}
	
}
