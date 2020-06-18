package com.example.project_m.profil;

public class Item {
    private String name;
    private String introduction;
    private String like;
    private String follower;
    private String following;
    private String profile;

    public Item(String name, String introduction, String like, String follower,String following, String profile){
        this.name = name;
        this.introduction = introduction;
        this.like = like;
        this.follower = follower;
        this.following = following;
        this.profile = profile;
    }

    public Item(String name, String introduction, String like, String follower, String following){
        this.name = name;
        this.introduction = introduction;
        this.like = like;
        this.follower = follower;
        this.following = following;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getIntroduction(){
        return this.introduction;
    }
    public void setIntroduction(String Introduction){
        this.introduction = introduction;
    }
    public String getLike(){
        return this.like;
    }
    public void setLike(String like){
        this.like = like;
    }
    public String getFollower(){
        return this.follower;
    }
    public void setFollower(String follower){
        this.follower = follower;
    }
    public String getFollowing(){
        return this.following;
    }
    public void setFollowing(String following){
        this.following = following;
    }
    public String getProfile(){
        return this.profile;
    }
    public void setProfile(String profile){
        this.profile = profile;
    }
}