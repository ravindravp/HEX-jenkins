def call() {
    echo 'Building Java application using Maven...'
    sh 'mvn clean package'
}
