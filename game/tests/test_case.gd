class_name TestCase
extends RefCounted
## Base class for tests. A test file extends this and defines methods whose
## names start with `test_`. The runner in run_tests.gd calls each one.

var failures: PackedStringArray = []
var checks: int = 0


func check(condition: bool, message: String) -> void:
	checks += 1
	if not condition:
		failures.append(message)


func check_eq(actual: Variant, expected: Variant, message: String) -> void:
	checks += 1
	if actual != expected:
		failures.append("%s: expected %s, got %s" % [message, str(expected), str(actual)])
