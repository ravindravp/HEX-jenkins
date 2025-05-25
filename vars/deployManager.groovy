def call() {
    def ec2Ip = '16.171.2.15'
    echo "Deploying application to EC2 instance: ${ec2Ip}"
    
    // Use the Secret File stored in Jenkins credentials
    withCredentials([file(credentialsId: 'your-credential-id', variable: 'SSH_KEY_PATH')]) {
        sh """
            scp -o StrictHostKeyChecking=no -i ${SSH_KEY_PATH} target/sample-java-app-1.0-SNAPSHOT.jar ubuntu@${ec2Ip}:/home/ubuntu/
            ssh -o StrictHostKeyChecking=no -i ${SSH_KEY_PATH} ubuntu@${ec2Ip} "java -jar /home/ubuntu/sample-java-app-1.0-SNAPSHOT.jar"
        """
    }
}
