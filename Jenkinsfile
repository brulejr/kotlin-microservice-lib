pipeline {

    agent any

    stages {
        stage ('Checkout') {
            steps {
                checkout scm
                sh 'ls -lat'
            }
        }
        stage("Compile") {
            steps {
                sh "./gradlew clean classes testClasses"
            }
        }
        stage ('Analysis') {
            steps {
                sh './gradlew check'
                junit "**/build/test-results/test/*.xml"
                jacoco(
                    execPattern: 'build/jacoco/jacoco.exec'
                    classPattern: 'build/classes/kotlin/**/**.class'
                    exclusionPattern: '**/**Test'
                )
            }
        }
        stage ('Build') {
            steps {
                sh './gradlew build'
            }
        }
    }

}
