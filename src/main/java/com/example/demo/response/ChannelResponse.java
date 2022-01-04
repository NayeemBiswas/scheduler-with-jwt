package com.example.demo.response;

import java.util.List;

import com.example.demo.entity.Channel;
import com.example.demo.entity.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChannelResponse {
	
	private Channel channel;
	
	private List<Item> items;

}
