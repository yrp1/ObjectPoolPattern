package com.november19.objectPoolDemo;

public class MainApp {
    public static void main(String[] args) {

        ObjectPool pool = ObjectPool.getInstance();
        System.out.println(pool.getMaxPoolSize() + " :: Size of Pool");
        ReusableObject obj1 = pool.acquireObject();
        obj1.operations();

        ObjectPool pool1 = ObjectPool.getInstance();
        ReusableObject obj2 = pool1.acquireObject();
        pool1.releaseObject(obj2);
        System.out.println(obj2.hashCode() + " hashcode value for ::obj2 ");

        ObjectPool pool2 = ObjectPool.getInstance();
        ReusableObject obj3 = pool.acquireObject();

        System.out.println(obj1.hashCode() + " ::obj1");
        System.out.println(obj2.hashCode() + " ::obj2");
        System.out.println(obj3.hashCode() + " ::obj3");

       /*//Case : Here I am not releasing any Objects so it will create new objects(ReusableObject class)...
       ObjectPool pool = ObjectPool.getInstance();
        ObjectPool pool1 =  ObjectPool.getInstance();
        for(int count = 0; count < ObjectPool.DEFAULT_POOL_SIZE + 1; count++ ) {
            ReusableObject obj = pool.acquireObject();
            if (obj == null) {
                System.out.println("Object pool is full...");
                break;
            }
            System.out.println(obj.hashCode() + " inUSe ");
        }*/


        /*//Case : Here I am using Objects at the same time releasing Objects. So, every at every count
        // the objects are reused...
        ObjectPool pool = ObjectPool.getInstance();
        for(int count = 0; count < ObjectPool.DEFAULT_POOL_SIZE ; count++ ){
            ReusableObject obj = pool.acquireObject();
            if(obj == null){
                System.out.println("Object pool is full...");
                break;
            }
            System.out.println(obj.hashCode() + " inUSe ");
            pool.releaseObject(obj);
        }*/
    }
}
