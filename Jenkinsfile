pipeline {
    agent any

    tools {
        maven 'Maven3' // Must match the Maven installation name under "Manage Jenkins → Tools → Maven"
    }

    environment {
        SONARQUBE_SERVER = 'SonarQubeServer' // Must match your configured SonarQube server name in Jenkins
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/ADirin/Week4_Inclass_Assignment_SonarQube_Jenkins.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                // Use SonarQube environment configured in Jenkins
                withSonarQubeEnv('SonarQubeServer') {
                    // Use secure token from Jenkins credentials
                    withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
                        bat """
                            mvn sonar:sonar ^
                              -Dsonar.projectKey=devops-demo ^
                              -Dsonar.projectName=DevOps-Demo ^
                              -Dsonar.host.url=%SONAR_HOST_URL% ^
                              -Dsonar.login=%SONAR_TOKEN%
                        """
                    }
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 2, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }

    post {
        success {
            echo '✅ Build and SonarQube analysis completed successfully!'
        }
        failure {
            echo '❌ Build or SonarQube analysis failed. Check logs for details.'
        }
    }
}
