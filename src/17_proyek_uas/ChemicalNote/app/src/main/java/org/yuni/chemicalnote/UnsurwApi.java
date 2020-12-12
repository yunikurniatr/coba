package org.yuni.chemicalnote;

import com.google.gson.annotations.SerializedName;
import android.os.Parcel;
import android.os.Parcelable;

public class UnsurwApi implements Parcelable {
    @SerializedName("name")
    private String name;
    @SerializedName("appearance")
    private String appearance;
    @SerializedName("atomic_mass")
    private String atomic_mass;
    @SerializedName("category")
    private String category;
    @SerializedName("density")
    private String density;
    @SerializedName("discovered_by")
    private String discovered_by;
    @SerializedName("melt")
    private String melt;
    @SerializedName("molar_heat")
    private String molar_heat;
    @SerializedName("named_by")
    private String named_by;
    @SerializedName("number")
    private String number;
    @SerializedName("period")
    private String period;
    @SerializedName("phase")
    private String phase;
    @SerializedName("summary")
    private String summary;
    @SerializedName("symbol")
    private String symbol;
    @SerializedName("electron_configuration")
    private String electron_configuration;
    @SerializedName("electron_configuration_semantic")
    private String electron_configuration_semantic;
    @SerializedName("electron_affinity")
    private String electron_affinity;
    @SerializedName("electronegativity_pauling")
    private String electronegativity_pauling;

    public UnsurwApi(String name, String appearance, String atomic_mass, String category, String density, String discovered_by, String melt, String molar_heat, String named_by, String number, String period, String phase, String summary, String symbol, String electron_configuration, String electron_configuration_semantic, String electron_affinity, String electronegativity_pauling) {
        this.name = name;
        this.appearance = appearance;
        this.atomic_mass = atomic_mass;
        this.category = category;
        this.density = density;
        this.discovered_by = discovered_by;
        this.melt = melt;
        this.molar_heat = molar_heat;
        this.named_by = named_by;
        this.number = number;
        this.period = period;
        this.phase = phase;
        this.summary = summary;
        this.symbol = symbol;
        this.electron_configuration = electron_configuration;
        this.electron_configuration_semantic = electron_configuration_semantic;
        this.electron_affinity = electron_affinity;
        this.electronegativity_pauling = electronegativity_pauling;
    }



    public String getName() {
        return name;
    }

    public String getAppearance() {
        return appearance;
    }

    public String getAtomic_mass() {
        return atomic_mass;
    }

    public String getCategory() {
        return category;
    }

    public String getDensity() {
        return density;
    }

    public String getDiscovered_by() {
        return discovered_by;
    }

    public String getMelt() {
        return melt;
    }

    public String getMolar_heat() {
        return molar_heat;
    }

    public String getNamed_by() {
        return named_by;
    }

    public String getNumber() {
        return number;
    }

    public String getPeriod() {
        return period;
    }

    public String getPhase() {
        return phase;
    }

    public String getSummary() {
        return summary;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getElectron_configuration() {
        return electron_configuration;
    }

    public String getElectron_configuration_semantic() {
        return electron_configuration_semantic;
    }

    public String getElectron_affinity() {
        return electron_affinity;
    }

    public String getElectronegativity_pauling() {
        return electronegativity_pauling;
    }

    protected UnsurwApi(Parcel in) {
        name = in.readString();
        appearance = in.readString();
        atomic_mass = in.readString();
        category = in.readString();
        density = in.readString();
        discovered_by = in.readString();
        melt = in.readString();
        molar_heat = in.readString();
        named_by = in.readString();
        number = in.readString();
        period = in.readString();
        phase = in.readString();
        summary = in.readString();;
        symbol = in.readString();;
        electron_affinity = in.readString();
        electron_configuration = in.readString();
        electron_configuration_semantic = in.readString();
        electronegativity_pauling = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(appearance);
        dest.writeString(atomic_mass);
        dest.writeString(category);
        dest.writeString(density);
        dest.writeString(discovered_by);
        dest.writeString(melt);
        dest.writeString(molar_heat);
        dest.writeString(named_by);
        dest.writeString(number);
        dest.writeString(period);
        dest.writeString(phase);
        dest.writeString(summary);
        dest.writeString(symbol);
        dest.writeString(electron_affinity);
        dest.writeString(electron_configuration);
        dest.writeString(electron_configuration_semantic);
        dest.writeString(electronegativity_pauling);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UnsurwApi> CREATOR = new Creator<UnsurwApi>() {
        @Override
        public UnsurwApi createFromParcel(Parcel in) {
            return new UnsurwApi(in);
        }

        @Override
        public UnsurwApi[] newArray(int size) {
            return new UnsurwApi[size];
        }
    };
}
