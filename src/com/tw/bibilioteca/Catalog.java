package com.tw.bibilioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Catalog {
    private HashMap<String, EntityDetails> availableEntities;
    private HashMap<String, EntityDetails> checked_outEntites;

    public Catalog(HashMap<String, EntityDetails> availableEntities, HashMap<String, EntityDetails> checked_outEntites) {
        this.availableEntities = availableEntities;
        this.checked_outEntites = checked_outEntites;
    }

    public boolean isEntityAvailableForCheckOut(String bookName) {
        return availableEntities.containsKey(bookName);
    }

    public void checkoutEntity(String bookName) {
        EntityDetails bookDetails = availableEntities.get(bookName);
        checked_outEntites.put(bookName, bookDetails);
        availableEntities.remove(bookName);
    }

    @Override
    public String toString() {
        String output = "";
        for (String bookName : availableEntities.keySet())
            output += bookName + " " + availableEntities.get(bookName).toString();
        return output;
    }

    public boolean isEntityReturnable(String bookName) {
        return checked_outEntites.containsKey(bookName);
    }

    public void returnEntity(String bookName) {
        EntityDetails bookDetails = checked_outEntites.get(bookName);
        availableEntities.put(bookName, bookDetails);
        checked_outEntites.remove(bookName);

    }

    public List<String> fields() {
        EntityDetails entityDetails = null;
        if (availableEntities.keySet().iterator().hasNext())
            entityDetails = availableEntities.get(availableEntities.keySet().iterator().next());
        else
            entityDetails = checked_outEntites.get(checked_outEntites.keySet().iterator().next());
        List<String> fields = new ArrayList<String>();
        fields.add("name");
        fields.addAll(entityDetails.fields());
        return fields;
    }

    public HashMap<String, EntityDetails> getAvailableEntities() {
        return availableEntities;
    }
}
