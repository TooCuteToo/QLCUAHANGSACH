/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Pojo.TacGiaPoJo;
import Provider.SQLProvider;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class TacGiaDAO {
    public ArrayList<TacGiaPoJo> getTacGiaList() throws ClassNotFoundException, SQLException {
        ArrayList<TacGiaPoJo> listTG = new ArrayList<>();        
        SQLProvider provider = new SQLProvider();
        
        String sql = "select * from TACGIA";
        
        provider.connect();
        ResultSet rs = provider.executeQuery(sql);
        
        while (rs.next()) {
            String ma_tg = rs.getString("MATG");
            String ten_tg = rs.getString("TENTG");
            
            TacGiaPoJo tg = new TacGiaPoJo(ma_tg, ten_tg);
            listTG.add(tg);
        }
        
        provider.close();
        
        return listTG;
    }
    
    public ArrayList<TacGiaPoJo> getTGListBySearch(TacGiaPoJo tg) throws ClassNotFoundException, SQLException {
        ArrayList<TacGiaPoJo> listTG = new ArrayList<>();        
        SQLProvider provider = new SQLProvider();
        
        provider.connect();
        
        String sql = "select * from TACGIA where MATG = ? or TENTG = ?";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, tg.getMaTG());
        provider.preState.setString(2, tg.getTenTG());
       
        ResultSet rs = provider.preState.executeQuery();
        
        while (rs.next()) {
            String ma_tg = rs.getString("MATG");
            String ten_tg = rs.getString("TENTG");
            
            TacGiaPoJo tgSearch = new TacGiaPoJo(ma_tg, ten_tg);
            listTG.add(tgSearch);
        }
        
        provider.close();
        
        return listTG;
    }
    
    public void addTG(TacGiaPoJo tg) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
        
        //provider.statement = provider.connection.createStatement();
        //String sqlopen = "SET IDENTITY_INSERT TACGIA ON";
        
        //provider.statement.execute(sqlopen);
        
        String sql = "insert into TACGIA " + "values(?, ?)";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, tg.getMaTG());
        provider.preState.setString(2, tg.getTenTG());
        
        provider.preState.executeUpdate();
        provider.close();
    
    }
    
    public void updateTG(TacGiaPoJo tg, String maTG) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
        
        //provider.statement = provider.connection.createStatement();
        //String sqlopen = "SET IDENTITY_INSERT TACGIA ON";
        
        //provider.statement.execute(sqlopen);
        
        String sql = "";
   
        sql = "update TACGIA " + "set MATG= ?, TENTG= ?  where MATG = ?";
        provider.preState = provider.connection.prepareStatement(sql);

        provider.preState.setString(1, tg.getMaTG());
        provider.preState.setString(2, tg.getTenTG());
        provider.preState.setString(3, maTG);
        
        provider.preState.executeUpdate();
        provider.close();
    }
    
    public void removeTG(TacGiaPoJo tg) throws ClassNotFoundException, SQLException {
        SQLProvider provider = new SQLProvider();
        provider.connect();
       
        String sql = "delete TACGIA where MATG = ?";
        provider.preState = provider.connection.prepareStatement(sql);
        
        provider.preState.setString(1, tg.getMaTG());
        provider.preState.executeUpdate();
        
        provider.close();
    }
}
