package org.example.dao;

import org.example.connection.DataBaseConnection;
import org.example.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{

    @Override
    public void addProduct(Product p) {
        String sql = "INSERT INTO product(pid, pname, cost, brand, category, rating, discount, manufactureDate) VALUES(?,?,?,?,?,?,?,?)";
        try(Connection con = DataBaseConnection.getConnection();){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, p.getPid());
            ps.setString(2, p.getPname());
            ps.setDouble(3, p.getCost());
            ps.setString(4, p.getBrand());
            ps.setString(5, p.getCategory());
            ps.setInt(6, p.getRating());
            ps.setDouble(7, p.getDiscount());
            ps.setString(8, p.getManufactureDate());
            int rows = ps.executeUpdate();
            System.out.println("Rows affected: " + rows);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try(Connection con = DataBaseConnection.getConnection();){
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(mapToProduct(rs));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product findProductById(int id) {
        Product p = null;
        String sql = "SELECT * FROM product WHERE pid = ?";
        try(Connection con = DataBaseConnection.getConnection();){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p = mapToProduct(rs);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void deleteProduct(int id) {
        String sql = "DELETE FROM product WHERE pid = ?";
        try(Connection con = DataBaseConnection.getConnection();){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println("Rows affected: " + rows);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> sortByName() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product ORDER BY pname";
        try(Connection con = DataBaseConnection.getConnection();){
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(mapToProduct(rs));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> sortByCost() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product ORDER BY cost";
        try(Connection con = DataBaseConnection.getConnection();){
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(mapToProduct(rs));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> sortByCategory() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product ORDER BY category";
        try(Connection con = DataBaseConnection.getConnection();){
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(mapToProduct(rs));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> sortByManufactureDate() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product ORDER BY manufactureDate";
        try(Connection con = DataBaseConnection.getConnection();){
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(mapToProduct(rs));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> findByCategory(String category) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE category = ?";
        try(Connection con = DataBaseConnection.getConnection();){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(mapToProduct(rs));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> findByCost(double mincost, double maxcost) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE cost BETWEEN ? AND ?";
        try(Connection con = DataBaseConnection.getConnection();){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, mincost);
            ps.setDouble(2, maxcost);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(mapToProduct(rs));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> findByManufactureDate(String date) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE manufactureDate = ?";
        try(Connection con = DataBaseConnection.getConnection();){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, date);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(mapToProduct(rs));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> findByManufactureMonth(String month) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE MONTH(manufactureDate) = ?";
        try(Connection con = DataBaseConnection.getConnection();){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, month);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(mapToProduct(rs));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> findByManufactureYear(String year) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE YEAR(manufactureDate) = ?";
        try(Connection con = DataBaseConnection.getConnection();){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, year);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(mapToProduct(rs));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    // Helper method to map ResultSet to Product object
    private Product mapToProduct(ResultSet rs) throws SQLException {
        return new Product(
            rs.getInt("pid"),
            rs.getString("pname"),
            rs.getDouble("cost"),
            rs.getString("brand"),
            rs.getString("category"),
            rs.getInt("rating"),
            rs.getDouble("discount"),
            rs.getString("manufactureDate")
        );
    }
}
