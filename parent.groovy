metadata {
    definition (name: "Parent", namespace: "example", author: "Derek Park") {
        command "recreateChildDevices"
    }
}

def installed() {
    log.debug "Parent installed"
    createChildDevices()
}

def updated() {
    log.debug "Parent updated"
}

def recreateChildDevices() {
    log.debug "Parent recreateChildDevices"
    deleteChildren()
    createChildDevices()
}

def createChildDevices() {
    log.debug "Parent createChildDevices"
    
    for (i in 1..2) {
        addChildDevice("example", "Child", "$device.deviceNetworkId-child-$i", [name: "child$i", label: "$device.displayName child $i", isComponent: true])
    }
}

def deleteChildren() {
	log.debug "Parent deleteChildren"
	def children = getChildDevices()
    
    children.each {child->
  		deleteChildDevice(child.deviceNetworkId)
    }
}
