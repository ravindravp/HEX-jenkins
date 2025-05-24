def call() {
    def ec2Ip = 'EC2_PUBLIC_IP'
    def sshKeyPath = '/path/to/your/ssh-key.pem'
    echo "Deploying application to EC2 instance: ${ec2Ip}"
    sh """
        scp -i ${sshKeyPath} target/sample-java-app-1.0-SNAPSHOT.jar ec2-user@${ec2Ip}:/home/ec2-user/
        ssh -i ${sshKeyPath} ec2-user@${ec2Ip} "java -jar /home/ec2-user/sample-java-app-1.0-SNAPSHOT.jar"
    """
}
