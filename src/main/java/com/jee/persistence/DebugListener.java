package com.jee.persistence;

import javax.persistence.*;

public class DebugListener {
    @PrePersist
    public void  prePersist(Object object){
        System.out.println("prePersisting "+ object.getClass().getName() );
    }

    @PostPersist
    public void postPersist(Object object){
        System.out.println("Post persist=>" + object.getClass().getName());
    }

    @PostLoad
    public void loading(Object object) {
        System.out.println("Selecting data =>" + object.getClass().getName());
    }

    @PreUpdate
    public  void preUpdate(Object object){
        System.out.println("PreUpdate =>"+object.getClass().getName());
    }

    @PostUpdate
    public void postUpdate(Object object){
        System.out.println("Post update =>" + object.getClass().getName());
    }

    @PreRemove
    public void preRemove(Object object) {
        System.out.println("Pre Remove => " + object.getClass().getName());
    }

    @PostRemove
    public void postRemove(Object object) {
        System.out.println("Post Remove " + object.getClass().getName());
    }


}
