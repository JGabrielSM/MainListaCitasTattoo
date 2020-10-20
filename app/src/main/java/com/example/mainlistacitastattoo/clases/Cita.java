package com.example.mainlistacitastattoo.clases;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Cita implements Parcelable {
    private String nombre, apellidos;
    private Date fechaNacimiento, fechaCita;
    private float fianza;
    private boolean autorizado, color;

    public Cita(String nombre, String apellidos, Date fechaNacimiento, Date fechaCita, float fianza, boolean autorizado, boolean color) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaCita = fechaCita;
        this.fianza = fianza;
        this.autorizado = autorizado;
        this.color = color;
    }

    public Cita() {
    }

    protected Cita(Parcel in) {
        nombre = in.readString();
        apellidos = in.readString();
        fianza = in.readFloat();
        autorizado = in.readByte() != 0;
        color = in.readByte() != 0;
        fechaCita = new Date();
        fechaCita.setTime(in.readLong());
        fechaNacimiento = new Date();
        fechaNacimiento.setTime(in.readLong());
    }

    public static final Creator<Cita> CREATOR = new Creator<Cita>() {
        @Override
        public Cita createFromParcel(Parcel in) {
            return new Cita(in);
        }

        @Override
        public Cita[] newArray(int size) {
            return new Cita[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(apellidos);
        dest.writeFloat(fianza);
        dest.writeByte((byte) (autorizado ? 1 : 0));
        dest.writeByte((byte) (color ? 1 : 0));
        dest.writeLong(fechaCita.getTime());
        dest.writeLong(fechaNacimiento.getTime());
    }
}
