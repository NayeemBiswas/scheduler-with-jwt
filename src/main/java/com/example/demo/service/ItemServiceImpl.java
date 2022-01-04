package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.repository.ChannelRepository;
import com.example.demo.repository.ItemRepository;
import com.example.demo.response.ChannelResponse;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ChannelRepository channelRepo;

	@Autowired
	private ItemRepository itemRepo;

	@Override
	public List<ChannelResponse> dashboard() {
		List<ChannelResponse> responses = new ArrayList<>();
		channelRepo.findAll().forEach(m -> {
			ChannelResponse response = new ChannelResponse();
			response.setChannel(m);
			response.setItems(itemRepo.findByChannelId(m.getId()));
			responses.add(response);
		});

		return responses;
	}

	@Override
	public List<Item> search(String key) {
		return itemRepo.getBySearchParam(key);
	}

}
