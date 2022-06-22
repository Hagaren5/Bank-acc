public class Usuario {

    private String nombre;
    private int edad;
    private String DNI;

    public Usuario(){}

    public Usuario (String nombre, int edad, String DNI){
        this.nombre = nombre;
        this.edad = edad;
        this.DNI = DNI;
    }

    public String getNombre () {
        return nombre;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }

    public int getEdad () {
        return edad;
    }

    public void setEdad (int edad) {
        this.edad = edad;
    }

    public String getDNI () {
        return DNI;
    }

    public Boolean setDNI(String DNI) {
        boolean dniescorrecto = false;
        if  (this.Dniescorrecto(DNI)) {
            this.DNI = DNI;
            dniescorrecto = true;
        }
        return dniescorrecto;
    }


    public boolean Dniescorrecto (String DNI) {
        //La variable longitudCorrecta nos dice que aceptara que tenga 9 o 10 caracteres, ni más ni menos.
        Boolean longitudCorrecta = DNI.length() == 9 || DNI.length() == 10;

        //Siempre y cuando no sea de 9 o 10 caracteres el DNI estará mal escrito.
        if (!longitudCorrecta) return false;

        //La variable ultimaLetraEsCaracter niega que la última letra sea tipo int, ergo es obligatorio que no sea un número.
        // Fuente substring: https://stackoverflow.com/questions/31960752/how-to-get-substring-from-string?lq=1
        Boolean ultimaLetraEsCaracter = !esInteger(DNI.substring(DNI.length()-1));

        //La variable penultimaLetraEsGuion la ejecutamos como true, teniendo en cuenta que si hubiera 9 caracteres sería correcto no llevar guión.
        Boolean penultimaLetraEsGuion = true;

        // el if lo ejecutamos para el caso en que tenga 10 caracteres, sí que nos compruebe que el penúltimo sea un guión.
        if (DNI.length() == 10  ){
            penultimaLetraEsGuion = DNI.substring(8,9).equals("-");
        }

        //Aqui utilizamos esInteger para determinar si los 8 primeros caracteres introducidos son de tipo int.
        Boolean sonLos8PrimerosNumeros = esInteger(DNI.substring(0,7));

        //Si todas las demás variables son correctas aceptará el valor del DNI introducido.
        return longitudCorrecta && ultimaLetraEsCaracter && penultimaLetraEsGuion && sonLos8PrimerosNumeros;
    }

    //Esta función nos dirá si es true que es un integer y si es false que no lo es
    // Fuente: https://stackoverflow.com/questions/5439529/determine-if-a-string-is-an-integer-in-java
    public static boolean esInteger (String prueba) {
        try {
            Integer.parseInt(prueba);

        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }


    @Override
    public String toString(){
        return "El nombre del usuario es: "+nombre+ ", la edad: "+ edad+ " y su DNI es: "+ DNI;
    }
}
