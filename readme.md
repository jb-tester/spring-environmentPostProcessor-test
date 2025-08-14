# The custom EnvironmentPostProcessor using with Spring Debugger

1. The most common way to use the custom EnvironmentPostProcessor is supported by Spring Debugger now:
see the `AddEnvironmentPostProcessor` class.
The different ways of adding the configuration properties map are supported:
  - FindUsages works for the overridden properties in application.properties/yaml
  - the added configuration properties are evaluated in Debugger, navigation to their source works 
  - the inlays are shown for the overridden values in application.properties/yaml

2. If the new property source is added after all the other property sources, so that the values from this custom EnvironmentPostProcessor 
have the lowest priority and are set only if the other property sources do not have the same property (see the `AddLastEnvironmentPostProcessor` class), then:
  - these values are evaluated
 BUT:
  - no inlays are shown for them in class 

3. The external extra property source file adding via the `EnvironmentPostProcessor` is supported partially (see the `AddExternalEnvironmentPostProcessor` class):
   - the properties from the external file are evaluated in Debugger, navigation to their source works 
   - the inlays are shown for the overridden values in application.properties/yaml
  BUT:
   - the external file itself is not detected as a SB configuration file
   - it is not shown as loaded in Debugger
   - no navigation to/from this file is provided
4. The property sources replacement is not supported (see the `OverrideEnvironmentPostProcessor` class):
   - no evaluation occurs for the overridden properties
   - no inlays are shown

