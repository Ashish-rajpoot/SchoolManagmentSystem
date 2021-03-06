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
                sh 'mvn clean '                      
            }
        }  
        stage('mvn Build Stage') {
            steps {
                echo '::::: Hello, mvn Build stage  :::::'
                sh 'mvn clean package -DskipTests'                       
            }
        }  
         stage('Docker Build Stage') {
            steps {
                echo '::::: Hello, Docker Build stage  :::::'
                sh 'docker image build -t SchoolManagmentSystems .'                              
            }
        } 
        stage('Tag docker image'){
            steps {
                sh 'docker tag SchoolManagmentSystems ashish142/SchoolManagmentSystems:1.0.0'
            }          
        }
        stage('Push docker image'){
            steps {
                sh 'sudo docker push ashish142/SchoolManagmentSystems:1.0.0'
            }          
        }
        stage('Deploy Stage') {
            steps {
                echo 'Hello, Docker Deployment.'
                sh '''
                 (if  [ $(docker ps -a | grep SchoolManagmentSystems | cut -d " " -f1) ]; then \
                        echo $(docker rm -f SchoolManagmentSystems); \
                        echo "---------------- successfully removed ecom-webservice ----------------"
                     else \
                    echo OK; \
                 fi;);
            docker container run --restart always --name SchoolManagmentSystems -p 8082:8081 -d SchoolManagmentSystems
            '''
            }
        }    
    }      
 }

