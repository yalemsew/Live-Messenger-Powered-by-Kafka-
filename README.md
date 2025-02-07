# Live Messenger with Kafka

Live Messenger with Kafka is a real-time messaging application built to demonstrate an event-driven, decoupled architecture using Spring Boot, Apache Kafka, and WebSockets on the backend, along with a React-based frontend. This application enables instant communication between clients without persisting messages in a database.

> **Note:** This demo application focuses on live, ephemeral messaging. Messages are broadcasted in real time and are not stored permanently.

## Table of Contents

- [Features](#features)
- [Architecture](#architecture)
- [Prerequisites](#prerequisites)
- [Setup and Installation](#setup-and-installation)
  - [Running Kafka and ZooKeeper via Docker](#running-kafka-and-zookeeper-via-docker)
  - [Running the Spring Boot Backend](#running-the-spring-boot-backend)
  - [Running the React Frontend](#running-the-react-frontend)
- [Usage](#usage)
- [Troubleshooting](#troubleshooting)
- [License](#license)
- [Author](#author)

## Features

- **Real-Time Messaging:** Instant communication using WebSocket.
- **Event-Driven Architecture:** Uses Kafka to decouple message production from consumption.
- **Ephemeral Chat:** Messages are not stored in a database; they are broadcasted live.
- **Scalable and Extensible:** Demonstrates the use of modern tools like Kafka for handling high-throughput events.

## Architecture

- **Spring Boot Backend:**
  - Exposes REST endpoints to receive messages.
  - Uses a Kafka producer to send messages to a Kafka topic.
  - Uses a Kafka consumer to receive messages from the topic.
  - Broadcasts messages to connected WebSocket clients via STOMP.
- **Apache Kafka:**
  - Acts as a messaging layer to decouple the message producer and consumer.
  - Provides durability and scalability for high message throughput.
- **React Frontend:**
  - Connects to the WebSocket endpoint using SockJS and STOMP.
  - Displays live messages in real time.
  - Provides a simple UI for sending messages.

## Prerequisites

Before you begin, ensure you have the following installed:

- [Docker & Docker Compose](https://docs.docker.com/get-docker/) – for running Kafka and ZooKeeper.
- [Java JDK 11+](https://adoptopenjdk.net/) – for running the Spring Boot application.
- [Maven](https://maven.apache.org/) – for building the Spring Boot project.
- [Node.js & npm](https://nodejs.org/) – for running the React application.

## Setup and Installation

### Running Kafka and ZooKeeper via Docker

1. **Create a directory for Docker configuration (if you haven't already):**

   ```bash
   mkdir kafka-docker
   cd kafka-docker
