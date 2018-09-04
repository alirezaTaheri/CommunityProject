package alireza.communityproject.Suppliers;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import alireza.communityproject.CultureProducts.Article;
import alireza.communityproject.CultureProducts.Video;

/**
 * Created by alireza321 on 04/09/2018.
 */

public class University implements Parcelable{
    private String id;
    private String name;
    private String tel;
    private String city;
    private String rank;
    private Location location;
    private String extraInfo;
    private ArrayList<Community> communities = new ArrayList<>();
    private ArrayList<Article> articles = new ArrayList<>();
    private ArrayList<Video> videos = new ArrayList<>();
    private ArrayList<Supplier> suppliers = new ArrayList<>();

    protected University(Parcel in) {
        id = in.readString();
        name = in.readString();
        tel = in.readString();
        city = in.readString();
        rank = in.readString();
        location = in.readParcelable(Location.class.getClassLoader());
        extraInfo = in.readString();
        communities = in.createTypedArrayList(Community.CREATOR);
        articles = in.createTypedArrayList(Article.CREATOR);
        videos = in.createTypedArrayList(Video.CREATOR);
        suppliers = in.createTypedArrayList(Supplier.CREATOR);
    }

    public static final Creator<University> CREATOR = new Creator<University>() {
        @Override
        public University createFromParcel(Parcel in) {
            return new University(in);
        }

        @Override
        public University[] newArray(int size) {
            return new University[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(tel);
        dest.writeString(city);
        dest.writeString(rank);
        dest.writeParcelable(location, flags);
        dest.writeString(extraInfo);
        dest.writeTypedList(communities);
        dest.writeTypedList(articles);
        dest.writeTypedList(videos);
        dest.writeTypedList(suppliers);
    }

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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public ArrayList<Community> getCommunities() {
        return communities;
    }

    public void setCommunities(ArrayList<Community> communities) {
        this.communities = communities;
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

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", city='" + city + '\'' +
                ", rank='" + rank + '\'' +
                ", location=" + location +
                ", extraInfo='" + extraInfo + '\'' +
                ", communities=" + communities +
                ", articles=" + articles +
                ", videos=" + videos +
                ", suppliers=" + suppliers +
                '}';
    }
}
