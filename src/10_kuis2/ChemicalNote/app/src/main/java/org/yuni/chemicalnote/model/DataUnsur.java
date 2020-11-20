package org.yuni.chemicalnote.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;

public class DataUnsur implements Parcelable {

    private String namaUnsur;
    private String descp;
    private Integer image;

    public DataUnsur(String namaUnsur, String descp, Integer image) {
        this.namaUnsur = namaUnsur;
        this.descp = descp;
        this.image = image;
    }

    protected DataUnsur(Parcel in) {
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

    public static final Creator<DataUnsur> CREATOR = new Creator<DataUnsur>() {
        @Override
        public DataUnsur createFromParcel(Parcel in) {
            return new DataUnsur(in);
        }

        @Override
        public DataUnsur[] newArray(int size) {
            return new DataUnsur[size];
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
