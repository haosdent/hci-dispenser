import RPIO
import urllib2, urllib

def status_change_trigger(id, val):
    print 'Status change: gpio_id:', id, ', value:', val

    data = urllib.urlencode({'status': val})
    url = 'http://hci-dispenser.cloudfoundry.com/status'
    result = urllib2.urlopen(url, data).read()
    print 'Post result:', result

    return result

gpio_id = 17
RPIO.add_interrupt_callback(gpio_id, status_change_trigger)
