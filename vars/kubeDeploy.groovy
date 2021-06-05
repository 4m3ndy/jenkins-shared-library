def call(Map deploymentConfig) {
  pipeline {
    agent {
      kubernetes {
        yaml libraryResource('org/andela/podTemplates/JenkinsKubernetesPod.yaml')
      }
    }

    stages {
      stage('Deploy') {
        steps {
          script {
            container('kubectl') {
              def deploymentObj = libraryResource("org/andela/deployments/${deploymentConfig.name}-deployment.yaml")
              writeFile file: 'deployment.yaml', text: "${deploymentObj}"
              sh "kubectl apply -f deployment.yaml"
            }
          }
        }
      }
    }
  }
}