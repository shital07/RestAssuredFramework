pipeline {
    agent any
    /*tools {
        // Define the Maven tool
       maven 'maven' 
    }*/
    environment {
        DOCKER_IMAGE = "shital0711/apitesting:latest"
        DOCKER_CREDENTAILS = 'Dockerhub'
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
                    // Run Maven commands using the configured Maven tool
                    sh "docker build -t $DOCKER_IMAGE -f Dockerfile ."
                }
                echo 'Building the docker image is sucessfully'
            }
        }
        stage('Push  the image to docker hub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_CREDENTAILS) {
                        docker.image(DOCKER_IMAGE).push()
                    }

                }
            }
        }

    }
}
