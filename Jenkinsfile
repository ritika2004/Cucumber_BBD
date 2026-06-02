pipeline {
    agent any

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                url: 'https://github.com/ritika2004/Cucumber_BBD.git'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t cucumber-framework .'
            }
        }

        stage('Run Tests in Docker') {
            steps {
                bat 'docker run --rm cucumber-framework'
            }
        }
    }

    post {

        always {
            archiveArtifacts artifacts: 'target/**/*', allowEmptyArchive: true
            junit 'target/surefire-reports/*.xml'
        }

        success {
            echo 'BUILD SUCCESS ✅'
        }

        failure {
            echo 'BUILD FAILED ❌'
        }
    }
}