function Cell(i, j, width) {
	this.x = i;
	this.y = j;
	this.width = width;
	this.right = true;
	this.left = true;
	this.up = true;
	this.down = true;
	this.visited = false;
	this.selected = false;

	this.show = function() {
		var x = this.x * this.width;
		var y = this.y * this.width;
		var w = this.width;

		noStroke();
		if (this.visited) {
			fill(100);
			if (getIndex(this.x, this.y) == grid.length - 1) {
				fill(200, 0, 0);
			} else if (getIndex(this.x, this.y) == 0) {
				fill(0, 200, 0);
			}
		}
		rect(x, y, w, w);

		stroke(0);
		if (this.up) {
			line(x, y, x + w, y);
		}
		if (this.down) {
			line(x, y + w, x + w, y + w);
		}
		if (this.right) {
			line(x + w, y, x + w, y + w);
		}
		if (this.left) {
			line(x, y, x, y + w);
		}
	}

	this.select = function() {
		var x = this.x * this.width;
		var y = this.y * this.width;
		var w = this.width;
		noStroke();
		fill(200, 0, 200);
		rect(x, y, w, w);
	}

	this.surrounding = function(grid) {
		if (getIndex(this.x, this.y) == grid.length - 1) {
			return null;
		}
		var unchecked = [];
		var first = grid[getIndex(this.x - 1, this.y)];
		var second = grid[getIndex(this.x + 1, this.y)];
		var third = grid[getIndex(this.x, this.y - 1)];
		var fourth = grid[getIndex(this.x, this.y + 1)];
		if (first && !first.visited) {
			unchecked.push(first);
		}
		if (second && !second.visited) {
			unchecked.push(second);
		}
		if (third && !third.visited) {
			unchecked.push(third);
		}
		if (fourth && !fourth.visited) {
			unchecked.push(fourth);
		}
		if (unchecked.length > 0) {
			var index = floor(random(0, unchecked.length));
			return unchecked[index];
		} else {
			return null;
		}
	}

}