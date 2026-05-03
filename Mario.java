public class Mario extends Personaje {
    private String nombre;

    // este es el Constructor | se ejecuta cuando creas el objeto
    public Mario(String color, String nombre){
        super(color);
        this.nombre = nombre;
        //this.color = color;
    }

    @Override
    public void moverArriba(){
        System.out.println(nombre + " " + "tiene el color: " + this.getColor() + " y se mueve arriba" );
    }
    @Override
    public void moverIzquierda(){
        System.out.println(nombre + " " + "tiene el color: " + this.getColor() + " y se mueve para la izquierda");
    }
    @Override
    public void moverDerecha(){
        System.out.println(nombre + " " + "tiene el color: " + this.getColor() + " y se mueve para la derecha");
    }
}
