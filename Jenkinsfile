pipeline {
  agent any

  tools {
    jdk   'JDK 21'          // set these names exactly as in Manage Jenkins -> Tools
    maven 'Maven 3.9.11'
  }

  options { timestamps() }

  stages {
    stage('Checkout') {
      steps {
        echo 'Cloning...'
        git branch: 'main', url: 'https://github.com/Arham-Mian/Online_Book_Store.git'
      }
    }

    stage('Build') {
      steps {
        script {
          // resolve tool path (handles spaces) and run via bat with explicit quoting
          def mvnHome = tool 'Maven 3.9.11'
          bat "\"${mvnHome}\\bin\\mvn\" -B -U clean compile"
        }
      }
    }

    stage('Test') {
      steps {
        script {
          def mvnHome = tool 'Maven 3.9.11'
          // run cucumber runner and ask it to write junit xml
          bat "\"${mvnHome}\\bin\\mvn\" -B -U \"-Dtest=RunCucumberTest\" \"-Dcucumber.plugin=pretty,summary,junit:target/cucumber-junit.xml\" test"
          bat 'dir target'
          bat 'if exist target\\cucumber-junit.xml (echo cucumber xml exists) else (echo NO cucumber xml)'
        }
      }
      post {
        always {
          // publish cucumber xml + surefire results
          junit testResults: 'target/cucumber-junit.xml, target/surefire-reports/*.xml', allowEmptyResults: false
        }
      }
    }

    stage('Package') {
      steps {
        script {
          def mvnHome = tool 'Maven 3.9.11'
          bat "\"${mvnHome}\\bin\\mvn\" -B -DskipTests package"
        }
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
      }
    }

    stage('Deploy (simulated)') {
      steps {
        echo 'Deploy (simulated)'
      }
    }
  }

  post {
    success { echo '✅ Build SUCCESS' }
    failure { echo '❌ Build FAILED' }
  }
}
