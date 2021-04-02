package com.abir.shortainer.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abir.shortainer.modal.Shortainer;
import com.abir.shortainer.repository.ShortainerRepository;
import com.abir.shortainer.service.ShortainerService;

@Service("shortainerService")
public class ShortainerServiceImpl implements ShortainerService {

	Logger logger = LoggerFactory.getLogger(ShortainerService.class);
	
	HashMap<String,String> urlMap = new HashMap<>();
	
    public String encode(String longUrl, String shortUrlDomain) {
    	
        Random rand = new Random();
        int urlLen = 6;
        char [] shortURL = new char[urlLen];
        String randChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

        for(int i = 0; i < urlLen; i++ )
            shortURL[i] = randChars.charAt(rand.nextInt(randChars.length()));

        StringBuilder sb = new StringBuilder("");
        sb.append(new String(shortURL));

        urlMap.put(sb.toString(),longUrl);

        return sb.toString();

    }
    
    public String decode(String shortUrl) {
            return urlMap.get(shortUrl);
    }
    
	@Autowired
	private ShortainerRepository shortainerRepository;
	
	@Override
	public Shortainer save(Shortainer shortainer) {
		shortainer.setShortUrl(encode(shortainer.getLongUrl(), shortainer.getShortUrlDomain()));
		return shortainerRepository.save(shortainer);
	}

	@Override
	public List<Shortainer> findAll() {
		return shortainerRepository.findAll();
	}

	@Override
	public Shortainer findById(Long id) {
		return shortainerRepository.findById(id).get();
	}

	@Override
	public Shortainer findByShortUrlDomainAndUrl(String shortUrlDomain, String shortUrl) {
		return shortainerRepository.FindByShortUrlDomainAndUrl(shortUrlDomain, shortUrl);
	}

}
