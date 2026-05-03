public class Personaje implements Movimientos {
	private String color;
    protected int altura;
    
    //protected String color;

    // como el color es private las clases hijas solo pueden accederlas con un getColor - esto es Encapsulamiento
    public String getColor() {
        return color;
    }
    public Personaje(String color, int altura) {
        this.color = color;
        this.altura = altura;
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
