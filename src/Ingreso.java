public class Ingreso extends Dinero {


    public Ingreso(double ingreso, String description){
        this.dinero = ingreso;
        this.description = description;
    }



    @Override
    public String getDescription () {
        return description;
    }

    @Override
    public void setDescription (String description) {
        this.description = description;
    }

    @Override
    public String toString(){

        return "Ingreso: "+ description +", cantidad: " + dinero +"€" ;
    }
}
