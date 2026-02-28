pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK'
    }

    environment {
        TOMCAT_HOME = "C:\\Tomcat"
    }

    stages {

        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Build Application') {
            steps {
                dir('SurnameSpring') {
                    bat 'mvn clean package'
                }
            }
        }

        stage('Stop Tomcat') {
            steps {
                bat '%TOMCAT_HOME%\\bin\\shutdown.bat || exit 0'
                sleep 5
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                dir('SurnameSpring') {
                    bat 'copy /Y target\\*.war %TOMCAT_HOME%\\webapps\\'
                }
            }
        }

        stage('Start Tomcat') {
            steps {
                bat '%TOMCAT_HOME%\\bin\\startup.bat'
            }
        }
    }
}