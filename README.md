### Tests and linter status:
[![Java CI](https://github.com/DaniilDeFacto/Tickets-analyzer/actions/workflows/main.yml/badge.svg)](https://github.com/DaniilDeFacto/Tickets-analyzer/actions/workflows/main.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/d45254fc205dfba9b93e/maintainability)](https://codeclimate.com/github/DaniilDeFacto/Tickets-analyzer/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/d45254fc205dfba9b93e/test_coverage)](https://codeclimate.com/github/DaniilDeFacto/Tickets-analyzer/test_coverage)
# Tickets analyzer
Данный проект является результатом выполнения следующего тестового задания:

"Напишите программу на языке программирования java, которая прочитает файл tickets.json и рассчитает:
- Минимальное время полета между городами Владивосток и Тель-Авив для каждого авиаперевозчика;
- Разницу между средней ценой и медианой для полета между городами Владивосток и Тель-Авив.

Программа должна вызываться из командной строки Linux, результаты должны быть представлены в текстовом виде."

Файл `tickets.json` расположен в директории `resources`.

### Start

```bash
make
```

### Setup

```bash
make build
```

### Run

```bash
make run
```

### Run tests

```bash
make test
```

### Run checkstyle

```bash
make lint
```