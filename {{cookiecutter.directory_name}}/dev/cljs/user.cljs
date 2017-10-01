(ns cljs.user
  (:require [{{cookiecutter.project_name}}.core]
            [{{cookiecutter.project_name}}.system :as system]))

(def go system/go)
(def reset system/reset)
(def stop system/stop)
(def start system/start)
