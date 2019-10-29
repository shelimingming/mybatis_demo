package com.sheliming.mybatis.kaikeba.util;

import java.util.List;

public interface SqlSession {
	
	   public int save(Object obj)throws Exception;//杈撻�佹坊鍔爏ql
	   public int delete(Object obj);//杈撻�佸垹闄ql
	   public int update(Object obj);//杈撻�佹洿鏂皊ql
	   public List find(Object obj); //杈撻�佹煡璇ql

}
