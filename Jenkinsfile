pipeline {
    agent any

    tools {
        // 👇 These names MUST match exactly what you configured in Jenkins > Global Tool Configuration
        jdk   'JDK 21'
        maven 'Maven 3.9.11'
    }

    options {
        // adds timestamps in Jenkins logs
        timestamps()
    }

    environment {
        // optional variables for clarity or later SSH deploy
        PROJECT_NAME = 'Online_Book_Store'
        BRANCH_NAME = 'main'
    }

    stages {

        stage('Checkout') {
            steps {
                echo "📦 Checking out code from GitHub..."
                git branch: "${BRANCH_NAME}", url: 'https://github.com/Arham-Mian/Online_Book_Store.git'
            }
        }

        stage('Build') {
            steps {
                echo "🔧 Compiling Java source code..."
                script {
                    def mvnHome = tool 'Maven 3.9.11'
                    // clean + compile
                    bat "\"${mvnHome}\\bin\\mvn\" -B -U clean compile"
                }
            }
        }

        stage('Test') {
            steps {
                echo "🧪 Running JUnit tests..."
                script {
                    def mvnHome = tool 'Maven 3.9.11'
                    // run unit tests and generate surefire reports
                    bat "\"${mvnHome}\\bin\\mvn\" -B -U test"
                    // optional: show test dir listing for debug
                    bat 'dir target\\surefire-reports'
                }
            }
            post {
                always {
                    echo "📊 Publishing JUnit test results..."
                    junit testResults: 'target/surefire-reports/*.xml', allowEmptyResults: false
                }
            }
        }

        stage('Package') {
            steps {
                echo "📦 Packaging JAR..."
                script {
                    def mvnHome = tool 'Maven 3.9.11'
                    // skip tests here (already done)
                    bat "\"${mvnHome}\\bin\\mvn\" -B -DskipTests package"
                }
                // save .jar file as artifact in Jenkins build
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Deploy (Simulated)') {
            steps {
                echo "🚀 Simulating deploy stage..."
                echo "Here you could SCP to Linux server or trigger Docker container."
                echo "Example (future): scp target/bookstore-1.0.0.jar user@server:/opt/app/"
            }
        }
    }

    post {
        success {
            echo "✅ BUILD SUCCESSFUL: Application built, tested and packaged successfully!"
        }
        failure {
            echo "❌ BUILD FAILED: Check console output for details."
        }
        always {
            echo "🏁 Pipeline finished at ${new Date()}"
        }
    }
}
