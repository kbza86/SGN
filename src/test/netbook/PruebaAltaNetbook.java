/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test.netbook;

import hibernate.dao.NetbookDAO;
import model.domain.Netbook;

/**
 *
 * @author tisan
 */
public class PruebaAltaNetbook {
 
    public static void main(String[] args) {
        
        Netbook netbook = new Netbook("aa1478523213", "marca 1", false, "xxxx", "xxxx", "dddd", "aaaa", "zzxz");
        NetbookDAO netbookDAO = new NetbookDAO();
        
        netbookDAO.altaNetbook(netbook);
        
        
    }
}
