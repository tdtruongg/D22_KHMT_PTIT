from collections import defaultdict

class SegmentTree:
    def __init__(self, y_coords):
        self.y_coords = sorted(set(y_coords))
        self.n = len(self.y_coords) - 1
        self.count = [0] * (4 * self.n)
        self.length = [0] * (4 * self.n)
        
    def update(self, node, start, end, y1, y2, delta):
        if y1 >= self.y_coords[end] or y2 <= self.y_coords[start]:
            return
        if y1 <= self.y_coords[start] and y2 >= self.y_coords[end]:
            self.count[node] += delta
        else:
            mid = (start + end) // 2
            self.update(2 * node, start, mid, y1, y2, delta)
            self.update(2 * node + 1, mid, end, y1, y2, delta)
        
        if self.count[node] > 0:
            self.length[node] = self.y_coords[end] - self.y_coords[start]
        else:
            self.length[node] = self.length[2 * node] + self.length[2 * node + 1]

    def query(self):
        return self.length[1]

def calculate_area(triangles):
    events = []
    y_coords = []
    
    # Tạo sự kiện cho mỗi cạnh của tam giác
    for x1, y1, x2, y2, x3, y3 in triangles:
        vertices = sorted([(x1, y1), (x2, y2), (x3, y3)])
        (x1, y1), (x2, y2), (x3, y3) = vertices
        
        events.append((x1, y1, y3, 1))  # Bắt đầu đoạn
        events.append((x3, y1, y3, -1)) # Kết thúc đoạn
        y_coords.extend([y1, y3])

    # Sắp xếp sự kiện theo x
    events.sort()
    
    # Khởi tạo Segment Tree với các tọa độ y duy nhất
    segment_tree = SegmentTree(y_coords)
    last_x = events[0][0]
    total_area = 0.0
    
    # Quét qua các sự kiện
    for x, y1, y2, delta in events:
        # Tính khoảng cách x và diện tích che phủ hiện tại
        dx = x - last_x
        total_area += segment_tree.query() * dx
        last_x = x
        
        # Cập nhật Segment Tree với đoạn mới
        segment_tree.update(1, 0, segment_tree.n, y1, y2, delta)
    
    return total_area

def main():
    n = int(input("Nhập số tam giác: ").strip())
    triangles = []

    for _ in range(n):
        x1, y1, x2, y2, x3, y3 = map(int, input("Nhập tọa độ tam giác: ").split())
        triangles.append((x1, y1, x2, y2, x3, y3))

    result = calculate_area(triangles)
    print(f"{result:.6f}")

main()
