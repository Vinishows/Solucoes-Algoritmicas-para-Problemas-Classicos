function quickSort(array, pivot, r) {
  if (pivot < r) {
    const q = partition(array, pivot, r);
    const auxA = q - 1;
    const auxB = q + 1;
    quickSort(array, pivot, auxA);
    quickSort(array, auxB, r);
  }

  return array;
}

function partition(array, pivot, r) {
  const x = array[r];
  let i = pivot - 1;

  for (let j = pivot; j <= r - 1; j++) {
    if (array[j] <= x) {
      i++;
      let temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
  }

  const temp = array[i + 1];
  array[i + 1] = array[r];
  array[r] = temp;

  return i + 1;
}

let A = [1, 6, 3, 8, 9, 5, 2, 10, 11, 7];
console.log(quickSort(A, 0, 9));
