const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return `${[year, month, day].map(formatNumber).join('/')} ${[hour, minute, second].map(formatNumber).join(':')}`
}
const formatDate = date => {
  const month = date.getMonth() + 1
  const day = date.getDate()
  // return `${[ month, day].map(formatNumber).join('-')} `
  return month+'-'+day
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : `0${n}`
}

function getCurrentToday(){
  const date = new Date()
  var year = date.getFullYear();
  var mouths = (date.getMonth() + 1) < 10 ? ("0" + (date.getMonth() + 1)) : (date.getMonth() + 1);
  var day = date.getDate() < 10 ? ("0" + date.getDate()) : date.getDate();
  var hours = date.getHours();
  var Minutes = date.getMinutes();//当前分
  var currentdate = year + "-" + mouths + "-" + day + "\t" + hours + ":" + Minutes;
  return currentdate
}
function dateLater(dates, later) {
  let dateObj = {};
  let show_day = new Array('周日', '周一', '周二', '周三', '周四', '周五', '周六');
  let date = new Date(dates);
  date.setDate(date.getDate() + later);
  let day = date.getDay();
  dateObj.dates = ((date.getMonth() + 1) < 10 ? ("0" + (date.getMonth() + 1)) : date.getMonth() + 1) + "月" + (date.getDate() < 10 ? ("0" + date.getDate()) : date.getDate()) + "日";
  dateObj.newdates = ((date.getMonth() + 1) < 10 ? ("0" + (date.getMonth() + 1)) : date.getMonth() + 1) + "-" + (date.getDate() < 10 ? ("0" + date.getDate()) : date.getDate());
  dateObj.year = date.getFullYear();
  dateObj.month = ((date.getMonth() + 1) < 10 ? ("0" + (date.getMonth() + 1)) : date.getMonth() + 1);
  dateObj.day = (date.getDate() < 10 ? ("0" + date.getDate()) : date.getDate());
  dateObj.week = show_day[day];
  return dateObj;
}

module.exports = {
  formatTime:formatTime,
  formatDate:formatDate,
  dateLater:dateLater,
  getCurrentToday,getCurrentToday
}
