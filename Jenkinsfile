pipeline {
  agent any

  tools {
    // EXACT names jaisa tumne "Global Tool Configuration" me set kiya:
    jdk   'jdk21'      // <- apne JDK ka naam yahi ho
    maven 'maven'      // <- apne Maven tool ka naam
  }

  options {
    timestamps()
    ansiColor('xterm')
  }

  stages {
    stage('Checkout') {
      steps {
        echo 'Cloning repository...'
        // 👉 yahan apna GitHub URL daalo
        git branch: 'main', url: 'https://github.com/Arham-Mian/Online_Book_Store.git'
      }
    }

    stage('Build') {
      steps {
        echo 'Building...'
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
        echo 'Deploy step placeholder – Day 10 me actual VM deploy karenge.'
      }
    }
  }

  post {
    success { echo '✅ Build SUCCESS' }
    failure { echo '❌ Build FAILED'  }
  }
}
