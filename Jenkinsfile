pipeline {
    agent any

    environment {
        AWS_REGION = "ap-northeast-2"
        ECR_REGISTRY = "767828724436.dkr.ecr.ap-northeast-2.amazonaws.com"
        IMAGE_NAME = "my-service"  // 원하는 이름으로 바꿔도 됨
        ECR_IMAGE = "${ECR_REGISTRY}/${IMAGE_NAME}:latest"
    }

    stages {
        stage('Clone') {
            steps {
                git branch: 'main', url: 'https://github.com/smj5846/your-repo.git'
            }
        }

        stage('Maven Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t $IMAGE_NAME .'
            }
        }

        stage('Tag Docker Image') {
            steps {
                sh 'docker tag $IMAGE_NAME:latest $ECR_IMAGE'
            }
        }

        stage('Push to ECR') {
            steps {
                sh """
                    aws ecr get-login-password --region $AWS_REGION | docker login --username AWS --password-stdin $ECR_REGISTRY
                    docker push $ECR_IMAGE
                """
            }
        }
    }
}
