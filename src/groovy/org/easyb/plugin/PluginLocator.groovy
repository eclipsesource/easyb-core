package org.easyb.plugin

import java.util.ServiceLoader;

class PluginLocator {
  EasybPlugin findPluginWithName(String pluginName) {
    for (EasybPlugin plugin: ServiceLoader.load(EasybPlugin)) {
      if (plugin.name.equals(pluginName)) {
        return plugin
      }
    }
    throw new RuntimeException("Plugin <${pluginName}> not found")
  }

  public static def findAllExampleDataParsers() {
    def dps = []

    ServiceLoader.load(ExampleDataParser).each { parser ->
      dps.add(parser)
    }

//    dps.addAll( ServiceLoader.load(ExampleDataParser) )
    dps.add(new ExampleAsMapDataParser())
    dps.add(new ExampleAsClosureDataParser())

    return dps
  }

  public static def findAllAutoloadingSyntaxExtensions() {
    def sas = []

    ServiceLoader.load(SyntaxExtension).each { SyntaxExtension parser ->
      if ( parser.autoLoad() )
        sas.add(parser)
    }

    return sas
  }

  public static def findSyntaxExtensionByName(String name) {

    for( SyntaxExtension parser : ServiceLoader.load(SyntaxExtension) ) {
      if ( parser.getName().equalsIgnoreCase(name) )
        return parser
    }

    throw new RuntimeException( "SyntaxExtension ${name} not found")
  }
}
