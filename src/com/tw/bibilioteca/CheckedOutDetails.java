package com.tw.bibilioteca;

import java.util.List;

public class CheckedOutDetails implements EntityDetails{
    private EntityDetails entityDetails;
    private String libraryNumber;

    public CheckedOutDetails(EntityDetails entityDetails, String libraryNumber) {
        this.entityDetails = entityDetails;
        this.libraryNumber = libraryNumber;
    }

    @Override
    public String toString(){
        return entityDetails.toString() + " " + libraryNumber;
    }

    public String getLibraryNumber(){
        return libraryNumber;
    }

    public EntityDetails getEntityDetails(){
        return entityDetails;
    }
    public List<String> fields() {
        List<String> bookFields = entityDetails.fields();
        bookFields.add("user");
        return bookFields;
    }
}
