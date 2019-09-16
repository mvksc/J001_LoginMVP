package m.vk.j001_loginmvp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements IUser, Parcelable {
    //Model จะเก็บข้อมูลอะไรบ้าง
    String name;
    String passwd;

    public UserModel(String name,String passwd){
        this.name = name;
        this.passwd = passwd;
    }

    protected UserModel(Parcel in) {
        name = in.readString();
        passwd = in.readString();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPasswd() {
        return passwd;
    }

    @Override
    public int checkUserValidity(String name, String passwd) {
        if (name==null||passwd==null||!name.equals(getName())||!passwd.equals(getPasswd())){
            return -1;
        }
        return 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(passwd);
    }
}
