def call() {
    def ec2Ip = '13.51.162.152'
    def sshKeyPath = '/mnt/c/Users/2000149437/Downloads/ravindrap.pem'
    echo "Deploying application to EC2 instance: ${ec2Ip}"
    sh """
        scp -i ${sshKeyPath} target/sample-java-app-1.0-SNAPSHOT.jar ec2-user@${ec2Ip}:/home/ec2-user/
        ssh -i ${sshKeyPath} ec2-user@${ec2Ip} "java -jar /home/ec2-user/sample-java-app-1.0-SNAPSHOT.jar"
    """
}
