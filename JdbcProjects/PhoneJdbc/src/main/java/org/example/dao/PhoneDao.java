package org.example.dao;

import org.example.entity.Phone;

import java.util.List;

public interface PhoneDao {
    public void addPhone(Phone p);
    public List<Phone> findAll();
    public Phone findPhoneById(int id);
    void deletePhone(int id);
    List<Phone> sortByName();
    List<Phone> sortByCost();
    List<Phone> sortByCategory();
    List<Phone> filterByCategory(String category);
    List<Phone> filterByCost(double mincost,double maxcost);


}
