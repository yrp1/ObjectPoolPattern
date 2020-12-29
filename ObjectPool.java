package com.november19.objectPoolDemo;

import java.util.ArrayList;

public class ObjectPool {
    public static final int DEFAULT_POOL_SIZE = 10;
    //data attributes
    private ArrayList<ReusableObject> list;
    private int maxPoolSize = DEFAULT_POOL_SIZE;

    protected static ObjectPool instance = null;

    private ObjectPool() {
        list = new ArrayList<>();
    }

    //Operations
    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public synchronized ReusableObject acquireObject() { //pool of Object
        for (ReusableObject visitor : list) {
            if (!visitor.isInUse()) {
                visitor.setInUse(true);
                return visitor;
            }
        }
        if (list.size() >= getMaxPoolSize()) {
            // the pool limit is reached:
            return null;
        }
        ReusableObject visitor = new ReusableObject();
        visitor.setInUse(true);
        list.add(visitor);
        return visitor;
    }


    public synchronized void releaseObject(ReusableObject subject) {
        int idx = list.indexOf(subject);
        ReusableObject visitor = list.get(idx);
        visitor.setInUse(false);
    }

    //Singleton implementation
    public synchronized static ObjectPool getInstance() {
        if (instance == null) {
            instance = new ObjectPool();
        }
        return instance;
    }
}
