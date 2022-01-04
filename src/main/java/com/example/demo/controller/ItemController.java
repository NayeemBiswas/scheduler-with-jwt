package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.CommonResponse;
import com.example.demo.service.ItemService;
import com.example.demo.utill.CommonUtils;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("score")
public class ItemController {

	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(ItemController.class);
	
	@Autowired
	private ItemService service;
	
	@Autowired
	private CommonUtils commonUtils;
	
	@GetMapping(value = "/dashboard")
    public CommonResponse dashboard(){
		try {
    		return commonUtils.generateSuccessResponse(service.dashboard());
		} catch (Exception e) {
			return commonUtils.generateErrorResponse(e);
		}
    }
	
	@GetMapping(value = "/search/{key}")
    public CommonResponse search(@PathVariable("key") String key){
		try {
    		return commonUtils.generateSuccessResponse(service.search(key));
		} catch (Exception e) {
			return commonUtils.generateErrorResponse(e);
		}
    }


}
