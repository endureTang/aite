package com.nj.core.ehcache;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhCacheUtil {  
	  
    private static final String path = "/ehcache.xml";  
  
    private URL url;  
  
    private CacheManager manager;  
  
    private static EhCacheUtil ehCache;  
  
    private EhCacheUtil(String path) {  
        url = getClass().getResource(path);  
        System.out.println("cache url:"+url);
        manager = CacheManager.create(url);  
    }  
  
    public static EhCacheUtil getInstance() {  
        if (ehCache== null) {  
            ehCache= new EhCacheUtil(path);  
        }  
        return ehCache;  
    }  
  
    private void addCacheIfNotExit(String cacheName){
    	if( ! manager.cacheExists(cacheName)){
    		Cache cache = new Cache(cacheName, 5000, false, false, 5, 2);
    		System.out.println("add cache name "+cacheName);
    		manager.addCache(cache);
    	}
    }
    public void put(String cacheName, String key, Object value) {  
    	this.addCacheIfNotExit(cacheName);
    	Cache cache = manager.getCache(cacheName); 
        Element element = new Element(key, value);  
        System.out.println("put cache:"+cacheName+key+value);
        cache.put(element);  
    }  
  
    public Object get(String cacheName, String key) { 
    	this.addCacheIfNotExit(cacheName);
        Cache cache = manager.getCache(cacheName); 
        Element element = cache.get(key);  
        return element == null ? null : element.getObjectValue();  
    }  
  
    public byte[] getBytes(String cacheName, String key){
    	this.addCacheIfNotExit(cacheName);
        Cache cache = manager.getCache(cacheName); 
        List<String> keys = cache.getKeys();
        for(String ele: keys){
        	System.out.println("test:" + ele + ":"+ String.valueOf(cache.get(ele)));
        }
        Element element = cache.get(key);  
        Object obj = element == null ? null : element.getObjectValue(); 
        System.out.println("test:"+key+":" + cacheName + ":"+ String.valueOf(obj));
        if(obj == null){
        	return null;
        }
        byte[] bytes = null; 
        ByteArrayOutputStream bos = new ByteArrayOutputStream();      
        try {        
            ObjectOutputStream oos = new ObjectOutputStream(bos);         
            oos.writeObject(obj);        
            oos.flush();         
            bytes = bos.toByteArray ();      
            oos.close();         
            bos.close();        
        } catch (IOException ex) {        
            ex.printStackTrace();   
        }  
        System.out.println("test1:" + ":"+ String.valueOf(bytes.toString()));
        return bytes;
    }
    public Cache get(String cacheName) {  
        return manager.getCache(cacheName);  
    }  
  
    public void remove(String cacheName, String key) {  
        Cache cache = manager.getCache(cacheName);  
        cache.remove(key);  
    }
    
    public void clearAll(){
    	manager.removalAll();
    }
      
} 
