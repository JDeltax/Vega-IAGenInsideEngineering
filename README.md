# IAGen Inside Engineering

## IA Generativa en Ingeniería de Sistemas: ¿Potenciador o Dependencia para los Desarrolladores?

**Actividad para el curso de CVDS/DOSW**

---

## 📋 Descripción General

Esta actividad tiene una duración de **40 minutos** y está diseñada para explorar cómo la inteligencia artificial generativa puede potenciar o limitar nuestras habilidades como desarrolladores.

### Encuesta Inicial

Antes de comenzar con los ejercicios, les pedimos que completen la siguiente encuesta para conocer su perspectiva inicial sobre el uso de IA en desarrollo:

📌 [Encuesta de Contexto](https://forms.office.com/Pages/ResponsePage.aspx?id=hAVkUEAqFkKoS5s-4PP2z7efSt55aMRCgcqqTsxt4VVUQlZLRU1UWDBZOFVDT1IyVjVKOEFIWFFBNy4u)

---

## 🎯 Enfoque de la Actividad

Se resolverán dos problemas utilizando **100% IA**. La duración limitada hace que se apoyen significativamente en herramientas de inteligencia artificial para su solución.

### Dos Enfoques Diferentes

#### Problema #1: "El Videoclub de Don Mario"
- **Contexto limitado**: solo enunciado
- **Sin documentación adicional**: aparte de su conocimiento previo
- **Desafío**: formular buenos prompts sin información visual o técnica previa

#### Problema #2: "Tienda Virtual"
- **Contexto enriquecido**: enunciado + código incompleto + diagramas UML
- **Mayor información disponible**: permite validar hipótesis con documentación
- **Desafío**: integrar múltiples fuentes de información para una solución completa

### Objetivo Pedagógico

Comparar cómo la IA logra resultados más precisos bajo diferentes condiciones de contexto. Esto demuestra que:

- La IA generativa **potencia nuestras capacidades** cuando sabemos usarla adecuadamente
- El **conocimiento del dominio** es fundamental para formular buenas preguntas a la IA
- La **calidad de la información proporcionada** impacta directamente en la solución
- El desarrollador sigue siendo **responsable del control y validación** del proceso

---

## ✅ Instrucciones de Entrega

1. **Hacer fork** de este repositorio en la cuenta personal de cada uno
2. **Crear archivo** `SOLUCION.md` con las respuestas y soluciones
3. **Incluir prompts**: dentro de cada ejercicio, documentar los prompts utilizados para cada solución
4. **Mantener estructura**: organizar las respuestas de forma clara y legible

---

## 📝 Problema #1: El Videoclub de Don 

### Duración: Máximo 15 minutos

Don Mario acaba de abrir un videoclub moderno donde los clientes pueden alquilar peliculas fisicas o digitales. El problema es que su sistema anterior era un caos: todos los precios se calculaban igual sin importar el tipo de pelicula o membresia del cliente, y no habia forma de saber que peliculas estaban disponibles en tiempo real.

### Tu Mision

Ayuda a Don Mario creando un sistema de alquiler que permita:

1. Registrar peliculas (fisicas o digitales) con su disponibilidad.
2. Que el cliente elija X peliculas para alquilar.
3. Calcular el precio total segun su tipo de membresia:
   - Basica: precio normal.
   - Premium: 20% de descuento.
4. Mostrar al finalizar un recibo con las peliculas, precio por unidad y total.

### Peliculas Disponibles

- [Fisica] Interestellar - $8.000 - Disponible
- [Fisica] El Padrino - $7.000 - No disponible
- [Digital] Inception - $5.000 - Disponible
- [Digital] Matrix - $6.000 - Disponible

### Caso de Ejemplo

Membresia del cliente: Premium  
Seleccione peliculas (numeros separados por coma): 1,3

```text
--- RECIBO DE ALQUILER ---
Cliente: Premium
Peliculas:
 - Interestellar (Fisica) - $8.000
 - Inception (Digital) - $5.000
Subtotal: $13.000
Descuento (20%): $2.600
Total a pagar: $10.400
--------------------------
¡Disfrute su pelicula!
```

### Objetivos del Ejercicio

- Identificar cual o cuales patrones de diseno utilizar.
- Explicar que principios de SOLID se aplican.
- Aplicar polimorfismo y encapsulamiento.
- Colocar evidencia de la ejecucion del ejercicio (ejecucion por consola; no es necesario hacer front).

---

## 🛒 Problema #2: Tienda Virtual

### Duración: Máximo 25 minutos

### Descripción del Problema

Una tienda virtual necesita implementar un sistema de pagos que soporte múltiples métodos de pago:

- **Tarjeta de crédito**
- **PayPal**
- **Criptomonedas**

Cada método tiene su propio proceso de validación y ejecución. El sistema debe:

1. Crear objetos de pago y sus validadores correspondientes
2. **No exponer los detalles internos** a la lógica principal de compras
3. **Notificar automáticamente** a otros componentes cuando se procesa un pago exitoso:
   - 📦 Módulo de inventario: descontar del stock
   - 📄 Módulo de facturación: generar factura
   - 📧 Módulo de notificaciones: enviar correo al cliente

### Requisitos Técnicos

La solución debe ser **flexible** para:
- ✅ Soportar nuevos métodos de pago sin modificar la lógica existente
- ✅ Permitir que nuevos módulos reaccionen a eventos de pago sin cambiar el core

**Pistas de patrones**:
- Se requiere un mecanismo para **crear familias de objetos relacionados** (pago + validador)
- Se requiere un mecanismo para **notificar automáticamente** a múltiples observadores de eventos

---

## 🎓 Objetivos de Aprendizaje

### Para el Problema #2 - Tienda Virtual

1. **Identificar patrones**: ¿Qué dos patrones de diseño se están utilizando? ¿Son los adecuados o alguno debería cambiar?

2. **Completar implementación**: ¿Qué clases/interfaces hacen falta para que el código satisfaga correctamente los patrones utilizados? 
   - Documentar en el `SOLUCION.md` (no es necesario modificar los diagramas)

3. **Validar diagrama**: ¿El diagrama de contexto proporciona información suficiente y pertinente? 
   - Si es necesario hacer cambios, documentarlos en el `SOLUCION.md`

4. **Identificar errores**: ¿Qué errores del código proporcionado identificaste? ¿Por qué no compila?

5. **Corregir código**: Implementar las correcciones necesarias para que el sistema funcione correctamente

6. **Ejecutar pruebas**:
   - Ejecutar las pruebas unitarias proporcionadas
   - Corregir las pruebas en caso de que fallen
   - Verificar que todo compila y pasa las pruebas

---

## 📦 Estructura del Repositorio

```
IAGenInsideEngineering/
├── docs/                          # Documentación y diagramas
│   ├── imagenes/                  # Imágenes de referencia
│   └── uml/                       # Diagramas UML
├── src/
│   ├── main/
│   │   ├── java/                  # Código fuente
│   │   │   └── eci/edu/byteProgramming/ejercicio/paper/
│   │   │       └── util/          # Implementación del sistema de pagos
│   │   └── resources/             # Propiedades y configuración
│   └── test/                      # Pruebas unitarias
└── README.md                       # Este archivo
```

---

## 🚀 Para Comenzar

1. Clone o haga fork del repositorio
2. Abra los archivos fuente en `src/main/java/`
3. Comience con la formación de prompts bien estructurados
4. Documente su proceso en `SOLUCION.md`
5. Verifique que el código compila sin errores
6. Ejecute las pruebas unitarias

---

## 💡 Recomendaciones

- **Tome notas** de los prompts que funcionan mejor
- **Itere** sobre sus preguntas a la IA según los resultados
- **Valide** cada solución contra los requisitos
- **Documente** el razonamiento detrás de cada decisión
- **Aproveche** la documentación brindada (diagramas, código parcial) en el problema #2

---

## 📚 Referencias Útiles

- [Patrones de Diseño - Factory Pattern](https://refactoring.guru/design-patterns/factory-method)
- [Patrones de Diseño - Observer Pattern](https://refactoring.guru/design-patterns/observer)
- Java Generics y Polimorfismo
- Principios SOLID

---

**¡Bienvenidos a esta experiencia de aprendizaje con IA generativa!**
