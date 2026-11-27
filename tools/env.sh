# Shared settings for the tools/ scripts. Source this file, do not run it.
# Everything downloaded lands in .tools/ at the repo root, which is ignored
# by git. Set GODOT to use an engine binary you already have.

GODOT_VERSION="4.7.2"
REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
TOOLS_DIR="${TOOLS_DIR:-$REPO_ROOT/.tools}"
GAME_DIR="$REPO_ROOT/game"
BUILD_DIR="$REPO_ROOT/build"
GODOT="${GODOT:-$TOOLS_DIR/godot/Godot_v${GODOT_VERSION}-stable_linux.x86_64}"
ANDROID_HOME="${ANDROID_HOME:-$TOOLS_DIR/android-sdk}"
export ANDROID_HOME
# Debug signing key, kept in the repo on purpose so that every debug build
# from any machine carries the same signature and installs over the last
# one. It uses the standard public Android debug credentials and protects
# nothing. Release builds must use a private key that is never committed.
DEBUG_KEYSTORE="$REPO_ROOT/tools/debug.keystore"

require_godot() {
  if [ ! -x "$GODOT" ]; then
    echo "Godot $GODOT_VERSION not found at $GODOT. Run tools/setup_godot.sh first." >&2
    exit 1
  fi
}
