package m.vk.j001_loginmvp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ProductModel implements  Parcelable {
    //Model จะเก็บข้อมูลอะไรบ้าง
    String name;
    int price;

    public ProductModel(String name, int price){
        this.name = name;
        this.price = price;
    }

    protected ProductModel(Parcel in) {
        name = in.readString();
        price = in.readInt();
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static final Creator<ProductModel> CREATOR = new Creator<ProductModel>() {
        @Override
        public ProductModel createFromParcel(Parcel in) {
            return new ProductModel(in);
        }

        @Override
        public ProductModel[] newArray(int size) {
            return new ProductModel[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(price);
    }
}
