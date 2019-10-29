package com.sheliming.mybatis.kaikeba.util;

import java.lang.reflect.Field;

public class SQLUtil {

	/*
	 * 功能: 运行时,会接收任意类型一个实体类对象 
	 *      根据实体类对象[特征]生成一条标准[插入语句]
	 * 
	 *  插入语句:
	 *     
	 *     INSERT INTO 表名  (字段1,字段2,字段3)  values(值1,值2,值3)
	 *     |-------------| |--------------| |-----------------|
	 *       sql第一部分              sql第二部分                        sql第三部分
	 */
	public static String createSaveSql(Object obj) throws IllegalArgumentException, IllegalAccessException{
		
		   //1.生成一个StringBuffer对象保存生成sql命令
		     StringBuffer sql = new StringBuffer();
		     
		   //2.生成sql第一部分----------------------start
		      //2.1 定位[实体类对象]隶属的类文件在内存中引用地址
		       Class classFile = obj.getClass();
		      //2.2 读取[类文件]的路径名称
		       String classPathName= classFile.getName();
		       //System.out.println("类文件名称 "+classPathName);
		      //2.3定位[类文件]的路径名称中最后一个"."出现位置 
		       int size=classPathName.lastIndexOf(".");
		      //2.4 从 [类文件]的路径名称中最后一个"."出现位置开始向后截取,获得操作表名
		       String tableName = classPathName.substring(size+1);
		      //2.5 拼接插入语第一部分
		       sql.append("INSERT INTO ");
		       sql.append(tableName);
		       //System.out.println("sql "+sql.toString());
		   //2.生成sql第一部分----------------------end 
		       
		       
		   //3.生成sql第二部分------------------------start
		        sql.append(" (");
		         //3.1 从[类文件]获得在[类文件]声明的所有[属性对象]
		         Field fieldArray[]= classFile.getDeclaredFields();
		         //3.2 循环[数组],将每一个属性名称,填充到sql语句第二部分
		         for(int i=0;i<fieldArray.length;i++){
		        	  Field fieldObj = fieldArray[i];
		        	  String fieldName=fieldObj.getName();//属性名即为字段名
		        	  sql.append(fieldName);
		        	  if(i<fieldArray.length-1){
		        	    sql.append(",");
		        	  }
		         }
		        sql.append(")");
		       // System.out.println("sql "+sql.toString());
		   //3.生成sql第二部分------------------------end    
		       
		       
		   //4.生成sql第三部分-------------------------start 
		        sql.append(" values(");
		        //4.1.循环遍历[属性对象数组],获得当前实例对象(obj)每一个属性内容
		        
		        for(int i=0;i<fieldArray.length;i++){
		        	  Field fieldObj = fieldArray[i];
		        	  fieldObj.setAccessible(true);
		        	  Object data= fieldObj.get(obj);// obj.fieldObj; obj.deptno
		        	  //判断当前属性对象的数据类型
		        	   if(fieldObj.getType()==int.class){
		        		   sql.append(data);
		        	   }else if(fieldObj.getType()==String.class){
		        		   sql.append("'");
		        		   sql.append(data);
		        		   sql.append("'");
		        	   }
		        	  
		        	  if(i<fieldArray.length-1){
		        		  sql.append(",");
		        	  }
		        }
		        
		        sql.append(")");
		        System.out.println("sql "+sql.toString());
		   //4.生成sql第三部分-------------------------end     
		     
		     
		
		return sql.toString();
	}
}
