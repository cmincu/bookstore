node {
        stage('Build') {
            // Get some code from a GitHub repository
            git 'https://github.com/cmincu/bookstore.git'

            // Run Maven on a Unix agent.
            sh "mvn clean package"

            archiveArtifacts artifacts: 'server/target/*.jar', followSymlinks: false
        }
        stage('Run JMeter tests'){
            sh 'mvn clean verify'

            archiveArtifacts artifacts: 'test/target/jmeter/results/*', followSymlinks: false

            publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: true, reportDir: 'test/target/jmeter/reports/JMeter_Post', reportFiles: 'index.html', reportName: 'HTML Report',  reportTitles: 'JMeter POST report'])
        }
}
