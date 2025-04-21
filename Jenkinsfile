pipeline {
    agent any
    parameters {
        string(name: 'TICKET_KEYS', defaultValue: 'POEI25P2G3-75', description: 'Liste des tickets séparés par des virgules, ex: TICKET-1,TICKET-2')
    }
    environment {
        XRAY_AUTH_URL = "https://xray.cloud.getxray.app/api/v2/authenticate"
        XRAY_REPORT_JSON = "https://xray.cloud.getxray.app/api/v2/import/execution/cucumber"
        CLIENT_ID = "81C7FEA9A5464340974B1548E5ADFA37"
        CLIENT_SECRET = "c3d20d2db84ce7fd05f4ca00bdd07d9aae16fe14b59b96712af9a1bf8c6171fe"
        XRAY_TOKEN = ""
    }
    stages {
        stage('Authenticate with Xray') {
            steps {
                script {
                    def authResponse = bat(
                        script: """
                            curl -H "Content-Type: application/json" -X POST --data ^
                            "{\\"client_id\\": \\"${CLIENT_ID}\\", \\"client_secret\\": \\"${CLIENT_SECRET}\\"}" ^
                            ${XRAY_AUTH_URL} 2> nul
                        """,
                        returnStdout: true
                    ).trim()

                    def lines = authResponse.readLines()
                    def token = lines[1].replaceAll('"', '').trim()

                    XRAY_TOKEN = token
                    echo "Xray Token: ${XRAY_TOKEN}"
                }
            }
        }

        stage('Import des Features') {
            steps {
                script {
                    def tickets = params.TICKET_KEYS.tokenize(',')
                    for (ticket in tickets) {
                        def ticketKey = ticket.trim()
                        def importUrl = "https://xray.cloud.getxray.app/api/v2/export/cucumber?keys=${ticketKey}"

                        echo "Importing features for ticket: ${ticketKey}"

                        bat(
                            script: """
                                curl -H "Content-Type: application/json" ^
                                -X GET -H "Authorization: Bearer ${XRAY_TOKEN}" ^
                                "${importUrl}" > features_${ticketKey}.zip
                            """,
                            returnStdout: true
                        ).trim()

                        powershell "Expand-Archive -Path features_${ticketKey}.zip -DestinationPath src/test/resources/features/ -Force"
                    }
                }
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Export report à XRAY') {
            steps {
                script {
                    def exportResponse = bat(
                        script: """
                            curl -H "Content-Type: application/json" ^
                            -X POST -H "Authorization: Bearer ${XRAY_TOKEN}" ^
                            --data @target/cucumber.json ${XRAY_REPORT_JSON}
                        """,
                        returnStdout: true
                    ).trim()

                    echo "Xray export response: ${exportResponse}"
                }
            }
        }
    }

    post {
        always {
            cucumber fileIncludePattern: 'target/cucumber.json'
        }
    }
}
