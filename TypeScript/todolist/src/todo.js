function addTask() {
    var taskToAdd = document.getElementById('todoInput');
    if (taskToAdd) {
        if (taskToAdd.value === "") {
            alert("Please Enter Task Name");
        }
        else {
            addTaskToList(taskToAdd.value);
            taskToAdd.value = '';
        }
    }
    else {
        //console.log("null");
        alert("no id exist");
    }
}
function addTaskToList(task) {
    var todoList = document.getElementById('todoList');
    if (todoList) {
        // Remove "No Task In Your List" message
        var noTaskRow = document.getElementById('noTaskRow');
        if (noTaskRow) {
            noTaskRow.remove();
        }
        // Create a new row for the task
        var taskRow_1 = document.createElement('tr');
        // Task name cell
        var taskCell = document.createElement('td');
        taskCell.textContent = task;
        // Action cell with delete button
        var actionCell = document.createElement('td');
        var deleteTaskButton = document.createElement('button');
        deleteTaskButton.textContent = "Delete";
        // Delete task functionality
        deleteTaskButton.onclick = function () {
            todoList.removeChild(taskRow_1);
            // If no tasks remain, show "No Task In Your List" message
            if (!todoList.hasChildNodes()) {
                var noTaskRow_1 = document.createElement('tr');
                noTaskRow_1.id = 'noTaskRow';
                var noTaskCell = document.createElement('td');
                noTaskCell.colSpan = 2;
                noTaskCell.textContent = "No Task In Your List";
                noTaskRow_1.appendChild(noTaskCell);
                todoList.appendChild(noTaskRow_1);
            }
        };
        // Append the button to the action cell
        actionCell.appendChild(deleteTaskButton);
        // Add the cells to the row
        taskRow_1.appendChild(taskCell);
        taskRow_1.appendChild(actionCell);
        // Add the row to the table
        todoList.appendChild(taskRow_1);
    }
}
