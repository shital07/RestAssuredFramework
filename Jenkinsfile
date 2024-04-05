pipeline {
    agent any
    stages {
        stage('Checkout git') {
            steps {
                // checkout the source code from Git using credentails
                git credentialsId: 'GitID',
                        url: 'https://github.com/shital07/RestAssuredFramework.git',
                echo 'Git checkout is successful'

            }
        }
    }
}