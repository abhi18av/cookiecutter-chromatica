(ns {{cookiecutter.project_name}}.events
  (:require [re-frame.core :as re-frame]
            [{{cookiecutter.project_name}}.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))
