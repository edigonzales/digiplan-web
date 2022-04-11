# digiplan-web


## postgres

**TODO:** Gretl weg, falls ich das im docker-compose nicht benötige.

```
docker-compose run --user $UID --rm -v $PWD/gretl:/home/gradle/project gretl "sleep 20 && cd /home/gradle && gretl -b project/build.gradle tasks --all"
```

```
export ORG_GRADLE_PROJECT_dbUriPub="jdbc:postgresql://pub-db/pub"
export ORG_GRADLE_PROJECT_dbUserPub="postgres"
export ORG_GRADLE_PROJECT_dbPwdPub="postgres"
export ORG_GRADLE_PROJECT_gretlEnvironment="dev"
```

```
./start-gretl.sh --docker-image sogis/gretl:latest --docker-network digiplan-web_default --job-directory $PWD/gretl/ importData_Digiplan createIndex_Digiplan

```