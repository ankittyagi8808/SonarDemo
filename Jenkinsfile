def gitBranch = "${env.BRANCH_NAME}"
if (gitBranch == 'master') {
    } else if (gitBranch.startsWith('PR')) {
      gitBranch = "${env.CHANGE_BRANCH}"
    } else {
      // some other branch
    }
node {
    def mvnHome
    stage('Preparation') { // for display purposes
        // Get some code from a GitHub repository
     //   git 'https://github.com/ankittyagi8808/SonarDemo.git'
      checkout([$class: 'GitSCM', branches: [[name: "${gitBranch}"]], extensions: [], userRemoteConfigs: [[credentialsId: 'e5132d10-1f6b-4bb8-856f-dc71e5942c97', url: 'https://github.com/ankittyagi8808/SonarDemo.git']]])
        // Get the Maven tool.
        // ** NOTE: This 'M3' Maven tool must be configured
        // **       in the global configuration.
        mvnHome = tool 'M3'
    }
    stage('Build') {
        // Run the maven build
        withEnv(["MVN_HOME=$mvnHome"]) {
            if (isUnix()) {
                sh '"$MVN_HOME/bin/mvn" -Dmaven.test.failure.ignore clean package'
            } else {
                bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean package/)
            }
        }
    }
      stage('SonarQube analysis') {
      withSonarQubeEnv('SonarQube') {
        withEnv(["MVN_HOME=$mvnHome"]) {
            sonarurl = "http://localhost:9000" 
            check = "${env.BRANCH_NAME}"
           if(check.startsWith('PR'))
           {
           bat(/"%MVN_HOME%\bin\mvn" -X clean package sonar:sonar  -Dsonar.host.url=$sonarurl -Dsonar.pullrequest.branch="${gitBranch}" -Dsonar.pullrequest.key="${env.BRANCH_NAME}" -Dsonar.pullrequest.base="${env.CHANGE_TARGET}" -Dsonar.login=a6d0ae150681c139b43ec2244bed8a2b2543fc0c/)
           }else{
      bat(/"%MVN_HOME%\bin\mvn" -X clean package sonar:sonar  -Dsonar.host.url=$sonarurl -Dsonar.branch.name="${gitBranch}" -Dsonar.login=a6d0ae150681c139b43ec2244bed8a2b2543fc0c/)
    }
    }
    }// submitted SonarQube taskId is automatically attached to the pipeline context
  }
    
    stage("Quality Gate"){
  timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
    def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
    if (qg.status != 'OK') {
      error "Pipeline aborted due to quality gate failure: ${qg.status}"
    }
  }
}

}
