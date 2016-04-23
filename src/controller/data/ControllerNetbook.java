/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.data;

import hibernate.dao.AlumnoDAO;
import hibernate.dao.DestinoDAO;
import hibernate.dao.NetbookDAO;
import hibernate.dao.PaseDAO;
import hibernate.dao.PersonaDAO;
import hibernate.dao.ReasignacionDAO;
import hibernate.dao.ServicioTecnicoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.domain.Alumno;
import model.domain.Destino;
import model.domain.Netbook;
import model.domain.Pase;
import model.domain.Persona;
import model.domain.Reasignacion;
import model.domain.ServicioTecnico;
import model.report.Informe;

/**
 *
 * @author wally86
 */
public class ControllerNetbook {

    private NetbookDAO netbookDAO;
    private Netbook netbook;

    public ControllerNetbook() {
        this.netbook = new Netbook();
        this.netbookDAO = new NetbookDAO();
    }

   
   
    /**
     *
     * @param tblNetbook
     * @return
     */
    public JTable cargaGrillaNetbook(JTable tblNetbook, String estado) {
        tblNetbook.removeAll();
        DefaultTableModel tableModel = (DefaultTableModel) tblNetbook.getModel();
        tableModel.setNumRows(0);
        Object[] fila = new Object[5];
        List<Netbook> lista = new ArrayList<Netbook>();
        
        switch (estado) {
            case "Todas":
                lista = netbookDAO.obtenerTodasNetbook();
                try {
            for (Netbook net : lista) {
                fila[0] = net.getIdNetbook();
                fila[1] = net.getIdHardware();
                fila[2] = net.getModelo();
                fila[3] = net.getMarca();
                fila[4] = net.isEstado();
                
                tableModel.addRow(fila);               
            }
        } catch (Exception ex) {

        }
                break;
            case "Osciosas":
                lista = netbookDAO.obtenerTodasNetbookNoValidas();
                try {
            for (Netbook net : lista) {
                fila[0] = net.getIdNetbook();
                fila[1] = net.getIdHardware();
                fila[2] = net.getModelo();
                fila[3] = net.getMarca();
                fila[4] = net.isEstado();
                tableModel.addRow(fila);               
            }
        } catch (Exception ex) {

        }
                break;
            case "En Servicio Tecnico":
                ServicioTecnicoDAO servicioTecnicoDAO = new ServicioTecnicoDAO();
                List<ServicioTecnico> listaServicio = servicioTecnicoDAO.obtenerTodosST();
                try{
                for (ServicioTecnico st : listaServicio) {
                    Netbook net = netbookDAO.obtenerNetbook(st.getNetbook().getIdNetbook());
                    fila[0] = net.getIdNetbook();
                fila[1] = net.getIdHardware();
                fila[2] = net.getMarca();
                fila[3] = net.getModelo();
                fila[4] = st.isEstado();
                tableModel.addRow(fila); 
               
                }
                }catch(Exception e){
                    
                }
                break;
            case "Pase":
                PaseDAO paseDAO = new PaseDAO();
                List<Pase> listaPase = paseDAO.obtenerTodosPases();
                try{
                for (Pase pase : listaPase) {
                    Netbook net = netbookDAO.obtenerNetbook(pase.getNetbook().getIdNetbook());
                    fila[0] = net.getIdNetbook();
                fila[1] = net.getIdHardware();
                fila[2] = net.getMarca();
                fila[3] = net.getModelo();
                fila[4] = pase.isEstado();
                tableModel.addRow(fila); 
                }
                }catch(Exception e){
                    
                }
                break;
            case "Migracion":
                DestinoDAO destinoDAO = new DestinoDAO();
                AlumnoDAO alumnoDAO = new AlumnoDAO();
                PersonaDAO personaDAO = new PersonaDAO();
                List<Destino> listaDestino = destinoDAO.obtenerTodasMigraciones();
                try{
                for (Destino destino : listaDestino) {
                    Persona p = personaDAO.obtenerPersonaPorId(destino.getPersona().getIdPersona());
                    Alumno a = alumnoDAO.buscarAlumnoDni(p.getDni());
                    Netbook net = netbookDAO.obtenerNetbook(a.getNetbook().getIdNetbook());
                    fila[0] = net.getIdNetbook();
                fila[1] = net.getIdHardware();
                fila[2] = net.getMarca();
                fila[3] = net.getModelo();
                fila[4] = destino.isEstado();
                tableModel.addRow(fila); 
                }
                }catch(Exception e){
                    
                }
                break;
            case "Reasignadas":
                ReasignacionDAO reasignacionDAO = new ReasignacionDAO();
                try{
                for(Reasignacion reasignacion : reasignacionDAO.obtenerTodasReasignaciones()){
                    Netbook net = netbookDAO.obtenerNetbook(reasignacion.getNetbook().getIdNetbook());
                    fila[0] = net.getIdNetbook();
                fila[1] = net.getIdHardware();
                fila[2] = net.getMarca();
                fila[3] = net.getModelo();
                fila[4] = reasignacion.isEstado();
                tableModel.addRow(fila); 
                }
                }catch(Exception e){
                    
                }
                break;

        }
        
        return tblNetbook;
    }
    public void verInforme(String tipoInforme) throws IOException{
        
        try {
            Informe informe = new Informe(); 
            informe.mostrarInforme(tipoInforme);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    
       
    }
    /**
     *
     * @param netbook
     */
    public void agregarNetbook(Netbook netbook) {
        getNetbookDAO().altaNetbook(netbook);
    }

    public Netbook buscarNetbookSerie(String numSerie) {
        Netbook netbookEncontrada = getNetbookDAO().obtenerNetbook(numSerie);
        return netbookEncontrada;
    }

    public boolean verificarExistencia(JTextField txtNumeroSerie) {
        String numeroSerie = txtNumeroSerie.getText();
        return netbookDAO.verificarExistencia(numeroSerie);

    }

    public boolean verificarEstadoNetbook(JTextField txtNumeroSerie) {
        Netbook netbook = buscarNetbookSerie(txtNumeroSerie.getText());
        boolean estado = netbook.isEstado();
        return estado;
    }

    public void actualizarTblNetbookPrincipal(JTable table, char tipoOperacion, Netbook netbook) {
        Object[] fila = new Object[4];
        fila[0] = netbook.getIdNetbook();
        fila[1] = netbook.getIdHardware();
        fila[2] = netbook.getMarca();
        fila[3] = netbook.getModelo();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        if (tipoOperacion == 'a') {
            tableModel.addRow(fila);
        } else {
            int posision = table.getSelectedRow();
            tableModel.setValueAt(fila[0], posision, 0);
            tableModel.setValueAt(fila[1], posision, 1);
            tableModel.setValueAt(fila[2], posision, 2);
            tableModel.setValueAt(fila[3], posision, 3);
        }

    }

    public void actualizarDatosNetbook(Netbook netbook) {
        netbookDAO.modificarNetbook(netbook);
    }

    /**
     * @return the netbookDAO
     */
    public NetbookDAO getNetbookDAO() {
        return netbookDAO;
    }

    /**
     * @param netbookDAO the netbookDAO to set
     */
    public void setNetbookDAO(NetbookDAO netbookDAO) {
        this.netbookDAO = netbookDAO;
    }

    /**
     * @return the netbook
     */
    public Netbook getNetbook() {
        return netbook;
    }

    /**
     * @param netbook the netbook to set
     */
    public void setNetbook(Netbook netbook) {
        this.netbook = netbook;
    }

    public int obtenerNumeroNetbookOsciosas() {
        return netbookDAO.obtenerNumeroNetbookNoValidas();
    }
}
