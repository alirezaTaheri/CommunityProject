package alireza.communityproject.CultureProducts;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import alireza.communityproject.Suppliers.Supplier;

/**
 * Created by alireza321 on 04/09/2018.
 */

public class Video implements Parcelable{
    private String id;
    private String name;
    private String title;
    private String subtitle;
    private String category;
    private String subject;
    private String ownerID;
    private Supplier owner;
    private String duration;
    private String rate;
    private String releaseDate;
    private String expirationDate;
    private String updateDate;
    private ArrayList<Like> likes = new ArrayList<>();
    private ArrayList<Comment> comments = new ArrayList<>();
    private ArrayList<Tag> tags = new ArrayList<>();

    protected Video(Parcel in) {
        id = in.readString();
        name = in.readString();
        title = in.readString();
        subtitle = in.readString();
        category = in.readString();
        subject = in.readString();
        ownerID = in.readString();
        owner = in.readParcelable(Supplier.class.getClassLoader());
        duration = in.readString();
        rate = in.readString();
        releaseDate = in.readString();
        expirationDate = in.readString();
        updateDate = in.readString();
        likes = in.createTypedArrayList(Like.CREATOR);
        comments = in.createTypedArrayList(Comment.CREATOR);
        tags = in.createTypedArrayList(Tag.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(title);
        dest.writeString(subtitle);
        dest.writeString(category);
        dest.writeString(subject);
        dest.writeString(ownerID);
        dest.writeParcelable(owner, flags);
        dest.writeString(duration);
        dest.writeString(rate);
        dest.writeString(releaseDate);
        dest.writeString(expirationDate);
        dest.writeString(updateDate);
        dest.writeTypedList(likes);
        dest.writeTypedList(comments);
        dest.writeTypedList(tags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Video> CREATOR = new Creator<Video>() {
        @Override
        public Video createFromParcel(Parcel in) {
            return new Video(in);
        }

        @Override
        public Video[] newArray(int size) {
            return new Video[size];
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(String ownerID) {
        this.ownerID = ownerID;
    }

    public Supplier getOwner() {
        return owner;
    }

    public void setOwner(Supplier owner) {
        this.owner = owner;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public ArrayList<Like> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Like> likes) {
        this.likes = likes;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", category='" + category + '\'' +
                ", subject='" + subject + '\'' +
                ", ownerID='" + ownerID + '\'' +
                ", owner=" + owner +
                ", duration='" + duration + '\'' +
                ", rate='" + rate + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", likes=" + likes +
                ", comments=" + comments +
                ", tags=" + tags +
                '}';
    }
}
