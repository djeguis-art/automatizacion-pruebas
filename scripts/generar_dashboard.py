import json
import os
from pathlib import Path

ruta = Path("target/k6-summary.json")

tps = 0.0
promedio = 0.0
p95 = 0.0
errores = 0.0

if ruta.exists():
    data = json.loads(ruta.read_text(encoding="utf-8"))
    metrics = data.get("metrics", {})

    reqs = metrics.get("http_reqs", {})
    duration = metrics.get("http_req_duration", {})
    failed = metrics.get("http_req_failed", {})

    tps = float(reqs.get("rate", 0) or 0)
    promedio = float(duration.get("avg", 0) or 0)
    p95 = float(duration.get("p(95)", 0) or 0)
    errores = float(failed.get("value", 0) or 0) * 100

summary = os.environ.get("GITHUB_STEP_SUMMARY")

if summary:
    with open(summary, "a", encoding="utf-8") as f:
        f.write("# Dashboard de Calidad\n\n")

        f.write("## Pruebas funcionales\n\n")
        f.write("| Indicador | Resultado |\n")
        f.write("|---|---|\n")
        f.write("| JUnit + BDD | Ejecutadas |\n")
        f.write("| Pipeline | Completado |\n\n")

        f.write("## Performance k6\n\n")
        f.write("| Métrica | Resultado |\n")
        f.write("|---|---:|\n")
        f.write(f"| Solicitudes por segundo (TPS aprox.) | {tps:.2f} |\n")
        f.write(f"| Latencia promedio | {promedio:.2f} ms |\n")
        f.write(f"| Latencia p95 | {p95:.2f} ms |\n")
        f.write(f"| Porcentaje de errores | {errores:.2f}% |\n")
else:
    print(f"TPS: {tps:.2f}")
    print(f"Latencia promedio: {promedio:.2f} ms")
    print(f"Latencia p95: {p95:.2f} ms")
    print(f"Errores: {errores:.2f}%")