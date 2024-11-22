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
//import readline from "node:readline";
// Replace with your Supabase project details
var supabaseUrl = 'https://ekkjrwomdgvcjhlwnheg.supabase.co';
var supabaseKey = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImVra2pyd29tZGd2Y2pobHduaGVnIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzIxODAwMTEsImV4cCI6MjA0Nzc1NjAxMX0.hQzQSbn8Dat7hg-sxDltq35xmqoyIKdyImPRLzu7NGU';
var supabase = (0, supabase_js_1.createClient)(supabaseUrl, supabaseKey);
var rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});
// Function to handle the CRUD operations based on user input
function handleCrudOperation(operation) {
    return __awaiter(this, void 0, void 0, function () {
        var _a;
        return __generator(this, function (_b) {
            switch (_b.label) {
                case 0:
                    _a = operation;
                    switch (_a) {
                        case 'insert': return [3 /*break*/, 1];
                        case 'showall': return [3 /*break*/, 3];
                        case 'update': return [3 /*break*/, 5];
                        case 'delete': return [3 /*break*/, 7];
                    }
                    return [3 /*break*/, 9];
                case 1: return [4 /*yield*/, insertData()];
                case 2:
                    _b.sent();
                    return [3 /*break*/, 10];
                case 3: return [4 /*yield*/, getData()];
                case 4:
                    _b.sent();
                    return [3 /*break*/, 10];
                case 5: return [4 /*yield*/, updateData()];
                case 6:
                    _b.sent();
                    return [3 /*break*/, 10];
                case 7: return [4 /*yield*/, deleteData()];
                case 8:
                    _b.sent();
                    return [3 /*break*/, 10];
                case 9:
                    console.log('Invalid operation');
                    _b.label = 10;
                case 10: return [2 /*return*/];
            }
        });
    });
}
// Insert operation
function insertData() {
    return __awaiter(this, void 0, void 0, function () {
        var _this = this;
        return __generator(this, function (_a) {
            rl.question('Enter name: ', function (name) {
                rl.question('Enter email: ', function (email) { return __awaiter(_this, void 0, void 0, function () {
                    var _a, data, error;
                    return __generator(this, function (_b) {
                        switch (_b.label) {
                            case 0: return [4 /*yield*/, supabase
                                    .from('users')
                                    .insert([{ name: name, email: email }])
                                    .select('*')];
                            case 1:
                                _a = _b.sent(), data = _a.data, error = _a.error;
                                if (error) {
                                    console.error('Error inserting data:', error.message);
                                }
                                else {
                                    console.log('Inserted data:', data);
                                }
                                rl.close();
                                return [2 /*return*/];
                        }
                    });
                }); });
            });
            return [2 /*return*/];
        });
    });
}
// Read (Select)
function getData() {
    return __awaiter(this, void 0, void 0, function () {
        var _a, data, error;
        return __generator(this, function (_b) {
            switch (_b.label) {
                case 0: return [4 /*yield*/, supabase
                        .from('users')
                        .select('*')];
                case 1:
                    _a = _b.sent(), data = _a.data, error = _a.error;
                    if (error) {
                        console.error('Error fetching data:', error.message);
                    }
                    else {
                        console.log('Fetched data:', data);
                    }
                    return [2 /*return*/];
            }
        });
    });
}
// Update
function updateData() {
    return __awaiter(this, void 0, void 0, function () {
        var _this = this;
        return __generator(this, function (_a) {
            rl.question('Enter email to update: ', function (email) {
                rl.question('Enter new name: ', function (newName) { return __awaiter(_this, void 0, void 0, function () {
                    var _a, data, error;
                    return __generator(this, function (_b) {
                        switch (_b.label) {
                            case 0: return [4 /*yield*/, supabase
                                    .from('users')
                                    .update({ name: newName })
                                    .eq('email', email)];
                            case 1:
                                _a = _b.sent(), data = _a.data, error = _a.error;
                                if (error) {
                                    console.error('Error updating data:', error.message);
                                }
                                else {
                                    console.log('Updated data:', data);
                                }
                                rl.close();
                                return [2 /*return*/];
                        }
                    });
                }); });
            });
            return [2 /*return*/];
        });
    });
}
// Delete
function deleteData() {
    return __awaiter(this, void 0, void 0, function () {
        var _this = this;
        return __generator(this, function (_a) {
            rl.question('Enter email to delete: ', function (email) { return __awaiter(_this, void 0, void 0, function () {
                var _a, data, error;
                return __generator(this, function (_b) {
                    switch (_b.label) {
                        case 0: return [4 /*yield*/, supabase
                                .from('users')
                                .delete()
                                .eq('email', email)];
                        case 1:
                            _a = _b.sent(), data = _a.data, error = _a.error;
                            if (error) {
                                console.error('Error deleting data:', error.message);
                            }
                            else {
                                console.log('Deleted data:', data);
                            }
                            rl.close();
                            return [2 /*return*/];
                    }
                });
            }); });
            return [2 /*return*/];
        });
    });
}
// Prompt for CRUD operation
rl.question('Enter operation (insert, select, update, delete): ', function (operation) {
    handleCrudOperation(operation);
});
