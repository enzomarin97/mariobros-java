# 🍄 MarioBros - Java OOP

Proyecto de práctica para aprender los conceptos de **Herencia**, **Encapsulamiento** y **Polimorfismo** en Java, modelando personajes del universo Mario Bros.

---

## 📁 Estructura del proyecto

```
MarioBros/
├── Movimientos.java   # Interface
├── Personaje.java     # Clase padre
├── Mario.java         # Clase hija
├── Luigi.java         # Clase hija
└── Main.java          # Punto de entrada
```

---

## 🧠 Conceptos aplicados

### Interface — `Movimientos`

Una **interface** no es una clase y no se puede instanciar (no se pueden crear objetos de ella directamente). Sirve para declarar métodos que se deben implementar de forma obligatoria dentro de las clases que la implementen.

```java
public interface Movimientos {
    void moverArriba();
    void moverIzquierda();
    void moverDerecha();
}
```

---

### Encapsulamiento — `Personaje`

La clase `Personaje` implementa la interface `Movimientos` y es la **clase padre**. Puede tener variables `private`, las cuales no son accesibles directamente por las clases hijas sino a través de métodos como `getColor()` — eso es el **Encapsulamiento**.

> Si quisiéramos que las hijas accedan directo a una variable del padre, usaríamos `protected` en lugar de `private`.

La clase padre también puede tener métodos que sus hijas heredan y pueden:
- ✅ **Usar** tal cual
- ✅ **Sobreescribir** con `@Override`
- ✅ **Ignorar** (en ese caso se usa la versión del padre)

```java
public class Personaje implements Movimientos {
    private String color; // no accesible directamente por las hijas

    public String getColor() { // las hijas acceden a color solo por acá
        return color;
    }

    public Personaje(String color) {
        this.color = color;
    }
}
```

---

### Herencia — `Mario` y `Luigi`

Las clases hijas `Mario` y `Luigi` heredan variables y métodos de `Personaje` gracias a la palabra clave `extends`. Además pueden tener sus propias variables y métodos privados, como `usarAspiradora()` en `Luigi`, que es una habilidad que `Mario` no tiene.

```java
public class Mario extends Personaje { ... }
public class Luigi extends Personaje { ... }
```

---

### Polimorfismo — `Main`

El método `main` instancia las clases, es decir, crea los **objetos**. Los objetos `mario` y `luigi` están declarados del tipo `Movimientos` (la interface), pero el objeto real creado con `new` es `Mario` o `Luigi` respectivamente.

```java
Movimientos mario = new Mario("rojo", "mario"); // tipo: interface Movimientos, objeto real: Mario
Movimientos luigi = new Luigi("verde", "luigi"); // tipo: interface Movimientos, objeto real: Luigi
```

Al momento de crear el objeto, los campos entre paréntesis son los **parámetros del constructor** — un método especial que se ejecuta al crear el objeto. Deben pasarse sí o sí al instanciar.

Llamando al mismo método sobre distintos objetos:

```java
mario.moverArriba(); // ejecuta la versión de Mario
luigi.moverArriba(); // ejecuta la versión de Luigi
```

Estos métodos están declarados en `Movimientos`, implementados en `Personaje`, y sobreescritos con `@Override` en cada clase hija con comportamiento personalizado. Esto es el **Polimorfismo**: mismo método, distinto comportamiento según el objeto real.

---

### ⚠️ Tipo declarado vs tipo concreto

Como `mario` y `luigi` están declarados del tipo `Movimientos`, **solo pueden llamar a los métodos que existen en esa interface**. Por eso para usar `usarAspiradora()` — una habilidad exclusiva de `Luigi` — necesitamos declarar la variable del tipo concreto:

```java
// Esto NO funciona: luigi.usarAspiradora() ❌
// Movimientos no conoce ese método

Luigi luigiHabilidad = new Luigi("verde", "luigi"); // tipo concreto
luigiHabilidad.usarAspiradora(); // ✅
```

---

## ▶️ Cómo ejecutar

```bash
javac *.java
java Main
```

### Output esperado

```
mario tiene el color: rojo y se mueve arriba
luigi tiene el color: verde SALTA MAS ALTO QUE MARIO
luigi tiene el color: verde y se mueve para la derecha
mario tiene el color: rojo y se mueve para la izquierda
luigi usa el Poltergust 3000 para atrapar fantasmas!
```

---

## 🗺️ Diagrama de clases

```
«interface»
Movimientos
  + moverArriba()
  + moverIzquierda()
  + moverDerecha()
       ↑
   implements
       ↑
  Personaje
  - color: String
  + getColor(): String
  + Personaje(color)
       ↑
    extends
    ↙       ↘
Mario       Luigi
- nombre    - nombre
            - tieneAspiradora: boolean
            + usarAspiradora()
```