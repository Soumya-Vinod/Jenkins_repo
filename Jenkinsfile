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
subject: "Build Successful ✅",
body: "Factorial pipeline built successfully.",
to: "[soumyav0212@gmail.com](mailto:soumyav0212@gmail.com),[2025.soumya.vinod@ves.ac.in](mailto:2025.soumya.vinod@ves.ac.in)"
)
}
}

}