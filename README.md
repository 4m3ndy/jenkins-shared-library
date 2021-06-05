### How to use the jenkins shared library in your Jenkinsfile
* Define the `jenkins-shared-library` as a Global library in your JenkinsCI instance. 
* Define the Kubernetes Cluster in Jenkins Clouds
* Define the `kubeconfig` kubernetes secret to include the cluster that we'll deploy to.
* Add the following `Jenkinsfile` and determine the name of the deployment to be deployed in your cluster
```groovy
@Library('jenkins-shared-library') _
kubeDeploy name: "nginx"
```