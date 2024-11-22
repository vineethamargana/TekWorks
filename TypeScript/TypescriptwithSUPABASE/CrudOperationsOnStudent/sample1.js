"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g = Object.create((typeof Iterator === "function" ? Iterator : Object).prototype);
    return g.next = verb(0), g["throw"] = verb(1), g["return"] = verb(2), typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (g && (g = 0, op[0] && (_ = 0)), _) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
Object.defineProperty(exports, "__esModule", { value: true });
var supabase_js_1 = require("@supabase/supabase-js");
var readline = require("readline");
var supabaseUrl = 'https://ekkjrwomdgvcjhlwnheg.supabase.co';
var supabaseKey = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImVra2pyd29tZGd2Y2pobHduaGVnIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzIxODAwMTEsImV4cCI6MjA0Nzc1NjAxMX0.hQzQSbn8Dat7hg-sxDltq35xmqoyIKdyImPRLzu7NGU';
var supabase = (0, supabase_js_1.createClient)(supabaseUrl, supabaseKey);
var read = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
function insertStudent(student) {
    return __awaiter(this, void 0, void 0, function () {
        var _a, data, error;
        return __generator(this, function (_b) {
            switch (_b.label) {
                case 0: return [4 /*yield*/, supabase
                        .from('student')
                        .insert(student)
                        .select('*')];
                case 1:
                    _a = _b.sent(), data = _a.data, error = _a.error;
                    if (error) {
                        console.log("Student not inserted", error.details);
                    }
                    else {
                        console.log("Student inserted Succesfully", data);
                    }
                    return [2 /*return*/];
            }
        });
    });
}
function deleteStudent(stu) {
    return __awaiter(this, void 0, void 0, function () {
        var _a, data, error;
        return __generator(this, function (_b) {
            switch (_b.label) {
                case 0: return [4 /*yield*/, supabase
                        .from('student')
                        .delete()
                        .eq('stuid', stu)
                        .select('*')];
                case 1:
                    _a = _b.sent(), data = _a.data, error = _a.error;
                    if (error) {
                        console.log("Student not Deleted", error.details);
                    }
                    else {
                        console.log("Student Deleted Succesfully", data);
                    }
                    return [2 /*return*/];
            }
        });
    });
}
function updateStudent(student) {
    return __awaiter(this, void 0, void 0, function () {
        var _a, data, error;
        return __generator(this, function (_b) {
            switch (_b.label) {
                case 0: return [4 /*yield*/, supabase
                        .from('student')
                        .update(student)
                        .eq('stuid', student.stuid)
                        .select('*')];
                case 1:
                    _a = _b.sent(), data = _a.data, error = _a.error;
                    if (error) {
                        console.log("Student not updated", error.details);
                    }
                    else {
                        console.log("Student updated Succesfully", data);
                    }
                    return [2 /*return*/];
            }
        });
    });
}
function showStudent() {
    return __awaiter(this, void 0, void 0, function () {
        var _a, data, error;
        return __generator(this, function (_b) {
            switch (_b.label) {
                case 0: return [4 /*yield*/, supabase
                        .from('student')
                        .select('*')];
                case 1:
                    _a = _b.sent(), data = _a.data, error = _a.error;
                    if (error) {
                        console.log("Empty list", error.details);
                    }
                    else {
                        console.log("list of students", data);
                    }
                    return [2 /*return*/];
            }
        });
    });
}
function showOnlyStudent(stu) {
    return __awaiter(this, void 0, void 0, function () {
        var _a, data, error;
        return __generator(this, function (_b) {
            switch (_b.label) {
                case 0: return [4 /*yield*/, supabase
                        .from('student')
                        .select()
                        .eq('stuid', stu)];
                case 1:
                    _a = _b.sent(), data = _a.data, error = _a.error;
                    if (error) {
                        console.log("Student not found", error.details);
                    }
                    else {
                        console.log("Student List is", data);
                    }
                    return [2 /*return*/];
            }
        });
    });
}
var stu = 4;
var student = {
    stuid: 2,
    stuname: 'mee',
    stucls: 1
};
function handlecrudOpertions(operations) {
    return __awaiter(this, void 0, void 0, function () {
        var exit, _a;
        return __generator(this, function (_b) {
            switch (_b.label) {
                case 0:
                    exit = false;
                    _b.label = 1;
                case 1:
                    if (!!exit) return [3 /*break*/, 15];
                    read.question('Enter operation (insert, select, update, delete): ', function (operation) {
                        handlecrudOpertions(operation);
                    });
                    _a = operations;
                    switch (_a) {
                        case 'insert': return [3 /*break*/, 2];
                        case 'update': return [3 /*break*/, 4];
                        case 'delete': return [3 /*break*/, 6];
                        case 'showallstudents': return [3 /*break*/, 8];
                        case 'showstudentsbased on id': return [3 /*break*/, 10];
                        case 'exit': return [3 /*break*/, 12];
                    }
                    return [3 /*break*/, 13];
                case 2: return [4 /*yield*/, insertStudent(student)];
                case 3:
                    _b.sent();
                    return [3 /*break*/, 14];
                case 4: return [4 /*yield*/, updateStudent(student)];
                case 5:
                    _b.sent();
                    return [3 /*break*/, 14];
                case 6: return [4 /*yield*/, deleteStudent(stu)];
                case 7:
                    _b.sent();
                    return [3 /*break*/, 14];
                case 8: return [4 /*yield*/, showStudent()];
                case 9:
                    _b.sent();
                    return [3 /*break*/, 14];
                case 10: return [4 /*yield*/, showOnlyStudent(stu)];
                case 11:
                    _b.sent();
                    return [3 /*break*/, 14];
                case 12:
                    exit = true;
                    console.log("exiting the system");
                    _b.label = 13;
                case 13:
                    console.log('invalid input');
                    _b.label = 14;
                case 14: return [3 /*break*/, 1];
                case 15: return [2 /*return*/];
            }
        });
    });
}
