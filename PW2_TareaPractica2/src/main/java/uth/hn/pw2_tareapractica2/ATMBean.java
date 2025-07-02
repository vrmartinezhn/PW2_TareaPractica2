package uth.hn.pw2_tareapractica2;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("atmBean")
@SessionScoped
public class ATMBean implements Serializable{
    private List<Cuenta> cuentas;
    private Cuenta cuenta;

    public ATMBean() {
        this.cuentas = new ArrayList<>();
        this.cuenta = null;
        cuentas.add(new Cuenta("11111111", "111111", 500));
        cuentas.add(new Cuenta("11111112", "111112", 1000));
        cuentas.add(new Cuenta("11111113", "111113", 1500));
        cuentas.add(new Cuenta("11111114", "111114", 2000));
        cuentas.add(new Cuenta("11111115", "111115", 2500));
    }

    public String redireccionDeposito (){
        return "depositos.xhtml?faces-redirect=true";
    }

    public String redireccionRetiro (){
        return "retiros.xhtml?faces-redirect=true";
    }
}
