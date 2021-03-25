node {
        stage('Build') {
            // Get some code from a GitHub repository
            git 'https://github.com/cmincu/bookstore.git'

            // Run Maven on a Unix agent.
            sh "mvn clean package docker:build"

            // To run Maven on a Windows agent, use
            // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            archiveArtifacts artifacts: 'server/target/*.jar', followSymlinks: false
        }
        stage('Start server') {
            sh "mvn docker:start"
        }
        stage ("Testing") {
            sh 'sleep 10'
            sh '/mnt/backup/Devel/apache-jmeter-5.4.1/bin/jmeter -j jmeter.save.saveservice.output_format=xml -n -t JMeter_Post.jmx -l /mnt/backup/Devel/apache-jmeter-5.4.1/reports/jenkins.io.report.jtl'
        }
        stage('Stop server'){
            sh "mvn docker:stop"
        }
}
