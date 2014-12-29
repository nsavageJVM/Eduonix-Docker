# download a image with java 8
FROM dockerfile/









































































# Install maven into the image
RUN apt-get update
RUN apt-get install -y maven

# create a work directory 'code' this is where we will build and run our application
WORKDIR /code

# Prepare by downloading dependencies
ADD pom.xml /code/pom.xml
RUN ["mvn", "dependency:resolve"]
RUN ["mvn", "verify"]

# Adding source, compile 
ADD src /code/src
RUN ["mvn", "package"]

# run the application
RUN ["mvn", "exec:java"]
