# fetch_rewards_test
tested on Fedora Linux, did not test on Windows or Mac.

build: ./gradlew clean build
run: java -jar build/libs/unique-email-test-0.0.1-SNAPSHOT.jar 
verify: http://localhost:8080/swagger-ui.html

intially i planned to add java bean validation to verify correctness of email addresses that are fed to the endpoint
but had to drop it due to time constraints.

other validation may not be fully implemented too

check out controller and service unit tests.
