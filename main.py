import os
import requests
from lxml import html

def get_dublin_forecast():

    url = 'https://www.met.ie/forecasts/dublin'
    page = requests.get(url)
    tree = html.fromstring(page.content)

    dublin = tree \
        .xpath('/html/body/div/div[1]/section'
               '/div/div[1]/div[1]/p[4]/text()')[0] \
        .replace('\n', ' ')

    return dublin

def send(url, forecast):
    lambda_endpoint = url + '/' + forecast
    requests.get(lambda_endpoint)

def main(*args, **kwargs):
    lambda_url = os.environ['LAMBDA_URL']
    fc = get_dublin_forecast()
    send(lambda_url, fc)

if __name__=='__main__':
    main(None)

