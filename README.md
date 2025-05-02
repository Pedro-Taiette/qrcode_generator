# 🧩 QR Code Generator

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.4-brightgreen)
![AWS SDK](https://img.shields.io/badge/AWS%20SDK-2.24.12-yellow)
![ZXing](https://img.shields.io/badge/ZXing-3.5.2-blue)
![Docker](https://img.shields.io/badge/Docker-enabled-blue)
![Maven](https://img.shields.io/badge/Maven-3.9.6-red)

Projeto Java com Spring Boot para criação de QR Codes, com envio automático das imagens para um bucket S3 na AWS. A biblioteca ZXing é usada na geração dos códigos.

---

## 📦 Requisitos

Antes de rodar, verifique se você possui:

- Java 21
- Maven
- Docker
- Conta AWS com permissão no S3
- AWS CLI configurado (com credenciais salvas)

---

## 🔐 Configuração

Crie um arquivo `.env` na raiz do projeto com:

```env
AWS_ACCESS_KEY_ID=exemplo_de_chave
AWS_SECRET_ACCESS_KEY=exemplo_de_segredo
AWS_REGION=us-east-1
AWS_BUCKET_NAME=meu-bucket-qrcodes
```

---

## ▶️ Execução

### Localmente

```bash
mvn clean install
mvn spring-boot:run
```

### Com Docker

```bash
docker build -t qrcode-app .
docker run --env-file .env -p 8080:8080 qrcode-app
```

---

## 📮 API

### POST `/qrcode`

Gera um QR code com base no texto enviado e retorna a URL pública da imagem hospedada no S3.

**JSON de entrada:**

```json
{
  "text": "https://meusite.com"
}
```

**Resposta esperada:**

```json
{
  "url": "https://meu-bucket.s3.us-east-1.amazonaws.com/uuid.png"
}
```

---

## 📃 Licença

Distribuído sob a licença MIT.
