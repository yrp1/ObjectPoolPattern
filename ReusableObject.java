package com.november19.objectPoolDemo;

public class ReusableObject {

    // data attributes
    private boolean inUse = false;

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public void operations() {
        System.out.println("Perform some operations..");
    }
}//class ReusableObject
