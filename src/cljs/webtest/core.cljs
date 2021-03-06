(ns webtest.core
  (:use websocket-example.handler
        websocket-example.dev
        org.httpkit.server ;; -->Added
        [ring.middleware file-info file]))

(defonce server (atom nil))

(defn get-handler []
  ;; #'app expands to (var app) so that when we reload our code,
  ;; the server is forced to re-resolve the symbol in the var
  ;; rather than having its own copy. When the root binding
  ;; changes, the server picks it up without having to restart.
  (-> #'app
      ; Makes static assets in $PROJECT_DIR/resources/public/ available.
      (wrap-file "resources")
      ; Content-Type, Content-Length, and Last Modified headers for files in body
      (wrap-file-info)))

(defn start-serve ;;starts the server at port 3449 and gives a link to be redirected there.
  "used for starting the server in development mode from REPL"
  [& [port]]
  (let [port (if port (Integer/parseInt port) 3449)]
    (reset! server
            (run-server (get-handler)
                   {:port port
                    :auto-reload? true
                    :join? false}))
    (println (str "You can view the site at http://localhost:test:" port))))

(defn stop-server [] ;; kills the server
  (@server) ;; -->Modified
  (reset! server nil))
