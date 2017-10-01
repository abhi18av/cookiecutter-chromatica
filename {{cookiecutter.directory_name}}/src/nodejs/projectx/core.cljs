(ns {{cookiecutter.project_name}}.core
  (:require [cljs.nodejs :as nodejs]))

(nodejs/enable-util-print!)

(def chalk (js/require "chalk"))

(defn -main []
  (println "Hello NodeJS!")
  (println (chalk.blue "BLUE")))

(set! *main-cli-fn* -main)

