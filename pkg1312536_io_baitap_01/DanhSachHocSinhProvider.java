/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1312536_io_baitap_01;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author qhcth
 */
public class DanhSachHocSinhProvider {
    
    static   private final String splitBy = ",";
    static public BufferedReader buffer = null;
    static private DanhSachHocSinhInfo dsHS = DanhSachHocSinhInfo.GetDanhSachHS();
    
    static public boolean ExportCSVFile(String filePath) throws IOException
    {
        BufferedWriter write = new BufferedWriter(new FileWriter(filePath));
        for(HocSinhInfo hs: DanhSachHocSinhInfo.GetDS())
            write.append(hs.ToCSVString());
        write.flush();
        write.close();
                
        return false;
    }
    
    static public boolean ImportCSVFile(String filePath)
    {
        try {
            buffer = new BufferedReader(new FileReader(filePath));
            String line = "";
            while((line = buffer.readLine()) != null)
            {
                HocSinhInfo hs = new HocSinhInfo();
                String[] arrHS = line.split(splitBy);
                
                hs.setMaHS(arrHS[0]);
                hs.setTenHS(arrHS[1]);
                hs.setDiem(Double.parseDouble(arrHS[2]));
                hs.setHinhAnh(arrHS[3]);
                hs.setDiaChi(arrHS[4]);
                hs.setGhiChu(arrHS[5]);
                
                dsHS.ThemHocSinh(hs);
            }
            
            System.out.println("Import thành công");
            return true;
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DanhSachHocSinhProvider.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Không tìm thấy file");
        } catch (IOException ex) {
            Logger.getLogger(DanhSachHocSinhProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException e){
        }
        return false;
        
    }
    
    
}
