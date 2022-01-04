package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Integer> {
	
	boolean existsByTitleAndLink(String title, String link);

	Channel findByTitleAndLink(String title, String link);
}
