node {
    stage('Clone') {
        checkout scm
    }

    stage('Build') {
        sh 'docker build -t showhost .'
    }

    stage('Upload') {
        sh 'aws ecr get-login-password --region ap-northeast-2 | docker login --username AWS --password-stdin 858869084011.dkr.ecr.ap-northeast-2.amazonaws.com'
        sh 'docker tag showhost:latest 858869084011.dkr.ecr.ap-northeast-2.amazonaws.com/show_hostname:latest'
        sh 'docker push 858869084011.dkr.ecr.ap-northeast-2.amazonaws.com/show_hostname:latest'

    }

    stage('Deploy'){
        sh "/var/lib/jenkins/bin/kubectl config use-context arn:aws:eks:ap-northeast-2:858869084011:cluster/eks-cluster"
        sh "/var/lib/jenkins/bin/kubectl rollout restart deploy show-hostname-deployment"
    }
    stage('Delete'){
        sh 'docker rmi 858869084011.dkr.ecr.ap-northeast-2.amazonaws.com/show_hostname:latest'
    }
    stage('Clean'){
            cleanWs()
       }

}