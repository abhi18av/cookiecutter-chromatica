(ns {{cookiecutter.project_name}}.components.ui
  (:require [com.stuartsierra.component :as component]
            [{{cookiecutter.project_name}}.core :refer [render]]))

(defrecord UIComponent []
  component/Lifecycle
  (start [component]
    (render)
    component)
  (stop [component]
    component))

(defn new-ui-component []
  (map->UIComponent {}))
