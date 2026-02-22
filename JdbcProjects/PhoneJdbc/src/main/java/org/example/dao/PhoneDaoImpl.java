package org.example.dao;

import org.example.connection.DataBaseConnection;
import org.example.entity.Phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneDaoImpl implements PhoneDao{
    @Override
    public void addPhone(Phone p) {
        String sql="insert into phone( ) values(?,?,?,?,?)";
        try(Connection con= DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,p.getId());
            ps.setString(2,p.getName());
            ps.setDouble(3,p.getCost());
            ps.setString(4,p.getBrand());
            ps.setString(5,p.getCategory());
            int rows=ps.executeUpdate();
            System.out.println("Rows effected: "+rows);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public List<Phone> findAll() {
       List<Phone> list=new ArrayList<>();
       String sql="select * from phone";
        try(Connection con= DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                list.add(new Phone(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5)));

            }


        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public Phone findPhoneById(int id) {
        Phone p=null;
        String sql="select * from phone where id=?";
        try(Connection con= DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                p=new Phone(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5));

            }


        }
        catch(Exception e){
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void deletePhone(int id) {
        String sql="delete from phone where id=?";
        try(Connection con= DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            int rows=ps.executeUpdate();
            System.out.println("No of rows efected: "+rows);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Phone> sortByName() {
        List<Phone> list=new ArrayList<>();
        String sql="select * from phone order by name";
        try(Connection con= DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                list.add(new Phone(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5)));

            }


        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;


    }

    @Override
    public List<Phone> sortByCost() {
        List<Phone> list=new ArrayList<>();
        String sql="select * from phone order by cost";
        try(Connection con= DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                list.add(new Phone(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5)));

            }


        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public List<Phone> sortByCategory() {
        List<Phone> list=new ArrayList<>();
        String sql="select * from phone order by category";
        try(Connection con= DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                list.add(mapToPhone(rs));

            }


        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;

    }

    private Phone mapToPhone(ResultSet rs) throws SQLException {
        return new Phone(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5));
    }

    @Override
    public List<Phone> filterByCategory(String category) {
        List<Phone> list=new ArrayList<>();
        String sql="select * from phone where category=?";
        try(Connection con= DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,category);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                list.add(new Phone(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5)));

            }


        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Phone> filterByCost(double mincost,double maxcost) {
        List<Phone> list=new ArrayList<>();
        String sql="select * from phone where cost between ? and ?";
        try(Connection con= DataBaseConnection.getConnection();){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDouble(1,mincost);
            ps.setDouble(2,maxcost);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                list.add(new Phone(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getString(4),rs.getString(5)));

            }


        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
