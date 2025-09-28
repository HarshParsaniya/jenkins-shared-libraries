def call(String ProjectName, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'dockerHubCred', usernameVariable: 'dockerHubUser', passwordVariable: 'dockerHubPass')]){
    sh "docker login -u ${dockerhubuser} -p ${dockerHubPass}"
  }
  sh "docker push ${dockerhubuser}/${ProjectName}:${ImageTag}"
}
