package com.example.demo.service;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Channel;
import com.example.demo.entity.Item;
import com.example.demo.repository.ChannelRepository;
import com.example.demo.repository.ItemRepository;

@Service
public class ReadXmlJDomParser {
	
	@Autowired
	private ChannelRepository channelRepo;
	
	@Autowired
	private ItemRepository itemRepo;

    private static final String FILENAME = "http://static.cricinfo.com/rss/livescores.xml";
    private static final int DELAY_SECOND = 10;

    
    @Scheduled(fixedDelay = DELAY_SECOND * 1000)
    public void xmlReader() throws Exception {

        try {

            SAXBuilder sax = new SAXBuilder();
            // XML is a local file
            Document doc = sax.build(new URL(FILENAME));

            Element rootNode = doc.getRootElement();
            List<Element> list = rootNode.getChildren("channel");

            for (Element target : list) {
            	Channel channel = new Channel();
            	
            	channel.setTitle(target.getChildText("title"));
            	channel.setTtl(target.getChildText("ttl"));
            	channel.setLink(target.getChildText("link"));
            	channel.setDescription(target.getChildText("description"));
            	channel.setCopyright(target.getChildText("copyright"));
            	channel.setLanguage(target.getChildText("language"));
            	
            	String pubDate = target.getChildText("pubDate");
            	
            	SimpleDateFormat formatter=new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss Z"); 
            	
            	channel.setPubDate(formatter.parse(pubDate));
//                System.out.println(channel);
            	
            	if(channelRepo.existsByTitleAndLink(channel.getTitle(), channel.getLink())) {
            		Channel fromDatabase = channelRepo.findByTitleAndLink(channel.getTitle(), channel.getLink());
            		channel.setId(fromDatabase.getId());
            		channel = channelRepo.save(channel);
//            		System.out.println("channel exist");
            	}
            	else {
            		channel = channelRepo.save(channel);
            	}
                
                
                
                List<Element> list2 = target.getChildren("item");
                

                for (Element target2 : list2) {
                	Item item = new Item();
                	
                	item.setChannel(channel);
                	item.setTitle(target2.getChildText("title"));
                	item.setLink(target2.getChildText("link"));
                	item.setDescription(target2.getChildText("description"));
                	item.setGuid(target2.getChildText("guid"));
//                	System.out.println(item);
                	
                	
                	if(itemRepo.existsByChannelIdAndLinkAndGuid(item.getChannel().getId(), item.getLink(), item.getGuid()))
                	{
                		Item itemFromDatabase = itemRepo.findByChannelIdAndLinkAndGuid(item.getChannel().getId(), item.getLink(), item.getGuid());
                		item.setId(itemFromDatabase.getId());
                		item = itemRepo.save(item);
//                		System.out.println("item exist");
                	}
                	else {
                		item = itemRepo.save(item);
					}

                }
            }
            
            

        } catch (IOException | JDOMException e) {
            e.printStackTrace();
        }

    }
}
