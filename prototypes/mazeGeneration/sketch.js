var w = 800;
var h = 600;
var tileW = 20;
var numTiles = w / tileW * h / tileW;
var grid = [];
var current;
var stack = [];
var show = false;
var finished = false;

var dropdown;

function setup() {
	createCanvas(w, h);
	createP("Show Type:");
	dropdown = createSelect();
	dropdown.changed(showType);
	dropdown.option("Live");
	dropdown.option("Static");
	showType();
}

function getIndex(i, j) {
	if (i < 0 || j < 0 || i > w / tileW - 1 || j > h / tileW - 1) {
		return -1;
	} else {
		return i * h / tileW + j;
	}
}

function draw() {
	background(0);
	for (var i = 0; i < numTiles; i++) {
		if (grid[i].visited) {
			grid[i].show();
		}
	}

	if (show == "Live" && !finished) {
		finished = createMaze();
	}

}

function createMaze() {
	current.visited = true;

	var next = current.surrounding(grid);
	if (next != null) {

		stack.push(next);

		removeWalls(current, next);

		current = next;
		current.select();

	} else if (stack.length > 0) {
		current = stack.pop();
		current.select();
	} else {
		return true;
	}
}

function showType() {
	finished = false;
	show = dropdown.value();
	grid = [];
	for (var i = 0; i < w / tileW; i++) {
		for (var j = 0; j < h / tileW; j++) {
			grid.push(new Cell(i, j, tileW));
		}
	}
	current = grid[0];
	current.visited = true;
	if (show == "Static") {
		while (!finished) {
			finished = createMaze();
		}
	}
}

function removeWalls(a, b) {
	var x = a.x - b.x;
	var y = a.y - b.y;

	if (x < 0) {
		a.right = false;
		b.left = false;
	} else if (x > 0) {
		a.left = false;
		b.right = false;
	}

	if (y < 0) {
		a.down = false;
		b.up = false;
	} else if (y > 0) {
		a.up = false;
		b.down = false;
	}
}

function keyPressed() {
	if (keyCode == 32) {
		showType();
	}
}