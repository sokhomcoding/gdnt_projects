package kh.gov.treasury.asset;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/asset")
public class AssetControler {

	@GetMapping("/list")
	public String list() {
		return "asset/Asset";
	}
	
	@GetMapping("/distribute")
	public String distribute() {
		return "asset/AssetDistribution";
	}
	
}
