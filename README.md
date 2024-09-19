# springboot-kafka

#kafka installation
1. https://kafka.apache.org/downloads

 download anyone
   ![img.png](img.png)

2. Go to the Downloads folder and select the downloaded Binary file.

3.  Extract the file and move the extracted folder to the directory 
    where you wish to keep the files.

4. [OPTIONAL]Copy the path of the Kafka folder. 
   Now go to config inside kafka folder and open zookeeper.properties file. 
   Copy the path against the field dataDir and add /zookeeper-data to the path.
   ![img_1.png](img_1.png)

5. [OPTIONAL] Now in the same folder config open server.properties and scroll down to log.dirs 
   and paste the path. To the path add /kafka-logs

6. START Zookeeper - open command prompt
   command: .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
   ![img_2.png](img_2.png)

7. START kafka server - open another command prompt
   command: .\bin\windows\kafka-server-start.bat .\config\server.properties
   ![img_3.png](img_3.png)   
