pipeline {
    agent any
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
        stage('Test Image') {
            steps {
                script {
                    // Run Maven commands using the configured Maven tool
                    sh "docker build -t shital0711/apitesting:latest -f Dockerfile ."
                }
                echo 'Building docker image sucessfully'
            }
        }
        
    }
}
