package dao;

import java.util.*;
import java.sql.*;
import model.Gallery;
import model.Image;

public class GalleryDao {
	
	public List<Gallery> getAllGallery(){
		List<Gallery> gList = new ArrayList<Gallery>();
		Connection con = DBconnection.getConnection();
		String sql = "select * from gallery  ";
		

		try {
			Statement st = con.createStatement();
			ResultSet rst = st.executeQuery(sql);
			
			while(rst.next()) {
				Gallery gallery = new Gallery();
				gallery.setgId(rst.getInt("gallery_id"));
				gallery.setName(rst.getString("name"));
				gallery.setgDes(rst.getString("description"));
				gList.add(gallery);
			}
			rst.close();
			st.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return gList;
	}
	
	
	public List<String> getFirstImg(int gId) {
		String imgUrl = null;
		Connection con = DBconnection.getConnection();
		String sql = "select image.link as link  from gallery,image  where image.gallery_id = gallery.gallery_id and gallery.gallery_id="+gId;
		List<String> links = new ArrayList<String>();

		try {
			Statement st = con.createStatement();
			ResultSet rst = st.executeQuery(sql);
			
			while(rst.next()) {
				imgUrl = rst.getString("link");
				links.add(imgUrl);
			}
			rst.close();
			st.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return links;
	}
	
	public void updateGallery(Gallery g) {
		Connection con = DBconnection.getConnection();
		String sql = "UPDATE gallery SET name = ?,description =? WHERE gallery_id= ?";
		//System.out.println("xx"+g.getgId());
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			//pst.executeQuery(sql);
			
			pst.setString(1,g.getName());
			pst.setString(2, g.getgDes());
			pst.setInt(3, g.getgId());
			System.out.println("jj"+g.getgId());
			pst.executeUpdate();
			pst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Gallery selectGById(int id) {
		Connection con = DBconnection.getConnection();
		String sql = "select * from gallery where gallery_id="+ id;
		Gallery g = new Gallery();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				g.setgId(rs.getInt("gallery_id"));
				g.setName(rs.getString("name"));
				g.setgDes(rs.getString("description"));
			}
			rs.close();
			st.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return g;
	}

	public void addGallery(Gallery g) {
		String sql = "insert into gallery(name,description) values(?,?) ";
		Connection con = DBconnection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,g.getName());
			pst.setString(2, g.getgDes());
			pst.executeUpdate();
			pst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//view all the images of the gallery
	public List<Image> viewGallery(int id) {
		String sql = "Select i.image_id  as id,i.title as title, i.link as link " + 
				"from gallery g, image i " + 
				"where g.gallery_id = i.gallery_id and g.gallery_id=" + id;
		
		Connection con = DBconnection.getConnection();
		List<Image> iList = new ArrayList<Image>(); 
		try {
			Statement st = con.createStatement();
			ResultSet rst = st.executeQuery(sql);
			while(rst.next()) {
				Image image = new Image();
				image.setiId(rst.getInt("id"));
				image.setTitle(rst.getString("title"));
				image.setLink(rst.getString("link"));
				iList.add(image);
			}
			rst.close();
			st.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return iList;
	}
	
	//return the total image number of the gallery
	public int totalNumber(int id) {
		String sql = "Select count(i.title) as amount  " + 
				"from gallery g, image i " + 
				"where g.gallery_id = i.gallery_id and g.gallery_id=" + id;
		Connection con = DBconnection.getConnection();
		int amount=0;
		try {
			Statement st = con.createStatement();
			ResultSet rst = st.executeQuery(sql);
			while(rst.next()){
				amount = rst.getInt("amount");
			}
			rst.close();
			st.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return amount;
	}
}
