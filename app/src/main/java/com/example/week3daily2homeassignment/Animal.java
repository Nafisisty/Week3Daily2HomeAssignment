package com.example.week3daily2homeassignment;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {

    private String animalName;
    private String animalType;
    private String animalSound;
    private String animalImage;

    public Animal() {
    }

    public Animal(String animalName, String animalType, String animalSound, String animalImage) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalSound = animalSound;
        this.animalImage = animalImage;
    }

    protected Animal(Parcel in) {
        animalName = in.readString();
        animalType = in.readString();
        animalSound = in.readString();
        animalImage = in.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalSound() {
        return animalSound;
    }

    public void setAnimalSound(String animalSound) {
        this.animalSound = animalSound;
    }

    public String getAnimalImage() {
        return animalImage;
    }

    public void setAnimalImage(String animalImage) {
        this.animalImage = animalImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(animalName);
        dest.writeString(animalType);
        dest.writeString(animalSound);
        dest.writeString(animalImage);
    }
}
