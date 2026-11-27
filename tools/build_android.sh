#!/usr/bin/env bash
# Exports a debug APK to build/sinews-of-war-debug.apk.
# Run tools/setup_godot.sh --templates and tools/setup_android.sh first.
set -euo pipefail
source "$(dirname "$0")/env.sh"
require_godot

java_home="${JAVA_HOME:-$(dirname "$(dirname "$(readlink -f "$(command -v java)")")")}"
keystore="$DEBUG_KEYSTORE"
[ -d "$ANDROID_HOME/build-tools" ] || { echo "Android SDK missing. Run tools/setup_android.sh." >&2; exit 1; }
[ -f "$keystore" ] || { echo "Debug keystore missing at $keystore." >&2; exit 1; }

# Godot reads the SDK and JDK locations from its editor settings, which
# live outside the project. Create them on first use, then point them here.
settings="$HOME/.config/godot/editor_settings-${GODOT_VERSION%.*}.tres"
if [ ! -f "$settings" ]; then
  "$GODOT" --headless --path "$GAME_DIR" --import >/dev/null 2>&1 || true
fi
set_setting() {
  local key="$1" value="$2"
  if grep -q "^$key = " "$settings"; then
    sed -i "s|^$key = .*|$key = \"$value\"|" "$settings"
  else
    sed -i "/^\[resource\]/a $key = \"$value\"" "$settings"
  fi
}
set_setting "export/android/android_sdk_path" "$ANDROID_HOME"
set_setting "export/android/java_sdk_path" "$java_home"

export GODOT_ANDROID_KEYSTORE_DEBUG_PATH="$keystore"
export GODOT_ANDROID_KEYSTORE_DEBUG_USER="androiddebugkey"
export GODOT_ANDROID_KEYSTORE_DEBUG_PASSWORD="android"

mkdir -p "$BUILD_DIR"
apk="$BUILD_DIR/sinews-of-war-debug.apk"
rm -f "$apk"
"$GODOT" --headless --path "$GAME_DIR" --export-debug "Android" "$apk"
[ -f "$apk" ] || { echo "Export finished without producing an APK." >&2; exit 1; }
echo "Wrote $apk ($(du -h "$apk" | cut -f1))"
