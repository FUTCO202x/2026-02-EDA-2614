# 📘 Programación Orientada a Objetos  
**Profesor:** Johanny E. Valencia Sánchez  

Este proyecto corresponde a la **Conducta de Entrada** de la asignatura *Programación Orientada a Objetos*.  

---

## 🚀 Instrucciones Generales
1. Realizar el código solicitado en la sección de **Requerimientos**.  
2. Hacer un **push** desde tu computador a tu repositorio personal en **Git**.  
3. Tener disponible el enlace del repositorio en caso de ser requerido por el profesor.  

---

## 📂 Requerimientos

### 1️⃣ Clase `Cuenta`
Crear una clase `Cuenta` con los siguientes atributos **encapsulados**:
- `private String numeroCuenta;`
- `private long dniCliente;`
- `private double saldoActual;`

---

### 2️⃣ Clases `Ahorro` y `Corriente`
Ambas deben **heredar** de la clase `Cuenta`.  
- **Constructores:** uno vacío y otro con todos los atributos.  
- **Encapsulación:** todos los atributos deben estar privados.  

#### 🔹 Clase `Ahorro`
- Atributo adicional: `String fechaCreacion`  
- Implementar `toString()` para imprimir todos los campos (incluyendo los heredados).  

#### 🔹 Clase `Corriente`
- Atributo adicional: `double impuesto`  
- Implementar `toString()` para imprimir todos los campos (incluyendo los heredados).  

---

### 3️⃣ Interface `IServiceCuenta` y Clase `ServiceCuenta`
- Implementar en la clase `ServiceCuenta` los métodos definidos en la interface `IServiceCuenta`.  

#### Métodos de la interface:
1. **Listar todas las cuentas**  
2. **Obtener datos de la cuenta** (recibe un número de cuenta y retorna la cuenta)  
3. **Crear cuenta**  

---

### 4️⃣ Clase Principal `App`
Crear un menú con las siguientes opciones:  
a. Listar todas las cuentas **Ahorro**  
b. Listar todas las cuentas **Corriente**  
c. Crear cuenta de **Ahorro**  
d. Crear cuenta **Corriente**  
e. Obtener la información de la cuenta por el número de la cuenta  

---

## 📌 Notas
- Recuerda aplicar **encapsulación** en todos los atributos.  
- Usa **herencia** correctamente para reutilizar código.  
- Implementa el menú en la clase principal para interactuar con el sistema.  

---

## 🛠️ Tecnologías sugeridas
- Lenguaje: **Java**  
- Control de versiones: **Git/GitHub**  
- IDE recomendado: **IntelliJ IDEA / Eclipse / VS Code**  

---

## ✅ Entregables
- Código fuente en tu repositorio personal.  
- Enlace al repositorio para revisión.  
