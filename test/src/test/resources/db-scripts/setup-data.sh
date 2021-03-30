#!/bin/bash

while ! echo $(mysql -h 127.0.0.1 -P 3306 -uroot \
	                 -proot -e "SELECT 'ready'") \
                     | grep --quiet "ready"; do
    sleep 2
    echo "====================================="
    echo "Waiting for mysql Server to be ready"
    echo "====================================="

done

mysql --user=root --password=root < /tmp/import/bookstore.sql && echo "bookstore.sql - import done"

# Add additional changes here as:
# mysql -uroot -proot --database=${schema} < /tmp/import/updates/???.sql && echo "???.sql - import done"

# mysql --user=root --password=root < /tmp/import/updates/000_setup_init.sql && echo "000_setup_init.sql - import done"

echo "Schema(s) creation DONE"
echo ""
