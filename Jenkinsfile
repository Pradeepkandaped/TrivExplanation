pipeline {
    agent any   // run on any available Jenkins agent

    stages {
        stage('Checkout') {
            steps {
                // Pull latest code from GitHub
                git branch : 'main', url: 'https://github.com/Pradeepkandaped/TrivExplanation.git'
            }
        }

        stage('Build') {
            steps {
                // Clean and compile the project
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                // Run Selenium + TestNG tests
                bat 'mvn test'
            }
        }

        stage('Report') {
            steps {
                // Publish test results (JUnit/TestNG XML reports)
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}
