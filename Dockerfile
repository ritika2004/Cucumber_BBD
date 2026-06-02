FROM maven:3.9.9-eclipse-temurin-25

# Install Chrome dependencies
RUN apt-get update && apt-get install -y \
    wget \
    curl \
    unzip \
    gnupg \
    ca-certificates

# Install Google Chrome
RUN curl -fsSL https://dl.google.com/linux/linux_signing_key.pub | gpg --dearmor -o /usr/share/keyrings/google.gpg && \
    echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google.gpg] http://dl.google.com/linux/chrome/deb/ stable main" \
    > /etc/apt/sources.list.d/google.list && \
    apt-get update && apt-get install -y google-chrome-stable

WORKDIR /app

COPY . .

RUN mvn clean compile

CMD ["mvn", "clean", "test", "-Dtest=Runner.RunCucumberTest"]