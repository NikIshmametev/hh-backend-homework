rm -r ./dist
mvn clean package shade:shade
docker image rm hh-homework-backend
docker image build --no-cache -t hh-homework-backend .