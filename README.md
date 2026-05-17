# Calculator Application

A modern, full-stack calculator application with an Angular frontend and Java 23 Spring Boot backend. Features a beautiful, responsive UI with dark/light mode toggle, keyboard support, and comprehensive error handling.

![Calculator App](https://img.shields.io/badge/version-1.0.0-blue.svg)
![Java](https://img.shields.io/badge/Java-23-orange.svg)
![Angular](https://img.shields.io/badge/Angular-17-red.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-green.svg)

## 🚀 Features

### Frontend
- **Modern Angular UI** with responsive design
- **Dark/Light mode toggle** for user preference
- **Keyboard input support** for efficient calculations
- **Real-time error handling** (division by zero, invalid inputs)
- **Beautiful gradient display** with smooth animations
- **Mobile-friendly** responsive layout

### Backend
- **Java 23** with Spring Boot 3.2.5
- **RESTful API** architecture
- **Comprehensive validation** and exception handling
- **Unit tests** with JUnit
- **Logging support** with SLF4J
- **Production-ready** configuration

### Operations Supported
- ➕ Addition
- ➖ Subtraction
- ✖️ Multiplication
- ➗ Division
- 🔢 Decimal numbers
- ⌫ Backspace/Clear functions

## 📋 Table of Contents

- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Quick Start](#quick-start)
- [Development Setup](#development-setup)
- [Running Tests](#running-tests)
- [Docker Deployment](#docker-deployment)
- [Windows Installer](#windows-installer)
- [API Documentation](#api-documentation)
- [CI/CD Pipeline](#cicd-pipeline)
- [Keyboard Shortcuts](#keyboard-shortcuts)
- [Contributing](#contributing)
- [License](#license)

## 📦 Prerequisites

### Required
- **Java 23** or higher ([Download](https://adoptium.net/))
- **Maven 3.8+** ([Download](https://maven.apache.org/download.cgi))
- **Node.js 20+** and npm ([Download](https://nodejs.org/))
- **Git** ([Download](https://git-scm.com/))

### Optional
- **Docker** and Docker Compose (for containerized deployment)
- **Inno Setup** (for building Windows installer)

## 🏗️ Project Structure

```
calculator-app/
│
├── backend/                      # Java Spring Boot backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/calculator/
│   │   │   │   ├── CalculatorApplication.java
│   │   │   │   ├── controller/
│   │   │   │   │   └── CalculatorController.java
│   │   │   │   ├── service/
│   │   │   │   │   └── CalculatorService.java
│   │   │   │   ├── dto/
│   │   │   │   │   ├── CalculationRequest.java
│   │   │   │   │   ├── CalculationResponse.java
│   │   │   │   │   └── ErrorResponse.java
│   │   │   │   └── exception/
│   │   │   │       ├── DivisionByZeroException.java
│   │   │   │       └── GlobalExceptionHandler.java
│   │   │   └── resources/
│   │   │       ├── application.yml
│   │   │       └── application-prod.yml
│   │   └── test/
│   │       └── java/com/calculator/
│   │           ├── service/
│   │           │   └── CalculatorServiceTest.java
│   │           └── controller/
│   │               └── CalculatorControllerTest.java
│   ├── pom.xml
│   └── Dockerfile
│
├── frontend/                     # Angular frontend
│   ├── src/
│   │   ├── app/
│   │   │   ├── components/
│   │   │   │   └── calculator/
│   │   │   │       ├── calculator.component.ts
│   │   │   │       ├── calculator.component.html
│   │   │   │       ├── calculator.component.scss
│   │   │   │       └── calculator.component.spec.ts
│   │   │   ├── services/
│   │   │   │   └── calculator.service.ts
│   │   │   ├── models/
│   │   │   │   └── calculation.model.ts
│   │   │   ├── app.module.ts
│   │   │   └── app.component.ts
│   │   ├── environments/
│   │   │   ├── environment.ts
│   │   │   └── environment.prod.ts
│   │   ├── index.html
│   │   ├── main.ts
│   │   └── styles.scss
│   ├── angular.json
│   ├── package.json
│   ├── Dockerfile
│   └── nginx.conf
│
├── installer/                    # Windows installer configuration
│   ├── scripts/
│   │   ├── start-calculator.bat
│   │   └── stop-calculator.bat
│   ├── setup-script.iss
│   ├── LICENSE.txt
│   └── README.txt
│
├── .github/
│   └── workflows/
│       └── build.yml             # GitHub Actions CI/CD pipeline
│
├── docker-compose.yml            # Docker Compose configuration
├── .gitignore
└── README.md
```

## 🚀 Quick Start

### Option 1: Run Locally

#### 1. Clone the repository
```bash
git clone https://github.com/yourusername/calculator-app.git
cd calculator-app
```

#### 2. Start the Backend
```bash
cd backend
mvn clean install
mvn spring-boot:run
```

The backend will start on `http://localhost:8080`

#### 3. Start the Frontend (in a new terminal)
```bash
cd frontend
npm install
npm start
```

The frontend will start on `http://localhost:4200`

#### 4. Open your browser
Navigate to `http://localhost:4200` and start calculating!

### Option 2: Run with Docker Compose

```bash
# Build and start all services
docker-compose up --build

# Access the application at http://localhost
```

## 💻 Development Setup

### Backend Development

```bash
cd backend

# Install dependencies and build
mvn clean install

# Run in development mode
mvn spring-boot:run

# Run tests
mvn test

# Package for production
mvn clean package -DskipTests
```

### Frontend Development

```bash
cd frontend

# Install dependencies
npm install

# Start development server
npm start

# Run tests
npm test

# Run tests in CI mode
npm run test:ci

# Build for production
npm run build:prod

# Lint code
npm run lint
```

## 🧪 Running Tests

### Backend Tests
```bash
cd backend
mvn test
```

Test coverage includes:
- ✅ Service layer unit tests
- ✅ Controller integration tests
- ✅ Exception handling tests
- ✅ Validation tests

### Frontend Tests
```bash
cd frontend
npm test
```

Test coverage includes:
- ✅ Component unit tests
- ✅ Service tests
- ✅ Integration tests
- ✅ UI interaction tests

## 🐳 Docker Deployment

### Build Individual Images

#### Backend
```bash
cd backend
mvn clean package -DskipTests
docker build -t calculator-backend:latest .
docker run -p 8080:8080 calculator-backend:latest
```

#### Frontend
```bash
cd frontend
npm run build:prod
docker build -t calculator-frontend:latest .
docker run -p 80:80 calculator-frontend:latest
```

### Using Docker Compose

```bash
# Start all services
docker-compose up -d

# View logs
docker-compose logs -f

# Stop all services
docker-compose down

# Rebuild and restart
docker-compose up --build -d
```

## 🪟 Windows Installer

### Prerequisites
- Inno Setup 6 ([Download](https://jrsoftware.org/isdl.php))
- Built backend JAR file
- Built frontend distribution

### Building the Installer

1. **Build the backend:**
```bash
cd backend
mvn clean package -DskipTests
```

2. **Build the frontend:**
```bash
cd frontend
npm run build:prod
```

3. **Compile the installer:**
```bash
cd installer
"C:\Program Files (x86)\Inno Setup 6\ISCC.exe" setup-script.iss
```

The installer will be created in `installer/Output/CalculatorApp-Setup-1.0.0.exe`

### Installer Features
- ✅ Automatic Java runtime detection
- ✅ Desktop shortcut creation
- ✅ Start menu integration
- ✅ Uninstall support
- ✅ Bundled JRE option (if Java not installed)

## 📚 API Documentation

### Base URL
```
http://localhost:8080/api/calculate
```

### Endpoints

#### 1. Addition
```http
POST /api/calculate/add
Content-Type: application/json

{
  "a": 10,
  "b": 5
}

Response:
{
  "result": 15.0
}
```

#### 2. Subtraction
```http
POST /api/calculate/subtract
Content-Type: application/json

{
  "a": 10,
  "b": 5
}

Response:
{
  "result": 5.0
}
```

#### 3. Multiplication
```http
POST /api/calculate/multiply
Content-Type: application/json

{
  "a": 10,
  "b": 5
}

Response:
{
  "result": 50.0
}
```

#### 4. Division
```http
POST /api/calculate/divide
Content-Type: application/json

{
  "a": 10,
  "b": 5
}

Response:
{
  "result": 2.0
}
```

#### 5. Health Check
```http
GET /api/calculate/health

Response:
"Calculator API is running"
```

### Error Response Format
```json
{
  "timestamp": "2026-05-17T15:30:00",
  "message": "Division Error",
  "details": "Cannot divide by zero"
}
```

## 🔄 CI/CD Pipeline

The project includes a comprehensive GitHub Actions workflow that:

### On Push/Pull Request
- ✅ Builds backend with Maven
- ✅ Runs backend tests
- ✅ Builds frontend with npm
- ✅ Runs frontend tests
- ✅ Performs code quality checks
- ✅ Uploads build artifacts

### On Release
- ✅ Builds Docker images
- ✅ Pushes to Docker Hub
- ✅ Creates Windows installer
- ✅ Uploads installer to GitHub Release

### Setup GitHub Secrets

For full CI/CD functionality, add these secrets to your repository:

```
DOCKER_USERNAME=your-dockerhub-username
DOCKER_PASSWORD=your-dockerhub-password
```

## ⌨️ Keyboard Shortcuts

| Key | Action |
|-----|--------|
| `0-9` | Input numbers |
| `.` | Decimal point |
| `+` | Addition |
| `-` | Subtraction |
| `*` | Multiplication |
| `/` | Division |
| `Enter` or `=` | Calculate result |
| `Escape` or `C` | Clear all |
| `Backspace` | Delete last digit |

## 🎨 Customization

### Changing API URL

Edit `frontend/src/environments/environment.ts`:
```typescript
export const environment = {
  production: false,
  apiUrl: 'http://your-api-url:8080/api/calculate'
};
```

### Changing Backend Port

Edit `backend/src/main/resources/application.yml`:
```yaml
server:
  port: 8080  # Change to your desired port
```

### Styling

Modify `frontend/src/app/components/calculator/calculator.component.scss` to customize:
- Colors
- Button styles
- Display appearance
- Animations

## 🛠️ Troubleshooting

### Backend won't start
- Ensure Java 23 is installed: `java -version`
- Check if port 8080 is available
- Review logs in `logs/calculator-backend.log`

### Frontend won't start
- Clear npm cache: `npm cache clean --force`
- Delete `node_modules` and reinstall: `rm -rf node_modules && npm install`
- Check Node.js version: `node -v` (should be 20+)

### Docker issues
- Ensure Docker is running
- Check port conflicts: `docker ps`
- View container logs: `docker-compose logs`

### Tests failing
- Ensure all dependencies are installed
- Check Java and Node.js versions
- Run tests in verbose mode for details

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/amazing-feature`
3. Commit your changes: `git commit -m 'Add amazing feature'`
4. Push to the branch: `git push origin feature/amazing-feature`
5. Open a Pull Request

### Code Style
- **Java**: Follow Google Java Style Guide
- **TypeScript**: Follow Angular style guide
- **Commits**: Use conventional commits format

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Authors

- **Calculator Team** - Initial work

## 🙏 Acknowledgments

- Spring Boot team for the excellent framework
- Angular team for the powerful frontend framework
- All contributors who help improve this project

## 📞 Support

For issues and questions:
- 🐛 [Report a bug](https://github.com/yourusername/calculator-app/issues)
- 💡 [Request a feature](https://github.com/yourusername/calculator-app/issues)
- 📧 Email: support@calculator-app.com

## 🗺️ Roadmap

Future enhancements:
- [ ] Scientific calculator functions (sin, cos, tan, etc.)
- [ ] Calculation history with persistence
- [ ] JWT authentication for API
- [ ] Multi-user support
- [ ] Themes customization
- [ ] Offline PWA support
- [ ] Mobile apps (iOS/Android)
- [ ] Auto-update mechanism

---

**Made with ❤️ by the Calculator Team**
