pipeline {
    agent any

    tools {
        maven 'Maven 3.8.5'   // Nom Maven installé dans Jenkins 
        jdk 'JDK17'     // Nom JDK 17 configuré dans Jenkins 
    }

    environment {
        SONARQUBE_ENV = 'SonarQube Server'  // Nom du serveur SonarQube configuré dans Jenkins
    }

    stages {
        stage('Build') {
            steps {
                echo 'Compilation du projet...'
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo ' Exécution des tests...'
                sh 'mvn test'
            }
            post {
                always {
                    // Publication des rapports JUnit
                    junit '**/target/surefire-reports/*.xml'
                }
                failure {
                    // Arrêt du pipeline si tests échouent
                    error(' Des tests ont échoué, arrêt du pipeline.')
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                echo 'Analyse SonarQube en cours...'
                withSonarQubeEnv(SONARQUBE_ENV) {
                    sh 'mvn sonar:sonar'
                }
            }
        }
    }
}
