
import java.util.ArrayList;

public class Cuenta {
  private double saldo = 0;
  Usuario usuario = new Usuario (){};
  ArrayList<Gasto> gastos = new ArrayList<>();
  ArrayList<Ingreso> ingresos = new ArrayList<> ();



  public Cuenta (){
  }

  public Cuenta (Usuario usuario){

  }

  public void addGasto(Gasto gasto) throws GastoException{
    this.gastos.add (gasto);
    if (saldo < gasto.dinero){
      throw new GastoException ();
    }
    this.saldo -= gasto.dinero;
  }


  public void addIngreso(Ingreso ingreso){
    this.ingresos.add(ingreso);
    this.saldo += ingreso.dinero;
  }

  public double getSaldo () {
    return  saldo;
  }

  public String toString (){
    return "El saldo de la cuenta es de: " + saldo;
  }

  public void IngresosAMostrar(){
    for ( int i = 0; i <ingresos.size () ; i++ ) {
      System.out.println (ingresos.get (i));
    }
  }

  public void setSaldo (double saldo) {
    this.saldo = saldo;
  }

  public Usuario getUsuario () {
    return usuario;
  }

  public void setUsuario (Usuario usuario) {
    this.usuario = usuario;
  }

  public ArrayList<Gasto> getGastos () {
    return gastos;
  }

  public ArrayList<Ingreso> getIngresos () {
     return ingresos;
  }
}