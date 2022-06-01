"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    Object.defineProperty(o, k2, { enumerable: true, get: function() { return m[k]; } });
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (k !== "default" && Object.prototype.hasOwnProperty.call(mod, k)) __createBinding(result, mod, k);
    __setModuleDefault(result, mod);
    return result;
};
Object.defineProperty(exports, "__esModule", { value: true });
var Http = __importStar(require("http"));
var Url = __importStar(require("url"));
var testServerApp;
(function (testServerApp) {
    var port = Number(process.env.PORT);
    if (!port)
        port = 8101;
    startServer(port);
    function startServer(_port) {
        var server = Http.createServer();
        console.log("i'm alive!");
        server.addListener("request", handleRequest);
        server.listen(port);
    }
    function handleRequest(_request, _response) {
        _response.setHeader("content-type", "text/html; charset=utf-8");
        _response.setHeader("Access-Control-Allow-Origin", "*");
        console.log("i hear voices");
        if (_request.url) {
            var url = Url.parse(_request.url, true);
            var path = url.pathname;
            console.log("////");
            console.log("Request Method: " + _request.method);
            console.log("Path: " + path);
            console.log("////");
            switch (path) {
                case "/v1/signInUser":
                    console.log("trys to sign in");
                    break;
                case "/v1/logInUser":
                    console.log("trys to log in");
                    break;
                case "/v1/statistics/":
                    console.log("trys get Stats");
                    break;
                case "/v1/statistic/":
                    console.log("trys to set Sat");
                    break;
            }
        }
        _response.write("Fuck off cunt!");
        _response.end();
    }
})(testServerApp || (testServerApp = {}));
// Server Init
//1. npm install @types/node
//2. npm init
//3. package.json "start": "node Relativer/Pfad/Zu/Datei.js"
//Database Init
//1. npm install @types/mongodb
//2. npm install mongodb 
//3. Copied MongoDB Folder in project
//4. in folder MongoDB/bin cmd: mongod --dbpath ../../X_Database
/*
if (_request.method == "POST") {
  let body = "";
  _request.on("data", data => {
    body += data;
  });
  _request.on("end", async () => {
    let post: any = JSON.parse(body);
  });
}
*/
