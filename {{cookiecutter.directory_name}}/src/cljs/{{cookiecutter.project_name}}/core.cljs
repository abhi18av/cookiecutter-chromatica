(ns {{cookiecutter.project_name}}.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [{{cookiecutter.project_name}}.events]
            [{{cookiecutter.project_name}}.subs]
            [{{cookiecutter.project_name}}.views :as views]
            [{{cookiecutter.project_name}}.config :as config]))

(enable-console-print!)

(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn render []
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))
