package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Item;
import com.example.demo.response.ChannelResponse;

public interface ItemService {

	public List<ChannelResponse> dashboard();
	
	public List<Item> search(String key);
}
