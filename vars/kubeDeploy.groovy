def call(Map deploymentConfig) {
  pipeline {
    agent {
      kubernetes {
        yamlFile 'org/andela/podTemplates/JenkinsKubernetesPod.yaml'
      }
    }

    stages {
      stage('Deploy') {
        steps {
          container('kubectl') {
            def deploymentObj = libraryResource "org/andela/deployments/${deploymentConfig.name}-deployment.yaml"
            print deploymentObj
            sh 'kubectl get namespaces'
          }
        }
      }
    }
  }
}