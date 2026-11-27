extends TestCase
## Checks that the project scaffold is wired up. No game rules are tested
## here because none exist yet.

const FOLDERS: PackedStringArray = ["boot", "sim", "view", "ui", "data", "parties", "tests"]


func test_project_name() -> void:
	check_eq(ProjectSettings.get_setting("application/config/name"), "War Within Us", "project name")


func test_landscape_orientation() -> void:
	check_eq(
		ProjectSettings.get_setting("display/window/handheld/orientation"),
		DisplayServer.SCREEN_SENSOR_LANDSCAPE,
		"handheld orientation",
	)


func test_folders_exist() -> void:
	for folder in FOLDERS:
		check(DirAccess.dir_exists_absolute("res://" + folder), "missing folder res://" + folder)


func test_main_scene_loads() -> void:
	var path: String = ProjectSettings.get_setting("application/run/main_scene")
	var scene: PackedScene = load(path)
	check(scene != null, "main scene did not load: " + path)
	if scene != null:
		var root := scene.instantiate()
		check(root is Control, "main scene root should be a Control")
		root.free()
