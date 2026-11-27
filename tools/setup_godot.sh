#!/usr/bin/env bash
# Downloads the pinned Godot editor binary for Linux into .tools/godot.
# Pass --templates to also install the export templates (about 1.3 GB),
# which are needed for tools/build_android.sh.
set -euo pipefail
source "$(dirname "$0")/env.sh"

base="https://downloads.godotengine.org/?version=${GODOT_VERSION}&flavor=stable"

mkdir -p "$TOOLS_DIR/godot"
if [ ! -x "$GODOT" ]; then
  echo "Downloading Godot $GODOT_VERSION..."
  curl -fsSL --retry 3 -o "$TOOLS_DIR/godot/godot.zip" "${base}&slug=linux.x86_64.zip&platform=linux.64"
  unzip -oq "$TOOLS_DIR/godot/godot.zip" -d "$TOOLS_DIR/godot"
  rm "$TOOLS_DIR/godot/godot.zip"
fi
"$GODOT" --headless --version

if [ "${1:-}" = "--templates" ]; then
  templates_dir="$HOME/.local/share/godot/export_templates/${GODOT_VERSION}.stable"
  if [ ! -f "$templates_dir/version.txt" ]; then
    echo "Downloading export templates..."
    curl -fsSL --retry 3 -o "$TOOLS_DIR/godot/templates.tpz" "${base}&slug=export_templates.tpz&platform=templates"
    mkdir -p "$templates_dir"
    unzip -oq "$TOOLS_DIR/godot/templates.tpz" -d "$TOOLS_DIR/godot/templates_tmp"
    mv "$TOOLS_DIR/godot/templates_tmp/templates/"* "$templates_dir/"
    rm -r "$TOOLS_DIR/godot/templates_tmp" "$TOOLS_DIR/godot/templates.tpz"
  fi
  echo "Export templates: $(cat "$templates_dir/version.txt")"
fi
