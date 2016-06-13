package cn.util;

import java.util.concurrent.TimeUnit;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;

import cn.beans.User;

public class RedisTool {

	private volatile static RedisTool redisTool;
	private static RedisTemplate<String, User>  userRedis;
	private static ValueOperations<String, User> operations;

	public static RedisTool getInstance()
	{
		if(redisTool==null)
		{
			synchronized (RedisTool.class) 
			{
			if(redisTool==null)
			{
				redisTool= new RedisTool();
			}
			}
			return redisTool;
		}
		else
		{
			return redisTool;
		}
	}
	@SuppressWarnings("unchecked")
	private RedisTool()
	{
		userRedis=(RedisTemplate<String, User>)SpringContext.getBean("redisTemplate");
		
		userRedis.setValueSerializer(new JacksonJsonRedisSerializer<>(User.class));
        operations = userRedis.opsForValue();
	}
	
	public void put(String token,User user) {  
		
		
		operations.set(token, user,24,TimeUnit.HOURS);;  
    }  
  
    public  void delete(String token) {  
    	userRedis.delete(token);
    	//operations.set(arg0, arg1, arg2, arg3);(token);  
    }  
  
    public  User get(String token) {
    	
    	return operations.get(token);  
    }
}
