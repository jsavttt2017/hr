package cn.mldn.dao;
import java.util.List;
import cn.mldn.vo.Areaplus;
public interface IAreaplusDAO {
	public List<Areaplus> findAllByArea(Integer aid) throws Exception;
}
