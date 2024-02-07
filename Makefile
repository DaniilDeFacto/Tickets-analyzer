.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.4

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

run-dist:
	./build/install/Tickets-analyzer/bin/Tickets-analyzer

run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain checkstyleTest

build-run: build run

.PHONY: build