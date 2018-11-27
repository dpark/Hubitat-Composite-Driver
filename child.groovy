metadata {
    definition (name: "Child", namespace: "example", author: "author") {
        capability "Switch"
    }
}

def on() {
    log.debug "child On"
}

def off() {
    log.debug "child Off"
}
