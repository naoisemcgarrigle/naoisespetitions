pipeline {
    agent any

    stages {
        stage('GetProject') {
            steps {
                git (
                    url: 'https://github.com/naoisemcgarrigle/naoisespetitions.git',
                    branch: 'master'
                )
            }
        }
        stage('Build') {
            steps {
                sh "java -version"
                sh "javac -version"
                sh "mvn clean:clean"
                sh "mvn dependency:copy-dependencies"
                sh "mvn compiler:compile"
            }
        }
        stage('Package') {
            steps {
                sh "mvn package"
            }
        }
        stage('Archive') {
            steps {
                archiveArtifacts allowEmptyArchive: true,
                    artifacts: '**/naoisespetitions*.war'
            }
        }
        stage('Deploy') {
            steps {
                script {
                    input message: "Approve new deployment?", ok: "Deploy"
                }
                sh "docker build -f Dockerfile -t myapp . "
                sh "docker rm -f \"myappcontainer\" || true"
                sh "docker run --name \"myappcontainer\" -p 8081:8080 --detach myapp:latest"
            }
        }
    }
}