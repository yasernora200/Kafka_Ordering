# 🚀 Kafka Ordering & Event Processing API

A robust Spring Boot and Apache Kafka project designed for handling order events processing, message partition keys, and scalable event streaming.

---

## 🛠️ Tech Stack

* **Java 17+**
* **Spring Boot 3.x**
* **Apache Kafka (KRaft Mode)**
* **OpenAPI 3 / Swagger Editor**

---

## ⚙️ Running Apache Kafka without Zookeeper (KRaft Mode)

This project uses **Kafka in KRaft Mode** (No Zookeeper required). The configuration files are located inside Kafka's `config/kraft/` folder (`server.properties`).

To start the Kafka Broker on **Windows**, execute the following commands in order using PowerShell or Command Prompt inside your Kafka installation directory:

### 1. Generate Cluster UUID
```powershell
$KAFKA_CLUSTER_ID = .\bin\windows\kafka-storage.bat random-uuid
```

### 2. Format Log Directories
```powershell
.\bin\windows\kafka-storage.bat format -t $KAFKA_CLUSTER_ID -c .\config\kraft\server.properties
```

### 3. Start Kafka Server / Broker
```powershell
.\bin\windows\kafka-server-start.bat .\config\server.properties
```

> 💡 **Note:** The Kafka broker will start on the default port `localhost:9092`.

---

## 🏃‍♂️ Running the Spring Boot Application

Once the Kafka broker is running, start your Spring Boot application:

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

* The server runs locally at: `http://localhost:9191`

---

## 🧪 Testing APIs using Swagger Editor

You can test and visualize the API using **Swagger Editor**:

1. Open **[Swagger Editor](https://editor.swagger.io/)** in your browser.
2. From the top menu, select **File** ➔ **Import file**.
3. Upload the project's API definition file:
   ```text
   Swagger_UI_API.json
   ```
4. Explore and test the available tags:
   * **`order-controller`**: Send single or multiple events (`count`) with or without message keys (`orderId`).
   * **`order-events-controller`**: Test event handling and processing logic.
5. Click **Try it out**, fill in parameters (e.g., `orderId`, `count`), and press **Execute**.

---

## 📌 Main API Endpoints

| Tag | Method | Endpoint | Description |
| :--- | :--- | :--- | :--- |
| `order-controller` | `POST` | `/demo/no-key` | Send order events without a key, specifying `orderId` and number of messages (`count`). |
| `order-controller` | `POST` | `/demo/with-key` | Send order events with a key (`orderId`) and number of messages (`count`). |
| `order-events-controller` | `POST` | `/order-events/process` | Process order events without key routing. |
| `order-events-controller` | `POST` | `/order-events/processWithKey` | Process order events using key routing. |

---

## 📝 Prerequisites
* Ensure the Spring Boot backend (`http://localhost:9191`) is running locally when executing requests from Swagger Editor.
