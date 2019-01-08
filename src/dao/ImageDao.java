package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Gallery;
import model.Image;

public class ImageDao {
	
	public Image getInfo(int id) {
		String sql = "Select image.image_id as id,image.title as title,image.link as link,artist.name as name,detail.year,detail.type,detail.width,detail.height,detail.location,detail.description,detail.detail_id as dId " + 
				"from image, detail,artist " + 
				"where image.detail_id=detail.detail_id  and image.artist_id=artist.artist_id and image.image_id= "+id ;
				
		
		Connection con = DBconnection.getConnection();
		Image image = new Image(); 
		try {
			Statement st = con.createStatement();
			ResultSet rst = st.executeQuery(sql);

			while(rst.next()) {
			
				image.setiId(rst.getInt("id"));
				image.setTitle(rst.getString("title"));
				image.setLink(rst.getString("link"));
				image.setName(rst.getString("name"));
				image.setYear(rst.getInt("year"));
				image.setType(rst.getString("type"));
				image.setWidth(rst.getInt("width"));
				image.setHeight(rst.getInt("height"));
				image.setLocation(rst.getString("location"));
				image.setDes(rst.getString("description"));
				image.setdId(rst.getInt("dId"));
			}
			rst.close();
			st.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public void deleteImage(int id) {
		
		String sql = "delete from image where image_id=?";
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
	
	public int addImage(Image image) {
		String sql = "insert into image(title,link,gallery_id,artist_id,detail_id) values(?,?,?,?,?)";
		Connection con = DBconnection.getConnection();
		int image_Id = 0;
		try {
			PreparedStatement pst = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pst.setString(1,image.getTitle());
			pst.setString(2,image.getLink());
			pst.setInt(3, image.getgId());
			pst.setInt(4, image.getaId());
			pst.setInt(5, image.getdId());
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			while(rs.next()) {
				image_Id = rs.getInt(1);
			}
			pst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return image_Id;
	}
	
	public void updateImageDid(int imageId, int detailId) {
		Connection con = DBconnection.getConnection();
		String sql = "UPDATE image SET detail_id = ? WHERE image_id= ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setInt(1,detailId);
			pst.setInt(2, imageId);
			pst.executeUpdate();
			pst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateImage(Image image) {
		Connection con = DBconnection.getConnection();
		String sql = "UPDATE image SET title = ?,link=?,artist_id=? WHERE image_id= ?";
		
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1,image.getTitle());
			pst.setString(2,image.getLink());
			pst.setInt(3, image.getaId());
			pst.setInt(4, image.getiId());
			pst.executeUpdate();
			pst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public Image selectById(int id) {
		Connection con = DBconnection.getConnection();
		String sql = "select * from image where image_id="+ id;
		Image image = new Image();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				image.setiId(rs.getInt("image_id"));
				image.setTitle(rs.getString("title"));
				image.setLink(rs.getString("link"));
				image.setaId(rs.getInt("artist_id"));
				image.setgId(rs.getInt("gallery_id"));
				image.setdId(rs.getInt("detail_id"));
			}
			rs.close();
			st.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public List<Image> findByArtist(int id){
		Connection con = DBconnection.getConnection();
		String sql = "select * from image where artist_id ="+ id;
		List<Image> list = new ArrayList<Image>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Image img = new Image();
				img.setiId(rs.getInt("image_id"));
				img.setTitle(rs.getString("title"));
				img.setLink(rs.getString("link"));
				img.setaId(rs.getInt("artist_id"));
				img.setgId(rs.getInt("gallery_id"));
				img.setdId(rs.getInt("detail_id"));
				list.add(img);
			}
			rs.close();
			st.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Image> findByType(String type){
		Connection con = DBconnection.getConnection();
		String sql = "select * from image,detail where image.image_id=detail.image_id and type = '" + type+"'";
		List<Image> list = new ArrayList<Image>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Image img = new Image();
				img.setiId(rs.getInt("image_id"));
				img.setTitle(rs.getString("title"));
				img.setLink(rs.getString("link"));
				img.setaId(rs.getInt("artist_id"));
				img.setgId(rs.getInt("gallery_id"));
				img.setdId(rs.getInt("detail_id"));
				list.add(img);
			}
			rs.close();
			st.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Image> findByLoc(String loc){
		Connection con = DBconnection.getConnection();
		String sql = "select * from image,detail where image.image_id=detail.image_id and location ='" + loc+"'";
		List<Image> list = new ArrayList<Image>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Image img = new Image();
				img.setiId(rs.getInt("image_id"));
				img.setTitle(rs.getString("title"));
				img.setLink(rs.getString("link"));
				img.setaId(rs.getInt("artist_id"));
				img.setgId(rs.getInt("gallery_id"));
				img.setdId(rs.getInt("detail_id"));
				list.add(img);
			}
			rs.close();
			st.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Image> findByYearRange(String y1, String y2){
		int year1 = Integer.parseInt(y1);
		int year2 = Integer.parseInt(y2);
		Connection con = DBconnection.getConnection();
		String sql = "select * from image,detail where image.image_id=detail.image_id and year between " + year1+ " and " +year2;
		List<Image> list = new ArrayList<Image>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Image img = new Image();
				img.setiId(rs.getInt("image_id"));
				img.setTitle(rs.getString("title"));
				img.setLink(rs.getString("link"));
				img.setaId(rs.getInt("artist_id"));
				img.setgId(rs.getInt("gallery_id"));
				img.setdId(rs.getInt("detail_id"));
				list.add(img);
			}
			rs.close();
			st.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
