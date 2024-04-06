pipeline {
    agent any
    triggers{
        githubPush(
                branches: [[name: 'main']]
        )
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
        stage('Test - Regression') {
            steps {
                script {
                    // Move the 'tool' step inside a 'script' block
                    def mvnHome = tool name: 'Maven', type: 'maven'
                    sh "${mvnHome}/bin/mvn clean test"
                }
                echo 'Testing is completed Successfully'
            
            }
        }
    }
}
