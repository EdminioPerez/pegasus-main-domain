#!/bin/bash

docker run -d \
  --name pegasus-dev-postgres \
  -p 5436:5432 \
  -e POSTGRES_USER=pegasus_dev_user \
  -e POSTGRES_PASSWORD=1234 \
  -e POSTGRES_DB=pegasus_dev \
  -e PGDATA=/var/lib/postgresql/data/pgdata \
  -v $HOME/pegasus_dev_pgdata:/var/lib/postgresql/data \
  -v "$PWD/custom-postgres.conf":/etc/postgresql/postgresql.conf \
  postgres \
  -c 'config_file=/etc/postgresql/postgresql.conf'
