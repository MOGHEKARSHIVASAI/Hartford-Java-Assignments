package org.example;

import java.util.*;

public class PhoneManager {
    private List<Phone> phones;
    public PhoneManager() {
        phones = new ArrayList<>();
    }

    public void addPhone(Phone phone) {
        phones.add(phone);
    }
    
    public List<Phone> getPhones() {
        return phones;
    }
    
    public List<Phone> getPhonesByBrand(String brand) {
        List<Phone> result = new ArrayList<>();
        for (Phone p : phones) {
            if (p.getBrand().equalsIgnoreCase(brand)) {
                result.add(p);
            }
        }
        return result;
    }
    
    public Phone getPhoneById(int id) {
        for (Phone p : phones) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    
    public boolean removePhoneById(int id) {
        return phones.remove(getPhoneById(id));
    }
    

    class NameComparator implements Comparator<Phone> {
        @Override
        public int compare(Phone a, Phone b) {
            return a.getName().compareTo(b.getName());
        }
    }
    public void sortByName() {
        Collections.sort(phones, new NameComparator());
    }
    public void sortByPrice(){
        Collections.sort(phones, new Comparator<Phone>(){
            @Override
            public int compare(Phone a,Phone b){
                return Double.compare(a.getPrice(), b.getPrice());
            }
        });
    }

    public void sortByCamMp(){
        Collections.sort(phones,(a,b)->Integer.compare(a.getCameraMP(), b.getCameraMP()));
    }
    public void sortByReleaseDate(){
        Collections.sort(phones,(a,b)->{
            String [] dateA=a.getReleaseDate().split("-");
            String [] dateB=b.getReleaseDate().split("-");
            int yearA=Integer.parseInt(dateA[2]);
            int yearB=Integer.parseInt(dateB[2]);
            if(yearA!=yearB) return Integer.compare(yearA, yearB);
            int monthA=Integer.parseInt(dateA[1]);
            int monthB=Integer.parseInt(dateB[1]);
            if(monthA!=monthB) return Integer.compare(monthA, monthB);
            int dayA=Integer.parseInt(dateA[0]);
            int dayB=Integer.parseInt(dateB[0]);
            return Integer.compare(dayA, dayB);
        });
    }
}
