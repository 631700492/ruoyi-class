import request from '@/utils/request'

// 查询可以租借车辆信息 列表
export function listRental(query) {
  return request({
    url: '/system-car/rental/list',
    method: 'get',
    params: query
  })
}

// 查询可以租借车辆信息 详细
export function getRental(id) {
  return request({
    url: '/system-car/rental/' + id,
    method: 'get'
  })
}

// 新增可以租借车辆信息 
export function addRental(data) {
  return request({
    url: '/system-car/rental',
    method: 'post',
    data: data
  })
}

// 修改可以租借车辆信息 
export function updateRental(data) {
  return request({
    url: '/system/rental',
    method: 'put',
    data: data
  })
}

// 删除可以租借车辆信息 
export function delRental(id) {
  return request({
    url: '/system-car/rental/' + id,
    method: 'delete'
  })
}
