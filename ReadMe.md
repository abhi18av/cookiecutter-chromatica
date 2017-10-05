## ReadMe

A [cookiecutter](http://cookiecutter.readthedocs.io/en/latest/readme.html) template for Browser Automation using **Clojure(script)** - **Selenium** - **Puppeteer**


```yaml
- clojure_version = "1.9.0-beta1"
```

## How to use


1. Install `cookiecutter` 

```sh
cookiecutter https://github.com/abhi18av/cookiecutter-chromatica

```

2. Follow the instructions to generate the desired folder structure and the sensible defaults

3. `cd` into the folder and run the `npm install` command.

4. Then run `lein figwheel`

5. And then in another terminal run `npm run repl`

## ToDo

- Add `.travis` etc
- Use a specific version of `node`
```sh
/Users/eklavya/.nvm/versions/node/v8.4.0/bin/node
```
- Add a post-hook for initial git commit
- Add pre-hooks for asking to check the latest version of clojure(script) and dependencies
