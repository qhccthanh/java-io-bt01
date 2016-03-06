/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1312536_io_baitap_01;
import java.io.*;
import java.util.Comparator;

/**
 *
 * @author qhcth
 */
public class HocSinhInfo {
    
    public HocSinhInfo()
    {
        this.hinhAnh = null;
    }
    public HocSinhInfo(String maHS, String tenHS, Double diem, String hinhAnh, String diaChi, String ghiChu) {
        this.maHS = maHS;
        this.tenHS = tenHS;
        this.diem = diem;
        this.hinhAnh = hinhAnh;
        this.diaChi = diaChi;
        this.ghiChu = ghiChu;
    }

    public String getMaHS() {
        return maHS;
    }

    public void setMaHS(String maHS) {
        this.maHS = maHS;
    }

    public String getTenHS() {
        return tenHS;
    }

    public void setTenHS(String tenHS) {
        this.tenHS = tenHS;
    }

    public Double getDiem() {
        return diem;
    }

    public void setDiem(Double diem) {
        this.diem = diem;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    static public HocSinhInfo NhapHocSinhInfo()
    {
        HocSinhInfo hs;
        try
        {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            
            //Mã số học sinh
            System.out.printf("Nhập mã số học sinh: ");
            String maHS = buffer.readLine();
            //Tên học sinh
            System.out.printf("Nhập tên học sinh: ");
            String tenHS = buffer.readLine();
            //Diem
            System.out.printf("Nhập điểm học sinh: ");
            String strDiemHS = buffer.readLine();
            Double diemHS = Double.parseDouble(strDiemHS);
            //HinhAnh
            System.out.printf("Nhập hình ảnh học sinh: ");
            String hinhHS = buffer.readLine();
            //DiaChi
            System.out.printf("Nhập địa chỉ học sinh: ");
            String diaChiHS = buffer.readLine();
            //GhiChu
            System.out.printf("Nhập ghi chú học sinh: ");
            String ghichuHS = buffer.readLine();
            
            hs = new HocSinhInfo(maHS,tenHS,diemHS,hinhHS,diaChiHS,ghichuHS);
        }
        catch(IOException | NumberFormatException e){
            return null;
        }
        return hs;
    }
    public void XuatThongTinHocSinh()
    {
        System.out.printf("Mã học sinh: %s\n",this.maHS);
        System.out.printf("Tên học sinh: %s\n",this.tenHS);
        System.out.printf("Điểm học sinh: %s\n",this.diem);
        System.out.printf("Hình ảnh học sinh: %s\n",this.hinhAnh);
        System.out.printf("Địa chỉ học sinh: %s\n",this.diaChi);
        System.out.printf("Ghi chú học sinh: %s\n",this.ghiChu);
    }
    public String ToCSVString()
    {
        String temp = "";
        temp = this.maHS + "," + this.tenHS+ ","+ this.diem + "," + 
                this.hinhAnh +","+ this.diaChi + "," 
                + this.ghiChu +"\n";
        return temp;
    }
    private String maHS;
    private String tenHS;
    private Double diem;
    private String hinhAnh;
    private String diaChi;
    private String ghiChu;
    
    public static Comparator<HocSinhInfo> MaHSTangDan = new Comparator<HocSinhInfo>(){
        public int compare(HocSinhInfo hs1, HocSinhInfo hs2)
        {
            return hs1.getMaHS().compareTo(hs2.getMaHS());
        }
    };
    public static Comparator<HocSinhInfo> MaHSGiamDan = new Comparator<HocSinhInfo>(){
        public int compare(HocSinhInfo hs1, HocSinhInfo hs2)
        {
            return hs2.getMaHS().compareTo(hs1.getMaHS());
        }
    };
    
    public static Comparator<HocSinhInfo> DiemTangDan = new Comparator<HocSinhInfo>(){
        public int compare(HocSinhInfo hs1, HocSinhInfo hs2)
        {
            return (hs1.getDiem() - hs2.getDiem())>0?1:0;
        }
    };
    public static Comparator<HocSinhInfo> DiemGiamDan = new Comparator<HocSinhInfo>(){
        public int compare(HocSinhInfo hs1, HocSinhInfo hs2)
        {
            return (hs1.getDiem() - hs2.getDiem())>0?0:1;
        }
    };
    
}
