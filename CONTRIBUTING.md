# Contributing to Quick Walker

Thank you for considering contributing to Quick Walker! This document provides guidelines and instructions for contributing to this project.

## Development Setup

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Git
- IntelliJ IDEA (recommended) or another Java IDE

### Setting Up the Development Environment

1. Fork the repository on GitHub
2. Clone your fork locally:
   ```
   git clone https://github.com/YOUR-USERNAME/QuickWalker.git
   cd QuickWalker
   ```
3. Set up the upstream remote:
   ```
   git remote add upstream https://github.com/GrixisTV/QuickWalker.git
   ```

### Building the Project

```
# Windows
.\gradlew clean build -x checkstyleMain -x checkstyleTest

# macOS/Linux
./gradlew clean build -x checkstyleMain -x checkstyleTest
```

## Code Style Guidelines

- Follow the existing code style in the project
- Use 4 spaces for indentation
- Keep lines under 100 characters when possible
- Use meaningful variable and method names
- Add comments for complex logic
- Follow RuneLite's plugin development conventions

## Pull Request Process

1. Create a new branch for your feature or bugfix:
   ```
   git checkout -b feature/your-feature-name
   ```
   or
   ```
   git checkout -b fix/issue-you-are-fixing
   ```

2. Make your changes, commit them with descriptive commit messages:
   ```
   git commit -m "Add feature: description of what you added"
   ```

3. Push your branch to your fork:
   ```
   git push origin feature/your-feature-name
   ```

4. Open a Pull Request (PR) against the main repository's `main` branch

5. Describe what your PR does, reference any related issues

6. Wait for review and address any feedback

## Testing

Before submitting a PR, please test your changes thoroughly:

1. Build the plugin and install it in your RuneLite client
2. Test all functionality related to your changes
3. Ensure there are no exceptions or errors in the RuneLite console

## RuneLite API Compatibility

- The plugin must be compatible with the latest RuneLite client
- Use the RuneLite API appropriately and follow best practices
- Check the [RuneLite Wiki](https://github.com/runelite/runelite/wiki) for development guidelines

## Reporting Issues

If you find a bug or have a suggestion:

1. Check if the issue already exists in the [GitHub Issues](https://github.com/GrixisTV/QuickWalker/issues)
2. If not, create a new issue with:
   - A clear title and description
   - Steps to reproduce the issue
   - Expected behavior
   - Screenshots if applicable
   - Any relevant logs or error messages

## License

By contributing to this project, you agree that your contributions will be licensed under the project's BSD 2-Clause License.

