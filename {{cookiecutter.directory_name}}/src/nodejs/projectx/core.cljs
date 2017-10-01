(ns {{cookiecutter.project_name}}.core
  (:require [cljs.nodejs :as nodejs]))

(nodejs/enable-util-print!)

(defn -main []
  (println "Hello NodeJS!"))

(set! *main-cli-fn* -main)

