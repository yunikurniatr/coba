package org.aplas.recyclerviewrecipe;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;

public class DataResep implements Parcelable {

    private String namaUnsur;
    private String descp;
    private Integer image;

    public DataResep(String namaUnsur, String descp, Integer image) {
        this.namaUnsur = namaUnsur;
        this.descp = descp;
        this.image = image;
    }

    protected DataResep(Parcel in) {
        namaUnsur = in.readString();;
        descp = in.readString();;
        image = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(namaUnsur);
        dest.writeString(descp);
        dest.writeInt(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DataResep> CREATOR = new Creator<DataResep>() {
        @Override
        public DataResep createFromParcel(Parcel in) {
            return new DataResep(in);
        }

        @Override
        public DataResep[] newArray(int size) {
            return new DataResep[size];
        }
    };

    public String getNamaUnsur() {
        return namaUnsur;
    }

    public void setNamaUnsur(String namaUnsur) {
        this.namaUnsur = namaUnsur;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
