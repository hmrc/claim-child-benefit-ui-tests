# claim-child-benefit-ui-tests

## Running the tests

Prior to executing the tests ensure you have:
 - Docker - to run mongo and browser (Chrome or Firefox) inside a container 
 - Appropriate [drivers installed](#installing-local-driver-binaries) - to run tests against locally installed Browser
 - Installed/configured [service manager](https://github.com/hmrc/service-manager).  
 - Docker selenium grid - clone this from GitHub

Run the following command to start services locally:

    docker run --rm -d --name mongo -d -p 27017:27017 mongo:4.0
    sm2 --start CLAIM_CHILD_BENEFIT_ALL -r --wait 100

Using the `--wait 100` argument ensures a health check is run on all the services started as part of the profile. `100` refers to the given number of seconds to wait for services to pass health checks.

Then run './start.sh' inside docker-selenium-grid

Then execute the `run_tests.sh` script:

    ./run_tests.sh

The `run_tests.sh` script defaults to using `chrome` in the `local` environment.  For a complete list of supported param values, see:
 - `src/test/resources/application.conf` for **environment** 
 - [webdriver-factory](https://github.com/hmrc/webdriver-factory#2-instantiating-a-browser-with-default-options) for **browser-driver**