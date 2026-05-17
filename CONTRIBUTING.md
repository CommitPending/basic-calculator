# Contributing to Calculator Application

Thank you for your interest in contributing to the Calculator Application! This document provides guidelines and instructions for contributing.

## 📋 Table of Contents

- [Code of Conduct](#code-of-conduct)
- [Getting Started](#getting-started)
- [Development Process](#development-process)
- [Coding Standards](#coding-standards)
- [Commit Guidelines](#commit-guidelines)
- [Pull Request Process](#pull-request-process)
- [Testing Guidelines](#testing-guidelines)

## 📜 Code of Conduct

### Our Pledge

We are committed to providing a welcoming and inspiring community for all. Please be respectful and constructive in your interactions.

### Expected Behavior

- Use welcoming and inclusive language
- Be respectful of differing viewpoints
- Accept constructive criticism gracefully
- Focus on what is best for the community

## 🚀 Getting Started

1. **Fork the repository**
   ```bash
   git clone https://github.com/yourusername/calculator-app.git
   cd calculator-app
   ```

2. **Create a branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

3. **Set up development environment**
   - Follow the setup instructions in README.md
   - Ensure all tests pass before making changes

## 💻 Development Process

### Backend Development

1. Make changes in `backend/src/main/java/com/calculator/`
2. Add tests in `backend/src/test/java/com/calculator/`
3. Run tests: `mvn test`
4. Build: `mvn clean package`

### Frontend Development

1. Make changes in `frontend/src/app/`
2. Add tests in corresponding `.spec.ts` files
3. Run tests: `npm test`
4. Build: `npm run build:prod`

## 📝 Coding Standards

### Java (Backend)

- Follow [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- Use meaningful variable and method names
- Add JavaDoc comments for public methods
- Keep methods small and focused
- Use Lombok annotations where appropriate

Example:
```java
/**
 * Performs addition of two numbers.
 *
 * @param a the first operand
 * @param b the second operand
 * @return the sum of a and b
 */
public Double add(Double a, Double b) {
    logger.info("Performing addition: {} + {}", a, b);
    return a + b;
}
```

### TypeScript (Frontend)

- Follow [Angular Style Guide](https://angular.io/guide/styleguide)
- Use TypeScript strict mode
- Add JSDoc comments for complex functions
- Use meaningful component and service names
- Follow reactive programming patterns with RxJS

Example:
```typescript
/**
 * Performs calculation using the calculator service.
 * @param operation The operation to perform
 */
performCalculation(operation: string): void {
  this.calculatorService.add(this.a, this.b)
    .subscribe({
      next: (response) => this.handleSuccess(response),
      error: (error) => this.handleError(error)
    });
}
```

### SCSS (Styling)

- Use BEM naming convention
- Keep selectors specific but not overly nested
- Use variables for colors and common values
- Mobile-first responsive design

## 📦 Commit Guidelines

We follow [Conventional Commits](https://www.conventionalcommits.org/) specification.

### Commit Message Format

```
<type>(<scope>): <subject>

<body>

<footer>
```

### Types

- `feat`: New feature
- `fix`: Bug fix
- `docs`: Documentation changes
- `style`: Code style changes (formatting, etc.)
- `refactor`: Code refactoring
- `test`: Adding or updating tests
- `chore`: Maintenance tasks

### Examples

```bash
feat(calculator): add scientific calculator functions

- Added sin, cos, tan operations
- Updated UI to include scientific mode toggle
- Added tests for new operations

Closes #123
```

```bash
fix(backend): resolve division by zero error handling

Previously, division by zero returned 500 error.
Now returns proper 400 error with descriptive message.

Fixes #456
```

## 🔄 Pull Request Process

1. **Update documentation**
   - Update README.md if needed
   - Add/update API documentation
   - Update CHANGELOG.md

2. **Ensure tests pass**
   ```bash
   # Backend
   cd backend && mvn test
   
   # Frontend
   cd frontend && npm test
   ```

3. **Create Pull Request**
   - Use a clear, descriptive title
   - Reference related issues
   - Provide detailed description of changes
   - Add screenshots for UI changes

4. **PR Template**
   ```markdown
   ## Description
   Brief description of changes
   
   ## Type of Change
   - [ ] Bug fix
   - [ ] New feature
   - [ ] Breaking change
   - [ ] Documentation update
   
   ## Testing
   - [ ] Unit tests pass
   - [ ] Integration tests pass
   - [ ] Manual testing completed
   
   ## Screenshots (if applicable)
   
   ## Related Issues
   Closes #issue_number
   ```

5. **Code Review**
   - Address reviewer feedback
   - Keep discussions professional
   - Make requested changes promptly

## 🧪 Testing Guidelines

### Backend Tests

- Write unit tests for all service methods
- Write integration tests for controllers
- Test error scenarios
- Aim for >80% code coverage

```java
@Test
void testDivisionByZeroThrowsException() {
    assertThrows(DivisionByZeroException.class, () -> {
        calculatorService.divide(10.0, 0.0);
    });
}
```

### Frontend Tests

- Write unit tests for components
- Test service methods
- Test user interactions
- Mock HTTP calls

```typescript
it('should handle error from service', () => {
  spyOn(calculatorService, 'divide').and.returnValue(
    throwError(() => new Error('Cannot divide by zero'))
  );
  
  component.performOperation('/');
  
  expect(component.errorMessage).toBe('Cannot divide by zero');
});
```

## 🐛 Reporting Bugs

When reporting bugs, include:

1. **Description**: Clear description of the bug
2. **Steps to Reproduce**: Detailed steps
3. **Expected Behavior**: What should happen
4. **Actual Behavior**: What actually happens
5. **Environment**: OS, browser, versions
6. **Screenshots**: If applicable
7. **Logs**: Relevant error logs

## 💡 Suggesting Features

When suggesting features, include:

1. **Use Case**: Why is this feature needed?
2. **Proposed Solution**: How should it work?
3. **Alternatives**: Other approaches considered
4. **Additional Context**: Screenshots, mockups, etc.

## 📞 Questions?

- Open an issue for questions
- Join our community discussions
- Email: dev@calculator-app.com

## 🙏 Thank You!

Your contributions make this project better. We appreciate your time and effort!
