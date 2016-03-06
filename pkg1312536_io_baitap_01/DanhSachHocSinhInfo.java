/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1312536_io_baitap_01;

import java.util.ArrayList;

/**
 *
 * @author qhcth
 */
public class DanhSachHocSinhInfo {
    static private ArrayList<HocSinhInfo> dsHocSinh = new ArrayList<>();
    static private DanhSachHocSinhInfo _instance = new DanhSachHocSinhInfo();
    
    private DanhSachHocSinhInfo(){}
    static public DanhSachHocSinhInfo GetDanhSachHS(){
        if(_instance == null) _instance = new DanhSachHocSinhInfo();
        return _instance;
    }

 
    static public ArrayList<HocSinhInfo> GetDS()
    {
        return dsHocSinh;
    }
    public void ThemHocSinh(HocSinhInfo hs)
    {
        dsHocSinh.add(hs);
    }
    public void InDanhSachHocSinh()
    {
        if(dsHocSinh.isEmpty()) System.out.println("Danh sách học sinh rỗng");
        for(HocSinhInfo hs: dsHocSinh){
            hs.XuatThongTinHocSinh();
            System.out.println("-------------------------");
        }
    }
    public HocSinhInfo TimHocSinh(String maHS)
    {
        HocSinhInfo hs = null;
        
        for(int i =0;i<dsHocSinh.size();i++){
            if(dsHocSinh.get(i).getMaHS().equals(maHS)) return dsHocSinh.get(i);
        }
        return hs;
    }
    public boolean XoaHocSinh(String maHS)
    {
        HocSinhInfo hs = TimHocSinh(maHS);
        if(hs == null) return false;
        dsHocSinh.remove(hs);
        return true;
    }
    
}
