#!/usr/bin/env bash
# Runs the headless test suite. Exits non-zero if any test fails.
set -euo pipefail
source "$(dirname "$0")/env.sh"
require_godot

# The first run builds the import cache and the class-name registry.
"$GODOT" --headless --path "$GAME_DIR" --import >/dev/null 2>&1 || true
"$GODOT" --headless --path "$GAME_DIR" --script res://tests/run_tests.gd
