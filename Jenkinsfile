pipeline {
	agent any
	
	environment {
		JAR_NAME = "wipro-capstone.jar"
		IMAGE_NAME = "wipro-capstone-demo"
		CONTAINER_NAME = "wipro-capstone-demo-container"
	}
	
	stages {
		stage('Checkout'){
			steps{
				git branch:'master',url:'https://github.com/Dipesh-Chadgal/Wipro-Capstone-Project.git'
			}
		}
		
		stage('Build') {
			steps {
				bat 'mvn clean package'
			}
		}
		
		stage('Build Docket Image'){
			steps {
				bat """
				docker build -t %IMAGE_NAME% .
				
			"""
			}
		}
		
		stage('Deploy'){
			steps {
				bat """
				docker stop %CONTAINER_NAME% || exit 0
				docker rm %CONTAINER_NAME% || exit 0
				"""
				
				bat """
					docker run -d -p 9050:8080 --name %CONTAINER_NAME% %IMAGE_NAME%
				"""
			}
		}
	}
	
	post {
	success {
		echo "Build and deployment successful !"
	}
	failure {
		echo "Build or deployment failed !"
	}
	
  }
}
