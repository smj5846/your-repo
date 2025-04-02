pipeline {
    agent any

    environment {
        AWS_REGION = "ap-northeast-2"
        ECR_REGISTRY = "767828724436.dkr.ecr.ap-northeast-2.amazonaws.com"
        IMAGE_NAME = "your-service"
    }

    stages {
        stage('Git Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/smj5846/your-repo.git'
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    sh "docker build -t ${IMAGE_NAME} ./app"
                }
            }
        }

        stage('Docker Tag') {
            steps {
                script {
                    sh "docker tag ${IMAGE_NAME}:latest ${ECR_REGISTRY}/${IMAGE_NAME}:latest"
                }
            }
        }

        stage('Push to ECR') {
            steps {
                script {
                    sh """
                        aws ecr get-login-password --region ${AWS_REGION} | docker login --username AWS --password-stdin ${ECR_REGISTRY}
                        docker push ${ECR_REGISTRY}/${IMAGE_NAME}:latest
                    """
                }
            }
        }
    }
}
