import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
  vus: 5,
  duration: '15s',

  thresholds: {
    http_req_failed: ['rate<0.01'],
    http_req_duration: ['p(95)<1000'],
  },
};

export default function () {

  const url = 'https://quickpizza.grafana.com/api/users/token/login';

  const payload = JSON.stringify({
    username: 'default',
    password: '1234',
  });

  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  const respuesta = http.post(url, payload, params);

  check(respuesta, {
    'login responde correctamente': (r) => r.status === 200,
  });

  sleep(1);
}