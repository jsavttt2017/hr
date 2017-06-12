package cn.mldn.vo.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.mldn.dao.IAreaplusDAO;
import cn.mldn.vo.Area;
import cn.mldn.vo.Areaplus;

public class AreaplusDAOImpl implements IAreaplusDAO {
	private Connection conn;
	private PreparedStatement pst;
	public AreaplusDAOImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public List<Areaplus> findAllByArea(Integer aid) throws Exception {
		List<Areaplus> all = new ArrayList<Areaplus>();
		String sql = "SELECT apid,aid,title FROM areaplus WHERE aid=?";
		this.pst = this.conn.prepareStatement(sql);
		this.pst.setInt(1, aid);
		ResultSet rs = this.pst.executeQuery();
		while(rs.next()){
			Areaplus vo = new Areaplus();
			vo.setArea(new Area());
			vo.setApid(rs.getInt(1));
			vo.getArea().setAid(rs.getInt(2));
			vo.setTitle(rs.getString(3));
			all.add(vo);
		}
		return all;
	}
}
