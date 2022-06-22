public class Gasto extends Dinero {


    public Gasto(double gasto, String description){
        this.dinero = gasto ;
        this.description = description ;
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

        return "Gasto: "+ description +", cantidad: " + dinero +"€" ;
    }
}
