def call() {
    def ec2Ip = '13.51.162.152' // Replace with your EC2 instance's public IP
    def sshKeyPath = '/c/Users/2000149437/Downloads/ravindrap.pem' // Path to your .pem file
    def appJar = 'target/HEX-jenkins-1.0-SNAPSHOT.jar' // Correct application JAR file path

    echo "Deploying application to EC2 instance: ${ec2Ip}"
    sh """
        # Copy the JAR file to the EC2 instance
        scp -o StrictHostKeyChecking=no -i ${sshKeyPath} ${appJar} ec2-user@${ec2Ip}:/home/ec2-user/

        # Run the application on the EC2 instance
        ssh -o StrictHostKeyChecking=no -i ${sshKeyPath} ec2-user@${ec2Ip} "java -jar /home/ec2-user/HEX-jenkins-1.0-SNAPSHOT.jar"
    """
}
