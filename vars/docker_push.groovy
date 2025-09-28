def call(String ProjectName, String ImageTag, String DockerHubUser){
  withCredentials([usernamePassword(credentialId: 'dockerHubCred', usernameVariable: 'dockerHubUser', passwordVariable: 'dockerHubPass')]){
    sh "docker login -u ${dockerHubUser} -p{dockerHubPass}"
  }
  sh "docker push ${DockerHubUser}/${ProjectName}:${ImageTag}"
}
