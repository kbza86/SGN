/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.report;

import java.io.File;
import java.io.IOException;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;


import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;




import org.hibernate.Session;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;



/**
 *
 * @author tisan
 */
public class Informe {

    private Connection connection;

    /**
     * Constructor
     */
    public Informe() {

        Session session = hibernate.configuration.HibernateUtil.getSessionFactory().openSession();
        SessionFactoryImplementor sfi = (SessionFactoryImplementor) session.getSessionFactory();
        ConnectionProvider cp = sfi.getConnectionProvider();
        connection = null;
        try {
            connection = cp.getConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     *
     * @param tipoReporte
     * @throws SQLException
     * @throws IOException
     */
    public void mostrarInforme(String tipoReporte) throws SQLException, IOException {

        try {
            File file = null;
            String path = "";
            path = System.getProperty("user.dir") + "\\src\\model\\report\\" + tipoReporte;
            file = new File(path);
            path = file.getAbsolutePath();
            System.out.println(path);
            JasperReport jasperReport = JasperCompileManager.compileReport(path);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connection);
            String pathDescarga = nombreInforme(tipoReporte);
            JasperExportManager.exportReportToPdfFile(jasperPrint, pathDescarga);
            connection.close();
        } catch (JRException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private String fechaInformeConFormato() {
        String fechaFormato = "";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_HHmmss");
        try {
            fechaFormato = sdf.format(date);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return fechaFormato;
    }

    private String nombreInforme(String tipo) {
        String nombreInforme = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showSaveDialog(null);
        File pdf = fileChooser.getSelectedFile();
        String pathPdf = pdf.getAbsolutePath();
        switch (tipo) {
            case "informeNetReasignadas.jrxml":
                nombreInforme = pathPdf + "_informe_Net_Reasignadas_" + fechaInformeConFormato() + ".pdf";
                break;
            case "informeNetbook.jrxml":
                nombreInforme = pathPdf + "_informe_Netbook_Gral_" + fechaInformeConFormato() + ".pdf";
                break;
            case "informeNetbookServTec.jrxml":
                nombreInforme = pathPdf + "_informe_Net_En_Serv_Tec_" + fechaInformeConFormato() + ".pdf";
                break;
            case "informeNetOsciosas.jrxml":
                nombreInforme = pathPdf + "_informe_Net_Osciocas_" + fechaInformeConFormato() + ".pdf";
                break;
            case "informeNetPase.jrxml":
                nombreInforme = pathPdf + "_informe_Pase_Net_" + fechaInformeConFormato() + ".pdf";
                break;
            case "informeNetMigradas.jrxml":
                nombreInforme = pathPdf + "_informe_Net_Migradas_" + fechaInformeConFormato() + ".pdf";
                break;
            case "informeAlumnosConNet.jrxml":
                nombreInforme = pathPdf + "_info_Alu_Con_Net_" + fechaInformeConFormato() + ".pdf";
                break;
            case "informeAlumnosRegulares.jrxml":
                nombreInforme = pathPdf + "_info_Alu_Regulares_" + fechaInformeConFormato() + ".pdf";
                break;
            case "informeAlumnosAbandonanConNet.jrxml":
                nombreInforme = pathPdf + "_info_Alu_Abandonan_Con_Net_" + fechaInformeConFormato() + ".pdf";
                break;
            case "informeAlumnosAbandonanSinNet.jrxml":
                nombreInforme = pathPdf + "_info_Alu_Abandonan_Sin_Net_" + fechaInformeConFormato() + ".pdf";
                break;
            case "infoAluEgresadosARecibir.jrxml":
                nombreInforme = pathPdf + "_info_Alu_A_Recibir_" + fechaInformeConFormato() + ".pdf";
                break;
            case "infoAluEgresadosConEquipo.jrxml":
                nombreInforme = pathPdf + "_info_Alu_Egresados_Con_Net_" + fechaInformeConFormato() + ".pdf";
                break;
            case "infoAluEgresadosNoCorrespNet.jrxml":
                nombreInforme = pathPdf + "_info_Alu_Egresados_No_Corres_Net_" + fechaInformeConFormato() + ".pdf";
                break;
        }
        return nombreInforme;
    }
}
