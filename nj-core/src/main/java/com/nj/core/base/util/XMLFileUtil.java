package com.nj.core.base.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;    
import java.util.List;
import java.util.Map;
import org.dom4j.Document;    
import org.dom4j.DocumentException;    
import org.dom4j.Element;    
import org.dom4j.io.SAXReader;
import org.dom4j.tree.DefaultAttribute;    
  
/** 
 * @author gongj 
 * @creation 2017-3-6 
 */  
public class XMLFileUtil {    
    
//	public static Map<String,Object> map = new HashMap<>();
	
    public static void main(String[] args) {    
        Document doc = null;    
        try {    
            doc = new SAXReader().read(new File("e://orderAudit2.xml"));    
        } catch (DocumentException e) {    
            e.printStackTrace();    
        }    
       Element root = doc.getRootElement();    
       System.out.println("根节点："+root.getName()+",内容："+root.attributeValue("id"));    
  
      Map<String,Object> map = new HashMap<>();
       
      //getElement(map,root,1);
      
      List list = new ArrayList<>();
      getElement(list, root, null);
      for (Object object : list) {
		System.out.println(object);
	}
      
      System.out.println("-----------------------------------------");
      getMap(map);
    }
    
    /**
     * 获取XML Map数据
     * @param filePath
     * @return
     */
    public static Map<String,Object> getXmlFileData(String filePath){   
    	Map<String,Object> map = new HashMap<>();
    	Document doc = null;    
        try {    
            doc = new SAXReader().read(new File(filePath));   
            Element root = doc.getRootElement();    
            getElement(map,root,1);  
        } catch (DocumentException e) {    
            e.printStackTrace();    
        }    
    	return map;
    }
    
    /**
     * 获取XML Map数据
     * @param filePath
     * @return
     */
    public static Map<String,Object> getXmlFileData(File file){   
    	Map<String,Object> map = new HashMap<>();
    	Document doc = null;    
        try {    
            doc = new SAXReader().read(file);   
            Element root = doc.getRootElement();    
            getElement(map,root,1);  
        } catch (DocumentException e) {    
            e.printStackTrace();    
        }    
    	return map;
    }
    
    /**
     * 获取XML Map数据
     * @param filePath
     * @return
     */
    public static List<Map<String,Object>> getXmlFileDataByTag(String filePath,String tag){   
    	List<Map<String,Object>> list = new ArrayList<>();
    	Document doc = null;    
        try {    
            doc = new SAXReader().read(new File(filePath));   
            Element root = doc.getRootElement();    
            getElement(list, root, tag);
        } catch (DocumentException e) {    
            e.printStackTrace();    
        }    
    	return list;
    }
    
    /**
     * 获取XML Map数据
     * @param filePath
     * @return
     */
    public static List<Map<String,Object>> getXmlFileDataByTag(File file){   
    	List<Map<String,Object>> list = new ArrayList<>();
    	Document doc = null;    
        try {    
            doc = new SAXReader().read(file);   
            Element root = doc.getRootElement();    
            getElement(list, root, null);
        } catch (DocumentException e) {    
            return list;
        }    
    	return list;
    }
    

    private static void getMap(Map<String,Object> map){   
    	for (String key : map.keySet()) {
    		Object o = map.get(key);
    		if(o instanceof String){
    			System.out.println("key:"+key +" value:"+o);
    		}else if(o instanceof Map){
    			System.out.println("-------key:"+key);
    			getMap((Map)o);
    		}
		}
    	
    }
        
    private static void getElement(Map<String,Object> map,Element element,int leve){    
        List list = element.elements();    
        //递归方法     
        for(Iterator its =  list.iterator();its.hasNext();){
            Element chileEle = (Element)its.next();    
//            System.out.println(leve+"  节点："+chileEle.getName()+"");    
            String text = chileEle.getText().replaceAll(" ", "").trim();
            if("nonRecuFeeType".equals(chileEle.getName())){
//            	System.out.println(1);
            }
            
            
            
            String str = "";
        	for(int i=1;i < leve;i++){
        		str += "\t";
        	}
        	System.out.println(str+""+leve+"  节点："+chileEle.getName());
            List list0 = chileEle.elements();
            if(list0 == null || list0.size() == 0){
//            	String str = "";
//            	for(int i=1;i < leve;i++){
//            		str += "\t";
//            	}
            	System.out.println(str+"\t内容："+text);
            	
            	
            	
            	if(map.containsKey(chileEle.getName())){
            		List<Object> lt = null;
            		Object o = map.get(chileEle.getName());
            		if(o instanceof String){
            			lt = new ArrayList<>();
            			lt.add(o);
            			map.put(chileEle.getName(),lt);
            		} else if(o instanceof List){
            			lt = (List<Object>) o;
            		} 
            		lt.add(text);
            	}else{
            		map.put(chileEle.getName(),text);
            	}
            	
            }else{
            	Map<String,Object> map1 = new HashMap<>();
            	map.put(chileEle.getName(),map1);
            	
//            	System.out.println(str+""+leve+"  节点："+chileEle.getName());
            	getElement(map1,chileEle,leve+1); 
            }
            
               
//            chileEle.getText()
//            Iterator it = chileEle.attributeIterator();
//            if( it != null){
//            	while(it.hasNext()){
//                	Object o = it.next();
//                	System.out.println(o);
//                }
//            }else{
//            	getElement(chileEle); 
//            }
            
            
        }    
    }     
    
    private static void getElement(List<Map<String,Object>> mList,Element element,String tag){    
        List list = element.elements();    
        //递归方法     
        for(Iterator its =  list.iterator();its.hasNext();){
            Element chileEle = (Element)its.next();    
            String text = chileEle.getText().replaceAll(" ", "").trim();
            List list0 = chileEle.elements();
            if(list0 == null || list0.size() == 0){
//            	if("userTask".equals(chileEle.getName())){
//            		Map mp = new HashMap();
//            		mp.put("tag","userTask");
//                	List<DefaultAttribute> lt = chileEle.attributes();
//                	for (DefaultAttribute attr : lt) {
//                		String name = attr.getQName().getName();
//                		mp.put(name, attr.getValue());
//    				}
//                	mList.add(mp);
//                } else if("sequenceFlow".equals(chileEle.getName())){
//            		Map mp = new HashMap();
//            		mp.put("tag","sequenceFlow");
//                	List<DefaultAttribute> lt = chileEle.attributes();
//                	for (DefaultAttribute attr : lt) {
//                		String name = attr.getQName().getName();
//                		mp.put(name, attr.getValue());
//    				}
//                	mList.add(mp);
//                }
            	List<DefaultAttribute> lt = chileEle.attributes();
            	if(lt != null && lt.size() > 0){
            		Map mp = new HashMap();
            		mp.put("tag", chileEle.getName());
            		boolean bl = false;
                	for (DefaultAttribute attr : lt) {
                		String name = attr.getQName().getName();
                		mp.put(name, attr.getValue());
                		if("id".equals(name)){
                			bl = true;
                		}
    				}
                	if(bl){
                		mList.add(mp);
                	}
            	}
            	
            }else{
            	
            	List<DefaultAttribute> lt = chileEle.attributes();
            	if(lt != null && lt.size() > 0){
            		Map mp = new HashMap();
            		mp.put("tag", chileEle.getName());
            		boolean bl = false;
                	for (DefaultAttribute attr : lt) {
                		String name = attr.getQName().getName();
                		mp.put(name, attr.getValue());
                		if("id".equals(name)){
                			bl = true;
                		}
    				}
                	if(bl){
                		mList.add(mp);
                	}
            	}
            	
//            	if("userTask".equals(chileEle.getName())){
//            		Map mp = new HashMap();
//            		mp.put("tag", "userTask");
//                	List<DefaultAttribute> lt = chileEle.attributes();
//                	for (DefaultAttribute attr : lt) {
//                		String name = attr.getQName().getName();
//                		mp.put(name, attr.getValue());
//    				}
//                	mList.add(mp);
//                } else if("sequenceFlow".equals(chileEle.getName())){
//            		Map mp = new HashMap();
//            		mp.put("tag", "sequenceFlow");
//                	List<DefaultAttribute> lt = chileEle.attributes();
//                	for (DefaultAttribute attr : lt) {
//                		String name = attr.getQName().getName();
//                		mp.put(name, attr.getValue());
//    				}
//                	mList.add(mp);
//                }
            	getElement(mList,chileEle,null); 
            }
        }    
    }  
}    