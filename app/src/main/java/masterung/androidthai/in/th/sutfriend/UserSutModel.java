package masterung.androidthai.in.th.sutfriend;


import android.os.Parcel;
import android.os.Parcelable;

public class UserSutModel implements Parcelable{

    private String nameString, urlAvataString;

    public UserSutModel() {
    }

    public UserSutModel(String nameString, String urlAvataString) {
        this.nameString = nameString;
        this.urlAvataString = urlAvataString;
    }

    protected UserSutModel(Parcel in) {
        nameString = in.readString();
        urlAvataString = in.readString();
    }

    public static final Creator<UserSutModel> CREATOR = new Creator<UserSutModel>() {
        @Override
        public UserSutModel createFromParcel(Parcel in) {
            return new UserSutModel(in);
        }

        @Override
        public UserSutModel[] newArray(int size) {
            return new UserSutModel[size];
        }
    };

    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    public String getUrlAvataString() {
        return urlAvataString;
    }

    public void setUrlAvataString(String urlAvataString) {
        this.urlAvataString = urlAvataString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nameString);
        dest.writeString(urlAvataString);
    }
}   // Main Class
