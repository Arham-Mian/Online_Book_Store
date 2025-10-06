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
        git branch: 'main', url: 'https://github.com/<YOUR_USERNAME>/Online_Book_Store.git'
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
        bat 'mvn -B -U test'
        echo '== Listing target directory =='
        bat 'dir target'
        echo '== Listing surefire-reports (if any) =='
        bat 'if exist target\\surefire-reports (dir target\\surefire-reports) else (echo No surefire-reports folder)'
        echo '== Show cucumber-junit.xml (if created) =='
        bat 'if exist target\\cucumber-junit.xml (type target\\cucumber-junit.xml) else (echo No cucumber-junit.xml)'
      }
      post {
        always {
          // publish both surefire XMLs and cucumber xml; allowEmptyResults true while debugging
          junit testResults: 'target/surefire-reports/*.xml, target/cucumber-junit.xml', allowEmptyResults: true
        }
      }
    }

    stage('Package') {
      when {
        expression { currentBuild.result == null || currentBuild.result == 'SUCCESS' }
      }
      steps {
        echo 'Packaging JAR...'
        bat 'mvn -B -DskipTests package'
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }

    stage('Deploy (simulated)') {
      steps {
        echo 'Deploy placeholder (Day 10: real deploy to Linux VM)'
      }
    }
  }

  post {
    success { echo '✅ Build SUCCESS' }
    unstable { echo '⚠️ Build UNSTABLE (tests had warnings)' }
    failure { echo '❌ Build FAILED'  }
  }
}
