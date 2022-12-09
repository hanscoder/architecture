# Architecture Tests

A crazy person wrote this code you can see it on the not existing clean code, security problems and more,
but more important, the defined architecture rules were not followed.

Therefore, it was decided that the architecture rules need to be checked automatically.
Thanks to the brave developers of [archunit](https://www.archunit.org/) we have a tool.
It is already defined as dependency, but we need to develop the rules now.

The defined rules:
- [ ] Rest controllers should reside in a package named rest.
- [ ] Rest controllers should be annotated with Tag, Validated and RequestMapping.
- [ ] Rest controllers should have a name which ends with Controller.
- [ ] Rest controllers should have only one method with the annotation RequestMapping.
- [ ] Rtos should reside in a package named rest.
- [ ] Rtos should not be used outside the package rest.
- [ ] Services should reside in a package named domain.
- [ ] Services should not call services from different use cases.
- [ ] Services should only have one public method.
- [ ] Services should only have public methods which are annotated with Use case.
- [ ] Repository should reside in a package named repository.
- [ ] Repository should be annotated with Repository.
- [ ] Rest controller, service and repository should be always grouped in a package which is named after the use case like login.
- [ ] Rest controller should only call a service in the same use case package.
- [ ] Service should only call a repository in the same use case package.
- [ ] Let's discuss what we should check.

Have fun.
