package com.wissen.xcelerate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wissen.xcelerate.model.Brand;
import com.wissen.xcelerate.repository.EncircleRepository;

@Service
public class EncircleServiceImp implements EncircleService {
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public Integer getwebhookId() {
		String webhookRequestUrl="https://api.encircleapp.com/v1/webhooks";
		String accessToken="";
		
		String delivery_Url = "";
		Object events=new Object[1];
		
		HttpHeaders headers= new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "bearer" +accessToken);
		
		HttpEntity<Object> entity=new HttpEntity<Object>(events,headers);	
		ResponseEntity<Integer> webhookResponse=restTemplate.exchange(webhookRequestUrl, HttpMethod.POST, entity, Integer.class );
		
		return webhookResponse.getBody();
	}

	@Override
	public List<Brand> getBrands() {
		// TODO Auto-generated method stub
		return null;
	}

}
