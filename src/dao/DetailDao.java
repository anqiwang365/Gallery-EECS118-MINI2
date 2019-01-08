package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Detail;
import model.Image;

public class DetailDao {

	public void deleteDetail(int id) {
		String sql = "delete from detail where detail_id=?";
		Connection con = DBconnection.getConnection();
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			pst.close();	
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int addDetail(Detail detail) {
		String sql = "insert into detail(image_id,year,type,width,height,location,description) values (?,?,?,?,?,?,?)";
		Connection con = DBconnection.getConnection();
		int detail_Id = 0;
		try {
			PreparedStatement pst = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1,detail.getiId());
			pst.setInt(2, detail.getYear());
			pst.setString(3,detail.getType());
			pst.setInt(4, detail.getWidth());
			pst.setInt(5, detail.getHeight());
			pst.setString(6, detail.getLocation());
			pst.setString(7, detail.getDes());
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			while(rs.next()) {
				detail_Id = rs.getInt(1);
			}
			pst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return detail_Id;
	}
	
	public void updateDetail(Detail detail) {
		Connection con = DBconnection.getConnection();
		String sql = "UPDATE detail SET year = ?,type=?,width=?,height=?,location=?, description=?  WHERE detail.image_id= ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1,detail.getYear());
			pst.setString(2,detail.getType());
			pst.setInt(3, detail.getWidth());
			pst.setInt(4, detail.getHeight());
			pst.setString(5, detail.getLocation());
			pst.setString(6, detail.getDes());
			pst.setInt(7, detail.getiId());
			pst.executeUpdate();
			pst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Detail selectById(int id) {
		Connection con = DBconnection.getConnection();
		String sql = "select * from detail where image_id="+ id;
		Detail d = new Detail();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				d.setdId(rs.getInt("detail_id"));
				d.setiId(rs.getInt("image_id"));
				d.setType(rs.getString("type"));
				d.setYear(rs.getInt("year"));
				d.setWidth(rs.getInt("width"));
				d.setHeight(rs.getInt("height"));
				d.setLocation(rs.getString("location"));
				d.setDes(rs.getString("description"));
			}
			rs.close();
			st.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return d;
	}
}
