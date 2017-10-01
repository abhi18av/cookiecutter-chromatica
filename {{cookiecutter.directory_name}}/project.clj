(defproject {{cookiecutter.project_name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "{{cookiecutter.clojure_version}}"]
                 [org.clojure/clojurescript "{{cookiecutter.clojurescript_version}}" :scope "provided"]

;; superguns begins

                            [instaparse "1.4.7"]

                            ;; This is for traversing the nested clojure data structure
                            [com.rpl/specter "1.0.3"]

                            ;; Utility for traversing CLJ(S) data structures
                            [medley "1.0.0"]

                            ;; Clojure AST to EDN
                            [org.clojure/tools.analyzer "0.6.9"]

                            ;; Concrete implementation of tools.analyzer
                            [org.clojure/tools.analyzer.jvm "0.7.0"]

                            ;; Clojure reader in clojure
                            [org.clojure/tools.reader "1.0.5"]

                            ; Quickcheck
                            [org.clojure/test.check "0.10.0-alpha2"]

                            ;; Asynchronous stuff
                            [org.clojure/core.async "0.3.443"]


                            ;; promises for CLJ(s)
                            [funcool/promesa "1.9.0"]


                            ;; Pattern matching in clojure
                            [org.clojure/core.match "0.3.0-alpha5"]

                            ;; MiniKanren
                            [org.clojure/core.logic "0.8.11"]

                            ;; Documentation using marginalia
                            [lein-marginalia "0.9.0"]

                            ;; Boot documenataion tool Codox
                            [lein-codox "0.10.3"]

                            ;; Shell library
                            [me.raynes/conch "0.8.0"]
;;;;; superguns end

                 [com.cognitect/transit-clj "0.8.300"]
                 [ring "1.6.2"]
                 [ring/ring-defaults "0.3.1"]
                 [bk/ring-gzip "0.2.1"]
                 [radicalzephyr/ring.middleware.logger "0.6.0"]
                 [compojure "1.6.0"]
                 [environ "1.1.0"]
                 [com.stuartsierra/component "0.3.2"]
                 [org.danielsz/system "0.4.0"]
                 [org.clojure/tools.namespace "0.2.11"]
                 [http-kit "2.2.0"]
                 [re-frame "0.9.4"]
                 [lambdaisland/garden-watcher "0.3.1"]]

  :plugins [[lein-cljsbuild "1.1.6"]
            [lein-environ "1.1.0"]]

  :min-lein-version "2.6.1"

  :source-paths ["src/clj" "src/cljs" "src/cljc"]

  :test-paths ["test/clj" "test/cljc"]

  :clean-targets ^{:protect false} [:target-path :compile-path "resources/public/js"]

  :uberjar-name "{{cookiecutter.project_name}}.jar"

  ;; Use `lein run` if you just want to start a HTTP server, without figwheel
  :main {{cookiecutter.project_name}}.application

  ;; nREPL by default starts in the :main namespace, we want to start in `user`
  ;; because that's where our development helper functions like (go) and
  ;; (browser-repl) live.
  :repl-options {:init-ns user}

  :cljsbuild {:builds
              [ {:id "nodejs"
                :source-paths ["src/nodejs"] ; "dev"]

                ;:figwheel {:on-jsload "{{cookiecutter.project_name}}.system/reset"}

                :compiler {:main {{cookiecutter.project_name}}.core
                           :target :nodejs
                           :figwheel true
                           ;:asset-path "js/compiled/out"
                           :output-to "target/js/compiled/nodejs/{{cookiecutter.project_name}}.js"
                           :output-dir "target/js/compiled/nodejs/out"
                           :pretty-print true
                           :optimizations :none ; :simple 
                           :parallel-build true
                           ;:npm-deps {:chalk "2.1.0"}
                           ;:install-deps true
                           ;:source-map true
                           ;:warnings false
                           :source-map-timestamp true}}







              {:id "app"
                :source-paths ["src/cljs" "src/cljc" "dev"]

                :figwheel {:on-jsload "{{cookiecutter.project_name}}.system/reset"}

                :compiler {:main cljs.user
                           :asset-path "js/compiled/out"
                           :output-to "resources/public/js/compiled/{{cookiecutter.project_name}}.js"
                           :output-dir "resources/public/js/compiled/out"
                           :source-map-timestamp true}}

               {:id "test"
                :source-paths ["src/cljs" "test/cljs" "src/cljc" "test/cljc"]
                :compiler {:output-to "resources/public/js/compiled/testable.js"
                           :main {{cookiecutter.project_name}}.test-runner
                           :optimizations :none}}

               {:id "min"
                :source-paths ["src/cljs" "src/cljc"]
                :jar true
                :compiler {:main {{cookiecutter.project_name}}.system
                           :output-to "resources/public/js/compiled/{{cookiecutter.project_name}}.js"
                           :output-dir "target"
                           :source-map-timestamp true
                           :optimizations :advanced
                           :pretty-print false}}]}

  ;; When running figwheel from nREPL, figwheel will read this configuration
  ;; stanza, but it will read it without passing through leiningen's profile
  ;; merging. So don't put a :figwheel section under the :dev profile, it will
  ;; not be picked up, instead configure figwheel here on the top level.

  :figwheel {;; :http-server-root "public"       ;; serve static assets from resources/public/
             ;; :server-port 3449                ;; default
             ;; :server-ip "127.0.0.1"           ;; default
             :css-dirs ["resources/public/css"]  ;; watch and update CSS

             ;; Start an nREPL server into the running figwheel process. We
             ;; don't do this, instead we do the opposite, running figwheel from
             ;; an nREPL process, see
             ;; https://github.com/bhauman/lein-figwheel/wiki/Using-the-Figwheel-REPL-within-NRepl
             ;; :nrepl-port 7888

             ;; To be able to open files in your editor from the heads up display
             ;; you will need to put a script on your path.
             ;; that script will have to take a file path and a line number
             ;; ie. in  ~/bin/myfile-opener
             ;; #! /bin/sh
             ;; emacsclient -n +$2 $1
             ;;
             ;; :open-file-command "myfile-opener"

             :server-logfile "log/figwheel.log"}

  :doo {:build "test"}

  :profiles {:dev
             {:dependencies [[figwheel "0.5.11"]
                             [figwheel-sidecar "0.5.11"]
                             [com.cemerick/piggieback "0.2.2"]
                             [org.clojure/tools.nrepl "0.2.13"]
                             [lein-doo "0.1.7"]
                             [reloaded.repl "0.2.3"]]

              :plugins [[lein-figwheel "0.5.11"]
                        [lein-doo "0.1.7"]]

              :source-paths ["dev"]
              :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}

             :uberjar
             {:source-paths ^:replace ["src/clj" "src/cljc"]
              :prep-tasks ["compile"
                           ["cljsbuild" "once" "min"]
                           ["run" "-m" "garden-watcher.main" "{{cookiecutter.project_name}}.styles"]]
              :hooks []
              :omit-source true
              :aot :all}})
