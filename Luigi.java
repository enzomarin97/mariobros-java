public class Luigi extends Personaje {
    private String nombre;
    private boolean tieneAspiradora = true;
    
    public Luigi(String color, String nombre, int altura){
        super(color, altura);
        this.nombre = nombre;
        this.altura = 2; //en realidad uso altura desde aca, no desde el super() porque es protected la variable
    }
    @Override
    public void moverArriba(){
        System.out.println(nombre + " " + "tiene el color: " + this.getColor() + 
            " y tiene una altura: " + this.altura + " SALTA MAS ALTO QUE MARIO");
    }
    @Override
    public void moverIzquierda(){
        System.out.println(nombre + " " + "tiene el color: " + this.getColor() + 
        " y tiene una altura: " + this.altura + " y se mueve para la izquierda");
    }
    @Override
    public void moverDerecha(){
        System.out.println(nombre + " " + "tiene el color: " + this.getColor() + 
        " y tiene una altura: " + this.altura + " y se mueve para la derecha");
    }
    // habilidad extra que mario no tiene
    public void usarAspiradora(){
        if(tieneAspiradora){
            System.out.println(nombre + " " + "usa el Poltergust 3000 para atrapar fantasmas!");
        }
    }
}