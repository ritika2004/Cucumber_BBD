pipeline {
    agent any

    environment {
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-25.0.3'
        MAVEN_HOME = 'C:\\apache-maven-3.9.15'
        PATH = "${JAVA_HOME}\\bin;${MAVEN_HOME}\\bin;${env.PATH}"
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/ritika2004/Cucumber_BBD.git'
            }
        }

        stage('Clean') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn compile'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Generate Report') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }

      
        stage('Docker Build') {
            steps {
                bat 'docker build -t cucumber-framework .'
            }
        }

        
        stage('Docker Run') {
            steps {
                bat 'docker run --rm cucumber-framework'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/**/*', allowEmptyArchive: true
        }

        success {
            echo 'Build Successful'
        }

        failure {
            echo 'Build Failed'
        }
    }
}