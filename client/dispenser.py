import RPIO
import urllib2

def status_change_trigger(id, val):
    val = (val + 1) % 2
    print 'Status change: gpio_id:', id, ', value:', val

    data = '{"status": ' + str(val) + '}'
    url = 'http://dispenser.cloudfoundry.com/status'
    req = urllib2.Request(url, data, {'Content-Type': 'application/json'})
    result = urllib2.urlopen(req).read()
    print 'Post result:', result

    return result

gpio_id = 4
RPIO.add_interrupt_callback(gpio_id, status_change_trigger)
RPIO.wait_for_interrupts()
