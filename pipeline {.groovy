pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                echo 'Building the project...'
                echo 'Using build tool: Maven'
            }
        }
        stage('Unit and Integration Tests') {
            steps {
                echo 'Running Unit and Integration Tests...'
                echo 'Using test tools: JUnit, Selenium'
            }
        }
        stage('Code Analysis') {
            steps {
                echo 'Performing Code Analysis...'
                echo 'Using code analysis tool: SonarQube'
            }
        }
        stage('Security Scan') {
            steps {
                echo 'Performing Security Scan...'
                echo 'Using security scan tool: OWASP Dependency-Check'
            }
        }
        stage('Deploy to Staging') {
            steps {
                echo 'Deploying to Staging Environment...'
                echo 'Using deployment platform: AWS EC2'
            }
        }
        stage('Integration Tests on Staging') {
            steps {
                echo 'Running Integration Tests on Staging...'
                echo 'Using testing tool: Selenium'
            }
        }
        stage('Deploy to Production') {
            steps {
                echo 'Deploying to Production...'
                echo 'Using production platform: AWS EC2'
            }
        }
    }
    post {
        always {
            script {
                echo 'Sending email notification...'
                mail to: 'developer@example.com',
                     subject: "Build Status: ${currentBuild.currentResult}",
                     body: "Build completed with status: ${currentBuild.currentResult}.",
                     attachLog: true
            }
        }
    }
}
