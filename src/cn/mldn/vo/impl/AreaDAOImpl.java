package cn.mldn.vo.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.mldn.dao.IAreaDAO;
import cn.mldn.vo.Area;

public class AreaDAOImpl implements IAreaDAO {
	private Connection conn;
	private PreparedStatement pst;
	public AreaDAOImpl(Connection conn) {
		this.conn = conn;
	}
	public List<Area> findAll() throws Exception {
		List<Area> all = new ArrayList<Area>();
		String sql = "SELECT aid,title FROM area";
		this.pst = this.conn.prepareStatement(sql);
		ResultSet rs = this.pst.executeQuery();
		while(rs.next()){
			Area vo = new Area();
			vo.setAid(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			all.add(vo);
		}
		return all;
	}
}
