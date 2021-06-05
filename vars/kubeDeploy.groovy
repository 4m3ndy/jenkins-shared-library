def call(Map deploymentConfig) {
  pipeline {
    agent {
      kubernetes {
        yamlFile libraryResource 'org/andela/podTemplates/JenkinsKubernetesPod.yaml'
      }
    }

    stages {
      stage('Deploy') {
        steps {
          container('kubectl') {
            script {
              def deploymentObj = libraryResource "org/andela/deployments/${deploymentConfig.name}-deployment.yaml"
              print deploymentObj
              sh 'kubectl get namespaces'
            }
          }
        }
      }
    }
  }
}