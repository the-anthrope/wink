#!/usr/bin/env bash
# Installs what Godot needs to export an Android APK: the Android SDK
# command-line tools, platform-tools, one platform and one build-tools
# version. Everything lands in .tools/. Needs a JDK 17 or newer on PATH.
# The platform and build-tools versions match the target SDK of the pinned
# Godot export templates (36).
set -euo pipefail
source "$(dirname "$0")/env.sh"

CMDLINE_TOOLS_ZIP="commandlinetools-linux-16111833_latest.zip"
ANDROID_PLATFORM="platforms;android-36"
ANDROID_BUILD_TOOLS="build-tools;36.0.0"

command -v java >/dev/null || { echo "A JDK is required on PATH." >&2; exit 1; }

sdkmanager="$ANDROID_HOME/cmdline-tools/latest/bin/sdkmanager"
if [ ! -x "$sdkmanager" ]; then
  echo "Downloading Android command-line tools..."
  mkdir -p "$ANDROID_HOME/cmdline-tools"
  curl -fsSL --retry 3 -o "$TOOLS_DIR/cmdline-tools.zip" \
    "https://dl.google.com/android/repository/$CMDLINE_TOOLS_ZIP"
  unzip -oq "$TOOLS_DIR/cmdline-tools.zip" -d "$ANDROID_HOME/cmdline-tools"
  rm -rf "$ANDROID_HOME/cmdline-tools/latest"
  mv "$ANDROID_HOME/cmdline-tools/cmdline-tools" "$ANDROID_HOME/cmdline-tools/latest"
  rm "$TOOLS_DIR/cmdline-tools.zip"
fi

yes | "$sdkmanager" --licenses >/dev/null || true
"$sdkmanager" "platform-tools" "$ANDROID_PLATFORM" "$ANDROID_BUILD_TOOLS"

echo "Android SDK ready at $ANDROID_HOME"
