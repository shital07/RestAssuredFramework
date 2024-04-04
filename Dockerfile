FROM maven:latest
WORKDIR /usr/apiautomation
COPY src /usr/apiautomation/src
COPY pom.xml /usr/apiautomation/pom.xml
COPY testng.xml /usr/apiautomation/testng.xml
COPY extent-reports /usr/apiautomation/extent-reports
RUN mvn clean install
CMD ["mvn","test"]
