

<- Environment Setup ->
The following need to be setup in your environment-

1)JDK->which can be downloaded at -> http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
2)Eclipse for Java EE which can be downloaded at ->https://www.eclipse.org/downloads/
3)Apache tomcat ->https://tomcat.apache.org/
4) Maven is optional if you want to run it from the terminal. However, Since I am on windows I prefer using the Eclipse plugin.


Environment variables for above-

1)Java need JAVA_HOME -> to point to the JDK folder
and PATH -> to point to bin

2)CATALINA_HOME is needed for Tomcat. it needs to point to bin.
<- Environment Setup->

<- Verification of Setup->

1) In terminal Java --version should print the version of JDK installed.
2)In the terminal, CATALINA_HOME/bin/startup.bat  should start up the server.

<-Verification of setup->


<- Building from source ->

1)Clone the copy of the project from -> https://github.com/pranav16/NaviFuse.git
2) Open the project in eclipse.
3)Since this is a Maven project all the dependencies are handled by it.
        -> If you eclipse is not set to auto update maven dependencies on the load you will have to manually do that by right-clicking on the project - Maven - update project.

4)Right, click on the project-> select run as -> maven build (make it a clean install).
5)If you have set up tomcat server then you could
        - right click on the project and run as -> run on the server and your done.
        
6) An another alternative is to export the project as a war. And to place the war in web apps folder of tomcat and starting it.
        However, it is a better workflow to set it up in eclipse.

fusing service endpoint -

/LocationServices/fusing-service?size=0.005&latitude=37.786882&longitude=-122.399972

size repsents the size of the bounding box of OSM.
latitude and longitude are the center point for both Yelp and OSM.


<-Output json fromat->

A json object which children -
a)Yelp which follows the format present on -> https://www.yelp.com/developers/documentation/v3/business_search
b)OSM data has a custom format. We have fused nodes, ways, relations to form more concrete types buildings and street. The pojo defining the same can be found in OSMCustomResponse.java.

Each building consists of-
a)A unique id to refer the object on the client end. It is the same id as that the relationship defining the building.
b)visible tag for the relationship and building in general.
c)tags. this is the tags give to the relationship defining the building. Is NULLABLE. This would contain details like the height of the building, house address, house number etc. (Properties of the Building).
d)A composite Node which contains -
1) A collection of nodes making up this node.
The 2)role this collection plays. For eg: role could be outer.
3)type of this collection. For eg way. (role + type would mean this collection of node is of type outer way).
4)visible whether this collection is visible.

Each Street consists of-
a)A unique id to refer the object on the client end. It is the same id as that the relationship defining the Street.
b)visible tag for the relationship and street in general.
c)tags. this is the tags give to the relationship defining the street. Is NULLABLE. This would contain details like street name, bus routes.
d)A composite Node which contains -
1) A collection of nodes making up this node. 
The 2)role this collection plays. For eg: role could be from.
3)type of this collection. For eg way. (role + type would mean this collection of node is of type from way).
4)visible whether this collection is visible.


Important Node: Some entries refer to relationship to relationship in case of streets. This was done by some users to get in extra tags. In our system, these are represented as a street with one node that refers to another street which may have the nodes and ways describing it in its node list.
This is done in order to maintain the integrity of data set. These streets would have composite nodes with visible set to false and type spefied as a relationship.
There are buildings repeseted only ways. These house will have id of the way instead of realtionship. However, they will remain unique.
