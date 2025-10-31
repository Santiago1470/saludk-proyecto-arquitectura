# 🏥 SaludK – Plataforma de Servicios Médicos Inteligentes

**SaludK** es una plataforma web diseñada para ofrecer servicios médicos presenciales y virtuales, gestión de historiales clínicos, venta de productos farmacéuticos y administración de suscripciones médicas.  
Su objetivo es digitalizar la atención médica, garantizando seguridad, eficiencia y accesibilidad para pacientes y profesionales de la salud.

---

## 🚀 **Características principales**

- **Registro y validación de pacientes:** permite almacenar información personal, médica y de contacto, con validación automática de formatos y archivos.
- **Gestión de solicitudes:** el Director Médico puede aprobar, rechazar o devolver registros según criterios médicos y legales.
- **Planes de suscripción:** acceso a planes Básico y Completo con múltiples métodos de pago (tarjeta, consignación, pasarela en línea).
- **Consultas médicas:** búsqueda de médicos por especialidad, localidad y disponibilidad, con opción de citas presenciales o virtuales.
- **Catálogo farmacéutico:** permite comprar medicamentos, suplementos y productos de salud con carrito de compras y entrega a domicilio o recogida.
- **Calificación de servicios:** pacientes pueden evaluar médicos y productos en una escala del 1 al 10.
- **Historial médico digital:** registro completo de consultas, exámenes, medicamentos y notificaciones de seguimiento.
- **Panel de control (Director Médico):** reportes de KPIs como consultas más demandadas, productos más vendidos y tasa de suscripción.
- **Sistema de notificaciones asíncronas:** envía alertas de salud crítica a pacientes o médicos mediante comunicación no bloqueante.

---

## 🧱 **Arquitectura y Tecnologías**

- **Frontend:** React.js  
- **Backend:** ASP.NET Core (C#)  
- **Base de datos:** SQL Server  
- **Autenticación:** JWT (JSON Web Tokens)  
- **Arquitectura:** API RESTful basada en microservicios  
- **Notificaciones:** comunicación asíncrona (colas de mensajería)  

---

## 🔐 **Requerimientos no funcionales**

- Seguridad: cifrado de datos sensibles, autenticación de múltiples niveles, uso de HTTPS.  
- Escalabilidad: soporte para alta concurrencia (100.000 usuarios simultáneos).  
- Rendimiento: respuesta rápida ante solicitudes y procesamiento eficiente.  
- Interfaz adaptable: diseño responsive para acceso desde cualquier dispositivo.  

---

## 👥 **Roles del sistema**

- **Paciente:** se registra, contrata planes, agenda citas, compra productos y consulta su historial.  
- **Director Médico:** valida solicitudes, gestiona reportes y analiza indicadores.  
- **Sistema:** envía notificaciones, valida datos y administra los procesos automáticos.

---

## 📊 **KPIs monitoreados**

- Consultas médicas más demandadas.  
- Productos farmacéuticos más vendidos.  
- Tasa de suscripción y retorno de pacientes.  

---

## 🧩 **Objetivo del proyecto**

Desarrollar una solución integral que fortalezca los servicios médicos digitales de **SaludK**, permitiendo competir en el mercado de telemedicina con una arquitectura segura, escalable y moderna.

---

Proyecto académico del **Programa de Ingeniería de Sistemas**  
**Fundación Universitaria Konrad Lorenz**  
Asignatura: *Arquitectura de Software*
