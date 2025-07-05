package uth.hn.pw2_tareapractica2;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import org.primefaces.PrimeFaces;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("atmBean")
@SessionScoped
public class ATMBean implements Serializable{
    private List<Cuenta> cuentas;
    private Cuenta cuenta;
    private String numCuenta;
    private  String pinCuenta;
    private double deposito;
    private double retiro;

    public ATMBean() {
        this.cuentas = new ArrayList<>();
        this.cuenta = null;
        this.numCuenta = "";
        this.pinCuenta = "";
        this.deposito = 0;
        this.retiro = 0;
        cuentas.add(new Cuenta("12341234", "1234","Alejandro Ruíz", 500));
        cuentas.add(new Cuenta("56785678", "5678","María Núñez", 1000));
        cuentas.add(new Cuenta("22442244", "2244","Rosa Soto", 1500));
        cuentas.add(new Cuenta("11331133", "1133","Rodolfo Palma", 2000));
        cuentas.add(new Cuenta("55665566", "5566","Miguel Flores", 2500));
    }

    public String redireccionDeposito (){
        obtenerCuenta();
        return "depositos.xhtml?faces-redirect=true";
    }

    public String redireccionRetiro (){
        obtenerCuenta();
        return "retiros.xhtml?faces-redirect=true";
    }

    /*public String mostrarSaldo(){
        return cuenta.getSaldo() + "";
    }*/
    public void obtenerCuenta(){
        for (Cuenta cuentaa : cuentas) {
            if (cuentaa.getCuenta().equals(this.numCuenta) && cuentaa.getPin().equals(this.pinCuenta)) {
                this.cuenta = cuentaa;
                return;
            }
        }

        this.cuenta = null;
    }

    public String volver(){
        this.deposito = 0;
        return "inicio.xhtml?faces-redirect=true";
    }

    public void cerrarCuenta(){
        this.numCuenta = "";
        this.pinCuenta = "";
        if(this.cuenta != null) {
            mostrarMensaje("Cuenta Cerrada ", FacesMessage.SEVERITY_INFO);
        }
        this.cuenta = null;
    }

    public void depositar (){
        if(cuenta != null){
            if(this.deposito > 0){
                this.cuenta.setSaldo(this.cuenta.getSaldo() + this.deposito);
                this.deposito = 0;
                mostrarMensaje("Deposito Realizado ", FacesMessage.SEVERITY_INFO);
                return;
            }
            mostrarMensaje("Cantidad Inválida", FacesMessage.SEVERITY_ERROR);
            return;
        }

        mostrarMensaje("Cuenta no Detectada", FacesMessage.SEVERITY_ERROR);
    }

    public void retirar (){
        if(cuenta != null){
            if (this.cuenta.getSaldo() > this.retiro) {
                this.cuenta.setSaldo(this.cuenta.getSaldo() - this.retiro);
                this.retiro = 0;
                mostrarMensaje("Retiro Realizado   ", FacesMessage.SEVERITY_INFO);
                return;
            }

            mostrarMensaje("Cantidad Inválida  ", FacesMessage.SEVERITY_ERROR);
            return;
        }
        mostrarMensaje("Cuenta no Detectada", FacesMessage.SEVERITY_ERROR);
    }

    private void mostrarMensaje(String mensaje, FacesMessage.Severity tipo) {
        FacesMessage message = new FacesMessage(tipo, "Notificación", mensaje);
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getPinCuenta() {
        return pinCuenta;
    }

    public void setPinCuenta(String pinCuenta) {
        this.pinCuenta = pinCuenta;
    }

    public double getDeposito() {
        return deposito;
    }

    public void setDeposito(double deposito) {
        this.deposito = deposito;
    }

    public double getRetiro() {
        return retiro;
    }

    public void setRetiro(double retiro) {
        this.retiro = retiro;
    }


}
