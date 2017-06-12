package cn.mldn.factory;
import java.sql.Connection;

import cn.mldn.dao.IAreaDAO;
import cn.mldn.dao.IAreaplusDAO;
import cn.mldn.vo.impl.AreaDAOImpl;
import cn.mldn.vo.impl.AreaplusDAOImpl;

public class DAOFactory {
	public static IAreaDAO getAreaDAOInstance(Connection conn){
		return new AreaDAOImpl(conn);
	}
	public static IAreaplusDAO getAreaplusDAOInstance(Connection conn){
		return new AreaplusDAOImpl(conn);
	}
}
