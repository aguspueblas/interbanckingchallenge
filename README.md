# interbanckingchallenge

Anotaciones:

Cuando se generó la entidad Transferencia se agrego el campo fecha, que representa el momento que hicieron la transferencia. Dicho campo se agrego para poder buscar las companias con transferencias realizadas en el último mes.
Las excepciones estan centralizadas.

Endpoints:
GET company/ Devuelve todas las companias junto con sus transferencias relacionadas.

GET company/transferlastmonth Devuelve las companias que hicieron transferencias el último mes.

GET company/addlastmonth Devuelve las companias que se adhirieron el último mes.

POST company/ Genera la adhesión de una empresa.

POST transfer/ Genera una transferencia.

Swagger: http://localhost:8080/swagger-ui/index.html#/ en caso que se ejecute de manera local.  

Challenge para la empresa Interbanking.
