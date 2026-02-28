pipeline {
    agent any

    stages {

        stage('Compile') {
            steps {
                bat 'javac Factorial.java'
            }
        }

        stage('Run') {
            steps {
                bat 'java Factorial'
            }
        }
    }

    post {
        success {
            emailext (
                subject: "Jenkins Build Success",
                body: "Your Java Factorial Pipeline built successfully!",
                to: "2025.soumya.vinod@ves.ac.in"
            )
        }
    }
}