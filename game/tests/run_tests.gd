extends SceneTree
## Headless test runner.
##
## Run with: godot --headless --path game --script res://tests/run_tests.gd
## Finds every res://tests/**/test_*.gd, calls each `test_` method on a fresh
## instance, prints a summary and exits with 1 if anything failed.

const TEST_ROOT := "res://tests"


func _init() -> void:
	var files := _find_test_files(TEST_ROOT)
	files.sort()
	var ran := 0
	var failed := 0
	for path in files:
		var script: GDScript = load(path)
		if script == null:
			printerr("FAIL  %s: could not load" % path)
			failed += 1
			continue
		for method in script.get_script_method_list():
			var method_name: String = method["name"]
			if not method_name.begins_with("test_"):
				continue
			var case: TestCase = script.new()
			case.call(method_name)
			ran += 1
			if case.failures.is_empty():
				print("ok    %s::%s (%d checks)" % [path.get_file(), method_name, case.checks])
			else:
				failed += 1
				for message in case.failures:
					printerr("FAIL  %s::%s: %s" % [path.get_file(), method_name, message])
	print("%d tests, %d failed" % [ran, failed])
	if ran == 0:
		printerr("FAIL  no tests found under %s" % TEST_ROOT)
		failed += 1
	quit(1 if failed > 0 else 0)


func _find_test_files(dir_path: String) -> PackedStringArray:
	var found: PackedStringArray = []
	var dir := DirAccess.open(dir_path)
	if dir == null:
		return found
	for sub in dir.get_directories():
		found.append_array(_find_test_files(dir_path.path_join(sub)))
	for file in dir.get_files():
		if file.begins_with("test_") and file.ends_with(".gd") and file != "test_case.gd":
			found.append(dir_path.path_join(file))
	return found
