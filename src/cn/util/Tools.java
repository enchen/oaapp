package cn.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;


public class Tools {
	
	private static Logger log=Logger.getLogger("工具类Tools");
	/**
	 * 
	 * @return 生成UUID字符串
	 */
	public static String generateToken()
	{
		String token=java.util.UUID.randomUUID().toString().replace("-", "");
		return token;
	}
	/*序列化工具*/
	 public static byte[] serialize(Object object) {
         ObjectOutputStream oos = null;
          ByteArrayOutputStream baos = null;
          try {
               // 序列化
              baos = new ByteArrayOutputStream();
              oos = new ObjectOutputStream(baos);
              oos.writeObject(object);
               byte[] bytes = baos.toByteArray();
               return bytes;
         } catch (Exception e) {
             log.error("序列化对象错误"+e.getMessage());
         }
          return null;
   }
	/* 反序列化方法*/
	 public static Object unserialize( byte[] bytes) {
         ByteArrayInputStream bais = null;
          try {
               // 反序列化
              bais = new ByteArrayInputStream(bytes);
              ObjectInputStream ois = new ObjectInputStream(bais);
               return ois.readObject();
         } catch (Exception e) {

         }
          return null;
   }

}
