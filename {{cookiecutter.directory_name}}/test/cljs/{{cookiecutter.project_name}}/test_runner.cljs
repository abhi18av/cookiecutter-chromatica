(ns {{cookiecutter.project_name}}.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [{{cookiecutter.project_name}}.core-test]
   [{{cookiecutter.project_name}}.common-test]))

(enable-console-print!)

(doo-tests '{{cookiecutter.project_name}}.core-test
           '{{cookiecutter.project_name}}.common-test)
