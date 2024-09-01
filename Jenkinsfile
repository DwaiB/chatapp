pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven-3.9.9"
    }

    stages {
        stage('Build Maven') {
            steps {
                // Get some code from a GitHub repository
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/DwaiB/chatapp']])

                // Run Maven on a Unix agent.
                sh "mvn clean install"

                
            }
        }
        stage('Build Docker Image') {
            steps {
                
                script{
                    sh "docker build -t aesterix/chatapp ."
                }
            }
        }
        stage('Push Iamge to Hub') {
            steps {
                
                script{
                    withCredentials([string(credentialsId: 'docker_pwd', variable: 'dockerpwd')]) {
                        sh 'docker login -u aesterix -p ${dockerpwd}'
                    }
                    sh ' docker push aesterix/chatapp'
                }
            }
        }
    }
}
