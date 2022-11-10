import request from '@/utils/request'

// 查询可以卖的车辆信息 列表
export function listSell(query) {
  return request({
    url: '/system-car/sell/list',
    method: 'get',
    params: query
  })
}

// 查询可以卖的车辆信息 详细
export function getSell(id) {
  return request({
    url: '/system-car/sell/' + id,
    method: 'get'
  })
}

// 新增可以卖的车辆信息 
export function addSell(data) {
  return request({
    url: '/system-car/sell',
    method: 'post',
    data: data
  })
}

// 修改可以卖的车辆信息 
export function updateSell(data) {
  return request({
    url: '/system-car/sell',
    method: 'put',
    data: data
  })
}

// 删除可以卖的车辆信息 
export function delSell(id) {
  return request({
    url: '/system-car/sell/' + id,
    method: 'delete'
  })
}
