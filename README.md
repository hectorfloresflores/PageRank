# PageRank
PageRank Algorithm with JAVA and NEO4J

Requirements:
Maven

STEPS TO MAKE IT RUN

STEP 1:
Download this repo

STEP 2:
Open terminal inside repo and execute this command`mvn clean compile assembly:single`

STEP 3:
You will notice that will appear a folder named **target** that has our jar
executable with dependencies

STEP 4:
Open terminal inside **target** folder and execute this command `java -jar your-jar-name.jar`

Example of program flow:

********   Bienvenido a PageRank con Neo4J   ********

Introduce tu usuario de NEO4J o ENTER para default:
Usuario: 

Introduce tu contrasenia de NEO4J:
Contrasenia: 
YOUR_NEO4J_PASSWORD
Nov 18, 2020 4:42:27 PM org.neo4j.driver.internal.logging.JULogger info
INFO: Direct driver instance 1241276575 created for server address localhost:7687
Conexión exitosa...
Presiona ENTER para cargar el grafo:


Grafo cargado exitosamente...
Presiona ENTER para obtener una estimación del grafo:

nodeCount	relationshipCount	bytesMin	bytesMax	requiredMemory	
8	14	1560	1560	1560 Bytes	
Estimacion exitosa...
Presiona ENTER para obtener el ranking de paginas del grafo:

name	score	
Home	3.2362017153762284	
About	1.0611098567023873	
Links	1.0611098567023873	
Product	1.0611098567023873	
Site A	0.3292259009438567	
Site B	0.3292259009438567	
Site C	0.3292259009438567	
Site D	0.3292259009438567	
Algoritmo de ranking aplicado correctamente...
Felicidades has cumplido con los siguientes entregables:
[-] Conectarte a tu base de datos NEO4J
[-] Crear tu grafo en la base de datos NEO4J
[-] Obtener una estimacion de recursos del algoritmo NEO4J
[-] Obtener un ranking de paginas con el algoritmo de NEO4J
