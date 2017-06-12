package cn.mldn.service.impl;
import java.util.List;

import cn.mldn.dbc.DataBaseConnection;
import cn.mldn.factory.DAOFactory;
import cn.mldn.service.IAreaplusService;
import cn.mldn.vo.Areaplus;

public class AreaplusServiceImpl implements IAreaplusService{
	private DataBaseConnection dbc = new DataBaseConnection();
	public List<Areaplus> listByArea(int aid) throws Exception {
		try{
			return DAOFactory.getAreaplusDAOInstance(this.dbc.getConnection()).findAllByArea(aid);
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}
	}
}
