package com.nj.enterprise.mapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;
import org.springframework.stereotype.Component;

@Component("dataMapper")  
public class DataMapper extends ObjectMapper {
	 public DataMapper(){
	        CustomSerializerFactory factory = new CustomSerializerFactory();
	        factory.addGenericMapping(Date.class, new JsonSerializer<Date>(){
	            @Override
	            public void serialize(Date value,
	                                  JsonGenerator jsonGenerator,
	                                  SerializerProvider provider)
	                    throws IOException {
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                jsonGenerator.writeString(sdf.format(value));
	            }
	        });
	        this.setSerializerFactory(factory);
	    }
	
}
