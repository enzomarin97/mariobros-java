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

La clase padre también puede tener métodos que sus hijas heredan y pueden:
- ✅ **Usar** tal cual
- ✅ **Sobreescribir** con `@Override`
- ✅ **Ignorar** (en ese caso se usa la versión del padre)

```java
public class Personaje implements Movimientos {
    private String color;   // solo accesible via getColor()
    protected int altura;   // accesible directamente por las clases hijas

    public String getColor() {
        return color;
    }

    public Personaje(String color, int altura) {
        this.color = color;
        this.altura = altura;
    }
}
```

---

### `private` vs `protected`

| Modificador | ¿Accesible desde la hija? | ¿Cómo? |
|---|---|---|
| `private` | ❌ No directamente | Solo via getter (`getColor()`) |
| `protected` | ✅ Sí directamente | `this.altura` desde la hija |

---

### Herencia — `Mario` y `Luigi`

Las clases hijas `Mario` y `Luigi` heredan variables y métodos de `Personaje` gracias a `extends`. Se trabajaron dos variantes distintas de `protected` a modo didáctico:

**Opción A — Mario: `altura` como parámetro del constructor**

`altura` se recibe desde afuera al instanciar el objeto y se pasa al padre con `super()`. Es la misma mecánica que `color`.

```java
public Mario(String color, String nombre, int altura) {
    super(color, altura); // le pasa altura al constructor del padre
    this.nombre = nombre;
}
```

En el `Main`:
```java
Movimientos mario = new Mario("rojo", "mario", 1); // altura = 1, definida desde afuera
```

**Opción B — Luigi: `altura` fija dentro de la clase**

`altura` no viene de afuera, está hardcodeada dentro del constructor de Luigi. Como es `protected`, la hija puede asignarla directamente con `this.altura`.

```java
public Luigi(String color, String nombre) {
    super(color, 0); // valor por defecto al padre
    this.nombre = nombre;
    this.altura = 2; // Luigi siempre mide 2, es fijo
}
```

> **Nota:** En el código actual Luigi todavía recibe `altura` como parámetro del constructor porque `super()` la requiere, pero inmediatamente la pisa con `this.altura = 2`. Esto significa que el valor que se le pase al instanciar Luigi siempre será ignorado. La Opción B pura sería quitar `altura` del constructor de Luigi por completo.

---

### Fuente de verdad única

Mezclar ambas estrategias en un mismo atributo genera inconsistencias: `altura` puede ser definida en el `Main`, en el `super()`, y en el `this.altura` al mismo tiempo, y no queda claro cuál valor vale.

La regla general es: **cada dato debe tener un único lugar donde se define**.

- Si el valor **varía por objeto** → se recibe como parámetro del constructor (Opción A)
- Si el valor **es fijo por clase** → se asigna dentro de la clase, no se recibe desde afuera (Opción B)

---

### Polimorfismo — `Main`

El método `main` instancia las clases, es decir, crea los **objetos**. Los objetos `mario` y `luigi` están declarados del tipo `Movimientos` (la interface), pero el objeto real creado con `new` es `Mario` o `Luigi` respectivamente.

```java
Movimientos mario = new Mario("rojo", "mario", 1); // tipo: interface Movimientos, objeto real: Mario
Movimientos luigi = new Luigi("verde", "luigi", 3); // tipo: interface Movimientos, objeto real: Luigi
```

Al momento de crear el objeto, los campos entre paréntesis son los **parámetros del constructor** — un método especial que se ejecuta al crear el objeto.

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

Luigi luigiHabilidad = new Luigi("verde", "luigi", 2); // tipo concreto
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
mario tiene el color: rojo y tiene una altura: 1 y se mueve arriba
luigi tiene el color: verde y tiene una altura: 2 SALTA MAS ALTO QUE MARIO
luigi tiene el color: verde y tiene una altura: 2 y se mueve para la derecha
mario tiene el color: rojo y tiene una altura: 1 y se mueve para la izquierda
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
  - color: String        (private   → acceso via getColor())
  # altura: int          (protected → acceso directo desde hijas)
  + getColor(): String
  + Personaje(color, altura)
       ↑
    extends
    ↙           ↘
Mario             Luigi
- nombre          - nombre
+ Mario(color,    - tieneAspiradora: boolean
  nombre, altura) + Luigi(color, nombre, altura)
                  + usarAspiradora()
```

> En UML, `#` representa `protected` y `-` representa `private`.