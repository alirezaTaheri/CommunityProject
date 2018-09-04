package alireza.communityproject.Suppliers;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import alireza.communityproject.CultureProducts.Article;
import alireza.communityproject.CultureProducts.Video;

/**
 * Created by alireza321 on 04/09/2018.
 */

public class Supplier implements Parcelable {
    private String id;
    private String name;
    private String userName;
    private String phoneNumber;
    private String role;
    private String rank;
    private Community communityId;
    private String adress;
    private String tel;
    private String birthDate;
    private ArrayList<Article> articles = new ArrayList<>();
    private ArrayList<Video> videos = new ArrayList<>();

    protected Supplier(Parcel in) {
        id = in.readString();
        name = in.readString();
        userName = in.readString();
        phoneNumber = in.readString();
        role = in.readString();
        rank = in.readString();
        communityId = in.readParcelable(Community.class.getClassLoader());
        adress = in.readString();
        tel = in.readString();
        birthDate = in.readString();
        articles = in.createTypedArrayList(Article.CREATOR);
        videos = in.createTypedArrayList(Video.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(userName);
        dest.writeString(phoneNumber);
        dest.writeString(role);
        dest.writeString(rank);
        dest.writeParcelable(communityId, flags);
        dest.writeString(adress);
        dest.writeString(tel);
        dest.writeString(birthDate);
        dest.writeTypedList(articles);
        dest.writeTypedList(videos);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Supplier> CREATOR = new Creator<Supplier>() {
        @Override
        public Supplier createFromParcel(Parcel in) {
            return new Supplier(in);
        }

        @Override
        public Supplier[] newArray(int size) {
            return new Supplier[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Community getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Community communityId) {
        this.communityId = communityId;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public ArrayList<Video> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<Video> videos) {
        this.videos = videos;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", role='" + role + '\'' +
                ", rank='" + rank + '\'' +
                ", communityId=" + communityId +
                ", adress='" + adress + '\'' +
                ", tel='" + tel + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", articles=" + articles +
                ", videos=" + videos +
                '}';
    }
}
