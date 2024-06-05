/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author NguyenVanSonIT
 */
public class product {
    private Integer maSP;
    private String tenSP;
    private Float giaBan;
    private Float giaMua;
    private Float giamGia;
    private Integer soLuong;

     public String toFile(){
        return String.format("%s|%s|%s|%s|%s|%s%n", maSP, tenSP, giaBan, giaMua, giamGia, soLuong);
    }

    public product() {
    }


    public product(String tenSP, Float giaBan, Float giaMua, Float giamGia, Integer soLuong) {
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.giaMua = giaMua;
        this.giamGia = giamGia;
        this.soLuong = soLuong;
    }

    public product(Integer maSP, String tenSP, Float giaBan, Float giaMua, Float giamGia, Integer soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.giaMua = giaMua;
        this.giamGia = giamGia;
        this.soLuong = soLuong;
    }


  
    public Integer getmaSP() {
        return maSP;
    }

    public void setmaSP(Integer maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Float giaBan) {
        this.giaBan = giaBan;
    }

    public Float getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(Float giaMua) {
        this.giaMua = giaMua;
    }

    public Float getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(Float giamGia) {
        this.giamGia = giamGia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "product{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", giaBan=" + giaBan + ", giaMua=" + giaMua + ", giamGia=" + giamGia + ", soLuong=" + soLuong + '}';
    }
    
} 
