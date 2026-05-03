public class Mario extends Personaje {
    private String nombre;
    public Mario(String color, String nombre){
        super(color);
        this.nombre = nombre;
        //this.color = color;
    }

    @Override
    public void moverArriba(){
        System.out.println("arriba " + nombre + " " + this.getColor());
    }
    @Override
    public void moverIzquierda(){
        System.out.println("izquierda");
    }
    @Override
    public void moverDerecha(){
        System.out.println("derecha " + nombre + " " + this.getColor());
    }
}
