/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1312536_io_baitap_01;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author qhcth
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        while(true){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("\t\tChương trình quản lý học sinh");
            System.out.println("\tChọn 1: thêm học sinh");
            System.out.println("\tChọn 2: cập nhật học sinh");
            System.out.println("\tChọn 3: xoá học sinh");
            System.out.println("\t4 Xem danh sách học sinh");
                System.out.println("\t\t41 Sap xep theo ma hoc sinh tang dan");
                System.out.println("\t\t42 Sap xep theo ma hoc sinh giam dan");
                System.out.println("\t\t43 Sap xep theo diem hoc sinh tang dan");
                System.out.println("\t\t44 Sap xep theo diem hoc sinh giam dan");
            System.out.println("\tChọn 5: import danh sách học sinh (csv)");
            System.out.println("\tChọn 6: export danh sách học sinh (csv)");
            System.out.println("\tChọn 0: thoát");
            System.out.print("Vui lòng chọn: ");
            try{
                Integer  chon = -1;
                String strChon = buffer.readLine();
                chon = Integer.parseInt(strChon);
                ThucThiMenu(chon);
            }catch(Exception e){
                System.out.println("Bạn đã chọn không hợp lệ vui lòng chọn lại");
            }
        }
    }
    private static void ThucThiMenu(Integer i) throws IOException
    {
        switch(i)
        {
            case 0:
                System.exit(0);
                break;
            case 1:
            {
                System.out.println("\tThêm học sinh");
                HocSinhInfo newHS = HocSinhInfo.NhapHocSinhInfo();
                if(newHS !=null)
                    DanhSachHocSinhInfo.GetDanhSachHS().ThemHocSinh(newHS);
                break;
            }
            case 2:
            {
                System.out.println("\tCập nhật học sinh");
                System.out.print("Nhập mã học sinh cập nhật: ");
                String mHS = buffer.readLine();
                HocSinhInfo hs = DanhSachHocSinhInfo.GetDanhSachHS().TimHocSinh(mHS);
                
                if(hs == null){
                 System.out.println("Không tìm thấy học sinh");
                 break;
                }
                
                System.out.println("Vui long nhập thông tin cập nhật");
                HocSinhInfo new1HS = HocSinhInfo.NhapHocSinhInfo();
                if(new1HS !=null){
                    DanhSachHocSinhInfo.GetDanhSachHS().ThemHocSinh(new1HS);
                    DanhSachHocSinhInfo.GetDS().remove(hs);
                }else
                {
                    System.out.println("Cập nhật thất bại");
                }
                break;
            }
            case 3:{
                System.out.println("\tXoá học sinh");
                System.out.print("Nhập mã học sinh xoá: ");
                String mHS = buffer.readLine();
                HocSinhInfo hs = DanhSachHocSinhInfo.GetDanhSachHS().TimHocSinh(mHS);
                
                if(hs == null){
                 System.out.println("Không tìm thấy học sinh");
                }else{
                    DanhSachHocSinhInfo.GetDS().remove(hs);
                }
                break;
            }
            case 41:
                System.out.println("\tXem danh sách học sinh");
                Collections.sort(DanhSachHocSinhInfo.GetDS(),HocSinhInfo.MaHSTangDan);
                DanhSachHocSinhInfo.GetDanhSachHS().InDanhSachHocSinh();
                break;
            case 42:
                System.out.println("\tXem danh sách học sinh");
                Collections.sort(DanhSachHocSinhInfo.GetDS(),HocSinhInfo.MaHSGiamDan);
                DanhSachHocSinhInfo.GetDanhSachHS().InDanhSachHocSinh();
                break;
             case 43:
                System.out.println("\tXem danh sách học sinh");
                Collections.sort(DanhSachHocSinhInfo.GetDS(),HocSinhInfo.DiemTangDan);
                DanhSachHocSinhInfo.GetDanhSachHS().InDanhSachHocSinh();
                break;
            case 44:
                System.out.println("\tXem danh sách học sinh");
                Collections.sort(DanhSachHocSinhInfo.GetDS(),HocSinhInfo.DiemGiamDan);
                DanhSachHocSinhInfo.GetDanhSachHS().InDanhSachHocSinh();
                break;
            case 5:
                System.out.println("Nhap duong dan file: ");
                String filePath = buffer.readLine();
                DanhSachHocSinhProvider.ImportCSVFile(filePath);
                break;
            case 6:
                System.out.println("Nhap duong dan file: ");
                String filePathOut = buffer.readLine();
                DanhSachHocSinhProvider.ExportCSVFile(filePathOut);
                break;
            default:{
                System.out.println("Bạn đã chọn không hợp lệ vui lòng chọn lại");
                break;
            }
        }
        buffer.readLine();
    }
    
}
