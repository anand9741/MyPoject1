package com.wissen.xcelerate.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wissen.xcelerate.model.Brand;
import com.wissen.xcelerate.service.EncircleService;

@RestController
@RequestMapping("/api")
public class EncircleController {

	@Autowired
	private EncircleService encircleService;

	@GetMapping("/healthCheck")
	public String healthCheck() {
		return "success";
	}

	@PostMapping(value = "/webhookUrl")
	public void getWebhookInfo(@RequestBody Map<String, Object> jsonWebhookResponse) {

		System.out.println("WebhookResponseBody" + jsonWebhookResponse);

	}

	@GetMapping("/brands")
	public ResponseEntity<List<Brand>> getBrands() {
		List<Brand> brands = encircleService.getBrands();
		return new ResponseEntity<List<Brand>>(brands, HttpStatus.OK);

	}

}
