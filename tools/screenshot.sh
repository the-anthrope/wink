#!/usr/bin/env bash
# Renders the game without a GPU and saves one PNG, for checking pictures
# on a machine with no display. Usage: tools/screenshot.sh [out.png] [frames]
# Uses a software Vulkan driver (lavapipe) under a virtual display, so the
# Mobile renderer draws the same picture a phone would, only slower.
set -euo pipefail
source "$(dirname "$0")/env.sh"
require_godot

out="${1:-$BUILD_DIR/screenshots/boot.png}"
frames="${2:-10}"
mkdir -p "$(dirname "$out")"
work="$(mktemp -d)"
trap 'rm -rf "$work"' EXIT

if [ -z "${VK_ICD_FILENAMES:-}" ] && [ -f /opt/lavapipe/lvp_icd.json ]; then
  export VK_ICD_FILENAMES=/opt/lavapipe/lvp_icd.json
fi

xvfb-run -a -s "-screen 0 1280x720x24" \
  "$GODOT" --path "$GAME_DIR" --rendering-method mobile --rendering-driver vulkan \
  --resolution 1280x720 --fixed-fps 30 --write-movie "$work/frame.png" --quit-after "$frames" \
  >"$work/log.txt" 2>&1 || { cat "$work/log.txt" >&2; exit 1; }

last="$(ls "$work"/frame*.png | sort | tail -1)"
cp "$last" "$out"
echo "Wrote $out"
