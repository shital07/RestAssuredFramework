pipeline {
    agent any
    /*tools {
        // Define the Maven tool
       maven 'maven'
    }*/
    environment {
        DOCKER_IMAGE = "shital0711/apitesting:latest"
    }

    stages {
        stage('Checkout git') {
            steps {
                // checkout the source code from Git using credentials
                git credentialsId: 'GitID',
                        url: 'https://github.com/shital07/RestAssuredFramework.git',
                        branch: 'main'
                echo 'Git checkout is successful'
            }
        }
        stage('Build docker image') {
            steps {
                script {
                    echo "Building the new docker image"
                    sh "docker build -t $DOCKER_IMAGE -f Dockerfile ."
                }
                echo 'Building the docker image is sucessfull.'
            }
        }
        stage('Push  the image to docker hub') {
            steps {
                script {
                    echo "Pushing the image to docker hub"
                    withCredentials([usernamePassword(credentialsId:"Dockerhub",passwordVariable: "DockerhubPass",usernameVariable: "DockerhubUser" )])
                  //  withCredentials([usernamePassword(credentialsId:"dockerHub",passwordVariable:"dockerHubPass",usernameVariable:"dockerHubUser")]){
                    
                        sh "docker login -u ${env.DockerhubUser} -p ${env.DockerhubPass}"
                        sh "docker push ${DOCKER_IMAGE}"

                    }
            }
        }

    }
}
