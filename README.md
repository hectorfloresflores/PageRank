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
Intel3142!
Nov 19, 2020 4:16:44 PM org.neo4j.driver.internal.logging.JULogger info
INFO: Direct driver instance 1241276575 created for server address localhost:7687
Conexión exitosa...
Presiona ENTER para cargar el grafo:


Grafo cargado exitosamente...
Presiona ENTER para obtener una estimación del grafo:

nodeCount	relationshipCount	bytesMin	bytesMax	requiredMemory	
23	41	2072	2072	2072 Bytes	
Estimacion exitosa...
Presiona ENTER para obtener el ranking de paginas del grafo:

name	score	
Iron Man	2.091787112923339	
Batman	1.9535549676977098	
Scarlet Witch	1.9175637533888221	
Superman	1.845226108748466	
Quicksilver	1.7571634164080023	
Hulk	1.502743928041309	
Flash	1.323142175609246	
Wonder Woman	1.2862133426126092	
Captain America	1.1084226472186858	
Thor	1.0817972619784995	
Green Arrow	1.0202235701028257	
Black Widow	0.9788553704041987	
Aquaman	0.46175478099612516	
Spider-Man	0.44524864849518053	
Ant-Man	0.43443150687467097	
Nick Fury	0.43443150687467097	
Green Lantern	0.3858750030398369	
Captain Marvel	0.33463097699113864	
Wasp	0.33463097699113864	
Hawkgirl	0.27750000506639483	
Black Panther	0.15000000000000002	
Hawkman	0.15000000000000002	
Star-Lord	0.15000000000000002	
Algoritmo de ranking aplicado correctamente...
Felicidades has cumplido con los siguientes entregables:
[-] Conectarte a tu base de datos NEO4J
[-] Crear tu grafo en la base de datos NEO4J
[-] Obtener una estimacion de recursos del algoritmo NEO4J
[-] Obtener un ranking de paginas con el algoritmo de NEO4J

