def call() {
    def ec2Ip = '13.51.162.250'
    def sshKeyPath = '/mnt/c/Users/2000149437/Downloads/ravindrap.pem' // Corrected path
    echo "Deploying application to EC2 instance: ${ec2Ip}"
    sh """
        scp -o StrictHostKeyChecking=no -i ${sshKeyPath} target/sample-java-app-1.0-SNAPSHOT.jar ubuntu@${ec2Ip}:/home/ubuntu/
        ssh -o StrictHostKeyChecking=no -i ${sshKeyPath} ubuntu@${ec2Ip} "java -jar /home/ubuntu/sample-java-app-1.0-SNAPSHOT.jar"
    """
}
