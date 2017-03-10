#!/usr/bin/env bash

mvn clean install spring-boot:run > /tmp/sub.log 2>&1 &
