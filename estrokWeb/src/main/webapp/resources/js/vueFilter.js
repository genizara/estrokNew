Vue.filter("capitalize", (value) => {
  if (!value) return '';
  value = value.toString();
  return value.charAt(0).toUpperCase() + value.slice(1);
});

Vue.filter("decipoint", (value, pointAt) => {
  if (!value) return '';
  if (pointAt===undefined || pointAt === null ) pointAt = 0;
  return value.toFixed(pointAt);
});

