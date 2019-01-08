package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Artist;
import model.Gallery;

public class ArtistDao {
	public void addArtist(Artist a) {
		String sql = "insert into artist(name,birth_year,country,description) values(?,?,?,?) ";
		Connection con = DBconnection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,a.getName());
			pst.setInt(2,a.getBirth());
			pst.setString(3, a.getCountry());
			pst.setString(4, a.getaDes());
			pst.executeUpdate();
			pst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public Artist selectAByImageId(int id) {
		Connection con = DBconnection.getConnection();
		String sql = "select artist.artist_id,artist.name,artist.birth_year,artist.country, artist.description from artist, image where image.artist_id=artist.artist_id and image.image_id="+ id;
		Artist a = new Artist();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				a.setaDes(rs.getString("description"));
				a.setaId(rs.getInt("artist_id"));
				a.setName(rs.getString("name"));
				a.setBirth(rs.getInt("birth_year"));
				a.setCountry(rs.getString("country"));
			}
			rs.close();
			st.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	} 
	
	public void updateArtist(Artist a) {
		Connection con = DBconnection.getConnection();
		String sql = "UPDATE artist SET name = ?,birth_year = ?, country = ?, description =? WHERE artist_id= ?";
		//System.out.println("xx"+g.getgId());
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			//pst.executeQuery(sql);
			
			pst.setString(1,a.getName());
			pst.setInt(2, a.getBirth());
			pst.setString(3, a.getCountry());
			pst.setString(4, a.getaDes());
			pst.setInt(5, a.getaId());
			pst.executeUpdate();
			pst.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	} 
	
	public Artist selectAById(int id) {
		Connection con = DBconnection.getConnection();
		String sql = "select * from artist where artist_id="+ id;
		Artist a = new Artist();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				a.setName(rs.getString("name"));
				a.setaId(rs.getInt("artist_id"));
				a.setBirth(rs.getInt("birth_year"));
				a.setaDes(rs.getString("description"));
				a.setCountry(rs.getString("country"));
			}
			rs.close();
			st.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public List<Artist> showAll(){
		List<Artist> AList = new ArrayList<Artist>();
		Connection con = DBconnection.getConnection();
		String sql = "select * from artist";
		try {
			Statement st = con.createStatement();
			ResultSet rst = st.executeQuery(sql);
			
			while(rst.next()) {
				Artist artist = new Artist();
				artist.setaId(rst.getInt("Artist_id"));
				artist.setName(rst.getString("name"));
				artist.setaDes(rst.getString("description"));
				artist.setBirth(Integer.parseInt(rst.getString("birth_year")));
				artist.setCountry(rst.getString("country"));
				AList.add(artist);
			}
			rst.close();
			st.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return AList;
	}
	
	public List<Artist> selectByCountry(String country){
		Connection con = DBconnection.getConnection();
		String sql = "select * from artist where country='"+country+"'";
		List<Artist> AList = new ArrayList<Artist>();
		try {
			Statement st = con.createStatement();
			ResultSet rst = st.executeQuery(sql);
			while(rst.next()) {
				Artist artist = new Artist();
				artist.setaId(rst.getInt("Artist_id"));
				artist.setName(rst.getString("name"));
				artist.setaDes(rst.getString("description"));
				artist.setBirth(Integer.parseInt(rst.getString("birth_year")));
				artist.setCountry(rst.getString("country"));
				AList.add(artist);
			}
			rst.close();
			st.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return AList;
	}
	
	public List<Artist> selectByYear(String year){
		Connection con = DBconnection.getConnection();
		int birth = Integer.parseInt(year);
		String sql = "select * from artist where birth_year ="+ birth;
		List<Artist> AList = new ArrayList<Artist>();
		try {
			Statement st = con.createStatement();
			ResultSet rst = st.executeQuery(sql);
			while(rst.next()) {
				Artist artist = new Artist();
				artist.setaId(rst.getInt("Artist_id"));
				artist.setName(rst.getString("name"));
				artist.setaDes(rst.getString("description"));
				artist.setBirth(Integer.parseInt(rst.getString("birth_year")));
				artist.setCountry(rst.getString("country"));
				AList.add(artist);
			}
			rst.close();
			st.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return AList;
	}

}
