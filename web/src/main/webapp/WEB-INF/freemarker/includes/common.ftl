[#ftl strip_text=true]
[#import "/spring.ftl" as spring]

[#--
 # message
 #
 # Translates a message code plus optional arguments into a message.
 #--]
[#function message code args...]
 [#return springMacroRequestContext.getMessage(code,args)]
[/#function]