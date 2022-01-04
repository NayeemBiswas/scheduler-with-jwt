package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
	boolean existsByChannelIdAndLinkAndGuid(Integer id,  String link, String guid);

	Item findByChannelIdAndLinkAndGuid(Integer id, String link, String guid);
	
	List<Item> findByChannelId (Integer id);
	
	String detailsQuery = "SELECT *\r\n"
    		+ "FROM ITEM \r\n"
    		+ "WHERE 1 = 1\r\n"
    		+ "AND TITLE  ILIKE %:key%\r\n"
    		+ "OR DESCRIPTION  ILIKE %:key%\r\n"
    		+ "ORDER BY ID DESC";
    
    @Query(value = detailsQuery, nativeQuery = true)
    List<Item> getBySearchParam(@Param("key") String key);

}
