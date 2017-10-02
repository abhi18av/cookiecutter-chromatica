(ns user
  (:require [{{cookiecutter.project_name}}.application]
            [me.raynes.conch :refer [programs with-programs let-programs] :as sh]
            [com.stuartsierra.component :as component]
            [figwheel-sidecar.config :as fw-config]
            [figwheel-sidecar.system :as fw-sys]
            [clojure.tools.namespace.repl :refer [set-refresh-dirs]]
            [reloaded.repl :refer [system init]]
            [ring.middleware.reload :refer [wrap-reload]]
            [figwheel-sidecar.repl-api :as figwheel]
            [garden-watcher.core :refer [new-garden-watcher]]
            [{{cookiecutter.project_name}}.config :refer [config]]))

(defn dev-system []
  (assoc ({{cookiecutter.project_name}}.application/app-system (config))
    :figwheel-system (fw-sys/figwheel-system (fw-config/fetch-config))
    :css-watcher (fw-sys/css-watcher {:watch-paths ["resources/public/css"]})
    :garden-watcher (new-garden-watcher ['{{cookiecutter.project_name}}.styles])))

(set-refresh-dirs "src" "dev")
(reloaded.repl/set-init! #(dev-system))

(defn cljs-repl []
  (fw-sys/cljs-repl (:figwheel-system system)))

;; Set up aliases so they don't accidentally
;; get scrubbed from the namespace declaration
(def start reloaded.repl/start)
(def stop reloaded.repl/stop)
(def go reloaded.repl/go)
(def reset reloaded.repl/reset)
(def reset-all reloaded.repl/reset-all)

;; deprecated, to be removed in Chestnut 1.0
(defn run []
  (println "(run) is deprecated, use (go)")
  (go))

(defn browser-repl []
  (println "(browser-repl) is deprecated, use (cljs-repl)")
  (cljs-repl))



(defn fig-start
  []
  (figwheel/start-figwheel!))

(defn fig-stop
  []
  (figwheel/stop-figwheel!))

(defn nodejs-repl 
  []
  ;(println "The nodejs-repl function is executed now")
  ;; This isn't the solution!
  ; (with-programs [node]
  ;  (node "target/js/compiled/nodejs-repl/{{cookiecutter.project_name}}.js")))
  (figwheel/cljs-repl))