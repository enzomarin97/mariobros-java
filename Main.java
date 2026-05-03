public class Main {
    public static void main(String[] args) {
        Movimientos mario = new Mario("rojo", "mario", 1); // tipo: interface Movimientos, objeto real: Mario (polimorfismo)
        //Movimientos luigi = new Mario("verde", "mario");
        Movimientos luigi = new Luigi("verde",  "luigi", 3); // tipo: interface Movimientos, objeto real: Luigi (polimorfismo)
    
        mario.moverArriba();
        luigi.moverArriba(); //hereda el mismo metodo de la interface pero tiene comportamiento distinto (polimorfismo)

        luigi.moverDerecha();
        mario.moverIzquierda();

        //para usar usarAspiradora() necesitamos a la clase Luigi (hija de Personaje, es el "tipo concreto"), no usa el metodo desde la interface Movimientos
        Luigi luigiHabilidad = new Luigi("verde", "luigi", 2);
        luigiHabilidad.usarAspiradora();
    }
}