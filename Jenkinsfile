pipeline {
    agent {
        docker{
            image 'maven:latest'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
    /*tools {
        // Define the Maven tool
       maven 'maven' 
    }*/
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
        stage('Test - Regression') {
            steps {
                script {
                    // Run Maven commands using the configured Maven tool
                    sh "mvn clean test"
                }
                echo 'Testing is completed Successfully'
            }
        }
    }
}
