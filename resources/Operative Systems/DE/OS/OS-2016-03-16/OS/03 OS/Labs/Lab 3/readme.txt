Ashraf Elsayed

1.

.:	java mkfs filesys.dat 64 8
block_size: 64
blocks: 8
super_blocks: 1
free_list_blocks: 1
inode_blocks: 3
data_blocks: 3
block_total: 8

3 index nodes



.:	java dump filesys.dat
1 40 64 @
5 8 8
9 1 1
13 2 2
17 5 5
64 1 1
128 40 64 @
131 3 3
139 20 32
143 ff 255
144 ff 255
145 ff 255
146 ff 255
147 ff 255
148 ff 255
149 ff 255
150 ff 255
151 ff 255
152 ff 255
153 ff 255
154 ff 255
155 ff 255
156 ff 255
157 ff 255
158 ff 255
159 ff 255
160 ff 255
161 ff 255
162 ff 255
163 ff 255
164 ff 255
165 ff 255
166 ff 255
167 ff 255
168 ff 255
169 ff 255
322 2e 46 .
338 2e 46 .
339 2e 46 .

.:	java dump filesys.dat
1 40 64 @
5 8 8
9 1 1
13 2 2
17 5 5
64 3 3
128 40 64 @
131 3 3
139 30 48 0
143 ff 255
144 ff 255
145 ff 255
146 ff 255
147 ff 255
148 ff 255
149 ff 255
150 ff 255
151 ff 255
152 ff 255
153 ff 255
154 ff 255
155 ff 255
156 ff 255
157 ff 255
158 ff 255
159 ff 255
160 ff 255
161 ff 255
162 ff 255
163 ff 255
164 ff 255
165 ff 255
166 ff 255
167 ff 255
168 ff 255
169 ff 255
192 40 64 @
195 1 1
203 20 32
206 1 1
207 ff 255
208 ff 255
209 ff 255
210 ff 255
211 ff 255
212 ff 255
213 ff 255
214 ff 255
215 ff 255
216 ff 255
217 ff 255
218 ff 255
219 ff 255
220 ff 255
221 ff 255
222 ff 255
223 ff 255
224 ff 255
225 ff 255
226 ff 255
227 ff 255
228 ff 255
229 ff 255
230 ff 255
231 ff 255
232 ff 255
233 ff 255
322 2e 46 .
338 2e 46 .
339 2e 46 .
353 1 1
354 75 117 u
355 73 115 s
356 72 114 r
385 1 1
386 2e 46 .
402 2e 46 .
403 2e 46 .



.:	java dump filesys.dat
1 40 64 @
5 8 8
9 1 1
13 2 2
17 5 5
64 7 7
128 40 64 @
131 3 3
139 40 64 @
143 ff 255
144 ff 255
145 ff 255
146 ff 255
147 ff 255
148 ff 255
149 ff 255
150 ff 255
151 ff 255
152 ff 255
153 ff 255
154 ff 255
155 ff 255
156 ff 255
157 ff 255
158 ff 255
159 ff 255
160 ff 255
161 ff 255
162 ff 255
163 ff 255
164 ff 255
165 ff 255
166 ff 255
167 ff 255
168 ff 255
169 ff 255
192 40 64 @
195 1 1
203 20 32
206 1 1
207 ff 255
208 ff 255
209 ff 255
210 ff 255
211 ff 255
212 ff 255
213 ff 255
214 ff 255
215 ff 255
216 ff 255
217 ff 255
218 ff 255
219 ff 255
220 ff 255
221 ff 255
222 ff 255
223 ff 255
224 ff 255
225 ff 255
226 ff 255
227 ff 255
228 ff 255
229 ff 255
230 ff 255
231 ff 255
232 ff 255
233 ff 255
256 40 64 @
259 1 1
267 20 32
270 2 2
271 ff 255
272 ff 255
273 ff 255
274 ff 255
275 ff 255
276 ff 255
277 ff 255
278 ff 255
279 ff 255
280 ff 255
281 ff 255
282 ff 255
283 ff 255
284 ff 255
285 ff 255
286 ff 255
287 ff 255
288 ff 255
289 ff 255
290 ff 255
291 ff 255
292 ff 255
293 ff 255
294 ff 255
295 ff 255
296 ff 255
297 ff 255
322 2e 46 .
338 2e 46 .
339 2e 46 .
353 2 2
354 62 98 b
355 69 105 i
356 6e 110 n
369 1 1
370 75 117 u
371 73 115 s
372 72 114 r
385 1 1
386 2e 46 .
402 2e 46 .
403 2e 46 .
449 2 2
450 2e 46 .
466 2e 46 .
467 2e 46 .


"/var" --> failed
java mkdir /var
mkdir: No space left on device
mkdir: "/var"

because of the limited # of blocks
==========
2.

Print function:

  /**
   * Print a listing for a particular file.
   * This is a convenience method.
   * @param name the name to print
   * @param stat the stat containing the file's information
   */
  private static void print( String name , Stat stat )
  {
    // a buffer to fill with a line of output
    StringBuffer s = new StringBuffer() ;

    // a temporary string
    String t = null ;

    // append the inode number in a field of 5
    t = Integer.toString( stat.getIno() ) ;
    for( int i = 0 ; i < 5 - t.length() ; i ++ )
      s.append( ' ' ) ;
    s.append( t ) ;
    s.append( ' ' ) ;

    // append the size in a field of 10
    t = Integer.toString( stat.getSize() ) ;
    for( int i = 0 ; i < 10 - t.length() ; i ++ )
      s.append( ' ' ) ;
    s.append( t ) ;
    s.append( ' ' ) ;
    
    int shiftTemp = ((1<<3) - 1);
	int first = shiftTemp & stat.getMode();
	int second = shiftTemp<<3 & stat.getMode();
	int third = shiftTemp<<6 & stat.getMode();
	 
	s.append(stat.getUid() + " ");
	s.append(stat.getGid() + " ");
	s.append(Integer.toOctalString(third) + Integer.toOctalString(second) + Integer.toOctalString(first) + " ");
    

    // append the name
    s.append( name ) ;

    // print the buffer
    System.out.println( s.toString() ) ;
  }

    0         64 0 0 000 .
    0         64 0 0 000 ..
    2         32 0 0 000 bin
    1         32 0 0 000 usr

.: total files: 4

