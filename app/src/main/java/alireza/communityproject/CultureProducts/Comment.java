package alireza.communityproject.CultureProducts;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by alireza321 on 04/09/2018.
 */

public class Comment implements Parcelable {
    private String id;
    private String commenterId;
    private String date;
    private String commentText;

    protected Comment(Parcel in) {
        id = in.readString();
        commenterId = in.readString();
        date = in.readString();
        commentText = in.readString();
    }

    public static final Creator<Comment> CREATOR = new Creator<Comment>() {
        @Override
        public Comment createFromParcel(Parcel in) {
            return new Comment(in);
        }

        @Override
        public Comment[] newArray(int size) {
            return new Comment[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(commenterId);
        dest.writeString(date);
        dest.writeString(commentText);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommenterId() {
        return commenterId;
    }

    public void setCommenterId(String commenterId) {
        this.commenterId = commenterId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", commenterId='" + commenterId + '\'' +
                ", date='" + date + '\'' +
                ", commentText='" + commentText + '\'' +
                '}';
    }
}


