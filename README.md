# Entity AI - Self-Learning Android App

An advanced Android application that implements on-device AI learning capabilities with secure cloud synchronization.

## Features

- On-device AI processing using ML Kit
- Secure cloud synchronization with Firebase and AWS
- Modern UI using Jetpack Compose
- Automated builds with GitHub Actions

## Setup Instructions

### 1. Firebase Setup

1. Create a Firebase Project:
   - Go to [Firebase Console](https://console.firebase.google.com/)
   - Click "Add project"
   - Name it "Entity AI"
   - Follow the setup wizard

2. Add Android App to Firebase:
   - In Firebase Console, click Android icon (</>)
   - Package name: `com.entity.ai`
   - App nickname: "Entity AI"
   - Click "Register app"

3. Download Configuration:
   - Download `google-services.json`
   - Place it in the `app` directory

4. Enable Firebase Services:
   - Go to Firebase Console > Authentication
   - Enable Email/Password authentication
   - Go to Firestore Database
   - Create database in test mode
   - Set up security rules

### 2. AWS Setup

1. Create AWS Cognito Identity Pool:
   - Go to AWS Console > Cognito
   - Create new Identity Pool
   - Note down the Identity Pool ID
   - Update `CloudSyncService.kt` with your ID

2. Create S3 Bucket:
   - Go to AWS Console > S3
   - Create new bucket
   - Note down the bucket name
   - Update `CloudSyncService.kt` with your bucket name

### 3. GitHub Setup

1. Create a new repository on GitHub
2. Upload all project files maintaining the directory structure
3. The GitHub Actions workflow will automatically build the APK

### 4. Project Structure

```
EntityAI/
├── .github/
│   └── workflows/
│       └── build.yml
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/
│   │       │       └── entity/
│   │       │           └── ai/
│   │       │               ├── MainActivity.kt
│   │       │               ├── MainViewModel.kt
│   │       │               ├── AIProcessor.kt
│   │       │               └── CloudSyncService.kt
│   │       └── AndroidManifest.xml
│   ├── build.gradle
│   └── google-services.json
├── build.gradle
└── README.md
```

## Security

- All cloud sync operations are authenticated
- Data is encrypted in transit
- On-device processing ensures privacy
- Firebase Authentication for user management
- AWS Cognito for secure access

## Building the App

The app is automatically built using GitHub Actions. To build locally:

1. Clone the repository
2. Place `google-services.json` in the `app` directory
3. Run `./gradlew assembleDebug`

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details. 