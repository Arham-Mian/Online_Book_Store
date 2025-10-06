pipeline {
    agent any

    tools {
        // yahan EXACT naam use karo jo Manage Jenkins -> Global Tool Configuration me set kiya tha
        jdk   'JDK 21'
        maven 'Maven 3.9.11'
    }

    options { timestamps() }

    stages {
        stage('Checkout') {
            steps {
                echo 'Cloning repository...'
                git branch: 'main', url: 'https://github.com/Arham-Mian/Online_Book_Store.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Compile'
                bat '%MAVEN_HOME%\\bin\\mvn -B -U clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Run cucumber runner and produce junit xml'
                // Windows: use bat and quote params
                bat '"%MAVEN_HOME%\\bin\\mvn" -B -U "-Dtest=RunCucumberTest" "-Dcucumber.plugin=pretty,summary,junit:target/cucumber-junit.xml" test'
                echo 'Listing target folder for debugging'
                bat 'dir target'
                bat 'if exist target\\cucumber-junit.xml (echo cucumber xml exists) else (echo NO cucumber xml)'
            }
            post {
                always {
                    // publish cucumber-junit.xml + any surefire xmls; do not allow empty now
                    junit testResults: 'target/cucumber-junit.xml, target/surefire-reports/*.xml', allowEmptyResults: false
                }
            }
        }

        stage('Package') {
            steps {
                echo 'Package'
                bat '"%MAVEN_HOME%\\bin\\mvn" -B -DskipTests package'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Deploy (simulated)') {
            steps {
                echo 'Deploy placeholder (Day 10)'
            }
        }
    }

    post {
        success { echo '✅ Build SUCCESS' }
        failure { echo '❌ Build FAILED' }
    }
}
