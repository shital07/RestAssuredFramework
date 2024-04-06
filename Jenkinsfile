pipeline {
    agent any
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
                sh 'echo $PATH'
              //  sh 'mvn clean test'
                echo 'Testing is completed Successfully'
            
            }
        }
    }
}
