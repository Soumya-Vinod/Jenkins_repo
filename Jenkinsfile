pipeline {
    agent any

    tools {
        nodejs 'NodeJS'
    }

    stages {

        stage('Install Dependencies') {
            steps {
                bat 'npm install'
            }
        }

        stage('Run Application') {
            steps {
                bat 'npm start'
            }
        }
    }

    post {
        success {
            echo 'Node.js Application Deployed Successfully!'
        }
    }
}