package com.example.myapplication.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class LoveBean {
    @Id
   private Long id;
   private String myId;
   private String title;
   private String image;
   private int type;
@Generated(hash = 1801228366)
public LoveBean(Long id, String myId, String title, String image, int type) {
    this.id = id;
    this.myId = myId;
    this.title = title;
    this.image = image;
    this.type = type;
}
@Generated(hash = 461774961)
public LoveBean() {
}
public Long getId() {
    return this.id;
}
public void setId(Long id) {
    this.id = id;
}
public String getMyId() {
    return this.myId;
}
public void setMyId(String myId) {
    this.myId = myId;
}
public String getTitle() {
    return this.title;
}
public void setTitle(String title) {
    this.title = title;
}
public String getImage() {
    return this.image;
}
public void setImage(String image) {
    this.image = image;
}
public int getType() {
    return this.type;
}
public void setType(int type) {
    this.type = type;
}

}
