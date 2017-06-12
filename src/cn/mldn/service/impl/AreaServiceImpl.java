package cn.mldn.service.impl;

import java.util.List;

import cn.mldn.dbc.DataBaseConnection;
import cn.mldn.factory.DAOFactory;
import cn.mldn.service.IAreaService;
import cn.mldn.vo.Area;

public class AreaServiceImpl implements IAreaService {
	private DataBaseConnection dbc = new DataBaseConnection();
	public List<Area> list() throws Exception {
		try{
			return DAOFactory.getAreaDAOInstance(this.dbc.getConnection()).findAll();
		}catch(Exception e){
			throw e;
		}finally{
			this.dbc.close();
		}	
	}
}
