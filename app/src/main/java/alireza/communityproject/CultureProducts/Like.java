package alireza.communityproject.CultureProducts;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by alireza321 on 04/09/2018.
 */

public class Like implements Parcelable {
    private String id;
    private String likerId;
    private String date;
    private String postId;

    protected Like(Parcel in) {
        id = in.readString();
        likerId = in.readString();
        date = in.readString();
        postId = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(likerId);
        dest.writeString(date);
        dest.writeString(postId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Like> CREATOR = new Creator<Like>() {
        @Override
        public Like createFromParcel(Parcel in) {
            return new Like(in);
        }

        @Override
        public Like[] newArray(int size) {
            return new Like[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLikerId() {
        return likerId;
    }

    public void setLikerId(String likerId) {
        this.likerId = likerId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "Like{" +
                "id='" + id + '\'' +
                ", likerId='" + likerId + '\'' +
                ", date='" + date + '\'' +
                ", postId='" + postId + '\'' +
                '}';
    }
}
