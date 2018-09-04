package alireza.communityproject.Suppliers;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import alireza.communityproject.CultureProducts.Article;
import alireza.communityproject.CultureProducts.Video;

/**
 * Created by alireza321 on 04/09/2018.
 */

public class Community implements Parcelable {

    private String id;
    private String name;
    private String UniversityId;
    private String tel;
    private String extraInfo;
    private String rank;
    private University university;
    private ArrayList<Article> articles = new ArrayList<>();
    private ArrayList<Video> videos = new ArrayList<>();
    private ArrayList<Supplier> suppliers = new ArrayList<>();


    protected Community(Parcel in) {
        id = in.readString();
        name = in.readString();
        UniversityId = in.readString();
        tel = in.readString();
        extraInfo = in.readString();
        rank = in.readString();
        articles = in.createTypedArrayList(Article.CREATOR);
        videos = in.createTypedArrayList(Video.CREATOR);
        suppliers = in.createTypedArrayList(Supplier.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(UniversityId);
        dest.writeString(tel);
        dest.writeString(extraInfo);
        dest.writeString(rank);
        dest.writeTypedList(articles);
        dest.writeTypedList(videos);
        dest.writeTypedList(suppliers);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Community> CREATOR = new Creator<Community>() {
        @Override
        public Community createFromParcel(Parcel in) {
            return new Community(in);
        }

        @Override
        public Community[] newArray(int size) {
            return new Community[size];
        }
    };
}
