public class Personaje implements Movimientos {
	private String color;
    
    //protected String color;

    // como el color es private las clases hijas solo pueden accederlas con un getColor - esto es Encapsulamiento
    public String getColor() {
        return color;
    }
    public Personaje(String color) {
        this.color = color;
	}
    @Override
    public void moverIzquierda() {
        
    }
    @Override
    public void moverDerecha() {
        
    }
    @Override
    public void moverArriba() {
        
    }
}
