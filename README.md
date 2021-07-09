
# pegasus-main-domain

## Executing a docker with postgres

If you have a postgres standalone installation, skip this step and go to '**Creating the role in postgres**'

If you don't have a postgres database standalone installation, you could use a docker image for it.

In **docker** folder, exists a file named

> startPostgresDocker.sh

you must give execution permissions to this file with:

    $ chmod +x startPostgresDocker.sh

You could customize this file but keep in mind, to put the same values you put here, in all the references to user, pass, port and database in other files

    $ ./startPostgresDocker.sh

The role and database are created in this script, so you can jump directly to **Using Maven command for first DB populate**

## Creating the role in postgres

### Linux command

    $ createuser -P -s -e pegasus_dev_user -U postgres

This command will prompt for password
Pass:1234

#### Postgres output

User:pegasus_dev_user
Pass:1234

`CREATE ROLE pegasus_dev_user PASSWORD 'md5c592929c1841d4b9a44eea93892e4abd' SUPERUSER CREATEDB CREATEROLE INHERIT LOGIN;`

## Creating the database

### Linux command

    $ createdb pegasus_dev -O pegasus_dev_user -U postgres

## Droping the database

### Linux command

    $ dropdb pegasus_dev -U postgres

## Using Maven command for first populate of DB

Check the values in file **liquibase.properties** has the right values of DB where liquibase will execute the scripts

Inside the folder of **pegasus-main-domain**

    $ mvn process-resources -P liquibase

This step only should be executed when there are changes in the DB model, and we need to have new Java Model representation

## Using Maven command for creating Entities automatically

1. Check the values in file **domain.properties** has the right values of DB where hibernate plugin will generate the entities
2. Remove all classes from package **.hibernate.model** package

Inside the folder of **pegasus-main-domain**

	$ mvn clean compile
	$ mvn generate-sources -P generateJPAEntities
	
## Clear checksums

	mvn process-resources -Pliquibase-clear-checksums

## Sonar

$> mvn clean verify -Psonar