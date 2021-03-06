pipeline {
    agent any 
      tools {
    jdk 'JDK8'
    maven 'maven3.6.3'
  }
    triggers {
        pollSCM('* * * * *')
    }

   
    stages {
stage('Compile Stage') {
            steps {
                echo '::::: Hello, Compile  :::::'                
                sh 'mvn clean'                      
            }
        }  
          
         stage('Docker Build Stage') {
            steps {
                echo '::::: Hello, Docker Build stage  :::::'
                sh 'docker image build -t schoolmanagmentsystems .'                              
            }
        } 
        stage('Tag docker image'){
            steps {
                sh 'docker tag schoolmanagmentsystems ashish142/schoolmanagmentsystems:1.0.0'
            }          
        }
        stage('Push docker image'){
            steps {
                sh 'sudo docker push ashish142/schoolmanagmentsystems:1.0.0'
            }          
        }
        stage('Deploy Stage') {
            steps {
                echo 'Hello, Docker Deployment.'
                sh '''
                 (if  [ $(docker ps -a | grep schoolmanagmentsystems | cut -d " " -f1) ]; then \
                        echo $(docker rm -f schoolmanagmentsystems); \
                        echo "---------------- successfully removed ecom-webservice ----------------"
                     else \
                    echo OK; \
                 fi;);
            docker container run --restart always --name schoolmanagmentsystems -p 8082:8081 -d schoolmanagmentsystems
            '''
            }
        }    
    }      
 }

