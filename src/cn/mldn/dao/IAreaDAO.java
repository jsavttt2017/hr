package cn.mldn.dao;

import java.util.List;
import cn.mldn.vo.Area;
public interface IAreaDAO {
	public List<Area> findAll() throws Exception;
}
