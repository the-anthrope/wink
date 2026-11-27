# tests

Headless tests. Run them from the repo root:

    tools/test.sh

How to add a test:

1. Create `test_<subject>.gd` in this folder or a subfolder.
2. Start it with `extends TestCase`.
3. Add methods named `test_...`. Use `check(condition, message)` and
   `check_eq(actual, expected, message)`.

`run_tests.gd` finds the files and exits non-zero if any check fails.
