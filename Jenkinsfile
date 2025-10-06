pipeline {
  agent any

  tools {
    jdk   'JDK 21'        // <-- EXACT name from Manage Jenkins -> Tools
    maven 'Maven 3.9.11'  // <-- EXACT name from Manage Jenkins -> Tools
  }

  options {
    timestamps()
  }

  stages {
    stage('Checkout') {
      steps {
        echo 'Cloning repository...'
        git branch: 'main', url: 'https://github.com/Arham-Mian/Online_Book_Store.git'
      }
    }

    stage('Build') {
      steps {
        echo 'Building project (compile)...'
        bat 'mvn -B -U clean compile'
      }
    }

    stage('Test') {
      steps {
        echo 'Running tests...'
        bat 'mvn -B test'
      }
      post {
        always {
          junit 'target/surefire-reports/*.xml'
        }
      }
    }

    stage('Package') {
      steps {
        echo 'Packaging JAR...'
        bat 'mvn -B -DskipTests package'
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }

    stage('Deploy (simulated)') {
      steps {
        echo 'Deploy step placeholder (Day 10: real deploy to Linux VM)'
      }
    }
  }

  post {
    success { echo '✅ Build SUCCESS' }
    failure { echo '❌ Build FAILED' }
  }
}
