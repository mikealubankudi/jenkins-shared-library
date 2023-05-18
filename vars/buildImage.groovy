#!/usr/bin/env groovy

def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: '5afdb5cf-c312-404d-a2a5-ffee0bda2442', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t mikealubankudi/demo-app:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push mikealubankudi/maven-app:2.0'
    }
}
