public class Luigi extends Personaje {
    private String nombre;
    private boolean tieneAspiradora = true;
    public Luigi(String color, String nombre){
        super(color);
        this.nombre = nombre;
    }
    @Override
    public void moverArriba(){
        System.out.println(nombre + " " + "tiene el color: " + this.getColor() + " SALTA MAS ALTO QUE MARIO");
    }
    @Override
    public void moverIzquierda(){
        System.out.println(nombre + " " + "tiene el color: " + this.getColor() + " y se mueve para la izquierda");
    }
    @Override
    public void moverDerecha(){
        System.out.println(nombre + " " + "tiene el color: " + this.getColor() + " y se mueve para la derecha");
    }
    // habilidad extra que mario no tiene
    public void usarAspiradora(){
        if(tieneAspiradora){
            System.out.println(nombre + " " + "usa el Poltergust 3000 para atrapar fantasmas!");
        }
    }
}