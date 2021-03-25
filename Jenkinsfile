node {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/cmincu/bookstore.git'

                // Run Maven on a Unix agent.
                sh "mvn clean package docker:build"


                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    // junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'server/target/*.jar'
                }
            }
        }
        stage('Start server') {
            sh "mvn docker:start"
        }
        stage ("Testing") {
            sh 'sleep 10'
        }
        stage('Stop server'){
            sh "mvn docker:stop"
        }


}
